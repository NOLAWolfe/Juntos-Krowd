package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import beans.Events;

public class EventDAOImpl implements EventDAO {

	private SessionFactory sf = HibernateUtil.getSessionFactory;
	
	
	@Override
	public Events getEventById(int event_Id) {
		
		Events evn = null;
		try (Session s = sf.getCurrentSession()) {
			Transaction tx = s.beginTransaction();
			evn = (Events) s.get(Events.class, event_Id);
		}
		return evn;
		
	}

	@Override
	public void deleteEvent(Events events) {
		try (Session s = sf.getCurrentSession()) {
			Transaction tx = s.beginTransaction();
			s.delete(events);
			tx.commit();
			s.close();
		}
		
	}

	@Override
	public void updateEvent(Events events) {
		try (Session s = sf.getCurrentSession()) {
			Transaction tx = s.beginTransaction();
			s.update(events);
			tx.commit();
			s.close();
		}
		
	}

	@Override
	public void createEvent(Events events) {
		try (Session s = sf.getCurrentSession()) {
			Transaction tx = s.beginTransaction();
			s.persist(events);
			tx.commit();
			s.close();
		}
		
	}

	@Override
	public List<Events> getAllEvents() {
		List<Events> events = new ArrayList<>();
		try (Session s = sf.getCurrentSession()) {
			Transaction tx = s.beginTransaction();
			events = s.createQuery("from Events").getResultList();
			tx.commit();
			s.close();
		}
		return events;
	}


}
