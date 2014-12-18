package com.bbva.net.front.controller.impl;

import java.util.List;

import javax.annotation.Resource;

import com.bbva.net.back.facade.LoanFacade;
import com.bbva.net.back.model.globalposition.LeasingDTO;
import com.bbva.net.back.model.globalposition.RotatingAccountDTO;
import com.bbva.net.front.controller.LoanController;
import com.bbva.net.front.core.AbstractBbvaController;

public class LoanControllerImpl extends AbstractBbvaController implements LoanController {

	private static final long serialVersionUID = 5726824668267606699L;

	private boolean stateLoans = true;

	public boolean isStateLoans() {
		return stateLoans;
	}

	public void setStateLoans(boolean stateLoans) {
		this.stateLoans = stateLoans;
	}

	@Resource(name = "loanFacade")
	private transient LoanFacade loanFacade;

	public void setLoanFacade(final LoanFacade loanFacade) {
		this.loanFacade = loanFacade;
	}

	@Override
	public List<RotatingAccountDTO> getCustomerRotatingAccount() {
		return this.loanFacade.getRotatingAccountByUser(getCurrentUser());
	}

	@Override
	public List<LeasingDTO> getCustomerLeasing() {
		return this.loanFacade.getLeasingByUser(getCurrentUser());
	}

}
