package com.bbva.net.webservices.accounts.impl;

import java.util.List;

import org.apache.cxf.common.util.StringUtils;
import org.apache.cxf.jaxrs.client.WebClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.client.RestClientException;

import com.bbva.czic.dto.net.AccMovementsResume;
import com.bbva.czic.dto.net.Account;
import com.bbva.czic.dto.net.Check;
import com.bbva.czic.dto.net.Checkbook;
import com.bbva.czic.dto.net.MonthlyBalances;
import com.bbva.net.webservices.accounts.AccountsService;
import com.bbva.net.webservices.core.pattern.AbstractBbvaRestService;
import com.bbva.net.webservices.core.stereotype.RestService;

@RestService(value = "accountsService")
public class AccountsServiceImpl extends AbstractBbvaRestService implements AccountsService {

	@Value("${fiql.filter.parameter}")
	private String FILTER;

	@Value("${rest.checkBooks.url}")
	private String URL_CHECKBOOK;

	@Value("${rest.check.url}")
	protected String URL_CHECK;

	@Override
	public Account getAccount(String accountId) {
		try {
			WebClient wc = getJsonWebClient(URL_BASE_ACCOUNTS + accountId);
			return wc.get(Account.class);
		} catch (Exception e) {
			throw new RestClientException(
					"Servicio no disponible - No se han podido cargar la información de chequeras, para mayor información comunicate a nuestras líneas BBVA");
		}
	}

	@Override
	public Check getCheck(String accountId, String checkId) {
		try {
			WebClient wc = getJsonWebClient(URL_BASE_ACCOUNTS + accountId + URL_CHECK + checkId);
			return wc.get(Check.class);
		} catch (Exception e) {
			throw new RestClientException(
					"NO EXISTEN DATOS A LISTAR");
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Checkbook> getCheckbook(String accountId, String checkbookId) {
		try {
			WebClient wc = getJsonWebClient(URL_BASE_ACCOUNTS + accountId + URL_CHECKBOOK + checkbookId);
			if (accountId != null && checkbookId != null) {
				wc.query("checkbookId", checkbookId);
				wc.query("accountId", accountId);
			}
			return (List<Checkbook>)wc.getCollection(Checkbook.class);
		} catch (Exception e) {
			throw new RestClientException(
					"NO EXISTEN DATOS A LISTAR");
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Check> listCheck(String accountId, String filter, Integer paginationKey, Integer pageSize) {
		try {
			WebClient wc = getJsonWebClient(URL_BASE_ACCOUNTS + accountId + URL_CHECK_LIST);
			if (!StringUtils.isEmpty(filter)) wc.query(FILTER, filter);

			if (paginationKey != null && pageSize != null) {
				wc.query("paginationKey", paginationKey);
				wc.query("pageSize", pageSize);
			}
			return (List<Check>)wc.getCollection(Check.class);
		} catch (Exception e) {
			throw new RestClientException(
					"NO EXISTEN DATOS A LISTAR");
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<MonthlyBalances> getAccountMonthlyBalance(String accountId, String filter, String fields,
			String expands, String sort) {
		try {
			WebClient wc = getJsonWebClient(URL_BASE_ACCOUNTS + accountId + URL_MOUNTHBALANCE);
			if (!StringUtils.isEmpty(filter)) wc.query(FILTER, filter);
			return (List<MonthlyBalances>)wc.getCollection(MonthlyBalances.class);
		} catch (Exception e) {
			throw new RestClientException(
					"Servicio no disponible - No se han podido cargar la información para la gráfica de depositos Electrónicos, para mayor información comunicate a nuestras líneas BBVA");
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<AccMovementsResume> getAccMovementResume(String id, String filter, String $fields, String $expands,
			String $sort) {
		try {
			WebClient wc = getJsonWebClient(URL_BASE_ACCOUNTS + id + URL_ACCOUNTS);
			if (!StringUtils.isEmpty(filter)) wc.query(FILTER, filter);
			return (List<AccMovementsResume>)wc.getCollection(AccMovementsResume.class);
		} catch (Exception e) {
			throw new RestClientException(
					"Servicio no disponible - No se han podido cargar la información para la gráfica de cuentas, para mayor información comunicate a nuestras líneas BBVA");
		}
	}
}
