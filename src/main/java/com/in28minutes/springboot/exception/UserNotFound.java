package com.in28minutes.springboot.exception;


//@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class UserNotFound extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public UserNotFound(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}
	
	

}
