/**
 * Author : Jayanth 
 *	Nov 1, 2016
 */
package com.edu.ads.prm.service;

import java.util.List;

import com.edu.ads.prm.entities.Project;
import com.edu.ads.prm.vo.ProjectRespVO;

/**
 * @author Jayanth
 *
 */
public interface ProjectServiceI {

	/**
	 * @return
	 */
	public ProjectRespVO getProjects();
	
	/**
     * @param id
     * @return
     */
    public Project getProject(Integer id);

	/**
	 * @return
	 */
	public List<Project> getProjectsList();

	/**
	 * @param projects
	 */
	public void setProjectTeamSize(List<Project> projects);

	/**
	 * @param resource
	 * @return
	 */
	public Project createProject(Project project);
	
	/**
	 * @param project
	 * @return
	 */
	public Project saveProject(Project project);
	
	/**
     * @param id
     */
    public void deleteProject(Integer id);

}
