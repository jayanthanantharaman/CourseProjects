package com.edu.ads.prm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.edu.ads.prm.dao.ProjectDaoI;
import com.edu.ads.prm.dao.ResourceDaoI;
import com.edu.ads.prm.entities.Project;
import com.edu.ads.prm.service.ProjectServiceI;
import com.edu.ads.prm.vo.ProjectRespVO;

/**
 * @author Jayanth
 *
 */
public class ProjectService implements ProjectServiceI {
	
	@Autowired
    ProjectDaoI projectDao;
    
    @Autowired
    ResourceDaoI resourceDao;


	/* (non-Javadoc)
	 * @see com.edu.ads.prm.service.ProjectServiceI#getProjects()
	 */
	@Override
	public ProjectRespVO getProjects() {
		ProjectRespVO projectRespVO = new ProjectRespVO();
		List<Project> projects = getProjectsList();
		setProjectTeamSize(projects);
		projectRespVO.setRecords(projects);
		projectRespVO.setTotal(projects.size());
		return projectRespVO;
	}

	/* (non-Javadoc)
	 * @see com.edu.ads.prm.service.ProjectServiceI#getProjectsList()
	 */
	@Override
	public List<Project> getProjectsList() {
		List<Project> projects = projectDao.findAll();
		return projects;
	}

	/* (non-Javadoc)
	 * @see com.edu.ads.prm.service.ProjectServiceI#setProjectTeamSize(java.util.List)
	 */
	@Override
	public void setProjectTeamSize(List<Project> projects) {
		for(Project project:projects){
		    project.setTeamSize(resourceDao.getByProject(project.getId()));
		}
		
	}

	/* (non-Javadoc)
	 * @see com.edu.ads.prm.service.ProjectServiceI#createProject(com.edu.ads.prm.entities.Project)
	 */
	@Override
	public Project createProject(Project project) {
		return projectDao.createProject(project);
	}

	/* (non-Javadoc)
	 * @see com.edu.ads.prm.service.ProjectServiceI#saveProject(com.edu.ads.prm.entities.Project)
	 */
	@Override
	public Project saveProject(Project project) {
		return projectDao.saveProject(project);
	}

	/* (non-Javadoc)
	 * @see com.edu.ads.prm.service.ProjectServiceI#deleteProject(java.lang.Integer)
	 */
	@Override
	public void deleteProject(Integer id) {
		projectDao.deleteProject(id);
		
	}

	/* (non-Javadoc)
	 * @see com.edu.ads.prm.service.ProjectServiceI#getProject(java.lang.Integer)
	 */
	@Override
	public Project getProject(Integer id) {
		return projectDao.findProject(id);
	}
	
	

	

}
