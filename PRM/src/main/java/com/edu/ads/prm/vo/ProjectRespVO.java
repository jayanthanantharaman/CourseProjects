package com.edu.ads.prm.vo;

import com.edu.ads.prm.entities.Project;

/**
 * @author Jayanth
 *
 */
public class ProjectRespVO extends BaseResponseVO {

	private static final long serialVersionUID = -6530016218789299969L;
	
	private Project project;

	/**
	 * @return the project
	 */
	public Project getProject() {
		return project;
	}

	/**
	 * @param project the project to set
	 */
	public void setProject(Project project) {
		this.project = project;
	}
	
	

}
