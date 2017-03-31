package com.edu.ads.prm.entities;

import java.util.ArrayList;
import java.util.List;

public class SkillCategory extends BaseEntity {

	private static final long serialVersionUID = 1L;
	
	private Integer id;
	
	private String category;
	
	List<Skill> skillsList = new ArrayList<Skill>();

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
	 * @return the category
	 */
	public String getCategory() {
		return category;
	}

	/**
	 * @param category the category to set
	 */
	public void setCategory(String category) {
		this.category = category;
	}

	/**
	 * @return the skillsList
	 */
	public List<Skill> getSkillsList() {
		return skillsList;
	}

	/**
	 * @param skillsList the skillsList to set
	 */
	public void setSkillsList(List<Skill> skillsList) {
		this.skillsList = skillsList;
	}
	
	

}
