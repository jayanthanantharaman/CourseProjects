package com.edu.ads.prm.entities;

import java.util.List;

public class Location extends BaseEntity{


	private static final long serialVersionUID = 1L;
    
	private Integer id;
	
	private String locationName ;
	
	private List<Resource> resourcesByLocation;
	
	private Integer peopleCount;

	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * @return the locationName
	 */
	public String getLocationName() {
		return locationName;
	}

	/**
	 * @param locationName the locationName to set
	 */
	public void setLocationName(String locationName) {
		this.locationName = locationName;
	}

	/**
	 * @return the resourcesByLocation
	 */
	public List<Resource> getResourcesByLocation() {
		return resourcesByLocation;
	}

	/**
	 * @param resourcesByLocation the resourcesByLocation to set
	 */
	public void setResourcesByLocation(List<Resource> resourcesByLocation) {
		this.resourcesByLocation = resourcesByLocation;
	}

	/**
	 * @return the peopleCount
	 */
	public Integer getPeopleCount() {
		return peopleCount;
	}

	/**
	 * @param peopleCount the peopleCount to set
	 */
	public void setPeopleCount(Integer peopleCount) {
		this.peopleCount = peopleCount;
	}
	
	

	
}
