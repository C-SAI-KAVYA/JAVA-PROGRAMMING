package com.bridgelabz.mongo.model;

import java.io.Serializable;

@SuppressWarnings("serial")
public class UserModel implements Serializable{
	
	private String userName;
	private String email;
	private long phoneNumber;
	private String city;
	private int id;
	
	public UserModel() {

	}
	public UserModel(String userName, String email, long phoneNumber, String city) {
		super();
		this.userName = userName;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.city = city;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public long getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	@Override
	public String toString() {
		return "UserModel [userName=" + userName + ", email=" + email + ", phoneNumber=" + phoneNumber + ", city="
				+ city + ", id=" + id + "]";
	}
}
