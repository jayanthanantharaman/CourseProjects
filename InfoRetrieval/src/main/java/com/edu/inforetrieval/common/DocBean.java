/**
 * @since: Feb 22, 2016
 *
 */
package com.edu.inforetrieval.common;

import java.io.Serializable;

/**
 * @author Jayanth
 *
 */
public class DocBean implements Serializable{

	private static final long serialVersionUID = 1L;

	private String Id;
	private String title;
	private String author;
	private String bibilio;
	/**
	 * @return the id
	 */
	public String getId() {
		return Id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		Id = id;
	}
	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}
	/**
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}
	/**
	 * @return the author
	 */
	public String getAuthor() {
		return author;
	}
	/**
	 * @param author the author to set
	 */
	public void setAuthor(String author) {
		this.author = author;
	}
	/**
	 * @return the bibilio
	 */
	public String getBibilio() {
		return bibilio;
	}
	/**
	 * @param bibilio the bibilio to set
	 */
	public void setBibilio(String bibilio) {
		this.bibilio = bibilio;
	}


}
