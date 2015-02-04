package com.bbva.net.webservices.loan.impl;

import javax.ws.rs.core.Response;

import com.bbva.czic.dto.net.Loan;
import com.bbva.czic.dto.net.RotaryQuotaMove;
import com.bbva.net.webservices.core.pattern.AbstractBbvaRestService;
import com.bbva.net.webservices.core.stereotype.RestService;
import com.bbva.net.webservices.loan.LoanService;

@RestService(value = "loanService")
public class LoanServiceImpl extends AbstractBbvaRestService implements LoanService {

	@Override
	public Loan getRotaryQuota(String idLoan) {
		final Loan loan = getJsonWebClient(URL_BASE_ROTARYQUOTA + idLoan).get(Loan.class);
		return loan;
	}

	@Override
	public RotaryQuotaMove getRotaryQuotaMovement(String idLoan, String idMovement) {
		final RotaryQuotaMove rotaryQuotaMove = getJsonWebClient(
				URL_BASE_ROTARYQUOTA + idLoan + URL_ROTARYQUOTA_MOVE + idMovement).get(RotaryQuotaMove.class);
		return rotaryQuotaMove;
	}

	@Override
	public Response listRotaryQuotaMovements(String loanId, String paginationKey, String pageSize, String $filter) {

		return null;
	}

}
