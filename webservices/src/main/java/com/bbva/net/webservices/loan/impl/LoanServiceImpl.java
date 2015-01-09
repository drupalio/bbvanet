package com.bbva.net.webservices.loan.impl;

import javax.ws.rs.core.Response;

import com.bbva.czic.dto.net.Loan;
import com.bbva.czic.dto.net.Movement;
import com.bbva.net.webservices.core.pattern.AbstractBbvaRestService;
import com.bbva.net.webservices.core.stereotype.RestService;
import com.bbva.net.webservices.loan.LoanService;

@RestService(value = "loanService")
public class LoanServiceImpl extends AbstractBbvaRestService implements LoanService {

	@Override
	public Loan getRotaryQuota(String idLoan) {
		final Loan loan = restTemplate.getForObject(URL_BASE_ROTARYQUOTA + idLoan, Loan.class);
		return loan;
	}

	@Override
	public Movement getRotaryQuotaMovement(String idMovement, String idLoan) {
		return null;
	}

	@Override
	public Response listRotaryQuotaMovements(String loanId, String $filter, String $fields, String $expands,
			String $sort) {
		return null;
	}

}
