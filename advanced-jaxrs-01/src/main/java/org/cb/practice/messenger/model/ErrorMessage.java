package org.cb.practice.messenger.model;

import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement
public class ErrorMessage {
	
	private String message;
	private int id;
	private String documentation;
	
	public ErrorMessage() {
		
	}
	
	public ErrorMessage(String message, int id, String documentation) {
		this.message = message;
		this.id = id;
		this.documentation = documentation;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDocumentation() {
		return documentation;
	}

	public void setDocumentation(String documentation) {
		this.documentation = documentation;
	}
	

}
