package com.bridgelabz.springboot.entity;

import org.springframework.stereotype.Component;

@Component
public class LabelEntity {
	private String labelName;
	
	public String getLabelName() {
		return labelName;
	}
	
	public void setLabelName(String labelName) {
		this.labelName = labelName;
	}
}
