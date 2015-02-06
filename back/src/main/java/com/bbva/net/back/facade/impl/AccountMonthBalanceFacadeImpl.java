package com.bbva.net.back.facade.impl;

import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Value;

import com.bbva.czic.dto.net.MonthlyBalances;
import com.bbva.net.back.core.pattern.facade.AbstractBbvaFacade;
import com.bbva.net.back.core.stereotype.Facade;
import com.bbva.net.back.facade.AccountMonthBalanceFacade;
import com.bbva.net.back.mapper.MonthlyBalanceMapper;
import com.bbva.net.back.model.accounts.GlobalMonthlyBalanceDto;
import com.bbva.net.back.model.commons.DateRangeDto;
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

	@Resource(name = "monthlyBalanceMapper")
	private MonthlyBalanceMapper monthlyBalanceMapper;

	@Override
	public GlobalMonthlyBalanceDto getAccountMonthlyBalance(String accountId, DateRangeDto dateRange, String fields,
			String expands, String sort) {

		GlobalMonthlyBalanceDto globalMonthlyBalance = new GlobalMonthlyBalanceDto();

		String filter = dateRange == null ? StringUtils.EMPTY : fiqlService.getFiqlQueryByDateRange(dateRange, DATE,
				DATE);

		final List<MonthlyBalances> response = this.accountsService.getAccountMonthlyBalance(accountId, filter, fields,
				expands, sort);

		globalMonthlyBalance.setMonthlyBalanceList(monthlyBalanceMapper.map(response));

		return globalMonthlyBalance;
	}

}
