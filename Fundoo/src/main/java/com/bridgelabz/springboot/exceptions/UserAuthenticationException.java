package com.bridgelabz.sprinboot.exceptions;

public class UserAuthenticationException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = -4781910640612612959L;
	public UserAuthenticationException(String message) {
		super(message);
	}
}
