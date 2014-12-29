/**
 * 
 */
package com.bbva.net.back.facade;

import java.util.List;

import com.bbva.net.back.model.checkbook.CheckbookDto;


/**
 * @author User
 *
 */
public interface MovementCriteriaFacade {
	
	/**
	 * 
	 * Method to get a list of CheckBookDto 
	 * @param user
	 * @return
	 */
	List<CheckbookDto> getCheckBookssByUser(String user);

}
