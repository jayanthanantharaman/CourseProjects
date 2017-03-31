var resource_config = {
	    layout: {
	        name: 'layout',
	        padding: 0,
	        panels: [
	            { type: 'left', size: 200, resizable: true, minSize: 120 },
	            { type: 'main', size: 600,resizable: true, minSize: 850, overflow: 'hidden' }
	        ]
	    },
	    sidebar: {
	        name: 'sidebar',
	        nodes: [ 
	            { id: 'general', text: 'Project Resource Manager', group: true, expanded: true, nodes: [
	                { id: 'resources', text: 'Resource', selected: true },
	                { id: 'projects', text: 'Project'},
	                { id: 'locations', text: 'Location'},
	                { id: 'skills', text: 'Skills'},
	            ]}
	        ],
	        onClick: function (event) {
	            switch (event.target) {
	                case 'resources':
	                    w2ui.layout.content('main', w2ui.resources);
	                    break;
	                case 'projects':
	                    w2ui.layout.content('main', w2ui.projects);
	                    break; 
	                case 'locations':
	                    w2ui.layout.content('main', w2ui.locations);
	                    break; 
	                case 'skills':
	                    w2ui.layout.content('main', w2ui.skills);
	                    break;    
	            }
	        }
	    },
	    resources: { 
	        name  : 'resources', 
	        header: 'List of People',
	        url    : 'api/resources',
	        method: 'GET',
	        recid:'id',
	        show: { 
	        	header : true,
	            toolbar: true,
	            footer: true,
	            toolbarAdd: true,
	            toolbarDelete: true,
	           // toolbarSave: true,
	            toolbarEdit: true
	        },
	        multiSearch: false,
	        searches: [
	            { field: 'fullName', caption: 'Name', type: 'text' },
	            { field: 'enterprise_Id', caption: 'Enterprise Id', type: 'text' },
	            { field: 'project.projectName', caption: 'Project', type: 'text' }
	        ],
	        columns: [                
	            { field: 'fullName', caption: 'Name', size: '10%', sortable: true },
	            { field: 'enterprise_Id', caption: 'Enterprise Id', size: '10%', sortable: true },
	            { field: 'location.locationName', caption: 'Location', size: '10%', sortable: true },
	            { field: 'phone', caption: 'Contact no.', size: '10%'},
	            { field: 'careerLevel', caption: 'Career Level', size: '10%'},
	            { field: 'email', caption: 'E-mail', size: '15%'},
	            { field: 'project.projectName', caption: 'Project', size: '10%', sortable: true },
	            { field: 'primarySkill.skillCategory.category', caption: 'Skill Category', size: '20%', sortable: true },
	            { field: 'primarySkill.skill', caption: 'Primary Skill', size: '15%', sortable: true },
	            { field: 'secondarySkill.skill', caption: 'Secondary Skill', size: '15%', sortable: true },
	        ],
	        onAdd: function (event) {
	        	resourceAdd ();
	        },
	        onEdit: function (event) {
	        	resourceAdd(this.get(event.recid));
	        },
	        onDelete: function (event) {
	        	resourceDelete();
	        }
	    },
	    projects: { 
	        name  : 'projects', 
	        header: 'Projects',
	        url    : 'api/projects',
	        method: 'GET',
	        recid:'id',
	        show: { 
	        	header : true,
	            toolbar: true,
	            footer: true,
	            toolbarAdd: true,
	            toolbarDelete: true,
	            toolbarEdit: true
	        },
	        columns: [                
	            { field: 'id', caption: 'Id', size: '5%' },
	            { field: 'projectName', caption: 'Projects', size: '20%' },
	            { field: 'teamSize', caption: 'Team Size', size: '20%' },
	        ],
	        onAdd: function (event) {
	        	projectAdd ();
	        },
	        onEdit: function (event) {
	        	projectAdd(this.get(event.recid));
	        },
	        onDelete: function (event) {
	        	projectDelete();
	        }
	    },
	    locations: { 
	        name  : 'locations', 
	        header: 'Locations',
	        url    : 'api/locations',
	        method: 'POST',
	        recid:'id',
	        show: { 
	        	header : true,
	            toolbar: true,
	            footer: true,
	            toolbarAdd: true,
	            toolbarDelete: true,
	            toolbarEdit: true
	        },
	        columns: [                
	            { field: 'id', caption: 'Id', size: '5%' },
	            { field: 'locationName', caption: 'Locations', size: '20%' },
	            { field: 'peopleCount', caption: 'People Count', size: '20%' },
	        ],
	        onAdd: function (event) {
	            w2alert('Work in Progress');
	        },
	        onEdit: function (event) {
	            w2alert('Work in Progress');
	        },
	        onDelete: function (event) {
	        	 w2alert('Work in Progress');
	        },
	        onSave: function (event) {
	        	 w2alert('Work in Progress');
	        }
	    },
	    skills: { 
	        name  : 'skills', 
	        header: 'Skills',
	        url    : 'api/skills',
	        method: 'POST',
	        recid:'id',
	        show: { 
	        	header : true,
	            toolbar: true,
	            footer: true,
	            toolbarAdd: true,
	            toolbarDelete: true,
	            toolbarEdit: true
	        },
	        columns: [                
	            { field: 'id', caption: 'Id', size: '5%' },
	            { field: 'skill', caption: 'Skill', size: '20%' },
	            { field: 'skillCategory.category', caption: 'Skill Category', size: '20%' },
	            { field: 'peopleCount', caption: 'People Count', size: '20%' },
	        ],
	        onAdd: function (event) {
	            w2alert('Work in Progress');
	        },
	        onEdit: function (event) {
	            w2alert('Work in Progress');
	        },
	        onDelete: function (event) {
	        	 w2alert('Work in Progress');
	        },
	        onSave: function (event) {
	        	 w2alert('Work in Progress');
	        }
	    },
	    add_resource:{
	        name: 'add_resource',
	        style:'border: 0px',
	        fields: [
	            { name: 'fullName', id: 'fullName', type: 'text', required: true,
	                html: { caption: 'Name', attr: 'style="width: 300px;" maxlength="255"' }
	            },
	            { name: 'enterprise_Id', id:'enterprise_Id', type: 'text',required: true,
	                html: { caption: 'Enterprise Id', attr: 'style="width: 300px;"'}
	            },
	            { name: 'phone', id:'phone', type: 'text',required: true,
	                html: { caption: 'Contact no.', attr: 'style="width: 300px;"'}
	            },
	            { name: 'careerLevel', id:'careerLevel', type: 'int',required: true,
	                html: { caption: 'Career Level', attr: 'style="width: 100px;"'}
	            },
	            { name: 'email', id:'email', type: 'text',required: true,
	                html: { caption: 'E-mail', attr: 'style="width: 300px;"'}
	            },
				{ name:'locations', type:'list',id:'locations',required: true, 
				 	html: {caption: 'Location', attr: 'style="width: 300px;"'}
				},
				{ name:'projects', type:'list',id:'projects',required: true, 
					html: { caption: 'Project', attr: 'style="width: 300px;"'}
				},
				{ name:'primarySkills', type:'list',id:'primarySkills',required: true, 
					html: { caption: 'Primary Skill', attr: 'style="width: 300px;"'}
				},
				{ name:'secondarySkills', type:'list',id:'secondarySkills',required: true, 
					html: { caption: 'Secondary Skill', attr: 'style="width: 300px;"'}
				}
	        ],
	        onChange: function (event) {
	        	
		    },
	        actions: {
	            'Cancel': function () {
	            	formChangedFlag = false;
	                confirmCloseDraft(formChangedFlag);
	           },
	            'Save': function () {
	                var errors  = this.validate();
	                var record = this.record;
	                
	                 if (errors.length == 0) {
	                 	w2popup.lock('one moment...', true);
	                 	var selectedLocation = {};
	                 	var selectedProject = {};
	                 	var selectedPrimarySkill = {};
	                 	var selectedSecondarySkill = {};
	                 	var saveResourceObj={};
	                 	
	                     saveResourceObj.fullName = record.fullName;
	                     saveResourceObj.enterprise_Id = record.enterprise_Id; 
	                     saveResourceObj.phone = record.phone;
	                     saveResourceObj.email = record.email;
	                     saveResourceObj.careerLevel = record.careerLevel;
	                     selectedLocation = {id:record.locations.id, locationName:record.locations.text};
	                     selectedProject={id:record.projects.id, projectName:record.projects.text};
	                     selectedPrimarySkill={id:record.primarySkills.id, skill:record.primarySkills.text};
	                     selectedSecondarySkill={id:record.secondarySkills.id, skill:record.secondarySkills.text};
	                     saveResourceObj.location=selectedLocation;
	                     saveResourceObj.project=selectedProject;
	                     saveResourceObj.primarySkill=selectedPrimarySkill;
	                     saveResourceObj.secondarySkill=selectedSecondarySkill;
	                     if (record.recid){     
	                    	 saveResourceObj.id = record.recid;
	                    	 resourcesCall.data = saveResourceObj;
	                    	 resourcesCall.postSaveResource(saveResourceObj);
	                	}
	                	else{
	                		resourcesCall.data = saveResourceObj;
	                		resourcesCall.postSaveResource();
	                	}
	                 }
	             }
	        }
	    },
	    add_project:{
	        name: 'add_project',
	        style:'border: 0px',
	        fields: [
	            { name: 'projectName', id: 'projectName', type: 'text', required: true,
	                html: { caption: 'Project', attr: 'style="width: 300px;" maxlength="255"' }
	            }
	        ],
	        onChange: function (event) {
	        	
		    },
	        actions: {
	            'Cancel': function () {
	            	formChangedFlag = false;
	                confirmCloseDraft(formChangedFlag);
	           },
	            'Save': function () {
	                var errors  = this.validate();
	                var record = this.record;
	                
	                 if (errors.length == 0) {
	                 	w2popup.lock('one moment...', true);
	                 	var saveProjectObj={};
	                 	
	                 	saveProjectObj.projectName = record.projectName;
	                     if (record.recid){     
	                    	 saveProjectObj.id = record.recid;
	                    	 projectCall.data = saveProjectObj;
	                    	 projectCall.postSaveProject(saveProjectObj);
	                	}
	                	else{
	                		projectCall.data = saveProjectObj;
	                		projectCall.postSaveProject();
	                	}
	                 }
	             }
	        }
	    }
	};

