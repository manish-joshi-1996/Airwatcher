package com.cognizant.airwatcher.exception;

@SuppressWarnings("serial")
public class CityNotFoundException extends Exception {
	
	String message;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return "CityNotFoundException [message=" + message + "]";
	}

	public CityNotFoundException(final String message) {
		super();
		this.message = message;
	}
}