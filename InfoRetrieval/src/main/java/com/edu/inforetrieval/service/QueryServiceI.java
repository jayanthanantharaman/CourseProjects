/**
 * @since: Feb 22, 2016
 *
 */
package com.edu.inforetrieval.service;

import com.edu.inforetrieval.vo.BaseResponseVO;

/**
 * @author Jayanth
 *
 */
public interface QueryServiceI {

	public BaseResponseVO searcDocuments(String query);
}
