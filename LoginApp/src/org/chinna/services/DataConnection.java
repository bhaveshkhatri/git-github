package org.chinna.services;

public class DataConnection {
	
	public boolean validate(String id, String pwd) {
		
		if(id == null || id.trim()=="") {
			return false;
		}
		else {
			return true;
		}
	}
	

}
