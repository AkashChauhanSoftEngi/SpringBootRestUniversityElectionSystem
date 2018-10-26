package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.dto.PersonDto;
import com.example.dto.StudentDto;
import com.example.service.ElectionSystemService;

@RestController
public class StudentRestController {
	
	@Autowired
	ElectionSystemService electionService;

	@PostMapping("/student")
	public ResponseEntity<StudentDto> addStudent(@RequestBody StudentDto student) throws Exception {
		ResponseEntity<StudentDto> responseEntity = null;
		
		System.out.println("Inside /student end point, to insert Student");
		
		StudentDto result = electionService.saveStudent(student);
		if (result!=null){
			responseEntity = new ResponseEntity<StudentDto>(result, HttpStatus.OK);
			return responseEntity;
		}else{
			throw new Exception("Your choices do not exist in Person table, choose only listed members");
		}
	}
	
	@PostMapping("/person")
	public PersonDto addPerson(@RequestBody PersonDto person) {
		System.out.println("Inside /person end point, to insert Person");
		return electionService.savePerson(person);
	}
	
	@GetMapping("/findElectedPresident")
	public String findElectedPresident(){
		return electionService.findElectedPresident();
	}
	
	@GetMapping("/findElectedVicePresident")
	public String findElectedVicePresident(){
		return electionService.findElectedVicePresident();
	}
	
	@GetMapping("/findElectedSecretary")
	public String findElectedSecretary(){
		return electionService.findElectedSecretary();
	}
}
