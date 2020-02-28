package com.bridgelabz.exceptions;

public class CannotCalculateZeroPowerException extends Exception {
	/**
	 * if inputs are zero then this exception will be throwed
	 */
	private static final long serialVersionUID = 1L;

	public CannotCalculateZeroPowerException(String message) {
		super(message);
	}
}
