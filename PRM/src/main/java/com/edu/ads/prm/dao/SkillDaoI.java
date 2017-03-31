package com.edu.ads.prm.dao;

import java.util.List;

import com.edu.ads.prm.entities.Skill;

/**
 * @author Jayanth
 *
 */
public interface SkillDaoI {

	public List<Skill> findAll();
	
	/**
	 * @param id
	 * @return
	 */
	public Skill findSkill(Integer id);
}
