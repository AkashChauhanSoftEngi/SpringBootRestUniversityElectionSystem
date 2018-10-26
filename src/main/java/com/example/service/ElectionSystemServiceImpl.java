package com.example.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dto.PersonDto;
import com.example.dto.StudentDto;
import com.example.entity.Person;
import com.example.entity.Student;
import com.example.repository.PersonRepository;
import com.example.repository.StudentRepository;

@Service
public class ElectionSystemServiceImpl implements ElectionSystemService {

	@Autowired
	StudentRepository studentRepository;

	@Autowired
	PersonRepository personRepository;

	@Override
	public StudentDto saveStudent(StudentDto inStudentDto) {
		if(inStudentDto.getChoiceForPresident().equals(inStudentDto.getChoiceForVicePresident())){
			return null;
		}
		if(inStudentDto.getChoiceForPresident().equals(inStudentDto.getChoiceForSecretary())){
			return null;
		}
		if(inStudentDto.getChoiceForVicePresident().equals(inStudentDto.getChoiceForSecretary())){
			return null;
		}
		Optional<Person> person1 = personRepository.findById(inStudentDto.getChoiceForPresident());
		Optional<Person> person2 = personRepository.findById(inStudentDto.getChoiceForVicePresident());
		Optional<Person> person3 = personRepository.findById(inStudentDto.getChoiceForSecretary());

		if (person1.isPresent() && person2.isPresent() && person3.isPresent()) {
			Student outStudent = new Student();
			BeanUtils.copyProperties(inStudentDto, outStudent);
			outStudent = studentRepository.save(outStudent);
			BeanUtils.copyProperties(outStudent, inStudentDto);
			return inStudentDto;
		} else {
			return null;
		}
	}

	@Override
	public PersonDto savePerson(PersonDto inPersonDto) {
		Person outPerson = new Person();
		BeanUtils.copyProperties(inPersonDto, outPerson);
		outPerson = personRepository.save(outPerson);
		BeanUtils.copyProperties(outPerson, inPersonDto);
		return inPersonDto;
	}

	@Override
	public String findElectedPresident() {
		List<Student> studentList = studentRepository.findAll();
		List<StudentDto> allDtoStudent = new ArrayList<>();
		for (com.example.entity.Student student : studentList) {
			StudentDto newDtoUser = new StudentDto();
			BeanUtils.copyProperties(student, newDtoUser);
			allDtoStudent.add(newDtoUser);
		}
		ListIterator<StudentDto> iterator = allDtoStudent.listIterator();
		List<String> allPresidents = new ArrayList<String>();
		while (iterator.hasNext()) {
			allPresidents.add(iterator.next().getChoiceForPresident());
		}
		Map<String, Long> frequency = allPresidents.stream()
				.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
		Map<Long, String> reverseKeysAndValues = new HashMap<Long, String>();
		Long max = 0L;
		for (Map.Entry<String, Long> map : frequency.entrySet()) {
			Long value = map.getValue();
			String key = map.getKey();
			reverseKeysAndValues.put(value, key);
			if (max < value) {
				max = value;
			}
		}
		return reverseKeysAndValues.get(max);
	}

	@Override
	public String findElectedVicePresident() {
		List<Student> studentList = studentRepository.findAll();
		List<StudentDto> allDtoStudent = new ArrayList<>();
		for (com.example.entity.Student student : studentList) {
			StudentDto newDtoUser = new StudentDto();
			BeanUtils.copyProperties(student, newDtoUser);
			allDtoStudent.add(newDtoUser);
		}
		ListIterator<StudentDto> iterator = allDtoStudent.listIterator();
		List<String> allVicePresidents = new ArrayList<String>();
		while (iterator.hasNext()) {
			allVicePresidents.add(iterator.next().getChoiceForVicePresident());
		}
		Map<String, Long> frequency = allVicePresidents.stream()
				.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
		Map<Long, String> reverseKeysAndValues = new HashMap<Long, String>();
		Long max = 0L;
		for (Map.Entry<String, Long> map : frequency.entrySet()) {
			Long value = map.getValue();
			String key = map.getKey();
			reverseKeysAndValues.put(value, key);
			if (max < value) {
				max = value;
			}
		}
		return reverseKeysAndValues.get(max);
	}

	@Override
	public String findElectedSecretary() {
		List<Student> studentList = studentRepository.findAll();
		List<StudentDto> allDtoStudent = new ArrayList<>();
		for (com.example.entity.Student student : studentList) {
			StudentDto newDtoUser = new StudentDto();
			BeanUtils.copyProperties(student, newDtoUser);
			allDtoStudent.add(newDtoUser);
		}
		ListIterator<StudentDto> iterator = allDtoStudent.listIterator();
		List<String> allSecretary = new ArrayList<String>();
		while (iterator.hasNext()) {
			allSecretary.add(iterator.next().getChoiceForSecretary());
		}
		Map<String, Long> frequency = allSecretary.stream()
				.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
		Map<Long, String> reverseKeysAndValues = new HashMap<Long, String>();
		Long max = 0L;
		for (Map.Entry<String, Long> map : frequency.entrySet()) {
			Long value = map.getValue();
			String key = map.getKey();
			reverseKeysAndValues.put(value, key);
			if (max < value) {
				max = value;
			}
		}
		return reverseKeysAndValues.get(max);
	}

}
