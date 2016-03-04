/**
 * @since: Oct 31, 2015
 *
 */
package com.edu.inforetrieval.vo;

import java.io.Serializable;
import java.util.List;

import com.edu.inforetrieval.common.AppConstants;

/**
 * @author Jayanth
 *
 */
public class BaseResponseVO implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Integer totalHits;
	private List<? extends Object> records;
	private String message;
	private String status = AppConstants.SUCCESS;
	
	
	
	/**
	 * @return the totalHits
	 */
	public Integer getTotalHits() {
		return totalHits;
	}
	/**
	 * @param totalHits the totalHits to set
	 */
	public void setTotalHits(Integer totalHits) {
		this.totalHits = totalHits;
	}
	/**
	 * @return the records
	 */
	public List<? extends Object> getRecords() {
		return records;
	}
	/**
	 * @param records the records to set
	 */
	public void setRecords(List<? extends Object> records) {
		this.records = records;
	}
	/**
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}
	/**
	 * @param message the message to set
	 */
	public void setMessage(String message) {
		this.message = message;
	}
	/**
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}
	/**
	 * @param status the status to set
	 */
	public void setStatus(String status) {
		this.status = status;
	}

	
}
