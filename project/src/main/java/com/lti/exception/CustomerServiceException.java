package com.lti.exception;

public class CustomerServiceException extends RuntimeException {
	
	public CustomerServiceException() {
		super();
	}

	public CustomerServiceException(String message) {
		super(message);
	}

}
