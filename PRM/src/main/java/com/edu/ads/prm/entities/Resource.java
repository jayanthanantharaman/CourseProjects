package com.edu.ads.prm.entities;

public class Resource extends BaseEntity{

	private static final long serialVersionUID = 1L;
	
	private Integer id;
	
	private String fullName ;
	
	private String email;
	
	private String phone;
	
	private String enterprise_Id;
	
	private Integer careerLevel;
	
	private Skill primarySkill;
	
	private Skill secondarySkill;
	
	private Project project;
	
	private Location location;

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
	 * @return the fullName
	 */
	public String getFullName() {
		return fullName;
	}

	/**
	 * @param fullName the fullName to set
	 */
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the phone
	 */
	public String getPhone() {
		return phone;
	}

	/**
	 * @param phone the phone to set
	 */
	public void setPhone(String phone) {
		this.phone = phone;
	}

	/**
	 * @return the enterprise_Id
	 */
	public String getEnterprise_Id() {
		return enterprise_Id;
	}

	/**
	 * @param enterprise_Id the enterprise_Id to set
	 */
	public void setEnterprise_Id(String enterprise_Id) {
		this.enterprise_Id = enterprise_Id;
	}

	/**
	 * @return the careerLevel
	 */
	public Integer getCareerLevel() {
		return careerLevel;
	}

	/**
	 * @param careerLevel the careerLevel to set
	 */
	public void setCareerLevel(Integer careerLevel) {
		this.careerLevel = careerLevel;
	}

	/**
	 * @return the primarySkill
	 */
	public Skill getPrimarySkill() {
		return primarySkill;
	}

	/**
	 * @param primarySkill the primarySkill to set
	 */
	public void setPrimarySkill(Skill primarySkill) {
		this.primarySkill = primarySkill;
	}

	/**
	 * @return the secondarySkill
	 */
	public Skill getSecondarySkill() {
		return secondarySkill;
	}

	/**
	 * @param secondarySkill the secondarySkill to set
	 */
	public void setSecondarySkill(Skill secondarySkill) {
		this.secondarySkill = secondarySkill;
	}

	/**
	 * @return the project
	 */
	public Project getProject() {
		return project;
	}

	/**
	 * @param project the project to set
	 */
	public void setProject(Project project) {
		this.project = project;
	}

	/**
	 * @return the location
	 */
	public Location getLocation() {
		return location;
	}

	/**
	 * @param location the location to set
	 */
	public void setLocation(Location location) {
		this.location = location;
	}
	


	
}
