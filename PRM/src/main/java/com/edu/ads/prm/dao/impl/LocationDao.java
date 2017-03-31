package com.edu.ads.prm.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.edu.ads.prm.common.DBConstants;
import com.edu.ads.prm.configs.DbConnect;
import com.edu.ads.prm.dao.LocationDaoI;
import com.edu.ads.prm.entities.Location;

/**
 * @author Jayanth
 *
 */
public class LocationDao implements LocationDaoI {

	private static String FIND_ALL_QUERY = "SELECT loc.ID AS ID,loc.LOCATION_NAME AS LOCATION_NAME FROM LOCATION loc";

	private static String FIND_LOCATION_QUERY = "SELECT loc.ID AS ID,loc.LOCATION_NAME AS LOCATION_NAME FROM LOCATION loc "
			+ "WHERE loc.ID = ?";

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.edu.ads.prm.dao.LocationDaoI#findAll()
	 */
	@Override
	public List<Location> findAll() {
		DbConnect dbConnect = DbConnect.getDbConnection();
		List<Location> locations = new ArrayList<Location>();
		Location location = null;
		try {
			ResultSet resultSet = dbConnect.query(FIND_ALL_QUERY, new ArrayList<Object>());
			while (resultSet.next()) {
				location = new Location();
				location.setId(resultSet.getInt(DBConstants.ID));
				location.setLocationName(resultSet.getString(DBConstants.LOCATION_NAME));
				locations.add(location);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				dbConnect.closeResources();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return locations;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.edu.ads.prm.dao.LocationDaoI#findLocation(java.lang.Integer)
	 */
	@Override
	public Location findLocation(Integer id) {
		DbConnect dbConnect = DbConnect.getDbConnection();
		Location location = null;
		try {
			List<Object> parameters = new ArrayList<Object>();
			parameters.add(id);
			ResultSet resultSet = dbConnect.query(FIND_LOCATION_QUERY, parameters);
			if (resultSet.next()) {
				location = new Location();
				location.setId(resultSet.getInt(DBConstants.ID));
				location.setLocationName(resultSet.getString(DBConstants.LOCATION_NAME));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				dbConnect.closeResources();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return location;
	}

}
