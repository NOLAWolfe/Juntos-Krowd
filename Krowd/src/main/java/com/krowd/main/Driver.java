package com.krowd.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.krowd.beans.Users;
import com.krowd.dao.UserDAO;
import com.krowd.dao.UserDAOImpl;
import com.krowd.util.HibernateUtil;

public class Driver {

	public static void main(String[] args) {

		SessionFactory sf = HibernateUtil.getSessionFactory();
		testingUsers(sf); //pretty self explanatory 
//		
		
	}
	
	static void testingUsers(SessionFactory sf) {
		UserDAO ud = new UserDAOImpl();
		Session s = sf.getCurrentSession();
		
		//ONLY NEED IF RUNNING SESSION METHODS< our DAOS have transaction instantiated already >
//		Transaction tx = s.beginTransaction();

//		tx.commit();

		
		s.close();
	}

}
