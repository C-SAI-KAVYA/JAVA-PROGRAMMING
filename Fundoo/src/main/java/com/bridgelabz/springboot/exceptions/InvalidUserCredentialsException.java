package com.bridgelabz.sprinboot.exceptions;

public class InvalidUserCredentialsException extends RuntimeException{
	/**
	 * 
	 */
	private static final long serialVersionUID = -408092544375545390L;

	public InvalidUserCredentialsException(String message) {
		super(message);
	}
}
