package com.bridgelabz.exceptions;

public class UnsupportedValuesForEuclideanDistanceCalculationException extends Exception{

	/**
	 * This error will be thrown whenever user tries to enter an Non Number values like characters and Strings
	 */
	private static final long serialVersionUID = 3446403810572808L;
	public UnsupportedValuesForEuclideanDistanceCalculationException(String message) {
		super(message);
	}
	

}
