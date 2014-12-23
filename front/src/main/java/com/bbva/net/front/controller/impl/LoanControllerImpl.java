package com.bbva.net.front.controller.impl;

import java.util.List;

import javax.annotation.Resource;

import com.bbva.net.back.facade.LoanFacade;
import com.bbva.net.back.model.globalposition.LeasingDTO;
import com.bbva.net.back.model.globalposition.LoanDTO;
import com.bbva.net.back.model.globalposition.RotatingAccountDTO;
import com.bbva.net.front.controller.LoanController;
import com.bbva.net.front.core.AbstractBbvaController;

/**
 * @author Entelgy
 */
public class LoanControllerImpl extends AbstractBbvaController implements LoanController {

	private static final long serialVersionUID = 5726824668267606699L;

	@Resource(name = "loanFacade")
	private transient LoanFacade loanFacade;

	@Override
	public List<RotatingAccountDTO> getCustomerRotatingAccount() {
		return this.loanFacade.getRotatingAccountByUser(getCurrentUser());
	}

	@Override
	public List<RotatingAccountDTO> getCustomerRotatingAccountHidden() {
		return this.loanFacade.getRotatingAccountByUserHidden(getCurrentUser());
	}

	@Override
	public List<LeasingDTO> getCustomerLeasing() {
		return this.loanFacade.getLeasingByUser(getCurrentUser());
	}

	@Override
	public List<LeasingDTO> getCustomerLeasingHidden() {
		return this.loanFacade.getLeasingByUserHidden(getCurrentUser());
	}

	@Override
	public List<LoanDTO> getCustomerLoan() {
		return this.loanFacade.getLoansByUser(getCurrentUser());
	}

	@Override
	public List<LoanDTO> getCustomerLoanHidden() {
		return this.loanFacade.getLoansByUserHidden(getCurrentUser());
	}

	/********************************* SETTERS BEANS ************************************/

	public void setLoanFacade(final LoanFacade loanFacade) {
		this.loanFacade = loanFacade;
	}

}
