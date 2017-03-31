package com.edu.ads.prm.dao;

import java.util.List;

import com.edu.ads.prm.entities.Project;

/**
 * @author Jayanth
 *
 */
public interface ProjectDaoI {
	
	/**
	 * @return
	 */
	public List<Project> findAll();
	
	/**
	 * @param id
	 * @return
	 */
	public Project findProject(Integer id);
	

	/**
	 * @param project
	 * @return
	 */
	public Project createProject(Project project) ;
	
	/**
	 * @param id
	 * @return
	 */
	public int deleteProject(Integer id);
	
	/**
	 * @param project
	 * @return
	 */
	public Project saveProject(Project project);
	

}
