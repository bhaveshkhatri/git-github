package org.cb.practice;

import org.cb.practice.dao.JdbcDaoImpl;
import org.cb.practice.dao.SupportJdbcDaoImpl;
import org.cb.practice.model.Circle;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class JdbcDemo {

	public static void main(String[] args) {
		
		ApplicationContext ctx = new ClassPathXmlApplicationContext("spring.xml");
		
		
		JdbcDaoImpl dao = ctx.getBean("jdbcDaoImpl", JdbcDaoImpl.class);
				
		SupportJdbcDaoImpl sDao = ctx.getBean("supportJdbcDaoImpl", SupportJdbcDaoImpl.class);
		
					
		//Circle circle = dao.getCircle(1);
		//System.out.println(circle.getName());
		
		//System.out.println(dao.getCircleForId(1).getName());
		
		//dao.insertCircle(new Circle(6, "Sixth Circle"));
		
		/*int i;
		for(i=0;i<dao.getAllCircle().size();i++)
		System.out.println(dao.getAllCircle().get(i).getName());*/

		//dao.createTriangleTable();
		
		System.out.println(sDao.getCircleCount());
	}

}
