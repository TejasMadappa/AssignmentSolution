package com.myapp.exception;

public class UpdatesRetrievalException extends RuntimeException {

	private static final long serialVersionUID = -5373577290031902537L;

	public UpdatesRetrievalException(String message) {
		super(message);
	}

	public UpdatesRetrievalException(String message, Throwable cause) {
		super(message, cause);
	}
}
