package com.bridgelabz.springboot.model;

import java.io.Serializable;
import java.util.Date;

import org.springframework.stereotype.Component;

@Component
public class Mail implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 2126089266085953993L;
	
	private String sender;
	private String recepient;
	private String subject;
	private String content;
	private Date sentDate;
	
	public Mail() {
		
	}

	public Mail(String sender, String recepient, String subject, String content, Date sentDate) {
		super();
		this.sender = sender;
		this.recepient = recepient;
		this.subject = subject;
		this.content = content;
		this.sentDate = sentDate;
	}

	public String getSender() {
		return sender;
	}

	public void setSender(String sender) {
		this.sender = sender;
	}

	public String getRecepient() {
		return recepient;
	}

	public void setRecepient(String recepient) {
		this.recepient = recepient;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getSentDate() {
		return sentDate;
	}

	public void setSentDate(Date sentDate) {
		this.sentDate = sentDate;
	}

	@Override
	public String toString() {
		return "Mail [sender=" + sender + ", recepient=" + recepient + ", subject=" + subject + ", content=" + content
				+ ", sentDate=" + sentDate + "]";
	}
}
