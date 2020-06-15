package com.bridgelabz.springboot.entity;

import org.springframework.stereotype.Component;

@Component
public class UpdatePasswordEntity {
	private String password;
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
}
