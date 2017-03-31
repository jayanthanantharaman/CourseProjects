package com.edu.ads.prm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.edu.ads.prm.dao.LocationDaoI;
import com.edu.ads.prm.dao.ResourceDaoI;
import com.edu.ads.prm.entities.Location;
import com.edu.ads.prm.service.LocationServiceI;
import com.edu.ads.prm.vo.LocationRespVO;

public class LocationService implements LocationServiceI {
	
	 	@Autowired
	    LocationDaoI locationDao;
	    
	    @Autowired
	    ResourceDaoI resourceDao;

	/* (non-Javadoc)
	 * @see com.edu.ads.prm.service.LocationServiceI#getPeachLocations()
	 */
	@Override
	public LocationRespVO getLocations() {
		LocationRespVO locationRespVO = new LocationRespVO();
		List<Location> locations = getLocationsList();
		setPeopleCount(locations);
		locationRespVO.setRecords(locations);
		locationRespVO.setTotal(locations.size());
		return locationRespVO;
	}

	/* (non-Javadoc)
	 * @see com.edu.ads.prm.service.LocationServiceI#getPeachLocationsList()
	 */
	@Override
	public List<Location> getLocationsList() {
		List<Location> locations = locationDao.findAll();
		return locations;
	}

	/* (non-Javadoc)
	 * @see com.edu.ads.prm.service.LocationServiceI#setPeopleCount(java.util.List)
	 */
	@Override
	public void setPeopleCount(List<Location> locations) {
		for (Location location : locations) {
			location.setPeopleCount(resourceDao.getByLocation(location.getId()));
		}

	}

}
