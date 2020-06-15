package com.bridgelabz.springboot.service;

import java.util.List;

import com.bridgelabz.springboot.entity.NoteEntity;
import com.bridgelabz.springboot.entity.ReminderEntity;
import com.bridgelabz.springboot.entity.UpdatedNoteEntity;
import com.bridgelabz.springboot.model.Note;

public interface NoteService {
	public boolean newNote(String token, NoteEntity entity);
	public boolean updateNote(String token, Long noteId, UpdatedNoteEntity entity);
	public boolean deleteNote(String token, Long noteId);
	public boolean trashedNote(Long noteId, String token);
	public boolean pinnedNote(Long noteId, String token);
	public boolean archievedNote(Long noteId, String token);
	public boolean setReminder(Long noteId, String token, ReminderEntity entity);
	public boolean deleteReminder(Long noteId, String token);
	public List<Note> fetchAllNotes(String token);
	public List<Note> fetchAllPinnedNotes(String token);
	public List<Note> fetchAllTrashedNotes(String token);
	public List<Note> fetchAllArchievedNotes(String token);
}
