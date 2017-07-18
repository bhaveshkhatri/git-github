package org.cb.practice.dao;

import org.cb.practice.dto.LoginBean;
import org.cb.practice.dto.Users;

public interface UsersDao {
	
	public void registerUser(Users user);	
	public boolean retriveUserInfo(LoginBean loginBean);
	

}
