package com.bbva.net.back.facade.impl;

import java.util.List;

import javax.annotation.Resource;

import com.bbva.net.back.core.pattern.facade.AbstractBbvaFacade;
import com.bbva.net.back.core.stereotype.Facade;
import com.bbva.net.back.facade.AccountsFacade;
import com.bbva.net.back.model.globalposition.AccountDTO;
import com.bbva.net.webservices.globalposition.GlobalPositionService;

@Facade(value = "accountsFacade")
public class AccountsFacadeImpl extends AbstractBbvaFacade implements AccountsFacade {

	private static final long serialVersionUID = -7965898288210045100L;

	@Resource(name = "globalPositionService")
	private GlobalPositionService globalPositionService;

	@Override
	public List<AccountDTO> getAccountsByUser(String user) {
		return null;// this.globalPositionService.get(user).getAccounts();
	}

	public void setGlobalPositionService(GlobalPositionService globalPositionService) {
		this.globalPositionService = globalPositionService;
	}

}
