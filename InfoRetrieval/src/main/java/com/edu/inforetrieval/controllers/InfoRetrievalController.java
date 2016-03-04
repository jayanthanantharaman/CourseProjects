/**
 * @since: Feb 22, 2016
 *
 */
package com.edu.inforetrieval.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.edu.inforetrieval.service.IndexServiceI;
import com.edu.inforetrieval.service.QueryServiceI;
import com.edu.inforetrieval.vo.BaseResponseVO;

/**
 * @author Jayanth
 *
 */
@RestController 
@RequestMapping(value="/api/retrievedocs")
public class InfoRetrievalController {

	@Autowired
	QueryServiceI queryService;
	
	@Autowired
	IndexServiceI indexService;
	
	@RequestMapping(method=RequestMethod.POST)
	public BaseResponseVO retrieveDocuments(@RequestBody String query){
		return queryService.searcDocuments(query);
	}
	
	@RequestMapping(method=RequestMethod.GET,value="/buildIndex")
	public BaseResponseVO buildIndex(){
		return indexService.indexDocuments();
	}
	
}
