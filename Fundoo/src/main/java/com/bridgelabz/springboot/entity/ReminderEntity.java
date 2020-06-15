package com.bridgelabz.springboot.entity;

import java.time.LocalDateTime;

import org.springframework.stereotype.Component;

@Component
public class ReminderEntity {
	private LocalDateTime time;

	public LocalDateTime getTime() {
		return time;
	}

	public void setTime(LocalDateTime time) {
		this.time = time;
	}
}
