package org.cb.practice;

public class InvalidInputException extends Exception {
	
	public String errorDetails;
	
	public InvalidInputException(String response, String errorDetails) {
		super(response);
		this.errorDetails = errorDetails;		
	}
	
	public String getFaultInfo() {
		return errorDetails;
	}

}
