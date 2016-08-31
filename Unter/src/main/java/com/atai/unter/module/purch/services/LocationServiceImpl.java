package com.atai.unter.module.purch.services;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.atai.erp.module.purch.dao.LocationDao;
import com.atai.erp.module.purch.model.Location;

@Service
public class LocationServiceImpl implements LocationService {

	private LocationDao locationDao;
	
	
	public void setLocationDao(LocationDao locationDao) {
		this.locationDao = locationDao;
	}

	@Transactional
	public void addLocation(Location p) {
		locationDao.addLocation(p);

	}
	
	@Transactional
	public void updateLocation(Location p) {
		locationDao.updateLocation(p);

	}

	@Transactional(readOnly = true)
	public List<Location> listLocations() {
		return locationDao.listLocations();
	}

	@Transactional(readOnly = true)
	public Location getLocationById(int id) {
		return locationDao.getLocationById(id);
	}

	@Transactional
	public void removeLocation(int id) {
		locationDao.removeLocation(id);

	}

}
