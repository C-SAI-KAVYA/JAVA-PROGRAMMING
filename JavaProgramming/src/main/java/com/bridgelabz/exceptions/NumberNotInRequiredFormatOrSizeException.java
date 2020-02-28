package com.bridgelabz.exceptions;

public class NumberNotInRequiredFormatOrSizeException extends Exception{
	/**
	 * If entered number is not in the specified format then this exception will be thrown
	 */
	private static final long serialVersionUID = 1L;

	public NumberNotInRequiredFormatOrSizeException(String message) {
		super(message);
	}
}
