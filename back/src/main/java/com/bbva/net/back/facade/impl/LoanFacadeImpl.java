package com.bbva.net.back.facade.impl;

import java.util.List;

import javax.annotation.Resource;

import co.com.bbva.services.transactions.globalposition.schema.GlobalProducts;
import co.com.bbva.services.transactions.globalposition.schema.Leasing;
import co.com.bbva.services.transactions.globalposition.schema.RotatingAccount;

import com.bbva.net.back.core.pattern.facade.AbstractBbvaFacade;
import com.bbva.net.back.core.stereotype.Facade;
import com.bbva.net.back.facade.LoanFacade;
import com.bbva.net.webservices.globalposition.GlobalPositionService;

@Facade(value = "loanFacade")
public class LoanFacadeImpl extends AbstractBbvaFacade implements LoanFacade {

	private static final long serialVersionUID = -6967081195758241814L;

	@Resource(name = "globalPositionService")
	private GlobalPositionService globalPositionService;

	@Override
	public List<Leasing> getLeasingByUser(String defaultUser) {
		return this.globalPositionService.get(defaultUser).getLeasings();

	}

	@Override
	public List<RotatingAccount> getRotatingAccountByUser(String defaultUser) {
		return this.globalPositionService.get(defaultUser).getRotatingAccounts();
	}

	@Override
	public GlobalProducts getLoansByUser(String defaultUser) {
		return this.globalPositionService.get(defaultUser);
	}

	public void setGlobalPositionService(GlobalPositionService globalPositionService) {
		this.globalPositionService = globalPositionService;
	}

}
