package com.bridgelabz.springboot.service;

import java.util.List;

import com.bridgelabz.springboot.entity.LabelEntity;
import com.bridgelabz.springboot.model.Label;

public interface LabelService {
	
	public Label newLabel(LabelEntity newLable, String token);
	public List<Label> fetchLabels(String token);
	public Label updateLabel(LabelEntity updateLabel, String token, Long labelId);
	public Label deleteLabel(String token, Long labelId);
	public Label fetchLabel(String token, Long labelId);
	public Label addToNote(Long noteId, String token, LabelEntity newLabel);
	public Label addLabelToNote(Long noteId, String token, Long labelId);
	public Label removeLabelFromNote(Long noteId, Long labelId, String token);
}
