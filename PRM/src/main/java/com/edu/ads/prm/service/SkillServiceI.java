package com.edu.ads.prm.service;

import java.util.List;

import com.edu.ads.prm.entities.Skill;
import com.edu.ads.prm.vo.SkillRespVO;

/**
 * @author Jayanth
 *
 */
public interface SkillServiceI {
	
	public SkillRespVO getSkills(); 
	
	public List<Skill> getSkillList();

}
