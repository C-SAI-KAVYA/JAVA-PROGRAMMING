package com.bridgelabz.exceptions;

public class CannotCheckAnagramForEmptyStringException extends Exception {

	/**
	 * This exception will be thrown whenever the two strings or any one string is empty while checking for anagram
	 */
	private static final long serialVersionUID = 6981299573367845345L;
	public CannotCheckAnagramForEmptyStringException(String message) {
		super(message);
	}
	
	
}
