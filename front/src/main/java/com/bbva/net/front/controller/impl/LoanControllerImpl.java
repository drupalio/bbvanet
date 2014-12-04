package com.bbva.net.front.controller.impl;

import javax.annotation.Resource;

import co.com.bbva.services.transactions.globalposition.schema.GlobalProducts;

import com.bbva.net.back.facade.LoanFacade;
import com.bbva.net.front.controller.LoanController;
import com.bbva.net.front.core.AbstractBbvaController;

public class LoanControllerImpl extends AbstractBbvaController implements
		LoanController {
	private static final long serialVersionUID = 5726824668267606699L;

	private static final String DEFAULT_USER = "123";
	// private GraphicUI graphicUI;

	private boolean stateLoans = true;

	public boolean isStateLoans() {
		return stateLoans;
	}

	public void setStateLoans(boolean stateLoans) {
		this.stateLoans = stateLoans;
	}

	@Resource(name = "loanFacade")
	private transient LoanFacade loanFacade;

	@Override
	public GlobalProducts getCustomerLoan() {

		return this.loanFacade.getLoansByUser(DEFAULT_USER);
		// this.graphicPieDelegate.convertToUI(glopalProducts)
	}

	public void setLoanFacade(final LoanFacade loanFacade) {
		this.loanFacade = loanFacade;
	}

}
