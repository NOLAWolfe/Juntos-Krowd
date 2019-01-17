package com.krowd.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.krowd.beans.Events;
import com.krowd.beans.Users;
import com.krowd.util.HibernateUtil;

public class JunctionDAOImpl implements JunctionDAO {

	private SessionFactory sf = HibernateUtil.getSessionFactory();

	@Override
	public List<Users> getAll(){
		List<Users> users = null;
		try(Session s = sf.getCurrentSession()){
			Transaction tx = s.beginTransaction();
			users = s.createQuery("from User_Friends", Users.class).getResultList();
			
			tx.commit();
			s.close();
		}
		return users;
	}
	
	// get List from User_Friends
	// Where CurrentUser//Id equals Following_User_Id = ?
	@Override
	public List<Users> getUserFollowingList(int user_Id) {
		List<Users> users = null;
		try (Session s = sf.getCurrentSession()) {
			Transaction tx = s.beginTransaction();
			users = s.createQuery("from user_Friends where FOLLOWING_USER_ID = :user_Id").setParameter("user_id", user_Id).getResultList();
			tx.commit();
			s.close();
		}
		return users;
	}

	// get List from User_Friends
	// Where CurrentUser//Id equals User_Id = ?
	@Override
	public List<Users> getUserFollowerList(int user_Id) {
		List<Users> users = null;
		try (Session s = sf.getCurrentSession()) {
			Transaction tx = s.beginTransaction();
			users = s.createQuery("from user_Friends where USER_ID = " + user_Id).getResultList();
			tx.commit();
			s.close();
		}
		return users;
	}

	@Override
	public void createFollower(Users userFriend) {
		try (Session s = sf.getCurrentSession()){
			Transaction tx = s.beginTransaction();
			s.persist(userFriend);
			tx.commit();
			s.close();
		}
	}

	@Override
	public void unFollow(Users userFriend) {
		try(Session s = sf.getCurrentSession()){
			Transaction tx = s.beginTransaction();
			s.delete(userFriend);
			tx.commit();
			s.close();
		}
	}
	
	
	// get User List from User_Events where Event_Id = ?
	@Override
	public List<Users> getAttendingUsersList(int event_Id) {
		List<Users> userEvents = new ArrayList<>();
		try (Session s = sf.getCurrentSession()) {
			Transaction tx = s.beginTransaction();
			userEvents = s.createQuery("from user_Events where EVENT_ID = " + event_Id).getResultList();
			tx.commit();
			s.close();
		}
		return userEvents;
	}



	@Override
	public List<Events> getEventUserIsAttending(int user_Id) {
		List<Events> userEvents = new ArrayList<>();
		try(Session s = sf.getCurrentSession()){
			Transaction tx = s.beginTransaction();
			userEvents = s.createQuery("from user_Events where User_Id = " + user_Id).getResultList();
			tx.commit();
			s.close();
		}
		return userEvents;
	}

	@Override
	public void createAttendee(Users userEvent) {
	}

	@Override
	public void removeAttendee(Users userEvent) {
		
	}

}
