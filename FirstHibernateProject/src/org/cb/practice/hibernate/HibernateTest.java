package org.cb.practice.hibernate;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.persistence.Query;

import org.cb.practice.dto.Address;
import org.cb.practice.dto.FourWheeler;
import org.cb.practice.dto.TwoWheeler;
import org.cb.practice.dto.UserDetails;
import org.cb.practice.dto.Vehicle;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Example;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

public class HibernateTest {

	public static void main(String[] args) {

										
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
				
		UserDetails user1 = (UserDetails) session.get(UserDetails.class, 9);
		
		//UserDetails user2 = (UserDetails) session.get(UserDetails.class, 9);
		
		System.out.println(user1.getUserName());
				
		session.getTransaction().commit();
		session.close();
		
			
		
		Session session2 = sessionFactory.openSession();
		session2.beginTransaction();
				
		UserDetails user2 = (UserDetails) session2.get(UserDetails.class, 9);

		
		System.out.println(user2.getUserName());
				
		session2.getTransaction().commit();
		session2.close();
		
		}

}