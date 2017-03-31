package com.edu.ads.prm.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.edu.ads.prm.common.DBConstants;
import com.edu.ads.prm.configs.DbConnect;
import com.edu.ads.prm.dao.ProjectDaoI;
import com.edu.ads.prm.entities.Project;

/**
 * @author Jayanth
 *
 */
public class ProjectDao implements ProjectDaoI {

	private static String FIND_ALL_QUERY = "SELECT proj.ID AS ID,proj.PROJECT_NAME AS PROJECT_NAME FROM PROJECT proj";

	private static String FIND_PROJECT_QUERY = "SELECT proj.ID AS ID, proj.PROJECT_NAME AS PROJECT_NAME FROM PROJECT proj "
			+ "WHERE proj.ID = ?";

	private static String INSERT_PROJECT_QUERY = "INSERT INTO PROJECT (PROJECT_NAME) values (?)";

	private static String UPDATE_PROJECT_QUERY = "UPDATE PROJECT set PROJECT_NAME=? where ID= ?";

	private static String DELETE_PROJECT_QUERY = "DELETE FROM PROJECT WHERE ID = ?";


	/*
	 * (non-Javadoc)
	 * 
	 * @see com.edu.ads.prm.dao.ProjectDaoI#findAll()
	 */
	@Override
	public List<Project> findAll() {
		DbConnect dbConnect = DbConnect.getDbConnection();
		Project project = null;
		List<Project> projects = new ArrayList<Project>();
		try {
			ResultSet resultSet = dbConnect.query(FIND_ALL_QUERY, new ArrayList<Object>());
			while (resultSet.next()) {
				project = new Project();
				project.setId(resultSet.getInt(DBConstants.ID));
				project.setProjectName(resultSet.getString(DBConstants.PROJECT_NAME));
				projects.add(project);
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

		return projects;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.edu.ads.prm.dao.ProjectDaoI#findProject(java.lang.Integer)
	 */
	@Override
	public Project findProject(Integer id) {
		DbConnect dbConnect = DbConnect.getDbConnection();
		Project project = null;
		try {
			List<Object> parameters = new ArrayList<Object>();
			parameters.add(id);
			ResultSet resultSet = dbConnect.query(FIND_PROJECT_QUERY, parameters);
			if (resultSet.next()) {
				project = new Project();
				project.setId(resultSet.getInt(DBConstants.ID));
				project.setProjectName(resultSet.getString(DBConstants.PROJECT_NAME));
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

		return project;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.edu.ads.prm.dao.ProjectDaoI#createProject(com.edu.ads.prm.entities.
	 * Project)
	 */
	@Override
	public Project createProject(Project project) {
		DbConnect dbConnect = DbConnect.getDbConnection();
		List<Object> parameters = new ArrayList<Object>();
		try {
			parameters.add(project.getProjectName());
			dbConnect.update(INSERT_PROJECT_QUERY, parameters);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				dbConnect.closeResources();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return project;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.edu.ads.prm.dao.ProjectDaoI#deleteProject(java.lang.Integer)
	 */
	@Override
	public int deleteProject(Integer id) {
		DbConnect dbConnect = DbConnect.getDbConnection();
		int result = 0;
		try {
			List<Object> parameters = new ArrayList<Object>();
			parameters.add(id);
			result = dbConnect.update(DELETE_PROJECT_QUERY, parameters);
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
	 * com.edu.ads.prm.dao.ProjectDaoI#saveProject(com.edu.ads.prm.entities.
	 * Project)
	 */
	@Override
	public Project saveProject(Project project) {
		DbConnect dbConnect = DbConnect.getDbConnection();
		List<Object> parameters = new ArrayList<Object>();
		try {
			parameters.add(project.getProjectName());
			parameters.add(project.getId());
			dbConnect.update(UPDATE_PROJECT_QUERY, parameters);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				dbConnect.closeResources();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return project;
	}

}
