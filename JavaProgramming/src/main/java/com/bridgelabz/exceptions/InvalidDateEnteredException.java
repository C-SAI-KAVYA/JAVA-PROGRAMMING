package com.bridgelabz.exceptions;

public class InvalidDateEnteredException extends Exception{

	/**
	 * This exception will be thrown whenever the date entered could not help to calculate day of week
	 */
	private static final long serialVersionUID = -8901972018854091867L;
	public InvalidDateEnteredException(String message) {
		super(message);
	}
	

}
