package com.neu.edu.exception;

public class PaymentException extends Exception{
	
	public PaymentException(String message) {
		super("PaymentException-" + message);
	}

	public PaymentException(String message, Throwable cause) {
		super("PaymentException-" + message, cause);
	}
}
