create table LOCATION (ID integer not null auto_increment, LOCATION_NAME varchar(255), primary key (ID));
create table RESOURCE (ID integer not null auto_increment, CAREER_LEVEL integer, EMAIL varchar(255), ENTERPRISE_ID varchar(255), FULLNAME varchar(255), PHONE varchar(255), LOCATION_ID integer, PRIMARYSKILL_ID integer, PROJECT_ID integer, SECONDARYSKILL_ID integer, primary key (ID));
create table PROJECT (ID integer not null auto_increment, PROJECT_NAME varchar(255), primary key (ID));
create table SKILLCATEGORY (ID integer not null auto_increment, CATEGORY varchar(255), primary key (ID));
create table SKILLS (ID integer not null auto_increment, SKILL varchar(255), SKILLCATEGORY_ID integer not null, primary key (ID));

alter table RESOURCE add constraint FK foreign key (LOCATION_ID) references LOCATION (ID);
alter table RESOURCE add constraint FK_1 foreign key (PRIMARYSKILL_ID) references SKILLS (ID);
alter table RESOURCE add constraint FK_2 foreign key (PROJECT_ID) references PROJECT (ID);
alter table RESOURCE add constraint FK_3 foreign key (SECONDARYSKILL_ID) references SKILLS (ID);
alter table SKILLS add constraint FK_4g3s597cbti3jj3g29sfgmbr7 foreign key (SKILLCATEGORY_ID) references SKILLCATEGORY (ID);