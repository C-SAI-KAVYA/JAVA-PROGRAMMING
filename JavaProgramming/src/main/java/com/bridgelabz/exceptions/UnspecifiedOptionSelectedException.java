package com.bridgelabz.exceptions;

public class UnspecifiedOptionSelectedException extends Exception{

	/**
	 * this exception will be thrown whenever the user selects the unspecified option
	 */
	private static final long serialVersionUID = -3225447842140254351L;
	
	public UnspecifiedOptionSelectedException(String message) {
		super(message);
	}
}
