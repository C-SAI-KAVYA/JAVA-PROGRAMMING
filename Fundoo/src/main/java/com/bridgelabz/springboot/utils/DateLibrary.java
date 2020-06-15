package com.bridgelabz.springboot.utils;

import java.time.LocalDateTime;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DateLibrary {
	@Autowired
	private Date date;
	
	public LocalDateTime presentDate() {
		return LocalDateTime.now();
	}
	
	public Date getdate() {
		return date;
	}
}
