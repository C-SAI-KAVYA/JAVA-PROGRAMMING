package com.bridgelabz.sprinboot.exceptions;

public class AlreadyExsistingUserException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1670738957682972431L;
	
	public AlreadyExsistingUserException(String message) {
		super(message);
	}
	
}
