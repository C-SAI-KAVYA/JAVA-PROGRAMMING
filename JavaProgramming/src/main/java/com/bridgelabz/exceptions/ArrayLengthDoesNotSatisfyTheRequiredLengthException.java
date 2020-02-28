package com.bridgelabz.exceptions;

public class ArrayLengthDoesNotSatisfyTheRequiredLengthException extends Exception{

	/**
	 * This exception will thrown whenever the array size is less than the required length
	 */
	private static final long serialVersionUID = 8262446922646222205L;
	
	public ArrayLengthDoesNotSatisfyTheRequiredLengthException(String message) {
		super(message);
	}	

}
