package com.bridgelabz.exceptions;

public class PrimeFactorsCannotBeFoundForZeroAndOneException extends Exception{
	/**
	 * If entered number entered is zero or one then this exception will be thrown
	 */
	private static final long serialVersionUID = 1L;

	public PrimeFactorsCannotBeFoundForZeroAndOneException(String message) {
		super(message);
	}

}
