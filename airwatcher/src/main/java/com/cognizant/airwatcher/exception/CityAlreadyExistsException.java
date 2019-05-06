package com.cognizant.airwatcher.exception;
@SuppressWarnings("serial")
public class CityAlreadyExistsException extends Exception {
	String message;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return "CityAlreadyExistsException [message=" + message + "]";
	}

	public CityAlreadyExistsException(final String message) {
		super();
		this.message = message;
	}
	
	

}
