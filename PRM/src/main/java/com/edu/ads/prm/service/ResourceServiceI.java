package com.edu.ads.prm.service;

import com.edu.ads.prm.entities.Resource;
import com.edu.ads.prm.vo.BaseResponseVO;

/**
 * @author Jayanth
 *
 */
public interface ResourceServiceI {
    
    /**
     * @return
     */
    public BaseResponseVO getResources();
    
    /**
     * @param id
     * @return
     */
    public Resource getResource(Integer id);
    
    /**
     * @param resource
     * @return
     */
    public Resource saveResource(Resource resource);
    
    /**
     * @param id
     */
    public void deleteResource(Integer id);
    
    
    /**
     * @param resource
     * @return
     */
    public Resource createResource(Resource resource);
    

}
