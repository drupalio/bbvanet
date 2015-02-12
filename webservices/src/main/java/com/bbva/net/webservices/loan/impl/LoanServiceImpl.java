package com.bbva.net.webservices.loan.impl;

import java.util.List;

import org.apache.cxf.common.util.StringUtils;
import org.apache.cxf.jaxrs.client.WebClient;
import org.springframework.beans.factory.annotation.Value;

import com.bbva.czic.dto.net.Loan;
import com.bbva.czic.dto.net.Movement;
import com.bbva.czic.dto.net.RotaryQuotaMove;
import com.bbva.net.webservices.core.pattern.AbstractBbvaRestService;
import com.bbva.net.webservices.core.stereotype.RestService;
import com.bbva.net.webservices.loan.LoanService;

@RestService(value = "loanService")
public class LoanServiceImpl extends AbstractBbvaRestService implements LoanService {

	@Value("${fiql.filter.parameter}")
	private String FILTER;

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

	@SuppressWarnings("unchecked")
	@Override
	public List<Movement> listRotaryQuotaMovements(String loanId, Integer paginationKey, Integer pageSize,
			String $filter) {

		WebClient wc = getJsonWebClient(URL_BASE_ROTARYQUOTA + loanId + URL_ROTARYQUOTA_MOVE);
		if (!StringUtils.isEmpty($filter)) wc.query(FILTER, $filter);

		if (paginationKey != null && pageSize != null) {
			wc.query("paginationKey", paginationKey);
			wc.query("pageSize", pageSize);
		}

		return (List<Movement>)wc.getCollection(Movement.class);
	}
}
