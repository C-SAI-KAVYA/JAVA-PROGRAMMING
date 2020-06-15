package com.bridgelabz.springboot.model;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.JoinColumn;
import javax.validation.constraints.NotNull;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity(name = "note")
@Component
public class Note {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "noteId")
	private Long noteId;
	
	@NotNull
	@Column(name = "title")
	private String title;
	
	@NotNull
	@Column(name = "description")
	private String description;
	
	@NotNull
	@Column(name = "archieved")
	private boolean archieved;
	
	@NotNull
	@Column(name = "pinned")
	private boolean pinned;
	
	@NotNull
	@Column(name = "inTrash")
	private boolean inTrash;
	
	@NotNull
	@Column(name = "color")
	private String color;
	
	private LocalDateTime reminderTime;
	private LocalDateTime updatedDateTime;
	private LocalDateTime createdDateTime;
	
	@JsonIgnore
	@JoinTable(name = "note_label", joinColumns = {@JoinColumn(name = "noteId")}, inverseJoinColumns = {@JoinColumn(name = "labelId")})
	@ManyToMany(cascade = CascadeType.ALL)
	private List<Label> labels;
	
	@JsonIgnore
	@ManyToMany(mappedBy = "collaboraterNote")
	private List<User> collaboratorUsers;

	public Long getNoteId() {
		return noteId;
	}

	public void setNoteId(Long noteId) {
		this.noteId = noteId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public boolean isArchieved() {
		return archieved;
	}

	public void setArchieved(boolean archieved) {
		this.archieved = archieved;
	}

	public boolean isPinned() {
		return pinned;
	}

	public void setPinned(boolean pinned) {
		this.pinned = pinned;
	}

	public boolean isInTrash() {
		return inTrash;
	}

	public void setInTrash(boolean inTrash) {
		this.inTrash = inTrash;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public LocalDateTime getReminderTime() {
		return reminderTime;
	}

	public void setReminderTime(LocalDateTime reminderTime) {
		this.reminderTime = reminderTime;
	}

	public LocalDateTime getUpdatedDateTime() {
		return updatedDateTime;
	}

	public void setUpdatedDateTime(LocalDateTime updatedDateTime) {
		this.updatedDateTime = updatedDateTime;
	}

	public LocalDateTime getCreatedDateTime() {
		return createdDateTime;
	}

	public void setCreatedDateTime(LocalDateTime createdDateTime) {
		this.createdDateTime = createdDateTime;
	}

	public List<Label> getLabels() {
		return labels;
	}

	public void setLabels(List<Label> labels) {
		this.labels = labels;
	}

	public List<User> getCollaboratorUsers() {
		return collaboratorUsers;
	}

	public void setCollaboratorUsers(List<User> collaboratorUsers) {
		this.collaboratorUsers = collaboratorUsers;
	}	
}
