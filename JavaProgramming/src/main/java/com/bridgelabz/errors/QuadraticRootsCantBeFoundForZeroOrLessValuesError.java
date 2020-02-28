package com.bridgelabz.errors;

public class QuadraticRootsCantBeFoundForZeroOrLessValuesError extends Error{

	/**
	 * This error will be thrown whenever the values of a b c in the quadratic equation are less than or equal to zero
	 */
	private static final long serialVersionUID = 2221695705385292580L;
	
	public QuadraticRootsCantBeFoundForZeroOrLessValuesError(String message) {
		super(message);
	}
	
}
