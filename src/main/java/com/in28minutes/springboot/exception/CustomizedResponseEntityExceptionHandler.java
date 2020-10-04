package com.in28minutes.springboot.exception;

import java.util.Date;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
@RestController
public class CustomizedResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(Exception.class)
	public final ResponseEntity<Object> handleAllException(UserNotFound ex, WebRequest request) {
                   
		ExceptionResponse e = new ExceptionResponse(new Date(),request.getDescription(false),
				ex.getMessage());
		return new ResponseEntity<Object>(e, HttpStatus.INTERNAL_SERVER_ERROR);
				
				
	}
	
	@ExceptionHandler(UserNotFound.class)
	public final ResponseEntity<Object> handleNotFoundException(Exception ex, WebRequest request) {

		ExceptionResponse e = new ExceptionResponse(new Date(),request.getDescription(false),
				ex.getMessage());
		return new ResponseEntity<Object>(e, HttpStatus.NOT_FOUND);
				
	}
	
	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		ExceptionResponse exceptionResponse = new ExceptionResponse(new Date(), "Validation Failed",
				ex.getBindingResult().toString());
		return new ResponseEntity<Object>(exceptionResponse, HttpStatus.BAD_REQUEST);
	}

}
