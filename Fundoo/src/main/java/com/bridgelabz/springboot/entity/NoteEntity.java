package com.bridgelabz.springboot.entity;

import org.springframework.stereotype.Component;

@Component
public class NoteEntity {
	
	private String noteTitle;
	private String description;
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
}
