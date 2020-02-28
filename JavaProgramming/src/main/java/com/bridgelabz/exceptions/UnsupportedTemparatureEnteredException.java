package com.bridgelabz.exceptions;

public class UnsupportedTemparatureEnteredException extends Exception {

	/**
	 * This Exception will be thrown when the user enteres any temparature which is not in celcius or farenheit format
	 */
	private static final long serialVersionUID = 358590005519007447L;
	public UnsupportedTemparatureEnteredException(String message) {
		super(message);
	}
	

}
