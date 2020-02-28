package com.bridgelabz.exceptions;

public class LinkedListEmptyException extends Exception {
	
	/**
	 * This exception will be thrown whenever the linked list is empty.
	 */
	private static final long serialVersionUID = 5250430441226873282L;

	public LinkedListEmptyException(String message) {
		super(message);
	}
}
