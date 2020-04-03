package com.bridgelabz.spring.dto;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.springframework.stereotype.Component;



@SuppressWarnings("serial")
@Component
@Entity
@Table(name = "users", schema = "bridgelabzmvc")
public class RegisterDTO implements Serializable {
	@Id
	@Column(name = "id")
	@GenericGenerator(name = "auto", strategy = "increment")
	@GeneratedValue(generator = "auto")
	private int id;
	@Column(name = "userName")
	private String userName;
	@Column(name = "email")
	private String email;
	@Column(name = "phnNum")
	private long phnNum;
	@Column(name = "password")
	private String password;
	@Column(name = "confirmPassword")
	private String confirmPassword;
	public int getId() {
		return id;
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
	public long getPhnNum() {
		return phnNum;
	}
	public void setPhnNum(long phnNum) {
		this.phnNum = phnNum;
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
		return "RegisterDTO [id=" + id + ", userName=" + userName + ", email=" + email + ", phnNum=" + phnNum
				+ ", password=" + password + ", confirmPassword=" + confirmPassword + "]";
	}
	
}