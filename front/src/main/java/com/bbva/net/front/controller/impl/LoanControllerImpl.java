package com.bbva.net.front.controller.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.primefaces.event.SelectEvent;

import com.bbva.net.back.facade.LoanFacade;
import com.bbva.net.back.model.globalposition.BalanceDto;
import com.bbva.net.back.model.globalposition.GlobalProductsDto;
import com.bbva.net.back.model.globalposition.LeasingDto;
import com.bbva.net.back.model.globalposition.LoanDto;
import com.bbva.net.back.model.globalposition.RotatingAccountDto;
import com.bbva.net.front.controller.LoanController;
import com.bbva.net.front.core.AbstractBbvaController;

/**
 * @author Entelgy
 */
public class LoanControllerImpl extends AbstractBbvaController implements LoanController {

	private static final long serialVersionUID = 5726824668267606699L;

	@Resource(name = "loanFacade")
	private transient LoanFacade loanFacade;

	private Map<String, BalanceDto> totalsProducts;

	private GlobalProductsDto globalProductsDto;

	public void init() {

		this.globalProductsDto = this.loanFacade.getLoanProducts();
		this.totalsProducts = this.loanFacade.getLoanTotals(globalProductsDto);
	}

	@Override
	public List<RotatingAccountDto> getCustomerRotatingAccount() {
		return this.loanFacade.getRotatingAccountByUser(globalProductsDto);
	}

	@Override
	public List<RotatingAccountDto> getCustomerRotatingAccountHidden() {
		return this.loanFacade.getRotatingAccountByUserHidden(globalProductsDto);
	}

	@Override
	public List<LeasingDto> getCustomerLeasing() {
		return this.loanFacade.getLeasingByUser(globalProductsDto);
	}

	@Override
	public List<LeasingDto> getCustomerLeasingHidden() {
		return this.loanFacade.getLeasingByUserHidden(globalProductsDto);
	}

	@Override
	public List<LoanDto> getCustomerLoan() {
		return this.loanFacade.getLoansByUser(globalProductsDto);
	}

	@Override
	public List<LoanDto> getCustomerLoanHidden() {
		return this.loanFacade.getLoansByUserHidden(globalProductsDto);
	}

	@Override
	public void onProductLoanSelected(SelectEvent selectEvent) {
		super.onProductSelected(selectEvent);
		this.sendAction("quotaSelected");

	}

	/********************************* SETTERS BEANS ************************************/

	public void setLoanFacade(final LoanFacade loanFacade) {
		this.loanFacade = loanFacade;
	}

	public Map<String, BalanceDto> getTotalsProducts() {
		return totalsProducts;
	}

	public void setTotalsProducts(Map<String, BalanceDto> totalsProducts) {
		this.totalsProducts = totalsProducts;
	}

	/**
	 * @return the globalProductsDto
	 */
	public GlobalProductsDto getGlobalProductsDto() {
		return globalProductsDto;
	}

	/**
	 * @param globalProductsDto the globalProductsDto to set
	 */
	public void setGlobalProductsDto(GlobalProductsDto globalProductsDto) {
		this.globalProductsDto = globalProductsDto;
	}

}
