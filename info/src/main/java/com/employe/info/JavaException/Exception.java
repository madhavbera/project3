package com.employe.info.JavaException;

public class Exception {
	//public static final String HttpStatus = null;
	private int status;
	private String error;
	private String message;
	public Exception(int status, String error, String message) {
		super();
		this.status = status;
		this.error = error;
		this.message = message;
	}
	public int getStstus() {
		return status;
	}
	public void setStstus(int status) {
		this.status = status;
	}
	public String getError() {
		return error;
	}
	public void setError(String error) {
		this.error = error;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}



	}
