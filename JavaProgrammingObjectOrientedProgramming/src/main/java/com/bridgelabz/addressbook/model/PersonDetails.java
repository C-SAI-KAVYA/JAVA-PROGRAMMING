package com.bridgelabz.addressbook.model;

public class PersonDetails {

	private Integer personID;
	private String firstName;
	private String lastName;
	private Long mobile;
	private PersonAddress address;
	
	
	public Integer getPersonID() {
		return personID;
	}
	
	public void setPersonID(Integer personID) {
		this.personID = personID;
	}
	
	public String getFirstName() {
		return firstName;
	}
	
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public Long getMobile() {
		return mobile;
	}
	
	public void setMobile(Long mobile) {
		this.mobile = mobile;
	}
	
	public PersonAddress getAddress() {
		return address;
	}
	
	public void setAddress(PersonAddress address) {
		this.address = address;
	}
	
	
	@Override
	public String toString() {
		return "PersonDetails [firstName=" + firstName + ", lastName=" + lastName + ", mobile=" + mobile + ", address="
				+ address + "]";
	}
	
	
	
}
