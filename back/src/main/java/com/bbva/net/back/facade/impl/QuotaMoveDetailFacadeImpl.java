package com.bbva.net.back.facade.impl;

import javax.annotation.Resource;

import com.bbva.czic.dto.net.RotaryQuotaMove;
import com.bbva.net.back.core.pattern.facade.AbstractBbvaFacade;
import com.bbva.net.back.core.stereotype.Facade;
import com.bbva.net.back.facade.QuotaMoveDetailFacade;
import com.bbva.net.back.mapper.QuotaMoveDetailMapper;
import com.bbva.net.back.model.quota.QuotaMoveDetailDto;
import com.bbva.net.webservices.loan.LoanService;

@Facade(value = "quotaMoveDetailFacade")
public class QuotaMoveDetailFacadeImpl extends AbstractBbvaFacade implements QuotaMoveDetailFacade {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Resource(name = "quotaMoveDetailMapper")
	private QuotaMoveDetailMapper mapper;

	// CLIENTE REST
	@Resource(name = "loanService")
	private LoanService loanService;

	// method
	public QuotaMoveDetailDto getRotaryQuotaMovement(String idLoan, String idMovement) {
		final RotaryQuotaMove response = this.loanService.getRotaryQuotaMovement(idLoan, idMovement);
		return mapper.map(response);
	}

	/**
	 * @return the mapper
	 */
	public QuotaMoveDetailMapper getMapper() {
		return mapper;
	}

	/**
	 * @param mapper the mapper to set
	 */
	public void setMapper(QuotaMoveDetailMapper mapper) {
		this.mapper = mapper;
	}

	/**
	 * @return the loanService
	 */
	public LoanService getLoanService() {
		return loanService;
	}

	/**
	 * @param loanService the loanService to set
	 */
	public void setLoanService(LoanService loanService) {
		this.loanService = loanService;
	}

}
