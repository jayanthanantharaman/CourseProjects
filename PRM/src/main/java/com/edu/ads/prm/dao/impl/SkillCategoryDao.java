package com.edu.ads.prm.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.edu.ads.prm.common.DBConstants;
import com.edu.ads.prm.configs.DbConnect;
import com.edu.ads.prm.dao.SkillCategoryDaoI;
import com.edu.ads.prm.entities.SkillCategory;

/**
 * @author Jayanth
 *
 */
public class SkillCategoryDao implements SkillCategoryDaoI {

	private static String FIND_SKILL_CATEGORY_QUERY = "SELECT skillcat.ID AS ID, skillcat.CATEGORY AS CATEGORY FROM SKILLCATEGORY"
			+ " skillcat WHERE skillcat.ID = ?";

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.edu.ads.prm.dao.SkillCategoryI#findSkill(java.lang.Integer)
	 */
	@Override
	public SkillCategory findSkill(Integer id) {
		DbConnect dbConnect = DbConnect.getDbConnection();
		SkillCategory skillCategory = null;
		try {
			List<Object> parameters = new ArrayList<Object>();
			parameters.add(id);
			ResultSet resultSet = dbConnect.query(FIND_SKILL_CATEGORY_QUERY, parameters);
			if (resultSet.next()) {
				skillCategory = new SkillCategory();
				skillCategory.setId(resultSet.getInt(DBConstants.ID));
				skillCategory.setCategory(resultSet.getString(DBConstants.CATEGORY));
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

		return skillCategory;
	}

}
