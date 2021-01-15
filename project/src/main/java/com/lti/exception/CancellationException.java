package com.lti.exception;

public class CancellationException extends RuntimeException{

	public CancellationException() {
		super();
		
	}

	public CancellationException(String arg0, Throwable arg1) {
		super(arg0, arg1);
		
	}
	public CancellationException(String message) {
		super(message);
		
	}
	
	

}
