package com.neu.edu.exception;

public class RecipientException extends Exception{
	
	public RecipientException(String message) {
		super("RecipientException-" + message);
	}

	public RecipientException(String message, Throwable cause) {
		super("RecipientException-" + message, cause);
	}
}
