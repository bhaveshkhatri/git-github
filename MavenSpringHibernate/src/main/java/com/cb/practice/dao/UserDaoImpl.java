package com.cb.practice.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.cb.practice.dto.User;

public class UserDaoImpl implements UsersDao {
	
	
	
	private SessionFactory sessionFactory;
	
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}


	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}


	public void registerUser(User user) {
		
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(user);
		session.getTransaction().commit();
		session.close();

	}

}
