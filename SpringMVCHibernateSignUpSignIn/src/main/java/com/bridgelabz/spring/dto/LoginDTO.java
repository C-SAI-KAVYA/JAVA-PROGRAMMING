package com.bridgelabz.spring.dto;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

@Component
@Entity
@Table(name = "users", schema = "bridgelabzmvc")
public class LoginDTO {
	private static Logger logger = Logger.getLogger(LoginDTO.class);

	@Column(name = "email")
	private String email;
	@Column(name = "password")
	private String password;
	
	public LoginDTO() {
		logger.info("Created \t"+this.getClass().getSimpleName());
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "LoginDTO [email=" + email + ", password=" + password + "]";
	}
	
}
