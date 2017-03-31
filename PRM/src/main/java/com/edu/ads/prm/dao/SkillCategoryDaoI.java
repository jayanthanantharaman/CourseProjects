package com.edu.ads.prm.dao;

import com.edu.ads.prm.entities.SkillCategory;

/**
 * @author Jayanth
 *
 */
public interface SkillCategoryDaoI {
	
	/**
	 * @param id
	 * @return
	 */
	public SkillCategory findSkill(Integer id);

}
