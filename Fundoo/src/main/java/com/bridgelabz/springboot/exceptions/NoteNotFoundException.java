package com.bridgelabz.sprinboot.exceptions;

public class NoteNotFoundException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 6952668051793055722L;
	
	public NoteNotFoundException(String message) {
		super(message);
	}
}
