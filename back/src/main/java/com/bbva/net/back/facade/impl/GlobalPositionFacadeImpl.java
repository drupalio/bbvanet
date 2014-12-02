package com.bbva.net.back.facade.impl;

import javax.annotation.Resource;

import co.com.bbva.services.transactions.globalposition.schema.GlobalProducts;

import com.bbva.net.back.core.stereotype.Facade;
import com.bbva.net.back.facade.GlobalPositionFacade;
import com.bbva.net.webservices.globalposition.GlobalPositionService;

@Facade(value = "globalPositionFacade")
public class GlobalPositionFacadeImpl implements GlobalPositionFacade {

	@Resource(name = "globalPositionService")
	private GlobalPositionService globalPositionService;
	
	@Override
	public GlobalProducts getGlobalProductsByUser(String user){
		return this.globalPositionService.get(user);
	}

	public void setGlobalPositionService(GlobalPositionService globalPositionService) {

		this.globalPositionService = globalPositionService;
		
	}


}
