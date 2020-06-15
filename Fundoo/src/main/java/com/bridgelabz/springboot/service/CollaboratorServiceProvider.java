package com.bridgelabz.springboot.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bridgelabz.sprinboot.exceptions.CollaboratorException;
import com.bridgelabz.sprinboot.exceptions.UserAuthenticationException;
import com.bridgelabz.sprinboot.exceptions.UserNotFoundException;
import com.bridgelabz.springboot.model.Mail;
import com.bridgelabz.springboot.model.Note;
import com.bridgelabz.springboot.model.User;
import com.bridgelabz.springboot.repository.UserRepositoryImpl;
import com.bridgelabz.springboot.utils.DateLibrary;
import com.bridgelabz.springboot.utils.JWTTokenLibrary;
import com.bridgelabz.springboot.utils.RabbitMQSender;

@Service
public class CollaboratorServiceProvider implements CollaboratorService{
	
	@Autowired
	private JWTTokenLibrary jwt;
	
	@Autowired
	private UserRepositoryImpl userRepository;
	
	@Autowired
	private RabbitMQSender rmqSender;
	
	@Autowired
	private Mail mail;
	
	@Autowired
	private DateLibrary date;
	
	private User userAuthentication(String token) {
		Long userId = jwt.tokenDecoder(token);
		if(userId > 0)
			return Optional.ofNullable(userRepository.fetchUser(userId)).get();
		throw new UserAuthenticationException("UnAuthorised User");
	}
	
	@Override
	public Note addCollaborator(Long noteId, String token, String emailId) {
		User user = userAuthentication(token);
		Optional.ofNullable(user).filter(usr -> user.getEmailId().equals(emailId)).ifPresent(usr -> {
			throw new CollaboratorException("Can't add same user as Collaborator");
		});
		User collaboratorUser = userValidation(emailId);
		List<Note> notes = user.getNotes();
		notes.forEach(note -> {
			if(note.getNoteId() == noteId) {
				note.getCollaboratorUsers().add(collaboratorUser);
				mail.setSender(user.getEmailId());
				mail.setRecepient(emailId);
				mail.setSubject("Sharing note :"+note.getTitle());
				mail.setContent("");
				mail.setSentDate(date.getdate());
				rmqSender.sendMail(mail);
			}
		});
		return null;
	}
	
	private User userValidation(String emailId) {
		return Optional.ofNullable(userRepository.fetchUser(emailId)).orElseThrow(() -> new UserNotFoundException("User Not Found Exception"));
	}

}
