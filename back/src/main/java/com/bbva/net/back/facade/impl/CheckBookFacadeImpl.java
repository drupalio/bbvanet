/**
 * 
 */
package com.bbva.net.back.facade.impl;

import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
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

	@Resource(name = "accountsService")
	private AccountsService accountService;

	@Resource(name = "checkBookMapper")
	private CheckBookMapper checkBookMapper;

	@Resource(name = "fiqlService")
	private FiqlService fiqlService;

	@Value("${fiql.accountMovement.date}")
	private String DATE;

	@Override
	public CheckDto getCheckById(final String idCheck) {
		final Check check = this.checkBookService.getChecks(idCheck, null, null, null, null);
		return checkBookMapper.mapCheck(check);
	}
	
	/***
	 * 
	 * month=ge=2014-12-27;month=le=2015-01-27
	 * /accounts/V01/{accountId}/listChecks?$filter=((check.issueDate=ge={startDate};check.issueDate=le={endDate}),check.status={status})&paginationKey={paginationKey}&pageSize={pageSize}"  
	 * 
	 */
	@Override
	public List<CheckDto> getCheckByStatusOrDate(String accountId, DateRangeDto dateRange, String status,
			Integer paginationKey, Integer pageSize) {
		String filter = dateRange == null ? StringUtils.EMPTY : fiqlService.getFiqlQueryByDateRange(dateRange, DATE,
				DATE);

		final List<Check> response = this.accountService.listCheck(accountId, filter, paginationKey, pageSize);
		return checkBookMapper.mapCheckList(response);
	}

	@Override
	public CheckbookDto getCheckBookByAccountId(String accountId, String checkBookId) {
		final Checkbook response = this.accountService.getCheckbook(checkBookId, accountId);
		return checkBookMapper.mapCheckBook(response);
	}
	
	@Override
	public List<CheckbookDto> getCheckBooksById(String checkBookId) {
		final List<Checkbook> response = this.checkBookService.getCheckbooks(checkBookId, null, null, null,null);
		return checkBookMapper.mapCheckBookList(response);
	}
}
