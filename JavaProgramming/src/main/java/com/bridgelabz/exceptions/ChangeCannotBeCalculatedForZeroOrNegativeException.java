package com.bridgelabz.exceptions;

public class ChangeCannotBeCalculatedForZeroOrNegativeException extends Exception {

	/**
	 * This exception will be throwed whenever the entered amount is zero for vending machine
	 */
	private static final long serialVersionUID = -5067514650607509491L;
	public ChangeCannotBeCalculatedForZeroOrNegativeException(String message) {
		super(message);
	}
	

}
