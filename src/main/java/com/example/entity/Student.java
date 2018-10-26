package com.example.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Student {
	@Id
	String name;
	String choiceForPresident;
	String choiceForVicePresident;
	String choiceForSecretary;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getChoiceForPresident() {
		return choiceForPresident;
	}
	public void setChoiceForPresident(String choiceForPresident) {
		this.choiceForPresident = choiceForPresident;
	}
	public String getChoiceForVicePresident() {
		return choiceForVicePresident;
	}
	public void setChoiceForVicePresident(String choiceForVicePresident) {
		this.choiceForVicePresident = choiceForVicePresident;
	}
	public String getChoiceForSecretary() {
		return choiceForSecretary;
	}
	public void setChoiceForSecretary(String choiceForSecretary) {
		this.choiceForSecretary = choiceForSecretary;
	}
	
}
