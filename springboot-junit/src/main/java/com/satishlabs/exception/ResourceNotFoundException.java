package com.satishlabs.exception;

public class ResourceNotFoundException extends RuntimeException{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String message;

	public ResourceNotFoundException(String message) {
		this.message = message;
	}
	
	
}
