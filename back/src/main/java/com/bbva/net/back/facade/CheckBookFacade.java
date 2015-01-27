/**
 * 
 */
package com.bbva.net.back.facade;

import java.util.List;

import com.bbva.net.back.model.checkbook.CheckDto;
import com.bbva.net.back.model.checkbook.CheckbookDto;
import com.bbva.net.back.model.commons.DateRangeDto;

/**
 * @author User
 */
public interface CheckBookFacade {

	/**
	 * Method to get a list of checks giving id Check and status
	 * 
	 * @param idCheck
	 * @return List<Check>
	 */
	List<CheckDto> getCheckById(String idCheck);

	/**
	 * Method to get a list of checkbook giving id account
	 * 
	 * @param idCheck
	 * @return List<CheckbookDto>
	 */

	List<CheckbookDto> getCheckbookDto(String idCheck);

	/**
	 * Method to get a list of checks giving id Check and status
	 * 
	 * @param idCheck
	 * @return List<Check>
	 */
	List<CheckDto> getCheckByStatusOrDate(String accountId, DateRangeDto dateRange, String status,
			String paginationKey, String pageSize);
	
	
	/**
	 * Method to search a checkBook by criteria
	 * @param accountId
	 * @param checkBookId
	 * @return CheckBookDto
	 */
	CheckbookDto getCheckBookById(String accountId,String checkBookId);	
}
