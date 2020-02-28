package com.bridgelabz.exceptions;

public class IncorrectStringFormatException extends Exception {

	/**
	 * This exception will be thrown whenever the string is not in the required format
	 */
	private static final long serialVersionUID = 8645517499834653228L;
	
	public IncorrectStringFormatException(String message) {
		super(message);
	}
	
}