$(function () {
	    // initialization
	    $('#main').w2layout(resource_config.layout);
	    w2ui.layout.content('left', $().w2sidebar(resource_config.sidebar));
	    w2ui.layout.content('main', $().w2grid(resource_config.resources));
	    // in memory initialization
	    $().w2grid(resource_config.projects);
	    $().w2grid(resource_config.locations);
	    $().w2grid(resource_config.skills);
	    $().w2form(resource_config.add_resource);
	    $().w2form(resource_config.add_project);
	});


function resourceAdd (resourceRec) {
	
	var formTitle;
    if(!resourceRec) formTitle = 'Add new resource'; 
    else{ 
    	formTitle = 'Edit resource',
    	editResourceId = resourceRec.id; 
    }
	
	formChangedFlag = false;
	
  w2popup.open({
      title   : formTitle,
      width   : 600,
      height  : 400,
      modal   : true,
      body    : '<div id="addresource" style="position: absolute; left: 0px; right: 0px; top: 0px; bottom: 0px"></div>',
      onOpen  : function (event) {
      	setTimeout(function () { w2popup.lock('', true); }, 1);
          event.onComplete = function () {
          	$('#w2ui-popup .w2ui-msg-title').unbind('mousedown');
            $('#w2ui-popup .w2ui-msg-title').css('cursor','auto');
            
            w2ui.add_resource.clear();
            
            if (resourceRec) loadResourceForEdit(resourceRec);
            else setResourceOptions(true);
            
            $('#w2ui-popup #addresource').w2render('add_resource');
          }
      }
  });
  // pop up close event attachment
  $('.w2ui-msg-close').on('click', function(event){confirmCloseDraft(formChangedFlag);});
}

