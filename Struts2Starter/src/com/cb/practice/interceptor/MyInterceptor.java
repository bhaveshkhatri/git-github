package com.cb.practice.interceptor;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;
import com.opensymphony.xwork2.util.ValueStack;


public class MyInterceptor implements Interceptor {

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

	@Override
	public void init() {
		// TODO Auto-generated method stub

	}

	@Override
	public String intercept(ActionInvocation ai) throws Exception {
		
		ValueStack stack = ai.getStack();
		String s = stack.findString("userId");
		stack.set("userId", s.toUpperCase());
		
		//stack.set("userId", stack.findString("userId").toUpperCase());
		
		System.out.println("The user id at interceptor is: "+stack.findString("userId"));
		Thread.sleep(3000);
		System.out.println("Active");
		return ai.invoke();
		  
	}
 
}
