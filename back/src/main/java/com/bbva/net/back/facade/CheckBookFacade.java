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
	 * Method to get a check giving id Check
	 * 
	 * @param checkId
	 * @param accountId
	 * @return Check
	 */
	CheckDto getCheckById(final String accountId, final String checkId);

	/**
	 * Method to get a list of checks giving id Check and status
	 * 
	 * @param idCheck
	 * @return List<Check>
	 */
	List<CheckDto> getCheckByStatusOrDate(String accountId, DateRangeDto dateRange, String status,
			Integer paginationKey, Integer pageSize);

	/**
	 * Method to search a checkBook by criteria
	 * 
	 * @param accountId
	 * @param checkBookId
	 * @return CheckBookDto
	 */
	CheckbookDto getCheckBookByAccountId(String accountId, String checkBookId);

	/**
	 * Method to search a checkBook by accountId
	 * 
	 * @param accountId
	 * @return List CheckBookDto
	 */
	List<CheckbookDto> getCheckBooksById(String accountId);
}
