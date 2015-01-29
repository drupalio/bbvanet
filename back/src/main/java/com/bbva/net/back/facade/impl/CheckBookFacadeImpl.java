/**
 * 
 */
package com.bbva.net.back.facade.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Value;

import com.bbva.czic.dto.net.Check;
import com.bbva.czic.dto.net.Checkbook;
import com.bbva.net.back.core.pattern.facade.AbstractBbvaFacade;
import com.bbva.net.back.core.stereotype.Facade;
import com.bbva.net.back.facade.CheckBookFacade;
import com.bbva.net.back.mapper.CheckBookMapper;
import com.bbva.net.back.model.checkbook.CheckDto;
import com.bbva.net.back.model.checkbook.CheckbookDto;
import com.bbva.net.back.model.commons.DateRangeDto;
import com.bbva.net.back.service.FiqlService;
import com.bbva.net.webservices.accounts.AccountsService;

/**
 * @author User
 */

@Facade(value = "checkBookFacade")
public class CheckBookFacadeImpl extends AbstractBbvaFacade implements CheckBookFacade {

	private static final long serialVersionUID = 1L;

	
	@Resource(name = "accountsService")
	private AccountsService accountService;

	@Resource(name = "checkBookMapper")
	private CheckBookMapper checkBookMapper;

	@Resource(name = "fiqlService")
	private FiqlService fiqlService;

	@Value("${fiql.accountMovement.date}")
	private String DATE;

	@Value("${fiql.accountMovement.status}")
	private String STATUS;

	@Override
	public CheckDto getCheckById(final String accountId, final String checkId) {
		final Check check = this.accountService.getCheck(accountId, checkId);
		return checkBookMapper.mapCheck(check);
	}

	@Override
	public List<CheckDto> getCheckByStatusOrDate(String accountId, DateRangeDto dateRange, String status,
			Integer paginationKey, Integer pageSize) {
		String filter = dateRange == null ? fiqlService.getFiqlQueryByStatus(status, STATUS) : fiqlService.getFiqlQueryByDateRange(dateRange, DATE, DATE);
		final List<Check> response = this.accountService.listCheck(accountId, filter, paginationKey, pageSize);
		return checkBookMapper.mapCheckList(response);
	}

	@Override
	public CheckbookDto getCheckBookByAccountId(String accountId, String checkBookId) {
		final Checkbook response = this.accountService.getCheckbook(checkBookId, accountId);
		return checkBookMapper.mapCheckBook(response);
	}
	
	@Override
	//TODO cambiar x accountId
	public List<CheckbookDto> getCheckBooksById(String accountId) {
		final List<Checkbook> response = this.accountService.getAccount(accountId).getCheckbooks();
		return checkBookMapper.mapCheckBookList(response);
	}
}
