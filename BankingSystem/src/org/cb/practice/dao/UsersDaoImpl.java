package org.cb.practice.dao;

import java.util.List;

import org.cb.practice.dto.LoginBean;
import org.cb.practice.dto.Users;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class UsersDaoImpl implements UsersDao {

	String loginID;
	String password;
	
	SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
	
	@Override
	public void registerUser(Users user) {
		Session session = sessionFactory.openSession();
		
		try {
			session.beginTransaction();		
			session.save(user);
		} catch(HibernateException e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}
		
		session.getTransaction().commit();
		session.close();	

	}
	
	
	public boolean retriveUserInfo(LoginBean loginBean) {
		
		this.loginID = loginBean.getLoginID();
		this.password = loginBean.getPassword();
		
		Session session = sessionFactory.openSession();
		try {
			session.beginTransaction();
			Query query = session.createQuery("from Users where email=? and password=?");
			query.setParameter(0, loginID);
			query.setParameter(1, password);
			
			List user = query.list();
			if(user.size()==1) {
				return true;
			}
			
		} catch(HibernateException e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}
		
		session.getTransaction().commit();
		session.close();	
		
		//System.out.println(user.size());
		
		return false;
	}
	


}
