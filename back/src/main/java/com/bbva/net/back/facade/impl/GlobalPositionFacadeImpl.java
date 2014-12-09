package com.bbva.net.back.facade.impl;

import javax.annotation.Resource;

import org.springframework.web.client.RestClientException;

import co.com.bbva.services.transactions.globalposition.schema.GlobalProducts;

import com.bbva.net.back.core.pattern.facade.AbstractBbvaFacade;
import com.bbva.net.back.core.stereotype.Facade;
import com.bbva.net.back.facade.GlobalPositionFacade;
import com.bbva.net.webservices.globalposition.GlobalPositionService;

@Facade(value = "globalPositionFacade")
public class GlobalPositionFacadeImpl extends AbstractBbvaFacade implements GlobalPositionFacade {

	private static final long serialVersionUID = -8133045188591147282L;

	@Resource(name = "globalPositionService")
	private GlobalPositionService globalPositionService;

	@Override
	public GlobalProducts getGlobalProductsByUser(String user) throws RestClientException {
		return this.globalPositionService.get(user);
	}

	public void setGlobalPositionService(GlobalPositionService globalPositionService) {

		this.globalPositionService = globalPositionService;

	}

}
