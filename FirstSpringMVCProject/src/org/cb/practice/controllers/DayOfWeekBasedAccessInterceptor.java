package org.cb.practice.controllers;

import java.io.IOException;
import java.util.Calendar;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class DayOfWeekBasedAccessInterceptor extends HandlerInterceptorAdapter {

		public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws IOException {
			
			Calendar cal = Calendar.getInstance();
			System.out.println("Hello chinna!x");
			
			int dayOfWeek = cal.get(cal.DAY_OF_WEEK);
			
			if(dayOfWeek==2) {
				
				System.out.println("Hello chinna!");
				response.getWriter().write("The website is closed on sunday.  So, please try another day!!!");
				return false;
			}
			return true;
		}
		
		
		public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView mv) {

			System.out.println("HandlerInteceptorAdaptor:  Spring MVC called after postHandle() method!!!"+request.getRequestURI().toString());			
		}
		
	
		public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
			
			System.out.println("HandlerInteceptorAdaptor:  Spring MVC called after afterCompletion() method!!!"+request.getRequestURI().toString());
		}
}
