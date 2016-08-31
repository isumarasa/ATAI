package com.atai.unter.module.purch.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.atai.unter.module.purch.model.Location;

@Repository
public class LocationDaoImpl implements LocationDao {

	private SessionFactory sessionFactory;
	
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public void addLocation(Location p) {
		Session session = sessionFactory.getCurrentSession();
		session.persist(p);
	}

	public void updateLocation(Location p) {
		Session session = sessionFactory.getCurrentSession();
		session.update(p);
	}

	public List<Location> listLocations() {
		Session session = sessionFactory.getCurrentSession();
		List<Location> locations = session.createQuery("from location_tab").list();
		return locations;
	}

	public Location getLocationById(int id) {
		Session session = sessionFactory.getCurrentSession();
		Location location = session.load(Location.class, new Integer(id));
		return location;
	}

	public void removeLocation(int id) {
		Session session = sessionFactory.getCurrentSession();
		Location location = session.load(Location.class, new Integer(id));
		if (location != null)
		{
			session.delete(location);
		}
	}

}

