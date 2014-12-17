package com.bbva.net.back.facade.impl;

import java.util.List;

import javax.annotation.Resource;

import com.bbva.net.back.core.pattern.facade.AbstractBbvaFacade;
import com.bbva.net.back.core.stereotype.Facade;
import com.bbva.net.back.facade.LoanFacade;
import com.bbva.net.back.model.globalposition.GlobalProductsDTO;
import com.bbva.net.back.model.globalposition.LeasingDTO;
import com.bbva.net.back.model.globalposition.RotatingAccountDTO;
import com.bbva.net.webservices.globalposition.GlobalPositionService;

@Facade(value = "loanFacade")
public class LoanFacadeImpl extends AbstractBbvaFacade implements LoanFacade {

	private static final long serialVersionUID = -6967081195758241814L;

	@Resource(name = "globalPositionService")
	private GlobalPositionService globalPositionService;

	@Override
	public List<LeasingDTO> getLeasingByUser(String defaultUser) {
		return null;// this.globalPositionService.get(defaultUser).getLeasings();

	}

	@Override
	public List<RotatingAccountDTO> getRotatingAccountByUser(String defaultUser) {
		return null;// this.globalPositionService.get(defaultUser).getRotatingAccounts();
	}

	@Override
	public GlobalProductsDTO getLoansByUser(String defaultUser) {
		return null;// this.globalPositionService.get(defaultUser);
	}

	public void setGlobalPositionService(GlobalPositionService globalPositionService) {
		this.globalPositionService = globalPositionService;
	}

}
