package com.bridgelabz.springboot.model;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity(name = "users")
public class User implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 4192838054089247308L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "userId")
	@NotNull
	private Long userId;
	
	@Column(name = "userName")
	@NotNull
	private String userName;
	
	@Column(name = "emailId")
	@NotNull
	private String emailId;
	
	@Column(name = "password")
	@NotNull
	private String password;
	
	@Column(name = "mobileNumber")
	@NotNull
	private long mobileNumber;
	
	@Column(name = "isVerified")
	@NotNull
	private boolean isVerified;
	
	@JsonIgnore
	@JoinColumn(name = "userId")
	@OneToMany(cascade = CascadeType.ALL)
	private List<Note> notes;
	
	@JsonIgnore
	@JoinColumn(name = "userId")
	@OneToMany(cascade = CascadeType.ALL)
	private List<Label> labels;
	
	public List<Note> getNotes() {
		return notes;
	}

	public void setNotes(List<Note> notes) {
		this.notes = notes;
	}

	public List<Label> getLabels() {
		return labels;
	}

	public void setLabels(List<Label> labels) {
		this.labels = labels;
	}

	@NotNull
	private LocalDateTime createdDateTime;
	
	@NotNull
	private LocalDateTime updatedDateTime;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
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

	public boolean isVerified() {
		return isVerified;
	}

	public void setVerified(boolean isVerified) {
		this.isVerified = isVerified;
	}

	public LocalDateTime getCreatedDateTime() {
		return createdDateTime;
	}

	public void setCreatedDateTime(LocalDateTime createdDateTime) {
		this.createdDateTime = createdDateTime;
	}

	public LocalDateTime getUpdatedDateTime() {
		return updatedDateTime;
	}

	public void setUpdatedDateTime(LocalDateTime updatedDateTime) {
		this.updatedDateTime = updatedDateTime;
	}

	public Long getUserId() {
		return userId;
	}
	
	public void setUserId(Long userID) {
		this.userId = userID;
	}
}
