package com.edu.ads.prm.service;

import java.util.List;

import com.edu.ads.prm.entities.Location;
import com.edu.ads.prm.vo.LocationRespVO;

public interface LocationServiceI {

    public LocationRespVO getLocations(); 
    
    public List<Location> getLocationsList(); 
    
    public void setPeopleCount(List<Location> locations);
}
