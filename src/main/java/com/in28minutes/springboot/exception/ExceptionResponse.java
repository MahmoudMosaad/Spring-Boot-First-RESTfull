package com.in28minutes.springboot.exception;

import java.util.Date;

public class ExceptionResponse {
	
	private Date timestamp;
	private String details;
	private String message ;
	public ExceptionResponse(Date timestamp, String details, String message) {
		super();
		this.timestamp = timestamp;
		this.details = details;
		this.message = message;
	}
	public Date getDate() {
		return timestamp;
	}
	public String getDetails() {
		return details;
	}
	public String getMessage() {
		return message;
	}
	
	
	

}
