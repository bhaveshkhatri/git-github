package org.cb.springpractice;

import org.cb.springpractice.service.ShapeService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AopMain {

	public static void main(String[] args) {
		
		
		ApplicationContext ctx = new ClassPathXmlApplicationContext("spring.xml");
		
		ShapeService shapeService = ctx.getBean("shapeService", ShapeService.class);
			
		shapeService.getCircle().setName("chinnaaaa");
		//System.out.println(shapeService.getCircle().getName());
				

	}
 
}
