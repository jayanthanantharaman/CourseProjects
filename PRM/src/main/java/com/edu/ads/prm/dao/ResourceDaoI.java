package com.edu.ads.prm.dao;

import java.util.List;

import com.edu.ads.prm.entities.Resource;

/**
 * @author Jayanth
 *
 */
public interface ResourceDaoI {
	
	/**
	 * @return ResourceRespVO
	 */
	public List<Resource> findAll();
	
	/**
	 * @param location
	 * @return List<Resource>
	 */
	public int getByPrimarySkill(Integer primarySkillId);

	/**
	 * @param location
	 * @return List<Resource>
	 */
	public int getByLocation(Integer locationId);
	
	/**
	 * @param project
	 * @return List<Resource>
	 */
	public int getByProject(Integer projectId);
	
	
	/**
	 * @param resource
	 * @return
	 */
	public Resource saveResource(Resource resource);
	
	
	/**
	 * @param id
	 * @return
	 */
	public Resource findResource(Integer id);
	
	
	/**
	 * @param resource
	 * @return
	 */
	public Resource createResource(Resource resource) ;
	
	
	/**
	 * @param id
	 * @return
	 */
	public int deleteResource(Integer id);

}