function resourceDelete(){
	w2confirm({
		title: 'Confirmation',
		msg: 'Are you sure you want to delete selected resource?',
		yes_text: 'Yes',
		no_text: 'No',
		yes_class: 'btn-red' 
	})
	.yes(function (){resourcesCall.deleteResourceDetails(w2ui.resources.getSelection()[0]);});   	
}


function setResourceOptions(focusNameField){
	resourcesCall.getSkillOptions().done(function(resultObj){ 
      var skill = {};
      var skillsArr = [];
      var project = {};
      var projectArr = [];
      var location = {};
      var locationArr = [];
      if(resultObj.skills != null || resultObj.skills != undefined){
        for(var i = 0; i < resultObj.skills.length; i++){
        	skill = {
                id:resultObj.skills[i].id,
                ruleId: resultObj.skills[i].id,
                text: resultObj.skills[i].skill,
                name: resultObj.skills[i].skill
                };
          skillsArr.push(skill);
        }
      }
      
      if(resultObj.locations != null || resultObj.locations != undefined){
          for(var i = 0; i < resultObj.locations.length; i++){
        	  location = {
                  id:resultObj.locations[i].id,
                  ruleId: resultObj.locations[i].id,
                  text: resultObj.locations[i].locationName,
                  name: resultObj.locations[i].locationName
                  };
        	  locationArr.push(location);
          }
        }
      
      if(resultObj.projects != null || resultObj.projects != undefined){
          for(var i = 0; i < resultObj.projects.length; i++){
        	  project = {
                  id:resultObj.projects[i].id,
                  ruleId: resultObj.projects[i].id,
                  text: resultObj.projects[i].projectName,
                  name: resultObj.projects[i].projectName
                  };
        	  projectArr.push(project);
          }
        }
      
      for(var j = 0; j < w2ui.add_resource.fields.length; j++){
        if(w2ui.add_resource.fields[j].field == 'primarySkills'){
          w2ui.add_resource.fields[j].options.items = skillsArr;
        }
        if(w2ui.add_resource.fields[j].field == 'secondarySkills'){
            w2ui.add_resource.fields[j].options.items = skillsArr;
        }
        if(w2ui.add_resource.fields[j].field == 'projects'){
            w2ui.add_resource.fields[j].options.items = projectArr;
        }
        if(w2ui.add_resource.fields[j].field == 'locations'){
            w2ui.add_resource.fields[j].options.items = locationArr;
        }
      }
      w2ui.add_resource.refresh();
      if(focusNameField) $('#fullName').focus();
      w2popup.unlock();               
    });
}


