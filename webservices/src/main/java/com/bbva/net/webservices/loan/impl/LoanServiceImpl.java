package com.bbva.net.webservices.loan.impl;

import java.util.List;

import org.apache.cxf.common.util.StringUtils;
import org.apache.cxf.jaxrs.client.WebClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.client.RestClientException;

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
		try {
			return getJsonWebClient(URL_BASE_ROTARYQUOTA + idLoan).get(Loan.class);
		} catch (Exception e) {
			throw new RestClientException(
					"Servicio no disponible - No se ha podido cargar la información de cupo rotativo, para mayor información comunicate a nuestras líneas BBVA");
		}
	}

	@Override
	public RotaryQuotaMove getRotaryQuotaMovement(String idLoan, String idMovement) {
		try {
			return getJsonWebClient(URL_BASE_ROTARYQUOTA + idLoan + URL_ROTARYQUOTA_MOVE + idMovement).get(
					RotaryQuotaMove.class);
		} catch (Exception e) {
			throw new RestClientException(
					"Servicio no disponible - No se ha podido cargar la información del movimiento seleccionado, para mayor información comunicate a nuestras líneas BBVA");
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Movement> listRotaryQuotaMovements(String loanId, String paginationKey, Integer pageSize, String $filter) {
		try {
			WebClient wc = getJsonWebClient(URL_BASE_ROTARYQUOTA + loanId + URL_ROTARYQUOTA_MOVES);
			if (!StringUtils.isEmpty($filter)) wc.query(FILTER, $filter);
			if (paginationKey != null && pageSize != null) {
				wc.query("paginationKey", paginationKey);
				wc.query("pageSize", pageSize);
			}
			return (List<Movement>)wc.getCollection(Movement.class);
		} catch (Exception e) {
			throw new RestClientException(
					"Servicio no disponible - No se ha podido cargar la lista de movimientos, para mayor información comunicate a nuestras líneas BBVA");
		}
	}
}
