package com.bridgelabz.spring.dto;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

import com.bridgelabz.spring.dao.ForgotDAOImpl;



@Component
@Entity
@Table(name = "users", schema = "bridgelabzmvc")
public class ForgotDTO {
	private static Logger logger = Logger.getLogger(ForgotDAOImpl.class);
	@Column(name = "email")
	private String email;
	@Column(name = "password")
	private String password;
	@Column(name = "confirmPassword")
	private String confirmPassword;
	
	public ForgotDTO() {
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
	public String getConfirmPassword() {
		return confirmPassword;
	}
	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}
	@Override
	public String toString() {
		return "ForgotDTO [email=" + email + ", password=" + password + ", confirmPassword=" + confirmPassword + "]";
	}
	
}