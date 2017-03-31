package com.edu.ads.prm.dao;

import java.util.List;

import com.edu.ads.prm.entities.Location;

/**
 * @author Jayanth
 *
 */
public interface LocationDaoI {
	
	public List<Location> findAll();
	
	public Location findLocation(Integer id);

}
