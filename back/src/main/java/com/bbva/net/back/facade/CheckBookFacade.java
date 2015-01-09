/**
 * 
 */
package com.bbva.net.back.facade;

import java.util.List;

import com.bbva.net.back.model.checkbook.CheckDto;
import com.bbva.net.back.model.checkbook.CheckbookDto;


/**
 * @author User
 *
 */
public interface CheckBookFacade {

	/**
	 * 
	 *Method to get a list of checks giving id Check and status
	 * @param idCheck
	 * @param status
	 * @return List<Check>
	 */
	List<CheckDto> getCheck(String idCheck, String status);
	
	/**
	 * 
	 *Method to get a list of checkbook giving id account
	 * @param idCheck
	 * @return List<CheckbookDto>
	 */
	
	List<CheckbookDto> getCheckbookDto(String idCheck);
}