function loadResourceForEdit(){
  	w2popup.lock('Loading ...', true);
  		resourcesCall.getResourceDetails(editResourceId).done(function(resultObj){
    		if(resultObj.resultString){
    			w2alert(resultObj.userString,'',w2popup.message());
    		}
    		
    		var selectedLocation = {};
         	var selectedProject = {};
         	var selectedPrimarySkill = {};
         	var selectedSecondarySkill = {};
         	var resource={};
         	
         	 resource.recid = resultObj.resource.id;
         	 resource.id = resultObj.resource.id;
         	 resource.fullName = resultObj.resource.fullName;
         	 resource.enterprise_Id = resultObj.resource.enterprise_Id; 
         	 resource.phone = resultObj.resource.phone;
         	 resource.email = resultObj.resource.email;
         	resource.careerLevel = resultObj.resource.careerLevel;
             selectedLocation = {
                     id: resultObj.resource.location.id,
                     ruleId: resultObj.resource.location.id,
                     text: resultObj.resource.location.locationName,
                     name: resultObj.resource.location.locationName
                     };
             selectedProject={
                     id: resultObj.resource.project.id,
                     ruleId: resultObj.resource.project.id,
                     text: resultObj.resource.project.projectName,
                     name: resultObj.resource.project.projectName
                     };
             selectedPrimarySkill={
                     id: resultObj.resource.primarySkill.id,
                     ruleId: resultObj.resource.primarySkill.id,
                     text: resultObj.resource.primarySkill.skill,
                     name: resultObj.resource.primarySkill.skill
                     };
             selectedSecondarySkill={
                     id: resultObj.resource.secondarySkill.id,
                     ruleId: resultObj.resource.secondarySkill.id,
                     text: resultObj.resource.secondarySkill.skill,
                     name: resultObj.resource.secondarySkill.skill
                     };
             resource.locations=selectedLocation;
             resource.projects=selectedProject;
             resource.primarySkills=selectedPrimarySkill;
             resource.secondarySkills=selectedSecondarySkill;
             
             w2ui.add_resource.record = resource;
             setResourceOptions();

    	}).fail(function(jqXHR, textStatus, errorThrown){
      	  showGenericError(jqXHR, textStatus, errorThrown);
      });
  }



