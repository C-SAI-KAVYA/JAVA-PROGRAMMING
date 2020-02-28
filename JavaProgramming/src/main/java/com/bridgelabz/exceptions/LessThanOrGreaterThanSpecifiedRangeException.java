package com.bridgelabz.exceptions;

public class LessThanOrGreaterThanSpecifiedRangeException extends Exception{
	/**
	 * If entered number is not in specified range then this exception will be thrown
	 */
	private static final long serialVersionUID = 1L;

	public LessThanOrGreaterThanSpecifiedRangeException(String message) {
		super(message);
	}

}
