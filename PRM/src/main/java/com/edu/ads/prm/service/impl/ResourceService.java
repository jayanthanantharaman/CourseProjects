package com.edu.ads.prm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.edu.ads.prm.dao.ResourceDaoI;
import com.edu.ads.prm.entities.Resource;
import com.edu.ads.prm.service.ResourceServiceI;
import com.edu.ads.prm.vo.BaseResponseVO;

/**
 * @author Jayanth
 *
 */
public class ResourceService implements ResourceServiceI {
	
	 @Autowired
	    ResourceDaoI resourceDao;

	/* (non-Javadoc)
	 * @see com.edu.ads.prm.service.ResourceServiceI#getResources()
	 */
	@Override
	public BaseResponseVO getResources() {
		BaseResponseVO resourceRespVO = new BaseResponseVO();
		List<Resource> resources = resourceDao.findAll();
		resourceRespVO.setRecords(resources);
		resourceRespVO.setTotal(resources.size());
		return resourceRespVO;
	}

	/* (non-Javadoc)
	 * @see com.edu.ads.prm.service.ResourceServiceI#getResource(java.lang.Integer)
	 */
	@Override
	public Resource getResource(Integer id) {
		Resource resource = resourceDao.findResource(id);
		return resource;
	}

	/* (non-Javadoc)
	 * @see com.edu.ads.prm.service.ResourceServiceI#saveResource(com.edu.ads.prm.entities.Resource)
	 */
	@Override
	public Resource saveResource(Resource resource) {
		return resourceDao.saveResource(resource);
	}

	/* (non-Javadoc)
	 * @see com.edu.ads.prm.service.ResourceServiceI#deleteResource(java.lang.Integer)
	 */
	@Override
	public void deleteResource(Integer id) {
		resourceDao.deleteResource(id);
		
	}

	/* (non-Javadoc)
	 * @see com.edu.ads.prm.service.ResourceServiceI#createResource(com.edu.ads.prm.entities.Resource)
	 */
	@Override
	public Resource createResource(Resource resource) {
		return resourceDao.createResource(resource);
	}


}
