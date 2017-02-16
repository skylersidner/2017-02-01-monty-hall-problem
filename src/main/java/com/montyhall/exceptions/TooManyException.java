package com.montyhall.exceptions;

public class TooManyException extends RuntimeException {


	private static final long serialVersionUID = 1L;

	public TooManyException() {
		super("The Decision Engine cannot handle the number of rounds or doors requested!");
	}
	
	public TooManyException(String message) {
		super(message);
	}

}
