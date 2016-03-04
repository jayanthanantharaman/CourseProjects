/**
 * @since: Feb 21, 2016
 *
 */
package com.edu.inforetrieval;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.edu.inforetrieval.common.InfoRetrievalUtil;
import com.edu.inforetrieval.service.IndexServiceI;
import com.edu.inforetrieval.service.QueryServiceI;
import com.edu.inforetrieval.service.impl.IndexService;
import com.edu.inforetrieval.service.impl.QueryService;

/**
 * @author Jayanth
 *
 */
@SpringBootApplication
public class InfoRetrievalApp {
	
	@Bean
	IndexServiceI getIndexService(){
		return new IndexService();
	}
	@Bean
	InfoRetrievalUtil getInfoRetrievalUtil(){
		return new InfoRetrievalUtil();
	}
	
	@Bean
	QueryServiceI getQueryService(){
		return new QueryService();
	}
	
	public static void main(String[] args) {
		SpringApplication.run(InfoRetrievalApp.class, args);
	}

}
