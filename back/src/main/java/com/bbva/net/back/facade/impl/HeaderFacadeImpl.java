package com.bbva.net.back.facade.impl;

import javax.annotation.Resource;

import com.bbva.czic.dto.net.Customer;
import com.bbva.czic.dto.net.Executive;
import com.bbva.net.back.core.pattern.facade.AbstractBbvaFacade;
import com.bbva.net.back.core.stereotype.Facade;
import com.bbva.net.back.facade.HeaderFacade;
import com.bbva.net.back.mapper.CustomerMapper;
import com.bbva.net.back.mapper.ExecutiveMapper;
import com.bbva.net.back.model.header.CustomerDto;
import com.bbva.net.back.model.header.ExecutiveDto;
import com.bbva.net.back.service.FiqlService;
import com.bbva.net.webservices.customers.CustomerService;
import com.bbva.net.webservices.executives.ExecutiveService;

@Facade(value = "headerFacade")
public class HeaderFacadeImpl extends AbstractBbvaFacade implements HeaderFacade {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2451180024940294464L;

	@Resource(name = "executiveService")
	private ExecutiveService executiveService;

	@Resource(name = "customerService")
	private CustomerService customerService;

	@Resource(name = "executiveMapper")
	private ExecutiveMapper mapper;

	@Resource(name = "customerMapper")
	private CustomerMapper mapperCustomer;

	@Resource(name = "fiqlService")
	private FiqlService fiqlService;

	@Override
	public ExecutiveDto getExecutive(String user) {
		final String filter = fiqlService.getExecutiveFiql(user);
		final Executive executive = this.executiveService.getExecutive(filter, null, null, null);
		return mapper.map(executive);
	}

	public void setExecutiveService(ExecutiveService executiveService) {
		this.executiveService = executiveService;
	}

	@Override
	public CustomerDto getCustomer(String userName, String docTypeUser, String docIdUser) {
		final String filter = fiqlService.getFiqlQueryCustomer(userName, docTypeUser, docIdUser);
		final Customer customer = this.customerService.getCustomer(filter);
		return mapperCustomer.map(customer);
	}
}
