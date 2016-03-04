/**
 * @since: Feb 22, 2016
 *
 */
package com.edu.inforetrieval.service.impl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.lucene.document.Document;
import org.apache.lucene.index.DirectoryReader;
import org.apache.lucene.index.IndexReader;
import org.apache.lucene.queryparser.classic.MultiFieldQueryParser;
import org.apache.lucene.queryparser.classic.ParseException;
import org.apache.lucene.queryparser.classic.QueryParser;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.ScoreDoc;
import org.apache.lucene.search.TopDocs;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import com.edu.inforetrieval.common.AppConstants;
import com.edu.inforetrieval.common.DocBean;
import com.edu.inforetrieval.common.InfoRetrievalUtil;
import com.edu.inforetrieval.service.QueryServiceI;
import com.edu.inforetrieval.vo.BaseResponseVO;

/**
 * @author Jayanth
 *
 */
public class QueryService implements QueryServiceI {
	
	@Value("${inforetrieval.indexPath}")
	private String indexPath;
	
	@Value("${inforetrieval.searchFields}")
	private String searchFields;

	@Autowired
	private InfoRetrievalUtil infoRetrievalUtil;
	
	private static final Logger logger = LoggerFactory.getLogger(QueryService.class);
	private IndexSearcher searcher = null;
    private QueryParser parser = null;
    
	
	/**
	 * Method to retrieve documents from index
	 * @param queryStr
	 * @return TopDocs
	 */
	private TopDocs searchDocs(String queryStr) {
		IndexReader reader;
		Query query;
		TopDocs topDocs=null;
		String[] fields=searchFields.split(",");
		try {
			reader = DirectoryReader.open(infoRetrievalUtil.getDirectory());
			searcher = getIndexSearcher(reader);
			parser = new MultiFieldQueryParser(fields, infoRetrievalUtil.getAnalyzer());
			query = parser.parse(queryStr);
			topDocs = searcher.search(query, infoRetrievalUtil.getResults());
		} catch (IOException e) {
			logger.error("IOException occured while reading directory " + e.getMessage());
		} catch (ParseException e) {
			logger.error("ParseException occured : " + e.getMessage());
		}
		return topDocs;
	}
	
	/* (non-Javadoc)
	 * @see com.edu.inforetrieval.service.QueryServiceI#searchDocs(java.lang.String)
	 */
	@Override
	public BaseResponseVO searcDocuments(String query){
		long startTime = new Date().getTime();
		BaseResponseVO baseResponseVO = new BaseResponseVO();
		List<Document> documents = new ArrayList<Document>();
		TopDocs topDocs = searchDocs(query);
		long endTime = new Date().getTime();
		logger.info("Total Time taken to search query" + (endTime-startTime)+"ms");
		startTime = new Date().getTime();
		baseResponseVO.setTotalHits(topDocs.totalHits);
		ScoreDoc[] hits = topDocs.scoreDocs;
		Document doc=null;
		for(ScoreDoc scoredoc:hits){
			try {
				doc = searcher.doc(scoredoc.doc);
				documents.add(doc);
			} catch (IOException e) {
				String msg="IOException occured : " + e.getMessage();
				logger.error(msg);
				baseResponseVO.setStatus(AppConstants.FAILURE);
				baseResponseVO.setMessage(msg);
				return baseResponseVO;
			}
		}
		baseResponseVO.setStatus(AppConstants.SUCCESS);
		baseResponseVO.setRecords(populateResult(documents));
		endTime = new Date().getTime();
		logger.info("Total Time taken to display query" + (endTime-startTime)+"ms");
		return baseResponseVO;
	}
	
	/**
	 * Method to populate required field from documents retrieved 
	 * to display in UI 
	 * @param documents
	 * @return List<DocBean>
	 */
	private List<DocBean> populateResult(List<Document> documents){
		List<DocBean> docbeanList = new ArrayList<DocBean>();
		DocBean bean = null;
		
		for(Document doc:documents){
			bean = new DocBean();
			bean.setId(doc.get(AppConstants.ID));
			bean.setAuthor(doc.get(AppConstants.AUTHOR));
			bean.setTitle(doc.get(AppConstants.TITLE));
			bean.setBibilio(doc.get(AppConstants.BIBILIO));
			docbeanList.add(bean);
		}
		logger.info("No Of Docs retrieved " + docbeanList.size());
		
		return docbeanList;
	}
	
	/**
	 * @param reader
	 * @return IndexSearcher
	 */
	private IndexSearcher getIndexSearcher(IndexReader reader){
		if(searcher == null){
			searcher = new IndexSearcher(reader);
			logger.info(">>>>>>> Index Statistics >>>>>>>>>");
			logger.info("Total Docs Indexed " + reader.numDocs());
		}
		return searcher;
	}
}
