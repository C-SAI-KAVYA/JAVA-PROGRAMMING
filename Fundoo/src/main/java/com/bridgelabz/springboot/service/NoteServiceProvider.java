package com.bridgelabz.springboot.service;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;

import org.apache.el.stream.Optional;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bridgelabz.sprinboot.exceptions.UserAuthenticationException;
import com.bridgelabz.springboot.entity.NoteEntity;
import com.bridgelabz.springboot.entity.ReminderEntity;
import com.bridgelabz.springboot.entity.UpdatedNoteEntity;
import com.bridgelabz.springboot.model.Note;
import com.bridgelabz.springboot.model.User;
import com.bridgelabz.springboot.repository.NoteRepository;
import com.bridgelabz.springboot.repository.UserRepository;
import com.bridgelabz.springboot.utils.DateLibrary;
import com.bridgelabz.springboot.utils.JWTTokenLibrary;

@Service
public class NoteServiceProvider implements NoteService{
	
	@Autowired
	private JWTTokenLibrary jwt;
	
	@Autowired
	private Note note;
	
	@Autowired
	private UserRepository ur;
	
	@Autowired
	private NoteRepository nr;
	
	@Autowired
	private DateLibrary date;
	

	private User userAuthentication(String token) {
		Long userId = jwt.tokenDecoder(token);
		if(userId > 0) {
			return ur.fetchUser(userId);
		}
		throw new UserAuthenticationException("UnAuthorized user please check with the credentials");
	}

	@Override
	public boolean newNote(String token, NoteEntity entity) {
		User user = userAuthentication(token);
		BeanUtils.copyProperties(entity, note);
		note.setCreatedDateTime(date.presentDate());
		note.setUpdatedDateTime(date.presentDate());
		note.setColor("white");
		note.setInTrash(false);
		note.setPinned(false);
		note.setArchieved(false);
		user.getNotes().add(note);
		nr.saveOrUpdate(note);
		return true;
	}


	@Override
	public boolean updateNote(String token, Long noteId, UpdatedNoteEntity entity) {
		userAuthentication(token);
		Note noteFetched = Optional.ofNullable(nr.searchById(noteId)).orElseThrow(() -> new NoteNotFoundException("Specified Note Not Found"));
		BeanUtils.copyProperties(entity, noteFetched);
		noteFetched.setUpdatedDateTime(LocalDateTime.now());
		nr.saveOrUpdate(noteFetched);
		return true;
	}


	@Override
	public boolean deleteNote(String token, Long noteId) {
		userAuthentication(token);
		Note fetchedNote = Optional.ofNullable(nr.searchById(noteId)).orElseThrow(() -> new NoteNotFoundException("Specified Note Not Found"));
		nr.delete(fetchedNote);
		return true;
	}


	@Override
	public boolean trashedNote(Long noteId, String token) {
		userAuthentication(token);
		Note fetchedNote = Optional.ofNullable(nr.searchById(noteId)).orElseThrow(() -> new NoteNotFoundException("Specified Note Not Found"));
		
		if(!fetchedNote.isInTrash()) {
			fetchedNote.setInTrash(true);
			fetchedNote.setUpdatedDateTime(date.presentDate());
			nr.saveOrUpdate(fetchedNote);
			return true;
		}
		
		fetchedNote.setInTrash(false);
		fetchedNote.setUpdatedDateTime(date.presentDate());
		nr.saveOrUpdate(fetchedNote);
		return false;
	}


	@Override
	public boolean pinnedNote(Long noteId, String token) {
		userAuthentication(token);
		Note fetchedNote = Optional.ofNullable(nr.searchById(noteId)).orElseThrow(()-> new NoteNoteFoundException("Note Not Found"));
		if(!fetchedNote.isPinned()) {
			fetchedNote.setPinned(true);
			fetchedNote.setUpdatedDateTime(date.presentDate());
			nr.saveOrUpdate(fetchedNote);
			return true;
		}
		fetchedNote.setPinned(false);
		fetchedNote.setUpdatedDateTime(date.presentDate());
		nr.saveOrUpdate(fetchedNote);
		return false;
	}


	@Override
	public boolean archievedNote(Long noteId, String token) {
		userAuthentication(token);
		Note fetchedNote = Optional.ofNullable(nr.searchById(noteId)).orElseThrow(() -> new NoteNotFoundException("Specified Note Not Found"));
		if(!fetchedNote.isArchieved()) {
			fetchedNote.setArchieved(true);
			fetchedNote.setUpdatedDateTime(date.presentDate());
			nr.saveOrUpdate(fetchedNote);
			return true;
		}
		fetchedNote.setArchieved(false);
		fetchedNote.setUpdatedDateTime(date.presentDate());
		nr.saveOrUpdate(fetchedNote);
		return false;
	}


	@Override
	public boolean setReminder(Long noteId, String token, ReminderEntity entity) {
		userAuthentication(token);
		Note fetchedNote = Optional.ofNullable(nr.searchById(noteId)).orElseThrow(() -> new NoteNotFoundException("Specified Note Not Found"));
		fetchedNote.setReminderTime(entity.getTime());
		fetchedNote.setUpdatedDateTime(date.presentDate());
		nr.saveOrUpdate(fetchedNote);
		return true;
	}


	@Override
	public boolean deleteReminder(Long noteId, String token) {
		userAuthentication(token);
		Note fetchedNote = Optional.ofNullable(nr.searchById(noteId)).orElseThrow(() -> new NoteNotFoundException("Specified Not Found"));
		fetchedNote.setReminderTime(null);
		fetchedNote.setUpdatedDateTime(date.presentDate());
		nr.saveOrUpdate(fetchedNote);
		return true;
	}

	@Override
	public List<Note> fetchAllNotes(String token) {
		User fetchedUser = userAuthentication(token);
		return nr.getArchievedNotes(fetchedUser.getUserId());
	}

	@Override
	public List<Note> fetchAllPinnedNotes(String token) {
		User fetchedUser = userAuthentication(token);
		return nr.getPinnedNotes(fetchedUser.getUserId());
	}

	@Override
	public List<Note> fetchAllTrashedNotes(String token) {
		User fetchedUser = userAuthentication(token);
		return nr.getTrashedNotes(fetchedUser.getUserId());
	}

	@Override
	public List<Note> fetchAllArchievedNotes(String token) {
		User fetchedUser = userAuthentication(token);
		return nr.getArchievedNotes(fetchedUser.getUserId());
	}
	
}
