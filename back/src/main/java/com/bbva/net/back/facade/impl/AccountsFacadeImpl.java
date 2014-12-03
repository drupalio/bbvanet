package com.bbva.net.back.facade.impl;

import javax.annotation.Resource;

import co.com.bbva.services.transactions.globalposition.schema.GlobalProducts;

import com.bbva.net.back.core.stereotype.Facade;
import com.bbva.net.back.facade.AccountsFacade;
import com.bbva.net.back.facade.GlobalPositionFacade;
import com.bbva.net.webservices.globalposition.GlobalPositionService;

@Facade(value = "accountsFacade")
public class AccountsFacadeImpl implements AccountsFacade {

	@Resource(name = "globalPositionService")
	private GlobalPositionService globalPositionService;
	

	public void setGlobalPositionService(GlobalPositionService globalPositionService) {

		this.globalPositionService = globalPositionService;
		
	}

	@Override
	public GlobalProducts getAccountsByUser(String user) {
		return this.globalPositionService.get(user);
	}


}
