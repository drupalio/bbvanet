package com.bbva.net.webservices.loan.impl;

import com.bbva.czic.dto.net.Loan;
import com.bbva.net.webservices.core.pattern.AbstractBbvaRestService;
import com.bbva.net.webservices.core.stereotype.RestService;
import com.bbva.net.webservices.loan.LoanService;

@RestService(value = "loanService")
public class LoanServiceImpl extends AbstractBbvaRestService implements
		LoanService {

	@Override
	public Loan getRotaryQuota(String idLoan) {
		final Loan loan = restTemplate.getForObject(URL_BASE_ROTARYQUOTA
				+ idLoan, Loan.class);
		return loan;
	}

}
