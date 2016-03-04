/**
 * @since: Feb 22, 2016
 *
 */
package com.edu.inforetrieval.common;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.core.SimpleAnalyzer;
import org.apache.lucene.analysis.core.StopAnalyzer;
import org.apache.lucene.analysis.core.WhitespaceAnalyzer;
import org.apache.lucene.analysis.en.EnglishAnalyzer;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;

/**
 * @author Jayanth
 *
 */
public class InfoRetrievalUtil {
	
	@Value("${inforetrieval.dataset}")
	private String dataset;

	@Value("${inforetrieval.analyzer}")
	private String analyzerStr;
	
	@Value("${inforetrieval.indexPath}")
	private String indexPath;
	
	@Value("${inforetrieval.results}")
	private String results;
	
	@Value("${inforetrieval.docsPath}")
	private String docsPath;

	private static final Logger logger = LoggerFactory.getLogger(InfoRetrievalUtil.class);
	/**
	 * @return the results
	 */
	public int getResults() {
		return new Integer(results) ;
	}

	/**
	 * Factory method to get analyzer
	 * @return Analyzer
	 */
	public Analyzer getAnalyzer() {
		Analyzer analyzer = null;
		if (AppConstants.WHITESPACE_ANALYZER.equalsIgnoreCase(analyzerStr)) {
			analyzer = new WhitespaceAnalyzer();
		} else if (AppConstants.STOP_ANALYZER.equalsIgnoreCase(analyzerStr)) {
			analyzer = new StopAnalyzer();
		} else if (AppConstants.SIMPLE_ANALYZER.equalsIgnoreCase(analyzerStr)) {
			analyzer = new SimpleAnalyzer();
		} else if(AppConstants.ENGISH_ANALYZER.equalsIgnoreCase(analyzerStr)){
			analyzer = new EnglishAnalyzer();
		}else{
			analyzer = new StandardAnalyzer();
		}
		logger.info("Analyzer used >>> " + analyzer.getClass().getName());
		return analyzer;
	}
	
	/**
	 * @return Directory
	 */
	public Directory getDirectory() {
		Directory directory=null;
		try {
			directory= FSDirectory.open(Paths.get(getIndexPath()));
		} catch (IOException e) {
			logger.error("IOException while opening " + indexPath);
		}
		return directory;
	}
	
	/**
	 * Method to get indexPath based on dataset
	 * 
	 * @return String
	 */
	private String getIndexPath(){
		String path=null;
		if(AppConstants.MEDLINE.equalsIgnoreCase(dataset)){
			path = indexPath+File.separator+AppConstants.MEDLINE;
		}else if(AppConstants.CRANFIELD.equalsIgnoreCase(dataset)){
			path = indexPath+File.separator+AppConstants.CRANFIELD;
		}
		return path;
	}
	
	/**
	 * Method to get DocsPath based on dataset
	 * @return String
	 */
	public String getDocsPath(){
		String doc=null;
		if(AppConstants.MEDLINE.equalsIgnoreCase(dataset)){
			doc = docsPath+File.separator+AppConstants.MEDLINE_DOC;
		}else if(AppConstants.CRANFIELD.equalsIgnoreCase(dataset)){
			doc = docsPath+File.separator+AppConstants.CRANFIELD_DOC;
		}
		return doc;
	}
}
