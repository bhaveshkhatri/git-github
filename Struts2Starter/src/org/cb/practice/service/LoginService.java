package org.cb.practice.service;

import org.cb.practice.model.User;



public class LoginService {

	public boolean verifyLogin(User user) {
		
		if(user.getUserId().equals("cb") && user.getPassword().equals("47")) 
			return true;
		else
			return false;
	}
	
}
