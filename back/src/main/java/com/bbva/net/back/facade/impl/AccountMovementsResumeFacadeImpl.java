package com.bbva.net.back.facade.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.client.RestClientException;

import com.bbva.czic.dto.net.AccMovementsResume;
import com.bbva.czic.dto.net.Check;
import com.bbva.net.back.core.pattern.facade.AbstractBbvaFacade;
import com.bbva.net.back.core.stereotype.Facade;
import com.bbva.net.back.facade.AccountMovementsResumeFacade;
import com.bbva.net.back.mapper.CheckBookMapper;
import com.bbva.net.back.mapper.GlobalResumeMovementsMapper;
import com.bbva.net.back.model.checkbook.CheckDto;
import com.bbva.net.back.model.commons.DateRangeDto;
import com.bbva.net.back.model.movements.GlobalResumeMovementsDto;
import com.bbva.net.back.service.FiqlService;
import com.bbva.net.webservices.accounts.AccountsService;
import com.bbva.net.webservices.customers.CustomerService;

/**
 * Clase que implementa cliente REST para resumen de movimientos en las cuentas
 * 
 * @author Entelgy
 */
@Facade(value = "accountMovementsFacade")
public class AccountMovementsResumeFacadeImpl extends AbstractBbvaFacade implements AccountMovementsResumeFacade {

	private static final long serialVersionUID = 1L;

	// CLIENTE REST
	@Resource(name = "customerService")
	private CustomerService customerService;

	@Resource(name = "accountsService")
	private AccountsService accountsService;

	@Resource(name = "globalResumeMovementsMapper")
	private GlobalResumeMovementsMapper globalResumeMovementsMapper;

	@Resource(name = "checkBookMapper")
	private CheckBookMapper checkBookMapper;
	
	@Resource(name = "fiqlService")
	private FiqlService fiqlService;

	@Value("${fiql.accountMovement.date}")
	private String DATE;

	/**
	 * Método que implementa el cliente REST para obtener el resumend de movimientos en las cuentas de un usuario
	 */
	@Override
	public GlobalResumeMovementsDto getMovementsResumeByCustomer(final String customerId, final DateRangeDto dateRange)
			throws RestClientException {
		GlobalResumeMovementsDto globalMovements = new GlobalResumeMovementsDto();

		String filter = dateRange == null ? StringUtils.EMPTY : fiqlService.getFiqlQueryByDateRange(dateRange, DATE,
				DATE);

		final List<AccMovementsResume> response = this.customerService.listAccountsMovementsResume(customerId, filter);
		globalMovements.setMovementsResumeDto(globalResumeMovementsMapper.map(response));

		return globalMovements;

	}

	@Override
	public GlobalResumeMovementsDto getMovementsResumeByAccount(String accountId, DateRangeDto dateRange,
			String fields, String expands, String sort) {

		GlobalResumeMovementsDto globalMovements = new GlobalResumeMovementsDto();

		String filter = dateRange == null ? StringUtils.EMPTY : fiqlService.getFiqlQueryByDateRange(dateRange, DATE,
				DATE);

		final List<AccMovementsResume> response = this.accountsService.getAccMovementResume(accountId, filter, fields,
				expands, sort);
		globalMovements.setMovementsResumeDto(globalResumeMovementsMapper.map(response));

		return globalMovements;
	}

	@Override
	public List<CheckDto> getChecksByAccount(String accountId, DateRangeDto dateRange, String status, String paginationKey, String pageSize) {
		List<CheckDto> checkList= new ArrayList<CheckDto>();
		String filter = dateRange == null ? StringUtils.EMPTY : fiqlService.getFiqlQueryByDateRange(dateRange, DATE,
				DATE);
		
		final List<Check> response = this.accountsService.listCheck(accountId, filter, status, paginationKey, pageSize);
		
		checkList = checkBookMapper.mapCheck(response);
		return checkList;
	}

	/********************************** DEPENDENCY INJECTIONS ***********************************/
	public void setCustomerService(final CustomerService customerService) {
		this.customerService = customerService;
	}

	public void setAccountsService(AccountsService accountsService) {
		this.accountsService = accountsService;
	}

}
