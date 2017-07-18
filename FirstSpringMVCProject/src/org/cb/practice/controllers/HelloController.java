package org.cb.practice.controllers;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;



/*import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

public class HelloController extends AbstractController {

	@Override
	protected ModelAndView handleRequestInternal(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		ModelAndView modelAndView = new ModelAndView("HelloPage");
		modelAndView.addObject("welcomeMessage", "Hi, CB.... Welcome to the first Spring MVC application");
		
		return modelAndView;
	}

}*/

@Controller
public class HelloController {
	
	@RequestMapping("/welcome/{countryName}/{userName}")
	public ModelAndView helloWorld(@PathVariable Map<String,String> pathVars) {
		
		String name = pathVars.get("userName");
		String country = pathVars.get("countryName");
		
		ModelAndView model = new ModelAndView("HelloPage");
		model.addObject("welcomeMessage", "Welcome "+name+" and your country is "+country);
		return model;
	}
	
	@RequestMapping("/hi")
	public ModelAndView hi() {
		ModelAndView model = new ModelAndView("HelloPage");
		model.addObject("welcomeMessage", "HI CB!");
		return model;
	}
	
}





