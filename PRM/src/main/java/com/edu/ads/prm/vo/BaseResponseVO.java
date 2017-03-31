package com.edu.ads.prm.vo;

import java.io.Serializable;
import java.util.List;

import com.edu.ads.prm.entities.BaseEntity;

public class BaseResponseVO implements Serializable{


	private static final long serialVersionUID = 1L;
	
	 private Integer total;
	    private List<? extends BaseEntity> records;
	    private String message;
	    private String status="success";
		/**
		 * @return the total
		 */
		public Integer getTotal() {
			return total;
		}
		/**
		 * @param total the total to set
		 */
		public void setTotal(Integer total) {
			this.total = total;
		}
		/**
		 * @return the records
		 */
		public List<? extends BaseEntity> getRecords() {
			return records;
		}
		/**
		 * @param records the records to set
		 */
		public void setRecords(List<? extends BaseEntity> records) {
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
