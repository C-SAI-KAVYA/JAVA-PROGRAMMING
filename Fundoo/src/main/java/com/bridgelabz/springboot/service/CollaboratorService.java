package com.bridgelabz.springboot.service;

import com.bridgelabz.springboot.model.Note;

public interface CollaboratorService {
	public Note addCollaborator(Long noteId, String token, String emailId);
}
