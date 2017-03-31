package com.edu.ads.prm;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.context.annotation.Bean;

import com.edu.ads.prm.dao.LocationDaoI;
import com.edu.ads.prm.dao.ProjectDaoI;
import com.edu.ads.prm.dao.ResourceDaoI;
import com.edu.ads.prm.dao.SkillCategoryDaoI;
import com.edu.ads.prm.dao.SkillDaoI;
import com.edu.ads.prm.dao.impl.LocationDao;
import com.edu.ads.prm.dao.impl.ProjectDao;
import com.edu.ads.prm.dao.impl.ResourceDao;
import com.edu.ads.prm.dao.impl.SkillCategoryDao;
import com.edu.ads.prm.dao.impl.SkillDao;
import com.edu.ads.prm.service.LocationServiceI;
import com.edu.ads.prm.service.ProjectServiceI;
import com.edu.ads.prm.service.ResourceServiceI;
import com.edu.ads.prm.service.SkillServiceI;
import com.edu.ads.prm.service.impl.LocationService;
import com.edu.ads.prm.service.impl.ProjectService;
import com.edu.ads.prm.service.impl.ResourceService;
import com.edu.ads.prm.service.impl.SkillService;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class, HibernateJpaAutoConfiguration.class})
public class PrmApp {

	@Bean
	ResourceDaoI resourceDao() {
		return new ResourceDao();
	}

	@Bean
	LocationDaoI locationDao() {
		return new LocationDao();
	}

	@Bean
	ProjectDaoI projectDao() {
		return new ProjectDao();
	}

	@Bean
	SkillDaoI skillDao() {
		return new SkillDao();
	}
	
	@Bean
	SkillCategoryDaoI skillCategoryDao() {
		return new SkillCategoryDao();
	}

	@Bean
	ResourceServiceI ResourceService() {
		return new ResourceService();
	}

	@Bean
	ProjectServiceI ProjectService() {
		return new ProjectService();
	}

	@Bean
	SkillServiceI SkillsService() {
		return new SkillService();
	}

	@Bean
	LocationServiceI LocationService() {
		return new LocationService();
	}

	public static void main(String[] args) {
		SpringApplication.run(PrmApp.class, args);
	}
}
