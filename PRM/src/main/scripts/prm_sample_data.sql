Insert into ppmdb.SKILLCATEGORY (CATEGORY) values ('JAVA ENTERPRISE EDITION - FRONT END');
Insert into ppmdb.SKILLCATEGORY (CATEGORY) values ('JAVA ENTERPRISE EDITION - BACK END');

Insert into ppmdb.SKILLS (SKILL,SKILLCATEGORY_ID) values ('SPRING',2);
Insert into ppmdb.SKILLS (SKILL,SKILLCATEGORY_ID) values ('HIBERNATE',2);
Insert into ppmdb.SKILLS (SKILL,SKILLCATEGORY_ID) values ('CORE JAVA',2);
Insert into ppmdb.SKILLS (SKILL,SKILLCATEGORY_ID) values ('SERVLETS',2);
Insert into ppmdb.SKILLS (SKILL,SKILLCATEGORY_ID) values ('SPRING MVC',2);

Insert into ppmdb.SKILLS (SKILL,SKILLCATEGORY_ID) values ('HTML5',1);
Insert into ppmdb.SKILLS (SKILL,SKILLCATEGORY_ID) values ('CSS3',1);
Insert into ppmdb.SKILLS (SKILL,SKILLCATEGORY_ID) values ('NODEJS',1);
Insert into ppmdb.SKILLS (SKILL,SKILLCATEGORY_ID) values ('JQuery',1);

Insert into ppmdb.LOCATION (LOCATION_NAME) values ('Bangalore');
Insert into ppmdb.LOCATION (LOCATION_NAME) values ('Sunnyvale');
Insert into ppmdb.LOCATION (LOCATION_NAME) values ('San Jose');
Insert into ppmdb.LOCATION (LOCATION_NAME) values ('New York');
Insert into ppmdb.LOCATION (LOCATION_NAME) values ('Mumbai');

Insert into ppmdb.PROJECT (PROJECT_NAME) values ('Project-1');
Insert into ppmdb.PROJECT (PROJECT_NAME) values ('Project-2');
Insert into ppmdb.PROJECT (PROJECT_NAME) values ('Project-3');
Insert into ppmdb.PROJECT (PROJECT_NAME) values ('Project-4');
Insert into ppmdb.PROJECT (PROJECT_NAME) values ('Project-5');

Insert into ppmdb.RESOURCE (EMAIL,ENTERPRISE_ID,FULLNAME,PHONE,CAREER_LEVEL,PRIMARYSKILL_ID,SECONDARYSKILL_ID,PROJECT_ID,LOCATION_ID) values ('resource1@wright.edu','00000001','resource1','987654321',10,1,2,1,1);
Insert into ppmdb.RESOURCE (EMAIL,ENTERPRISE_ID,FULLNAME,PHONE,CAREER_LEVEL,PRIMARYSKILL_ID,SECONDARYSKILL_ID,PROJECT_ID,LOCATION_ID) values ('resource2@wright.edu','00000002','resource2','987654321',10,3,1,1,1);
Insert into ppmdb.RESOURCE (EMAIL,ENTERPRISE_ID,FULLNAME,PHONE,CAREER_LEVEL,PRIMARYSKILL_ID,SECONDARYSKILL_ID,PROJECT_ID,LOCATION_ID) values ('resource3@wright.edu','00000003','resource3','987654321',9,3,5,1,2);
Insert into ppmdb.RESOURCE (EMAIL,ENTERPRISE_ID,FULLNAME,PHONE,CAREER_LEVEL,PRIMARYSKILL_ID,SECONDARYSKILL_ID,PROJECT_ID,LOCATION_ID) values ('resource4@wright.edu','00000004','resource4','987654321',10,3,6,2,1);
Insert into ppmdb.RESOURCE (EMAIL,ENTERPRISE_ID,FULLNAME,PHONE,CAREER_LEVEL,PRIMARYSKILL_ID,SECONDARYSKILL_ID,PROJECT_ID,LOCATION_ID) values ('resource5@wright.edu','00000005','resource5','987654321',10,6,7,2,1);
Insert into ppmdb.RESOURCE (EMAIL,ENTERPRISE_ID,FULLNAME,PHONE,CAREER_LEVEL,PRIMARYSKILL_ID,SECONDARYSKILL_ID,PROJECT_ID,LOCATION_ID) values ('resource6@wright.edu','00000006','resource6','987654321',9,6,9,2,2);