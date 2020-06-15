package com.bridgelabz.springboot.entity;

import java.time.LocalDateTime;

import org.springframework.stereotype.Component;

@Component
public class UpdatedNoteEntity {
	
	private String noteTitle;
	private String description;
	private String color;
	private boolean archieved;
	private boolean pinned;
	private boolean inTrash;
	private LocalDateTime reminder;
	
	
	public String getNoteTitle() {
		return noteTitle;
	}
	public void setNoteTitle(String noteTitle) {
		this.noteTitle = noteTitle;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
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
	public LocalDateTime getReminder() {
		return reminder;
	}
	public void setReminder(LocalDateTime reminder) {
		this.reminder = reminder;
	}
}
