package com.example.service;

import com.example.dto.PersonDto;
import com.example.dto.PostDto;
import com.example.dto.StudentDto;

public interface ElectionSystemService {
	StudentDto saveStudent(StudentDto student);
	PersonDto savePerson(PersonDto person);
	String findElectedPresident();
	String findElectedVicePresident();
	String findElectedSecretary();
	PostDto savePosts(PostDto post);
}
