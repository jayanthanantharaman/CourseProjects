package com.edu.ads.prm.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.edu.ads.prm.common.DBConstants;
import com.edu.ads.prm.configs.DbConnect;
import com.edu.ads.prm.dao.SkillCategoryDaoI;
import com.edu.ads.prm.dao.SkillDaoI;
import com.edu.ads.prm.entities.Skill;
import com.edu.ads.prm.entities.SkillCategory;

/**
 * @author Jayanth
 *
 */
public class SkillDao implements SkillDaoI {
	
	@Autowired
	SkillCategoryDaoI skillCategoryDao;
	
	private static String FIND_SKILL_QUERY = "SELECT skill.ID AS ID, skill.SKILL AS SKILL, skill.SKILLCATEGORY_ID AS SKILLCATEGORY_ID,"
			+ " skillcat.ID AS SKILLCATEGORY_ID, skillcat.CATEGORY AS CATEGORY FROM SKILLS skill "
			+ "INNER JOIN SKILLCATEGORY skillcat ON skill.SKILLCATEGORY_ID = skillcat.ID WHERE skill.ID =?";

	private static String FIND_ALL_QUERY = "SELECT skill.ID AS ID,skill.SKILL AS SKILL,skill.SKILLCATEGORY_ID AS SKILLCATEGORY_ID FROM SKILLS skill";
	/* (non-Javadoc)
	 * @see com.edu.ads.prm.dao.SkillDaoI#findAll()
	 */
	@Override
	public List<Skill> findAll() {
		DbConnect dbConnect = DbConnect.getDbConnection();
		Skill skill = null;
		List<Skill> skills = new ArrayList<Skill>();
		try {
			ResultSet resultSet = dbConnect.query(FIND_ALL_QUERY, new ArrayList<Object>());
			while (resultSet.next()) {
				skill = new Skill();
				skill.setId(resultSet.getInt(DBConstants.ID));
				skill.setSkill(resultSet.getString(DBConstants.SKILL));
				skill.setSkillCategory(skillCategoryDao.findSkill(resultSet.getInt(DBConstants.SKILLCATEGORY_ID)));
				skills.add(skill);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				dbConnect.closeResources();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return skills;
	}

	/* (non-Javadoc)
	 * @see com.edu.ads.prm.dao.SkillDaoI#findSkill(java.lang.Integer)
	 */
	@Override
	public Skill findSkill(Integer id) {
		DbConnect dbConnect = DbConnect.getDbConnection();
		Skill skill = null;
		SkillCategory skillCategory =null;
		try {
			List<Object> parameters = new ArrayList<Object>();
			parameters.add(id);
			ResultSet resultSet = dbConnect.query(FIND_SKILL_QUERY, parameters);
			if (resultSet.next()) {
				skill = new Skill();
				skillCategory = new SkillCategory();
				skill.setId(resultSet.getInt(DBConstants.ID));
				skill.setSkill(resultSet.getString(DBConstants.SKILL));
				skillCategory.setId(resultSet.getInt(DBConstants.SKILLCATEGORY_ID));
				skillCategory.setCategory(resultSet.getString(DBConstants.CATEGORY));
				skill.setSkillCategory(skillCategory);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				dbConnect.closeResources();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return skill;
	}

}
