package com.edu.ads.prm.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.edu.ads.prm.common.DBConstants;
import com.edu.ads.prm.configs.DbConnect;
import com.edu.ads.prm.dao.LocationDaoI;
import com.edu.ads.prm.dao.ProjectDaoI;
import com.edu.ads.prm.dao.ResourceDaoI;
import com.edu.ads.prm.dao.SkillDaoI;
import com.edu.ads.prm.entities.Resource;

/**
 * @author Jayanth
 *
 */
public class ResourceDao implements ResourceDaoI {

	@Autowired
	LocationDaoI locationDao;
	@Autowired
	ProjectDaoI projectDao;
	@Autowired
	SkillDaoI skillsDao;

	private static String FIND_ALL_QUERY = "SELECT res.ID AS ID, res.CAREER_LEVEL AS CAREER_LEVEL, res.EMAIL AS EMAIL, "
			+ "res.ENTERPRISE_ID AS ENTERPRISE_ID, res.FULLNAME AS FULLNAME, res.LOCATION_ID AS LOCATION_ID, res.PHONE AS PHONE, "
			+ "res.PRIMARYSKILL_ID AS PRIMARYSKILL_ID, res.PROJECT_ID AS PROJECT_ID, res.SECONDARYSKILL_ID AS SECONDARYSKILL_ID"
			+ " FROM RESOURCE res";

	private static String FIND_RESOURCE_QUERY = "SELECT res.ID AS ID, res.CAREER_LEVEL AS CAREER_LEVEL, res.EMAIL AS EMAIL, "
			+ "res.ENTERPRISE_ID AS ENTERPRISE_ID, res.FULLNAME AS FULLNAME, res.LOCATION_ID AS LOCATION_ID, res.PHONE AS PHONE, "
			+ "res.PRIMARYSKILL_ID AS PRIMARYSKILL_ID, res.PROJECT_ID AS PROJECT_ID, res.SECONDARYSKILL_ID AS SECONDARYSKILL_ID"
			+ " FROM RESOURCE res WHERE res.ID = ?";

	private static String INSERT_RESOURCE_QUERY = "INSERT INTO RESOURCE (CAREER_LEVEL, EMAIL, ENTERPRISE_ID, FULLNAME, LOCATION_ID, PHONE,"
			+ " PRIMARYSKILL_ID, PROJECT_ID, SECONDARYSKILL_ID) values (?, ?, ?, ?, ?, ?, ?, ?, ?)";

	private static String UPDATE_RESOURCE_QUERY = "UPDATE RESOURCE set CAREER_LEVEL=?, EMAIL=?, ENTERPRISE_ID=?, FULLNAME=?, LOCATION_ID=?, "
			+ "PHONE=?, PRIMARYSKILL_ID=?, PROJECT_ID=?, SECONDARYSKILL_ID=? where ID=?";

	private static String DELETE_RESOURCE_QUERY = "DELETE FROM RESOURCE WHERE ID = ?";

	private static String GET_RESOURCE_COUNT_BY_PROJECT = "SELECT COUNT(*) AS COUNT FROM RESOURCE res LEFT OUTER JOIN PROJECT "
			+ "proj ON res.PROJECT_ID = proj.ID WHERE proj.ID = ?";

	private static String GET_RESOURCE_COUNT_BY_LOCATION = "SELECT COUNT(*) AS COUNT FROM RESOURCE res LEFT OUTER JOIN LOCATION "
			+ "loc ON res.LOCATION_ID = loc.ID WHERE loc.ID = ?";

