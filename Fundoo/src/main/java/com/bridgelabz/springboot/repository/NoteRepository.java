package com.bridgelabz.springboot.repository;

import java.util.List;

import com.bridgelabz.springboot.model.Note;

public interface NoteRepository {
	public Note saveOrUpdate(Note note);
	public Note searchById(Long noteId);
	public boolean delete(Note retrievedNote);
	public List<Note> getAllNotes(Long userId);
	public List<Note> getArchievedNotes(Long userId);
	public List<Note> getPinnedNotes(Long userId);
	public List<Note> getTrashedNotes(Long userID);
}
