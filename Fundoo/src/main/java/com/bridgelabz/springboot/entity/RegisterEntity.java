package com.bridgelabz.springboot.entity;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

import org.springframework.stereotype.Component;

@Component
public class RegisterEntity {
	
	@NotNull
	private String userName;
	
	@NotNull
	private String password;
	
	@NotNull
	private long mobileNumber;
	
	@Email
	private String emailId;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public long getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(long mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	@Override
	public String toString() {
		return "RegisterEntity [userName=" + userName + ", password=" + password + ", mobileNumber=" + mobileNumber
				+ ", emailId=" + emailId + "]";
	}
}