function projectAdd (projectRec) {
	
	var formTitle;
    if(!projectRec) formTitle = 'Add new Project'; 
    else{ 
    	formTitle = 'Edit Project',
    	editProjectId = projectRec.id; 
    }
	
	formChangedFlag = false;
	
  w2popup.open({
      title   : formTitle,
      width   : 600,
      height  : 400,
      modal   : true,
      body    : '<div id="addproject" style="position: absolute; left: 0px; right: 0px; top: 0px; bottom: 0px"></div>',
      onOpen  : function (event) {
      	setTimeout(function () { w2popup.lock('', true); }, 1);
          event.onComplete = function () {
          	$('#w2ui-popup .w2ui-msg-title').unbind('mousedown');
            $('#w2ui-popup .w2ui-msg-title').css('cursor','auto');
            
            w2ui.add_project.clear();
            
            if (projectRec) loadProjectForEdit(projectRec);
            else {
            	w2ui.add_project.refresh();
            	$('#projectName').focus();
                w2popup.unlock();
            }
            $('#w2ui-popup #addproject').w2render('add_project');
          }
      }
  });
  // pop up close event attachment
  $('.w2ui-msg-close').on('click', function(event){confirmCloseDraft(formChangedFlag);});
}

function loadProjectForEdit(){
  	w2popup.lock('Loading ...', true);
  	projectCall.getProjectDetails(editProjectId).done(function(resultObj){
    		if(resultObj.resultString){
    			w2alert(resultObj.userString,'',w2popup.message());
    		}
         	var project={};
         	
         	project.recid = resultObj.project.id;
         	project.id = resultObj.project.id;
         	project.projectName = resultObj.project.projectName;
             w2ui.add_project.record = project;
             w2ui.add_project.refresh();
         	$('#projectName').focus();
             w2popup.unlock();

    	}).fail(function(jqXHR, textStatus, errorThrown){
      	  showGenericError(jqXHR, textStatus, errorThrown);
      });
  }

function projectDelete(){
	w2confirm({
		title: 'Confirmation',
		msg: 'Are you sure you want to delete selected project?',
		yes_text: 'Yes',
		no_text: 'No',
		yes_class: 'btn-red' 
	})
	.yes(function (){projectCall.deleteProjectDetails(w2ui.projects.getSelection()[0]);});   	
}


