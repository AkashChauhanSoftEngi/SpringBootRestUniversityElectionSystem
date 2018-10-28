package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.dto.PersonDto;
import com.example.dto.PostDto;
import com.example.dto.StudentDto;
import com.example.service.ElectionSystemService;

@RestController
public class StudentRestController {

	@Autowired
	ElectionSystemService electionService;

	@PostMapping("/addPost")
	public ResponseEntity<PostDto> addPosts(@RequestBody PostDto post) throws Exception {
		ResponseEntity<PostDto> responseEntity = null;
		PostDto result = null;
		System.out.println("Inside /posts end point, to insert posts");		
		result = electionService.savePosts(post);
		if (result != null) {
			responseEntity = new ResponseEntity<PostDto>(result, HttpStatus.OK);
			return responseEntity;
		} else {
			throw new Exception("Exception Occured, during saving posts into post table");
		}
	}

	@PostMapping("/addPerson")
	public ResponseEntity<PersonDto> addPerson(@RequestBody PersonDto person) throws Exception {
		System.out.println("Inside /person end point, to insert Person");
		ResponseEntity<PersonDto> responseEntity = null;
		PersonDto result = null;
		System.out.println("Inside /posts end point, to insert posts");		
		result = electionService.savePerson(person);
		if (result != null) {
			responseEntity = new ResponseEntity<PersonDto>(result, HttpStatus.OK);
			return responseEntity;
		} else {
			throw new Exception("Your choices do not exist in Post table, choose only listed posts");
		}		
	}
	
	@PostMapping("/addStudent")
	public ResponseEntity<StudentDto> addStudent(@RequestBody StudentDto student) throws Exception {
		ResponseEntity<StudentDto> responseEntity = null;

		System.out.println("Inside /student end point, to insert Student");

		StudentDto result = electionService.saveStudent(student);
		if (result != null) {
			responseEntity = new ResponseEntity<StudentDto>(result, HttpStatus.OK);
			return responseEntity;
		} else {
			throw new Exception("Your choices do not exist in Person table, choose only listed members");
		}
	}

	@GetMapping("/findElectedPresident")
	public String findElectedPresident() {
		return electionService.findElectedPresident();
	}

	@GetMapping("/findElectedVicePresident")
	public String findElectedVicePresident() {
		return electionService.findElectedVicePresident();
	}

	@GetMapping("/findElectedSecretary")
	public String findElectedSecretary() {
		return electionService.findElectedSecretary();
	}
}
