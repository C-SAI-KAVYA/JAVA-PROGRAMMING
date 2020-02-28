package com.bridgelabz.exceptions;

public class SelectedStringDoesNotExsistsException extends Exception{

	/**
	 * this exception will be thrown whenever the entered string is not present
	 */
	private static final long serialVersionUID = 423936170176346550L;
	public SelectedStringDoesNotExsistsException(String message) {
		super(message);
	}
	

}
