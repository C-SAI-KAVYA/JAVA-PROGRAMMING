package com.bridgelabz.springboot.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bridgelabz.sprinboot.exceptions.LabelAlreadyExsistsException;
import com.bridgelabz.sprinboot.exceptions.LabelNotAddedException;
import com.bridgelabz.sprinboot.exceptions.LabelNotFoundException;
import com.bridgelabz.sprinboot.exceptions.NoteNotFoundException;
import com.bridgelabz.sprinboot.exceptions.UserAuthenticationException;
import com.bridgelabz.springboot.entity.LabelEntity;
import com.bridgelabz.springboot.model.Label;
import com.bridgelabz.springboot.model.Note;
import com.bridgelabz.springboot.model.User;
import com.bridgelabz.springboot.repository.LabelRepository;
import com.bridgelabz.springboot.repository.NoteRepository;
import com.bridgelabz.springboot.repository.UserRepository;
import com.bridgelabz.springboot.utils.DateLibrary;
import com.bridgelabz.springboot.utils.JWTTokenLibrary;

@Service
public class LabelServiceProvider implements LabelService{
	@Autowired
	private JWTTokenLibrary jwt;
	
	@Autowired
	private UserRepository userRepo;
	
	@Autowired
	private NoteRepository nr;
	
	@Autowired
	private LabelRepository labelRepo;
	
	@Autowired
	private DateLibrary date;
	
	private User userAuthentication(String token) {
		Long userId = jwt.tokenDecoder(token);
		if(userId > 0)
			return userRepo.fetchUser(userId);
		throw new UserAuthenticationException("UnAuthorized User");
	}
	
	private Note noteValidation(Long noteId) {
		return Optional.ofNullable(nr.searchById(noteId)).orElseThrow(() -> new NoteNotFoundException("Specified Note Not Found"));
	}

	@Override
	public Label newLabel(LabelEntity newLabel, String token) {
		User fetchedUser = userAuthentication(token);
		Optional.ofNullable(labelRepo.searchByLabelName(newLabel.getLabelName())).ifPresent(label -> {
			throw new LabelAlreadyExsistsException("Label Already Exsists");
		});
		Label label = new Label();
		BeanUtils.copyProperties(newLabel,  label);
		label.setCreatedDateTime(date.presentDate());
		label.setUpdatedDateTime(date.presentDate());
		fetchedUser.getLabels().add(label);
		labelRepo.save(label);
		return label;
	}

	@Override
	public List<Label> fetchLabels(String token) {
		User fetchedUser = userAuthentication(token);
		return Optional.ofNullable(labelRepo.searchAllByUserId(fetchedUser.getUserId())).orElseThrow(() -> new LabelNotFoundException("Specified Label Not Found"));
	}

	@Override
	public Label updateLabel(LabelEntity updateLabel, String token, Long labelId) {
		userAuthentication(token);
		Label label = Optional.ofNullable(labelRepo.searchByLabelId(labelId)).orElseThrow(() -> new LabelNotFoundException("Specified Label Not Found"));
		label.setLabelName(updateLabel.getLabelName());
		label.setUpdatedDateTime(date.presentDate());
		labelRepo.save(label);
		return null;
	}

	@Override
	public Label deleteLabel(String token, Long labelId) {
		userAuthentication(token);
		return Optional.ofNullable(labelRepo.searchByLabelId(labelId)).orElseThrow(() -> new LabelNotFoundException("Specified Label Not Found"));
	}

	@Override
	public Label fetchLabel(String token, Long labelId) {
		userAuthentication(token);
		return Optional.ofNullable(labelRepo.searchByLabelId(labelId)).orElseThrow(() -> new LabelNotFoundException("Specified Label Not Found Exception"));
	}

	@Override
	public Label addToNote(Long noteId, String token, LabelEntity newLabel) {
		User fetchedUser = userAuthentication(token);
		Note fetchedNote = noteValidation(noteId);
		Optional.ofNullable(labelRepo.searchByLabelName(newLabel.getLabelName())).ifPresent(label -> {
			throw new LabelAlreadyExsistsException("Specified Label Already Exsists");
		});
		
		Label label = new Label();
		BeanUtils.copyProperties(newLabel, label);
		label.setCreatedDateTime(date.presentDate());
		label.setUpdatedDateTime(date.presentDate());
		fetchedUser.getLabels().add(label);
		fetchedNote.getLabels().add(label);
		labelRepo.save(label);
		return label;
	}

	@Override
	public Label addLabelToNote(Long noteId, String token, Long labelId) {
		userAuthentication(token);
		Note fetchedNote = noteValidation(noteId);
		Label fetchedLabel = Optional.ofNullable(labelRepo.searchByLabelId(labelId)).orElseThrow(() -> new LabelNotFoundException("Specified Label Not Found"));
		
		if(fetchedNote.getLabels().contains(fetchedLabel))
			throw new LabelAlreadyExsistsException("Label Already Present In Note");
		fetchedNote.getLabels().add(fetchedLabel);
		labelRepo.save(fetchedLabel);
		return fetchedLabel;
	}

	@Override
	public Label removeLabelFromNote(Long noteId, Long labelId, String token) {
		userAuthentication(token);
		Note fetchedNote = noteValidation(noteId);
		Label fetchedLabel = Optional.ofNullable(labelRepo.searchByLabelId(labelId)).orElseThrow(() -> new LabelNotFoundException("Specified Label Not Found"));
		
		if(!fetchedNote.getLabels().contains(fetchedLabel))
			throw new LabelNotAddedException("Specified Label Not added to Note");
		fetchedNote.getLabels().remove(fetchedLabel);
		labelRepo.save(fetchedLabel);
		return fetchedLabel;
	}
	
}
