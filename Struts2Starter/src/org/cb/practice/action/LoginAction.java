package org.cb.practice.action;

import org.apache.commons.lang.StringUtils;
import org.cb.practice.model.User;
import org.cb.practice.service.LoginService;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class LoginAction extends ActionSupport implements ModelDriven {
	

	/*private String userId;
	private String password;*/
	User user = new User();    
	
	/* public User getUser() {
	return user;
}

public void setUser(User user) {
	this.user = user;
} */

	
	public void validate() {
		
		if(StringUtils.isEmpty(user.getUserId())) {
			addFieldError("userId", "UserID can not be blank");
		}
		if(StringUtils.isEmpty(user.getPassword())) {
			addFieldError("password", "Password can not be blank");
		}
	}
	

	public String execute() {
		
		LoginService loginService = new LoginService();
		
		/*User user = new User();
		user.setUserId(userId);
		user.setPassword(password);*/
				System.out.println("User ID before execute: "+user.getUserId());
		if(loginService.verifyLogin(user)) {
			System.out.println("This is user ID: "+user.getUserId());
			
			if(user.getUserId().equals("cb")) {
				//int i = 12/0;
			}
			return SUCCESS;
		}
		else
			return LOGIN;
	}
	
	
	public String someOther() {
		
		System.out.println("hello cb....!");
		return "success";
	}

	@Override
	public Object getModel() {

		return user;
	}

	
}
