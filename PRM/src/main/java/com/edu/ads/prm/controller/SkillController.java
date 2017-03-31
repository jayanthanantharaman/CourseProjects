package com.edu.ads.prm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.edu.ads.prm.service.SkillServiceI;
import com.edu.ads.prm.vo.SkillRespVO;

/**
 * @author Jayanth
 *
 */
@RestController
public class SkillController {

	@Autowired
	SkillServiceI skillService;

	@RequestMapping(value = "/api/skills", method = RequestMethod.POST)
	public SkillRespVO getSkill() {
		return skillService.getSkills();

	}

}
