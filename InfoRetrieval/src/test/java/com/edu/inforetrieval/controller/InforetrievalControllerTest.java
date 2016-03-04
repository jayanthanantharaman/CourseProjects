/**
 * @since: Feb 26, 2016
 *
 */
package com.edu.inforetrieval.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.WebIntegrationTest;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.client.RestTemplate;

import com.edu.inforetrieval.InfoRetrievalApp;
import com.edu.inforetrieval.common.AppConstants;
import com.edu.inforetrieval.vo.BaseResponseVO;

/**
 * @author Jayanth
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = InfoRetrievalApp.class)
@WebIntegrationTest
public class InforetrievalControllerTest {

	private static Logger logger = LoggerFactory.getLogger(InforetrievalControllerTest.class);
	private RestTemplate restTemplate = new RestTemplate();
	private String QUERY_FILE = "G:\\Courses\\Information Retrieval\\Workspace\\InfoRetrieval\\src\\main\\resources\\query.text";
	private String URL = "http://localhost:8888/inforetrieval/api/retrievedocs/";

	@Test
	public void testRetrieveDocuments() {
		ResponseEntity<BaseResponseVO> response = null;
		BaseResponseVO responseVO = null;
		HttpEntity<String> httpEntity = null;
		List<String> queryList = buildQueryList();
		for (String query : queryList) {
			httpEntity = new HttpEntity<String>(query);
			response = restTemplate.postForEntity(URL, httpEntity, BaseResponseVO.class);
			responseVO = response.getBody();
			writeResults(query, responseVO);
			Assert.assertTrue(responseVO.getRecords().size() > 0);
		}
	}

	/**
	 * @param docbeanList
	 */
	@SuppressWarnings("unchecked")
	private void writeResults(String query, BaseResponseVO responseVO) {
		List<? extends Object> docbeanList = responseVO.getRecords();
		StringBuilder builder = new StringBuilder();
		Map<String, Object> Id = null;
		for (Object obj : docbeanList) {
			Id = (Map<String, Object>)obj;
			builder.append(Id.get(AppConstants.ID));
			builder.append(",");
		}
		logger.info("Query " + query);
		logger.info("Total Hits " + responseVO.getTotalHits());
		logger.info("Top 10 Docs " + builder.toString());
	}

	/**
	 * Method to build querylist from the queryfile
	 * @return
	 */
	private List<String> buildQueryList() {
		File file = new File(QUERY_FILE);
		InputStream inputStream = null;
		Scanner scanner = null;
		String line = null;
		List<String> queryList = new ArrayList<String>();
		int count = 25;
		try {
			inputStream = new FileInputStream(file);
			scanner = new Scanner(inputStream);
			StringBuilder builder;
			while (scanner.hasNextLine() && count > 0) {
				line = scanner.nextLine();
				if (line.startsWith(".W")) {
					builder = new StringBuilder();
					while (!scanner.hasNext(".I") && scanner.hasNextLine()) {
						builder.append(scanner.nextLine());
					}
					queryList.add(builder.toString());
					--count;
				}
			}
		} catch (FileNotFoundException e) {
			System.out.println("FileNotFoundException occured " + e.getMessage());
		}
		System.out.println("Total no. of queries " + queryList.size());
		return queryList;
	}

}
