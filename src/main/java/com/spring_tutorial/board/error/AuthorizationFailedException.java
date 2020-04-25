package com.spring_tutorial.board.error;

public class AuthorizationFailedException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	private String message;
	
	public AuthorizationFailedException(String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
}
