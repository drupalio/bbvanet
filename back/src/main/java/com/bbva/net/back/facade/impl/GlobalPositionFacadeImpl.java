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

	@Override
	public GlobalProducts getGlobalProductsByUserVisible(String defaultUser, boolean b) {

		/*
		 * globalProducts.setAccounts((List) CollectionUtils.select(globalProducts.getAccounts(), predicate));
		 * globalProducts.setCreditCards((List) CollectionUtils.select(globalProducts.getCreditCards(), predicate));
		 * globalProducts.setElectronicDeposits((List) CollectionUtils.select(globalProducts.getElectronicDeposits(),
		 * predicate)); globalProducts.setFunds((List) CollectionUtils.select(globalProducts.getFunds(), predicate));
		 * globalProducts.setLeasings((List) CollectionUtils.select(globalProducts.getLeasings(), predicate));
		 * globalProducts.setRotatingAccounts((List) CollectionUtils.select(globalProducts.getRotatingAccounts(),
		 * predicate));
		 */
		return this.globalPositionService.get(defaultUser);
	}

}
