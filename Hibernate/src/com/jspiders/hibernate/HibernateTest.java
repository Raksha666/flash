package com.jspiders.hibernate;

import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.jspiders.dto.Address;
import com.jspiders.dto.userDetails128;


public class HibernateTest {

	public static void main(String[] args) {
		
		userDetails128 user= new userDetails128();
		user.setUserName("vishal");
		user.setJoinedDate(new Date());
		user.setUserId(1234);
		
		Address a1=new Address();
		a1.setCity("Jaynaar");
		a1.setState("Karnataka");
		a1.setPincode(560060);
		
		//user.setHomeAddress(a1);
		
		Address a2=new Address();
		a1.setCity("rajaajinagar");
		a1.setState("Andra");
		a1.setPincode(560040);
		//user.setHomeAddress(a2);
		
		user.getListOfAddress().add(a1);
		user.getListOfAddress().add(a2);
		    
	SessionFactory sessionFactory=	new Configuration().configure().buildSessionFactory();
	Session session=sessionFactory.openSession();
	session.beginTransaction();

	session.save(user);
  session.getTransaction().commit();	
	session.close();
	
	session=sessionFactory.openSession();
	userDetails128 user1=(userDetails128)session.get(userDetails128.class,1234);
	session.close();
	System.out.println(user1);
   //session.close();
   //System.out.println(user1);
	
	
}
}