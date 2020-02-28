package com.bridgelabz.errors;

public class UnspecifiedOptionSelectedError extends Error{

	/**
	 * this error will be thrown when the user will select anything that is not present in the specified list
	 */
	private static final long serialVersionUID = 1L;
		public UnspecifiedOptionSelectedError(String message) {
			super(message);
		}
}
