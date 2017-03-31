package com.edu.ads.prm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.edu.ads.prm.entities.Project;
import com.edu.ads.prm.service.ProjectServiceI;
import com.edu.ads.prm.vo.ProjectRespVO;

/**
 * @author Jayanth
 *
 */
@RestController
@RequestMapping(value = "/api/projects")
public class ProjectsController {

	@Autowired
	ProjectServiceI projectService;

	@RequestMapping(method = RequestMethod.GET)
	public ProjectRespVO getProjects() {
		return projectService.getProjects();

	}
	
	@RequestMapping(method = RequestMethod.GET, value = "{id}")
	public ProjectRespVO getProjct(@PathVariable Integer id) {
		ProjectRespVO projectRespVO = new ProjectRespVO();
		projectRespVO.setProject(projectService.getProject(id));
		return projectRespVO;
	}

	@RequestMapping(method = RequestMethod.POST)
	public ProjectRespVO createProject(@RequestBody Project project) {
		ProjectRespVO projectRespVO = new ProjectRespVO();
		projectService.createProject(project);
		projectRespVO.setMessage("Project saved successfully");
		return projectRespVO;
	}

	@RequestMapping(method = RequestMethod.PUT, value = "{id}")
	public ProjectRespVO updateProject(@PathVariable Integer id, @RequestBody Project project) {
		ProjectRespVO projectRespVO = new ProjectRespVO();
		projectService.saveProject(project);
		projectRespVO.setMessage("Project modified successfully");
		return projectRespVO;
	}

	@RequestMapping(method = RequestMethod.DELETE, value = "{id}")
	public ProjectRespVO deleteProject(@PathVariable Integer id) {
		ProjectRespVO projectRespVO = new ProjectRespVO();
		projectService.deleteProject(id);
		projectRespVO.setMessage("Project deleted successfully");
		return projectRespVO;
	}
}
