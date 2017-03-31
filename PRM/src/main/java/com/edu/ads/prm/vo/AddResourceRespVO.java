package com.edu.ads.prm.vo;

import java.util.List;

import com.edu.ads.prm.entities.Location;
import com.edu.ads.prm.entities.Project;
import com.edu.ads.prm.entities.Skill;

/**
 * @author Jayanth
 *
 */
public class AddResourceRespVO extends BaseResponseVO {

	private static final long serialVersionUID = 5296999691402149570L;

	private String name;
	private String enterprise_Id;
	private List<Skill> skills;
	private List<Location> locations;
	private List<Project> projects;

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name
	 *            the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the enterprise_Id
	 */
	public String getEnterprise_Id() {
		return enterprise_Id;
	}

	/**
	 * @param enterprise_Id
	 *            the enterprise_Id to set
	 */
	public void setEnterprise_Id(String enterprise_Id) {
		this.enterprise_Id = enterprise_Id;
	}

	/**
	 * @return the skills
	 */
	public List<Skill> getSkills() {
		return skills;
	}

	/**
	 * @param skills
	 *            the skills to set
	 */
	public void setSkills(List<Skill> skills) {
		this.skills = skills;
	}

	/**
	 * @return the locations
	 */
	public List<Location> getLocations() {
		return locations;
	}

	/**
	 * @param locations
	 *            the locations to set
	 */
	public void setLocations(List<Location> locations) {
		this.locations = locations;
	}

	/**
	 * @return the projects
	 */
	public List<Project> getProjects() {
		return projects;
	}

	/**
	 * @param projects
	 *            the projects to set
	 */
	public void setProjects(List<Project> projects) {
		this.projects = projects;
	}

}
