package com.bbva.net.webservices.accounts.impl;

import java.util.List;

import org.apache.cxf.common.util.StringUtils;
import org.apache.cxf.jaxrs.client.WebClient;
import org.springframework.beans.factory.annotation.Value;

import com.bbva.czic.dto.net.AccMovementsResume;
import com.bbva.czic.dto.net.Account;
import com.bbva.czic.dto.net.Check;
import com.bbva.czic.dto.net.Checkbook;
import com.bbva.czic.dto.net.MonthlyBalances;
import com.bbva.net.webservices.accounts.AccountsService;
import com.bbva.net.webservices.core.pattern.AbstractBbvaRestService;
import com.bbva.net.webservices.core.stereotype.RestService;
import com.google.gson.Gson;

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
		WebClient wc = getJsonWebClient(URL_BASE_ACCOUNTS + accountId);
		return wc.get(Account.class);
	}

	@Override
	public Check getCheck(String accountId, String checkId) {
		WebClient wc = getJsonWebClient(URL_BASE_ACCOUNTS + accountId + URL_CHECK + checkId);
		if (accountId != null && checkId != null) {
			wc.query("checkbookId", checkId);
			wc.query("accountId", accountId);
		}
		return wc.get(Check.class);
	}

	@Override
	public Checkbook getCheckbook(String accountId, String checkbookId) {
		WebClient wc = getJsonWebClient(URL_BASE_ACCOUNTS + accountId + URL_CHECKBOOK + checkbookId);

		if (accountId != null && checkbookId != null) {
			wc.query("checkbookId", checkbookId);
			wc.query("accountId", accountId);
		}
		return wc.get(Checkbook.class);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Check> listCheck(String accountId, String filter, Integer paginationKey, Integer pageSize) {

		WebClient wc = getJsonWebClient(URL_BASE_ACCOUNTS + accountId + URL_CHECK_LIST);
		if (!StringUtils.isEmpty(filter)) wc.query(FILTER, filter);

		if (paginationKey != null && pageSize != null) {
			wc.query("paginationKey", paginationKey);
			wc.query("pageSize", pageSize);
		}

		return (List<Check>)wc.getCollection(Check.class);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<MonthlyBalances> getAccountMonthlyBalance(String accountId, String filter, String fields,
			String expands, String sort) {
		WebClient wc = getJsonWebClient(URL_BASE_ACCOUNTS + accountId + URL_MOUNTHBALANCE);

		LOGGER.info("PETICION: " + wc.getCurrentURI());
		if (!StringUtils.isEmpty(filter)) wc.query(FILTER, filter);
		if (!StringUtils.isEmpty(fields)) wc.query(FILTER, fields);

		List<MonthlyBalances> result = (List<MonthlyBalances>)wc.getCollection(MonthlyBalances.class);

		final Gson gson = new Gson();
		String json = gson.toJson(result);
		LOGGER.info("JSON ACCOUNT MONTHLY BALANCE: " + json);

		return result;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<AccMovementsResume> getAccMovementResume(String id, String filter, String $fields, String $expands,
			String $sort) {
		WebClient wc = getJsonWebClient(URL_BASE_ACCOUNTS + id + URL_ACCOUNTS);
		if (!StringUtils.isEmpty(filter)) wc.query("$filter", filter);
		return (List<AccMovementsResume>)wc.getCollection(AccMovementsResume.class);
	}

}
