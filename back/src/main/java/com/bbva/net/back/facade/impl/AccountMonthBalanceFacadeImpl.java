package com.bbva.net.back.facade.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Value;

import com.bbva.czic.dto.net.AccMovementsResume;
import com.bbva.czic.dto.net.MonthlyBalances;
import com.bbva.net.back.core.pattern.facade.AbstractBbvaFacade;
import com.bbva.net.back.core.stereotype.Facade;
import com.bbva.net.back.facade.AccountMonthBalanceFacade;
import com.bbva.net.back.model.accounts.AccountsMonthBalanceDto;
import com.bbva.net.back.model.commons.DateRangeDto;
import com.bbva.net.back.model.movements.GlobalResumeMovementsDto;
import com.bbva.net.back.service.FiqlService;
import com.bbva.net.webservices.accounts.AccountsService;

@Facade(value = "accountMonthBalanceFacade")
public class AccountMonthBalanceFacadeImpl extends AbstractBbvaFacade implements AccountMonthBalanceFacade {

	private static final long serialVersionUID = 1L;

	@Resource(name = "accountsService")
	private AccountsService accountsService;

	@Resource(name = "fiqlService")
	private FiqlService fiqlService;

	@Value("${fiql.accountMovement.date}")
	private String DATE;

	@Override
	public List<AccountsMonthBalanceDto> getAccountMonthlyBalance(String accountId, DateRangeDto dateRange,
			String fields, String expands, String sort) {

		List<AccountsMonthBalanceDto> accountsMonthBalanceDto = new ArrayList<AccountsMonthBalanceDto>();

		String filter = dateRange == null ? StringUtils.EMPTY : fiqlService.getFiqlQueryByDateRange(dateRange, DATE,
				DATE);

		final List<MonthlyBalances> response = this.accountsService.getAccountMonthlyBalance(accountId, filter, fields,
				expands, sort);
		// accountsMonthBalanceDto.add(globalResumeMovementsMapper.map(response));

		return accountsMonthBalanceDto;
	}

}
