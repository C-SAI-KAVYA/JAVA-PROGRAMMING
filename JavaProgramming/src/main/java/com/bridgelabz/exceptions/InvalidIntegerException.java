package com.bridgelabz.exceptions;

public class InvalidIntegerException extends Exception{

	/**
	 * This exception will be thrown whenever the entered integers are invalid
	 */
	private static final long serialVersionUID = 6503335672651388927L;
	
	public InvalidIntegerException(String message) {
		super(message);
	}
	

}
