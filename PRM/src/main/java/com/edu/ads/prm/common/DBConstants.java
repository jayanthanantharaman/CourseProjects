package com.edu.ads.prm.common;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
@Configuration

public class DBConstants {
	
	@Value("${db.driver}")
	 public static String DB_DRIVER ="com.mysql.jdbc.Driver";

	@Value("${db.password}")
	 public static String DB_PASSWORD="prmuser123";

	@Value("${db.url}")
	 public static String DB_URL="jdbc:mysql://localhost:3306/ppmdb?logger=com.mysql.jdbc.log.Slf4JLogger&profileSQL=true&useSSL=false";

	@Value("${db.username}")
	 public static String DB_USERNAME="root";
	
    public static final String RESOURCE = "RESOURCE";
    public static final String ID = "ID";
    public static final String FULLNAME ="FULLNAME";
    public static final String EMAIL="EMAIL";
    public static final String PHONE="PHONE";
    public static final String ENTERPRISE_ID="ENTERPRISE_ID";
    public static final String PRIMARYSKILL_ID= "PRIMARYSKILL_ID";
    public static final String SECONDARYSKILL_ID="SECONDARYSKILL_ID";
    public static final String CAREER_LEVEL="CAREER_LEVEL";
    
    
    public static final String SKILLCATEGORY="SKILLCATEGORY";
    public static final String CATEGORY="CATEGORY";
    
    public static final String SKILLS="SKILLS";
    public static final String SKILL="SKILL";
    public static final String SKILLCATEGORY_ID="SKILLCATEGORY_ID";
    
    
    public static final String PROJECT="PROJECT";
    public static final String PROJECT_NAME="PROJECT_NAME";
    public static final String PROJECT_ID="PROJECT_ID";
    
    public static final String LOCATION="LOCATION";
    public static final String LOCATION_NAME="LOCATION_NAME";
    public static final String LOCATION_ID="LOCATION_ID";
    
    public static final String COUNT="COUNT";
    
    
    
}
