/**
 * 
 */
package com.bbva.net.back.mapper;

import java.util.List;

import com.bbva.czic.dto.net.Check;
import com.bbva.czic.dto.net.Checkbook;
import com.bbva.net.back.model.checkbook.CheckDto;
import com.bbva.net.back.model.checkbook.CheckbookDto;


/**
 * @author User
 *
 */
public interface CheckBookMapper {
	
	/**
	 * @param checkBooks
	 * @return List checkBookDto
	 */
	List<CheckbookDto> mapCheckBook(final List<Checkbook> checkBooks);
	
	/**
	 * @param Check
	 * @return List CheckDto
	 */
	List<CheckDto> mapCheck(final List<Check> check);

}
