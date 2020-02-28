package com.bridgelabz.errors;

public class HarmonicNumberCannotBeFoundError extends Error{
	
	/**
	 * This Error will be thrown whenever an number is entered whose harmonic numbers cannot be found like 0 and 1
	 */
	private static final long serialVersionUID = 816559509028592457L;

	public HarmonicNumberCannotBeFoundError(String message){
		super(message);
	}
}