resourcesCall ={
		data : {
			'id':null,
			'name':null,
			'enterprise_Id':null,
			'phone':null,
			'email':null,
			'location':null,
			'project':null,
			'primarySkill':null,
			'secondarySkill':null
		},
		getResourceDetails: function(urlEnd){
			return $.ajax({ 
				url: 'api/resources/'+urlEnd,
				contentType: 'application/json',
				type:'GET',
				dataType: 'json',
				complete:(function(jqXHR){
					var resJSON = jqXHR.responseJSON;
					if(resJSON.resultString){
	            		w2alert(resJSON.userString,'',w2popup.message());
	                    layout.unlock('right');
	            	}
				}),
				Accept: 'application/json'
			}); 
		},
		getSkillOptions: function(){
			return $.ajax({
	    		url:'api/resources/new',
	            dataType:'json',
	            type: 'POST',
	            Accept: 'application/json'
	    	});
		},
		postSaveResource: function(modifyResourceRec){
			if(!modifyResourceRec){
				methodType = 'POST'; 
				methodUrl = 'api/resources';
			}	
		    else{
		    	methodType = 'PUT'; 
				methodUrl = 'api/resources/'+modifyResourceRec.id;
		    }
				$.ajax({
		        	type: methodType,
		        	contentType: 'application/json',
		        	url: methodUrl,
		        	dataType:'json',
		        	data:JSON.stringify(this.data),
		        	Accept: 'application/json',
		        	complete: function(jqXHR) {
		        		var resJSON = jqXHR.responseJSON;
		        		if(resJSON.resultString){
		        			w2alert(resJSON.userString);
		        			w2popup.unlock();
			        	}
		        		else{
			        		w2alert(resJSON.message,'Notification',w2popup.close());
			        		w2ui.resources.reload();
		               		setTimeout(function(){
		               			w2ui.resources.select(resJSON.id);
		               			w2ui.resources.scrollIntoView();
		          		   }, 3000); 
			        	}
			           }
		        });
		},
		deleteResourceDetails: function(deleteId){
			return $.ajax({ 
				url: 'api/resources/'+deleteId,
				contentType: 'application/json',
				type:'DELETE',
				dataType: 'json',
				complete:(function(jqXHR){
					var resJSON = jqXHR.responseJSON;
					w2alert(resJSON.message,'Notification',w2popup.close());
					w2ui.resources.reload();
				}),
				Accept: 'application/json'
			}); 
		}
}

projectCall = {
	data : {
		'id' : null,
		'projectName' : null
	},
	getProjectDetails : function(urlEnd) {
		return $.ajax({
			url : 'api/projects/' + urlEnd,
			contentType : 'application/json',
			type : 'GET',
			dataType : 'json',
			complete : (function(jqXHR) {
				var resJSON = jqXHR.responseJSON;
				if (resJSON.resultString) {
					w2alert(resJSON.userString, '', w2popup.message());
					layout.unlock('right');
				}
			}),
			Accept : 'application/json'
		});
	},
	postSaveProject : function(modifyProjectRec) {
		if (!modifyProjectRec) {
			methodType = 'POST';
			methodUrl = 'api/projects';
		} else {
			methodType = 'PUT';
			methodUrl = 'api/projects/' + modifyProjectRec.id;
		}
		$.ajax({
			type : methodType,
			contentType : 'application/json',
			url : methodUrl,
			dataType : 'json',
			data : JSON.stringify(this.data),
			Accept : 'application/json',
			complete : function(jqXHR) {
				var resJSON = jqXHR.responseJSON;
				if (resJSON.resultString) {
					w2alert(resJSON.userString);
					w2popup.unlock();
				} else {
					w2alert(resJSON.message, 'Notification', w2popup.close());
					w2ui.projects.reload();
					setTimeout(function() {
						w2ui.projects.select(resJSON.id);
						w2ui.projects.scrollIntoView();
					}, 3000);
				}
			}
		});

	},
	deleteProjectDetails : function(deleteId) {
		return $.ajax({
			url : 'api/projects/' + deleteId,
			contentType : 'application/json',
			type : 'DELETE',
			dataType : 'json',
			complete : (function(jqXHR) {
				var resJSON = jqXHR.responseJSON;
				w2alert(resJSON.message, 'Notification', w2popup.close());
				w2ui.projects.reload();
			}),
			Accept : 'application/json'
		});
	}
}


