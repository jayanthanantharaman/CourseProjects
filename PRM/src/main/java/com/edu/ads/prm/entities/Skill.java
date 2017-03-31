package com.edu.ads.prm.entities;

import java.util.List;

public class Skill extends BaseEntity{

	private static final long serialVersionUID = -3792381099402281464L;

	private Integer id;
	
	private String skill;
	
	private List<Resource> resourcesByPrimarySkill;
	
	private List<Resource> resourcesBySecondarySkill;
	
	private SkillCategory skillCategory;
	
	private Integer peopleCount;

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
	 * @return the skill
	 */
	public String getSkill() {
		return skill;
	}

	/**
	 * @param skill the skill to set
	 */
	public void setSkill(String skill) {
		this.skill = skill;
	}

	/**
	 * @return the resourcesByPrimarySkill
	 */
	public List<Resource> getResourcesByPrimarySkill() {
		return resourcesByPrimarySkill;
	}

	/**
	 * @param resourcesByPrimarySkill the resourcesByPrimarySkill to set
	 */
	public void setResourcesByPrimarySkill(List<Resource> resourcesByPrimarySkill) {
		this.resourcesByPrimarySkill = resourcesByPrimarySkill;
	}

	/**
	 * @return the resourcesBySecondarySkill
	 */
	public List<Resource> getResourcesBySecondarySkill() {
		return resourcesBySecondarySkill;
	}

	/**
	 * @param resourcesBySecondarySkill the resourcesBySecondarySkill to set
	 */
	public void setResourcesBySecondarySkill(List<Resource> resourcesBySecondarySkill) {
		this.resourcesBySecondarySkill = resourcesBySecondarySkill;
	}

	/**
	 * @return the skillCategory
	 */
	public SkillCategory getSkillCategory() {
		return skillCategory;
	}

	/**
	 * @param skillCategory the skillCategory to set
	 */
	public void setSkillCategory(SkillCategory skillCategory) {
		this.skillCategory = skillCategory;
	}

	/**
	 * @return the peopleCount
	 */
	public Integer getPeopleCount() {
		return peopleCount;
	}

	/**
	 * @param peopleCount the peopleCount to set
	 */
	public void setPeopleCount(Integer peopleCount) {
		this.peopleCount = peopleCount;
	}
	
	

	

}
