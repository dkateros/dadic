package gr.dkateros.dadic.demo;

import java.time.LocalDate;

import gr.dkateros.dadic.DictionaryElement;

public class Person {
	
	public Person(LocalDate birthDate, String uid) {
		this.birthDate = birthDate;
		this.uid = uid;
	}

	@DictionaryElement
	LocalDate birthDate;
	
	String uid;

}