	private static String GET_RESOURCE_COUNT_BY_PRIMARYSKILL = "SELECT COUNT(*) AS COUNT FROM RESOURCE res LEFT OUTER JOIN SKILLS "
			+ "skill ON res.PRIMARYSKILL_ID = skill.ID WHERE skill.ID = ?";
	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.edu.ads.prm.dao.ResourceDaoI#getByLocation(com.edu.ads.prm.entities.
	 * Location)
	 */
	@Override
	public int getByLocation(Integer locationId) {
		DbConnect dbConnect = DbConnect.getDbConnection();
		int result = 0;

		try {
			List<Object> parameters = new ArrayList<Object>();
			parameters.add(locationId);
			ResultSet resultSet = dbConnect.query(GET_RESOURCE_COUNT_BY_LOCATION, parameters);
			if (resultSet.next()) {
				result = resultSet.getInt(DBConstants.COUNT);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				dbConnect.closeResources();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.edu.ads.prm.dao.ResourceDaoI#getByProject(com.edu.ads.prm.entities.
	 * Project)
	 */
	@Override
	public int getByProject(Integer projectId) {
		DbConnect dbConnect = DbConnect.getDbConnection();
		int result = 0;

		try {
			List<Object> parameters = new ArrayList<Object>();
			parameters.add(projectId);
			ResultSet resultSet = dbConnect.query(GET_RESOURCE_COUNT_BY_PROJECT, parameters);
			if (resultSet.next()) {
				result = resultSet.getInt(DBConstants.COUNT);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				dbConnect.closeResources();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.edu.ads.prm.dao.ResourceDaoI#findAll()
	 */
	@Override
	public List<Resource> findAll() {

		DbConnect dbConnect = DbConnect.getDbConnection();
		List<Resource> resources = new ArrayList<Resource>();
		Resource resource = null;
		try {
			ResultSet resultSet = dbConnect.query(FIND_ALL_QUERY, new ArrayList<Object>());
			while (resultSet.next()) {
				resource = new Resource();
				resource.setId(resultSet.getInt(DBConstants.ID));
				resource.setCareerLevel(resultSet.getInt(DBConstants.CAREER_LEVEL));
				resource.setEnterprise_Id(resultSet.getString(DBConstants.ENTERPRISE_ID));
				resource.setEmail(resultSet.getString(DBConstants.EMAIL));
				resource.setFullName(resultSet.getString(DBConstants.FULLNAME));
				resource.setPhone(resultSet.getString(DBConstants.PHONE));
				resource.setLocation(locationDao.findLocation(resultSet.getInt(DBConstants.LOCATION_ID)));
				resource.setProject(projectDao.findProject(resultSet.getInt(DBConstants.PROJECT_ID)));
				resource.setPrimarySkill(skillsDao.findSkill(resultSet.getInt(DBConstants.PRIMARYSKILL_ID)));
				resource.setSecondarySkill(skillsDao.findSkill(resultSet.getInt(DBConstants.SECONDARYSKILL_ID)));
				resources.add(resource);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				dbConnect.closeResources();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return resources;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.edu.ads.prm.dao.ResourceDaoI#save(com.edu.ads.prm.entities.Resource)
	 */
	@Override
	public Resource saveResource(Resource resource) {
		DbConnect dbConnect = DbConnect.getDbConnection();
		List<Object> parameters = new ArrayList<Object>();
		try {
			parameters.add(resource.getCareerLevel());
			parameters.add(resource.getEmail());
			parameters.add(resource.getEnterprise_Id());
			parameters.add(resource.getFullName());
			parameters.add(resource.getLocation().getId());
			parameters.add(resource.getPhone());
			parameters.add(resource.getPrimarySkill().getId());
			parameters.add(resource.getProject().getId());
			parameters.add(resource.getSecondarySkill().getId());
			parameters.add(resource.getId());
			dbConnect.update(UPDATE_RESOURCE_QUERY, parameters);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				dbConnect.closeResources();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return resource;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.edu.ads.prm.dao.ResourceDaoI#findResource(com.edu.ads.prm.entities.
	 * Resource)
	 */
	@Override
	public Resource findResource(Integer id) {
		Resource resource = null;
		DbConnect dbConnect = DbConnect.getDbConnection();
		try {
			List<Object> parameters = new ArrayList<Object>();
			parameters.add(id);
			ResultSet resultSet = dbConnect.query(FIND_RESOURCE_QUERY, parameters);
			if (resultSet.next()) {
				resource = new Resource();
				resource.setId(resultSet.getInt(DBConstants.ID));
				resource.setCareerLevel(resultSet.getInt(DBConstants.CAREER_LEVEL));
				resource.setEnterprise_Id(resultSet.getString(DBConstants.ENTERPRISE_ID));
				resource.setEmail(resultSet.getString(DBConstants.EMAIL));
				resource.setFullName(resultSet.getString(DBConstants.FULLNAME));
				resource.setPhone(resultSet.getString(DBConstants.PHONE));
				resource.setLocation(locationDao.findLocation(resultSet.getInt(DBConstants.LOCATION_ID)));
				resource.setProject(projectDao.findProject(resultSet.getInt(DBConstants.PROJECT_ID)));
				resource.setPrimarySkill(skillsDao.findSkill(resultSet.getInt(DBConstants.PRIMARYSKILL_ID)));
				resource.setSecondarySkill(skillsDao.findSkill(resultSet.getInt(DBConstants.SECONDARYSKILL_ID)));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				dbConnect.closeResources();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return resource;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.edu.ads.prm.dao.ResourceDaoI#insertResource(com.edu.ads.prm.entities.
	 * Resource)
	 */
	@Override
	public Resource createResource(Resource resource) {
		DbConnect dbConnect = DbConnect.getDbConnection();
		List<Object> parameters = new ArrayList<Object>();
		try {
			parameters.add(resource.getCareerLevel());
			parameters.add(resource.getEmail());
			parameters.add(resource.getEnterprise_Id());
			parameters.add(resource.getFullName());
			parameters.add(resource.getLocation().getId());
			parameters.add(resource.getPhone());
			parameters.add(resource.getPrimarySkill().getId());
			parameters.add(resource.getProject().getId());
			parameters.add(resource.getSecondarySkill().getId());
			dbConnect.update(INSERT_RESOURCE_QUERY, parameters);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				dbConnect.closeResources();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return resource;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.edu.ads.prm.dao.ResourceDaoI#deleteResource(java.lang.Integer)
	 */
	@Override
	public int deleteResource(Integer id) {
		DbConnect dbConnect = DbConnect.getDbConnection();
		int result = 0;
		try {
			List<Object> parameters = new ArrayList<Object>();
			parameters.add(id);
			result = dbConnect.update(DELETE_RESOURCE_QUERY, parameters);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				dbConnect.closeResources();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return result;
	}

	/* (non-Javadoc)
	 * @see com.edu.ads.prm.dao.ResourceDaoI#getByPrimarySkill(java.lang.Integer)
	 */
	@Override
	public int getByPrimarySkill(Integer primarySkillId) {
		DbConnect dbConnect = DbConnect.getDbConnection();
		int result = 0;

		try {
			List<Object> parameters = new ArrayList<Object>();
			parameters.add(primarySkillId);
			ResultSet resultSet = dbConnect.query(GET_RESOURCE_COUNT_BY_PRIMARYSKILL, parameters);
			if (resultSet.next()) {
				result = resultSet.getInt(DBConstants.COUNT);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				dbConnect.closeResources();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return result;
	}

}
