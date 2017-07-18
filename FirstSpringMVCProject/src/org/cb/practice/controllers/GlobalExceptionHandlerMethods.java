package org.cb.practice.controllers;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;


@ControllerAdvice
public class GlobalExceptionHandlerMethods {
	
	
	
	@ExceptionHandler(value=NullPointerException.class)
	public String handleNullPointerException(Exception e) {
		
		System.out.println("Null pointer exception has occured"+e);
		return "NullPointerException";
		
	}
	
	@ResponseStatus
	@ExceptionHandler(value=Exception.class)
	public String handleExceptions(Exception e) {
		System.out.println("All kinds of exceptionns "+e);
		return "Exception";
	}
	

}
