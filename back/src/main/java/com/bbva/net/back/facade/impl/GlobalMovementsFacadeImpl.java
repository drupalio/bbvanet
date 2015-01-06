package com.bbva.net.back.facade.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.web.client.RestClientException;

import com.bbva.czic.dto.net.AccMovementsResume;
import com.bbva.net.back.core.pattern.facade.AbstractBbvaFacade;
import com.bbva.net.back.core.stereotype.Facade;
import com.bbva.net.back.facade.GlobalMovementsFacade;
import com.bbva.net.back.mapper.GlobalResumeMovementsMapper;
import com.bbva.net.back.model.movements.GlobalResumeMovementsDto;
import com.bbva.net.webservices.customers.CustomerService;

@Facade(value = "globalMovementsFacade")
public class GlobalMovementsFacadeImpl extends AbstractBbvaFacade implements GlobalMovementsFacade {

	private static final long serialVersionUID = 1L;

	// CLIENTE REST
	@Resource(name = "customerService")
	private CustomerService customerService;

	@Resource(name = "globalResumeMovementsMapper")
	private GlobalResumeMovementsMapper globalResumeMovementsMapper;

	@Override
	public GlobalResumeMovementsDto getGlobalMovementsByCustomer(final String customerId) throws RestClientException {

		final List<AccMovementsResume> response = this.customerService.listAccountsMovementsResume(customerId);
		return globalResumeMovementsMapper.map(response);
	}

	/********************************** DEPENDENCY INJECTIONS ***********************************/
	public void setCustomerService(final CustomerService customerService) {
		this.customerService = customerService;
	}

}
