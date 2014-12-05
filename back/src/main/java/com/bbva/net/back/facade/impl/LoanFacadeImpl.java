package com.bbva.net.back.facade.impl;

import java.util.List;

import javax.annotation.Resource;

import co.com.bbva.services.transactions.globalposition.schema.GlobalProducts;
import co.com.bbva.services.transactions.globalposition.schema.Leasing;
import co.com.bbva.services.transactions.globalposition.schema.RotatingAccount;

import com.bbva.net.back.core.stereotype.Facade;
import com.bbva.net.back.facade.LoanFacade;
import com.bbva.net.webservices.globalposition.GlobalPositionService;

@Facade(value = "loanFacade")
public class LoanFacadeImpl implements LoanFacade {

	@Resource(name = "globalPositionService")
	private GlobalPositionService globalPositionService;

	public void setGlobalPositionService(
			GlobalPositionService globalPositionService) {

		this.globalPositionService = globalPositionService;

	}

	@Override
	public List<Leasing> getLeasingByUser(String defaultUser) {
		return this.globalPositionService.get(defaultUser).getLeasings();

	}

	@Override
	public List<RotatingAccount> getRotatingAccountByUser(String defaultUser) {
		return this.globalPositionService.get(defaultUser)
				.getRotatingAccounts();
	}

	@Override
	public GlobalProducts getLoansByUser(String defaultUser) {
		return this.globalPositionService.get(defaultUser);
	}

}
