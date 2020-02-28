package com.bridgelabz.exceptions;

public class PermutationsCannotBeFoundForNullOrZeroCharacterisedString extends Exception {

	/**
	 * this exception will be thrown while searching the permutations of a string if the entered string has less than two characters
	 */
	private static final long serialVersionUID = 3357649946951212372L;
	
	public PermutationsCannotBeFoundForNullOrZeroCharacterisedString(String message) {
		super(message);
	}
	
	
}
