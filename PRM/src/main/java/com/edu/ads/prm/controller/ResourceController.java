package com.edu.ads.prm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.edu.ads.prm.entities.Location;
import com.edu.ads.prm.entities.Project;
import com.edu.ads.prm.entities.Resource;
import com.edu.ads.prm.entities.Skill;
import com.edu.ads.prm.service.LocationServiceI;
import com.edu.ads.prm.service.ProjectServiceI;
import com.edu.ads.prm.service.ResourceServiceI;
import com.edu.ads.prm.service.SkillServiceI;
import com.edu.ads.prm.vo.BaseResponseVO;
import com.edu.ads.prm.vo.ResourceRespVO;

/**
 * @author Jayanth
 *
 */
@RestController
@RequestMapping(value = "/api/resources")
public class ResourceController {

	@Autowired
	ResourceServiceI resourceService;
	@Autowired
	SkillServiceI skillsService;
	@Autowired
	LocationServiceI locationService;
	@Autowired
	ProjectServiceI projectService;

	@RequestMapping(method = RequestMethod.GET)
	public BaseResponseVO getResources() {
		return resourceService.getResources();
	}

	@RequestMapping(method = RequestMethod.GET, value = "{id}")
	public ResourceRespVO getResource(@PathVariable Integer id) {
		ResourceRespVO resourceRespVO = new ResourceRespVO();
		resourceRespVO.setResource(resourceService.getResource(id));
		return resourceRespVO;
	}

	@RequestMapping(method = RequestMethod.POST)
	public ResourceRespVO createResource(@RequestBody Resource resource) {
		ResourceRespVO resourceRespVO = new ResourceRespVO();
		resourceService.createResource(resource);
		resourceRespVO.setMessage("Resource saved successfully");
		return resourceRespVO;
	}

	@RequestMapping(method = RequestMethod.PUT, value = "{id}")
	public ResourceRespVO updateResource(@PathVariable Integer id, @RequestBody Resource resource) {
		ResourceRespVO resourceRespVO = new ResourceRespVO();
		resourceService.saveResource(resource);
		resourceRespVO.setMessage("Resource modified successfully");
		return resourceRespVO;
	}

	@RequestMapping(method = RequestMethod.DELETE, value = "{id}")
	public ResourceRespVO deleteResource(@PathVariable Integer id) {
		ResourceRespVO resourceRespVO = new ResourceRespVO();
		resourceService.deleteResource(id);
		resourceRespVO.setMessage("Resource deleted successfully");
		return resourceRespVO;
	}

	@RequestMapping(value = "/new", method = RequestMethod.POST)
	public ResourceRespVO addResource() {
		ResourceRespVO resourceRespVO = new ResourceRespVO();
		List<Skill> skills = skillsService.getSkillList();
		List<Location> locations = locationService.getLocationsList();
		List<Project> projects = projectService.getProjectsList();
		resourceRespVO.setSkills(skills);
		resourceRespVO.setLocations(locations);
		resourceRespVO.setProjects(projects);
		return resourceRespVO;

	}

}
