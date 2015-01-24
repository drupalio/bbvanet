package com.bbva.net.back.facade.impl;

import javax.annotation.Resource;

import com.bbva.czic.dto.net.Loan;
import com.bbva.net.back.core.pattern.facade.AbstractBbvaFacade;
import com.bbva.net.back.core.stereotype.Facade;
import com.bbva.net.back.facade.QuotaDetailFacade;
import com.bbva.net.back.mapper.QuotaDetailMapper;
import com.bbva.net.back.model.quota.QuotaDetailDto;
import com.bbva.net.webservices.loan.LoanService;

@Facade(value = "quotaDetailFacade")
public class QuotaDetailFacadeImpl extends AbstractBbvaFacade
		implements
			QuotaDetailFacade {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Resource(name = "quotaDetailMapper")
	private QuotaDetailMapper mapper;

	// CLIENTE REST
	@Resource(name = "loanService")
	private LoanService loanService;

	// method

	public QuotaDetailDto getDetailRotaryQuota(String idLoan) {
		final Loan response = this.loanService.getRotaryQuota(idLoan);
		return mapper.map(response);
	}

	public void setMapper(QuotaDetailMapper mapper) {
		this.mapper = mapper;
	}

	public void setLoanService(LoanService loanService) {
		this.loanService = loanService;
	}
}
