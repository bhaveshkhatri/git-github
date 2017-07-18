package org.cb.practice.controller;

import org.cb.practice.dao.UsersDao;
import org.cb.practice.dao.UsersDaoImpl;
import org.cb.practice.dto.LoginBean;
import org.cb.practice.dto.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CoreController {
	
	@Autowired
	private UsersDao userDao;
	
	@RequestMapping(value="/registration.html", method = RequestMethod.POST)
	public ModelAndView registerUser(@ModelAttribute("user") Users user) {
						
		userDao.registerUser(user);
		
		
		ModelAndView mv = new ModelAndView("success");
		System.out.println("hello cb");
		
		return mv;
	}
	
	@RequestMapping(value="/login", method=RequestMethod.GET)
	public ModelAndView loginUser(@ModelAttribute("loginBean") LoginBean loginBean) {
		
		if(loginBean.getLoginID()!=null && loginBean.getPassword()!=null) {
			if(userDao.retriveUserInfo(loginBean)) {
				ModelAndView mv = new ModelAndView("success");
				return mv;
			} 			
		}
		
		
		ModelAndView mv = new ModelAndView("login");
		mv.addObject("loginAlert", "Please enter correct LoginID and Password!!!");
		return mv;
		
	}

}
