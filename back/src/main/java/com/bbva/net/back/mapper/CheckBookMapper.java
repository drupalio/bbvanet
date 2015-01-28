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
	 * @return checkBookDto
	 */
	public CheckbookDto mapCheckBook(Checkbook checkBooks);
	
	
	/**
	 * @param CheckbookDto
	 * @return List<CheckbookDto>
	 */
	List<CheckbookDto> mapCheckBookList(final List<Checkbook> checkbook);
	
	
	/**
	 * @param Check
	 * @return List CheckDto
	 */
	List<CheckDto> mapCheckList(final List<Check> check);
	
	
	/**
	 * @param Check
	 * @return List CheckDto
	 */
	CheckDto mapCheck(final Check check);

}
