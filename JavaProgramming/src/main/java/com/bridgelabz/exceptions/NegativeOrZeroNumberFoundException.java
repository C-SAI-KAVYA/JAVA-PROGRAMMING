package com.bridgelabz.exceptions;

public class NegativeOrZeroNumberFoundException extends Exception{
	/**
	 * if negative inputs are given or if input is zero this exception will be throwed
	 */
	private static final long serialVersionUID = 1L;

	public NegativeOrZeroNumberFoundException(String message) {
		super(message);
	}
}
