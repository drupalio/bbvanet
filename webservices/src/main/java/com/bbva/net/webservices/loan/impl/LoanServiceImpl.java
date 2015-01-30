package com.bbva.net.webservices.loan.impl;

import javax.ws.rs.core.Response;

import com.bbva.czic.dto.net.Loan;
import com.bbva.net.webservices.core.pattern.AbstractBbvaRestService;
import com.bbva.net.webservices.core.stereotype.RestService;
import com.bbva.net.webservices.loan.LoanService;

@RestService(value = "loanService")
public class LoanServiceImpl extends AbstractBbvaRestService
		implements
			LoanService {

	@Override
	public Loan getRotaryQuota(String idLoan) {
		final Loan loan = getJsonWebClient(URL_BASE_ROTARYQUOTA + idLoan).get(Loan.class);
		return loan;
	}

	@Override
	public Response getRotaryQuotaMovement(String idLoan, String idMovement) {

		return null;
	}

	@Override
	public Response listRotaryQuotaMovements(String loanId,
			String paginationKey, String pageSize, String $filter) {

		return null;
	}

}
