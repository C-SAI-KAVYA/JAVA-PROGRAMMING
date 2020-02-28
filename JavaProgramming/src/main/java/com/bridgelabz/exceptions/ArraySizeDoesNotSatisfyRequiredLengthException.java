package com.bridgelabz.exceptions;

public class ArraySizeDoesNotSatisfyRequiredLengthException extends Exception{
	

	/**
	 * when array size is less than or greater than the specified length then this error will be thrown
	 */
	private static final long serialVersionUID = 1L;
	public ArraySizeDoesNotSatisfyRequiredLengthException(String message) {
		super(message);
	}
}
