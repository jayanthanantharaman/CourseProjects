package com.edu.ads.prm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.edu.ads.prm.service.LocationServiceI;
import com.edu.ads.prm.vo.LocationRespVO;

@RestController
public class LocationController {
	
	 
    @Autowired
    LocationServiceI locationService;
    
    @RequestMapping(value="/api/locations",method=RequestMethod.POST)
    public LocationRespVO getLocations(){
	return locationService.getLocations();
	
    }

}
