package com.bridgelabz.addressbook.model;

import java.util.List;

public class AddressBookModel {
	private List<PersonDetails> persons;
	
	public void setPersons(List<PersonDetails> persons) {
		this.persons = persons;
	}
	
	public List<PersonDetails> getPersons() {
		return persons;
	}
	
}
