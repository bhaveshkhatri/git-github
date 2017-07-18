package com.cb.practice.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.cb.practice.dao.UserDaoImpl;
import com.cb.practice.dao.UsersDao;
import com.cb.practice.dto.User;

@Controller
public class FirstController {

	@Autowired
	private UsersDao userDao;
	
	@RequestMapping(value = "/registration", method = RequestMethod.POST)
	public ModelAndView firstMethod(@ModelAttribute("user") User user) {
		//User user = new User("Surya", "Kondamidi", "surya@gmail.com", "123456", "05/01/1990", "Mail", "9666528526");
		System.out.println("it is here!!!!!!!!!!!");
		userDao.registerUser(user);
		ModelAndView mv = new ModelAndView("welcome");
		mv.addObject("message", "User registration successful");
		return mv;
	}

		
}
