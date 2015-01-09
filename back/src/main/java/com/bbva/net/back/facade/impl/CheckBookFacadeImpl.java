/**
 * 
 */
package com.bbva.net.back.facade.impl;

import java.util.List;

import javax.annotation.Resource;

import com.bbva.czic.dto.net.Check;
import com.bbva.czic.dto.net.Checkbook;
import com.bbva.net.back.core.pattern.facade.AbstractBbvaFacade;
import com.bbva.net.back.core.stereotype.Facade;
import com.bbva.net.back.facade.CheckBookFacade;
import com.bbva.net.back.mapper.CheckBookMapper;
import com.bbva.net.back.model.checkbook.CheckDto;
import com.bbva.net.back.model.checkbook.CheckbookDto;
import com.bbva.net.webservices.checkbooks.CheckBookService;

/**
 * @author User
 */

@Facade(value = "checkBookFacade")
public class CheckBookFacadeImpl extends AbstractBbvaFacade implements CheckBookFacade {

	private static final long serialVersionUID = 1L;

	// CLIENTE REST
	@Resource(name = "checkBookService")
	private CheckBookService checkBookService;

	@Resource(name = "checkBookMapper")
	private CheckBookMapper checkBookMapper;

	@Override
	public List<CheckDto> getCheck(final String idCheck, final String status) {
		final List<Check> checks = this.checkBookService.getChecks(idCheck, null, null,null,null);
		return checkBookMapper.mapCheck(checks);
	}

	@Override
	public List<CheckbookDto> getCheckbookDto(String checkbookId) {
		final List<Checkbook> checkBooks = this.checkBookService.getCheckbooks(checkbookId, null, null,null,null);
		return checkBookMapper.mapCheckBook(checkBooks);
	}
}
