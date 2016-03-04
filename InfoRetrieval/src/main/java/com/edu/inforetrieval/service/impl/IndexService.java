/**
 * @since: Feb 21, 2016
 *
 */
package com.edu.inforetrieval.service.impl;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.document.StringField;
import org.apache.lucene.document.TextField;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.IndexWriterConfig;
import org.apache.lucene.index.IndexWriterConfig.OpenMode;
import org.apache.lucene.store.Directory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import com.edu.inforetrieval.common.AppConstants;
import com.edu.inforetrieval.common.InfoRetrievalUtil;
import com.edu.inforetrieval.service.IndexServiceI;
import com.edu.inforetrieval.vo.BaseResponseVO;


/**
 * @author Jayanth
 *
 */
public class IndexService implements IndexServiceI {

	@Value("${inforetrieval.createIndex}")
	private String createIndex;
	
	@Value("${inforetrieval.boost}")
	private String boost;

	@Value("${inforetrieval.boostvalue}")
	private String boostValue;

	@Autowired
	private InfoRetrievalUtil infoRetrievalUtil;
	
	private IndexWriter indexWriter = null;
	private static final Logger logger = LoggerFactory.getLogger(IndexService.class);


	/*
	 * (non-Javadoc)
	 * 
	 * @see com.edu.inforetrieval.service.IndexServiceI#indexDocuments()
	 */
	@Override
	public BaseResponseVO indexDocuments() {
		long startTime = new Date().getTime();
		BaseResponseVO baseResponseVO = new BaseResponseVO();
		IndexWriter writer = getIndexWriter();
		List<Document> documents = processDocuments();

		for (Document doc : documents) {
			try {
				writer.addDocument(doc);
			} catch (IOException e) {
				String msg = "IOException occured while adding documents " + e.getMessage();
				logger.error(msg);
				baseResponseVO.setStatus(AppConstants.FAILURE);
				baseResponseVO.setMessage(msg);
				return baseResponseVO;
			}
		}
		long endTime = new Date().getTime();
		logger.info("Total Time taken to build Index " + (endTime-startTime)+"ms");
		closeindexWriter();
		baseResponseVO.setMessage(" No. Of Documents " + documents.size());
		baseResponseVO.setStatus(AppConstants.SUCCESS);
		return baseResponseVO;
	}

	private IndexWriter getIndexWriter() {
		if (indexWriter == null) {
			IndexWriterConfig indexWriterConfig = new IndexWriterConfig(infoRetrievalUtil.getAnalyzer());
			try {
				Directory directory = infoRetrievalUtil.getDirectory();
				if (getCreateIndex()) {
					indexWriterConfig.setOpenMode(OpenMode.CREATE);
				} else {
					indexWriterConfig.setOpenMode(OpenMode.CREATE_OR_APPEND);
				}
				indexWriter = new IndexWriter(directory, indexWriterConfig);
			} catch (IOException e) {
				logger.error("IOException while creating index " +e.getMessage());
			}
		}
		return indexWriter;
	}

	/**
	 * @return 
	 */
	private List<Document> processDocuments() {
		List<Document> documents = new ArrayList<Document>();
		Document document = null;
		String line = null;
		File file = new File(infoRetrievalUtil.getDocsPath());
		Scanner scanner = null;
		String[] splitStr = null;
		StringBuilder builder = null;
		InputStream inputStream = null;
		try {
			inputStream = new FileInputStream(file);
			scanner = new Scanner(inputStream);
			while (scanner.hasNextLine()) {
				line = scanner.nextLine();
				if (line.startsWith(".I")) {
					document = new Document();
					splitStr = line.split(" ");
					document.add(new StringField(AppConstants.ID, splitStr[1], Field.Store.YES));
				} else if (line.startsWith(".T")) {
					builder = new StringBuilder();
					while (!scanner.hasNext(".A")) {
						builder.append(scanner.nextLine());
					}
					Field field = new TextField(AppConstants.TITLE, builder.toString(), Field.Store.YES);
					if(getBoost()){
						field.setBoost(getBoostValue());
					}
					document.add(field);
				} else if (line.startsWith(".A")) {
					builder = new StringBuilder();
					while (!scanner.hasNext(".B")) {
						builder.append(scanner.nextLine());
					}
					document.add(new StringField(AppConstants.AUTHOR, builder.toString(), Field.Store.YES));
				} else if (line.startsWith(".B")) {
					builder = new StringBuilder();
					while (!scanner.hasNext(".W")) {
						builder.append(scanner.nextLine());
					}
					document.add(new StringField(AppConstants.BIBILIO, builder.toString(), Field.Store.YES));
				} else if (line.startsWith(".W")) {
					builder = new StringBuilder();
					while (!scanner.hasNext(".I") && scanner.hasNextLine()) {
						builder.append(scanner.nextLine());
					}
					document.add(new TextField(AppConstants.ABSTRACT, builder.toString(), Field.Store.YES));
					documents.add(document);
				}
			}
		} catch (FileNotFoundException e) {
			logger.error("FileNotFoundException occured while reading " + e.getMessage());
		} finally {
			scanner.close();
			try {
				inputStream.close();
			} catch (IOException e) {
				logger.error("IOException occured :: "+ e.getMessage());
			}
		}
		logger.info(" No. Of Documents " + documents.size());
		return documents;
	}

	private void closeindexWriter(){
		if(indexWriter!=null){
			try {
				indexWriter.close();
			} catch (IOException e) {
				logger.error("IOException while closing indexwriter " + e.getMessage());
			}
		}
	}
	
	/**
	 * @return the boostValue
	 */
	public float getBoostValue() {
		return new Float(boostValue);
	}
	
	/**
	 * @return the createIndex
	 */
	public boolean getCreateIndex() {
		return new Boolean(createIndex) ;
	}
	
	
	/**
	 * @return the boost
	 */
	public boolean getBoost() {
		return new Boolean(boost) ;
	}
	/*
	 * public static void main(String[] args) { new
	 * IndexService().processDocuments(); }
	 */

}
