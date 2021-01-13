package com.lti.dto;

public class Status {

	private String message;
	private StatusType status;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public StatusType getStatus() {
		return status;
	}

	public void setStatus(StatusType status) {
		this.status = status;
	}

	public static enum StatusType {
		SUCCESS, FAILED;
	}
}
