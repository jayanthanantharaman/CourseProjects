package com.edu.ads.prm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.edu.ads.prm.dao.ResourceDaoI;
import com.edu.ads.prm.dao.SkillDaoI;
import com.edu.ads.prm.entities.Skill;
import com.edu.ads.prm.service.SkillServiceI;
import com.edu.ads.prm.vo.SkillRespVO;

/**
 * @author Jayanth
 *
 */
public class SkillService implements SkillServiceI {
	
	@Autowired
    SkillDaoI skillsDao;
	
	@Autowired
    ResourceDaoI resourceDao;

	/* (non-Javadoc)
	 * @see com.edu.ads.prm.service.SkillServiceI#getSkills()
	 */
	@Override
	public SkillRespVO getSkills() {
		SkillRespVO skillRespVO = new SkillRespVO();
		List<Skill> skills = getSkillList(); 
		setPeopleCount(skills);
		skillRespVO.setRecords(skills);
		skillRespVO.setTotal(skills.size());
		return skillRespVO;
	}
	
	public List<Skill> getSkillList() {
		List<Skill> skills = skillsDao.findAll();
		return skills;
	}
	
	public void setPeopleCount(List<Skill> skills) {
		for (Skill skill : skills) {
			skill.setPeopleCount(resourceDao.getByPrimarySkill(skill.getId()));
		}

	}

}
