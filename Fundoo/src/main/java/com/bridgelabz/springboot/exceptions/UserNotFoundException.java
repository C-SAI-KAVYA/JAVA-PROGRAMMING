package com.bridgelabz.sprinboot.exceptions;

public class UserNotFoundException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 8523058469794790018L;
	
	public UserNotFoundException(String message) {
		super(message);
	}

}
