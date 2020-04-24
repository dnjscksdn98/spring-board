package com.spring_tutorial.board.error;

public class PasswordDismatchException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	private String message;
	
	public PasswordDismatchException(String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
}
