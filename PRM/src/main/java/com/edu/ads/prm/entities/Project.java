package com.edu.ads.prm.entities;

import java.util.List;

public class Project extends BaseEntity {

	private static final long serialVersionUID = -613163193991433546L;

	private Integer id;

	private String projectName;

	private List<Resource> resourcesByProject;

	private Integer teamSize;

	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * @return the projectName
	 */
	public String getProjectName() {
		return projectName;
	}

	/**
	 * @param projectName the projectName to set
	 */
	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	/**
	 * @return the resourcesByProject
	 */
	public List<Resource> getResourcesByProject() {
		return resourcesByProject;
	}

	/**
	 * @param resourcesByProject the resourcesByProject to set
	 */
	public void setResourcesByProject(List<Resource> resourcesByProject) {
		this.resourcesByProject = resourcesByProject;
	}

	/**
	 * @return the teamSize
	 */
	public Integer getTeamSize() {
		return teamSize;
	}

	/**
	 * @param teamSize the teamSize to set
	 */
	public void setTeamSize(Integer teamSize) {
		this.teamSize = teamSize;
	}
	
	

}
