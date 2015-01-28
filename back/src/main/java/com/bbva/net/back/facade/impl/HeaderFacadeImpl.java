package com.bbva.net.back.facade.impl;

import javax.annotation.Resource;

import com.bbva.czic.dto.net.Executive;
import com.bbva.net.back.core.pattern.facade.AbstractBbvaFacade;
import com.bbva.net.back.core.stereotype.Facade;
import com.bbva.net.back.facade.HeaderFacade;
import com.bbva.net.back.mapper.ExecutiveMapper;
import com.bbva.net.back.model.executive.ExecutiveDto;
import com.bbva.net.back.service.FiqlService;
import com.bbva.net.webservices.executives.ExecutiveService;

@Facade(value = "headerFacade")
public class HeaderFacadeImpl extends AbstractBbvaFacade implements HeaderFacade {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2451180024940294464L;

	@Resource(name = "executiveService")
	private ExecutiveService executiveService;

	@Resource(name = "executiveMapper")
	private ExecutiveMapper mapper;

	@Resource(name = "fiqlService")
	private FiqlService fiqlService;

	@Override
	public ExecutiveDto getExecutive(String user) {

		final String filter = fiqlService.getCustomerFiql(user);
		final Executive executive = this.executiveService.getExecutive(filter, null, null, null);
		return mapper.map(executive);
	}

	public void setExecutiveService(ExecutiveService executiveService) {
		this.executiveService = executiveService;
	}

}
