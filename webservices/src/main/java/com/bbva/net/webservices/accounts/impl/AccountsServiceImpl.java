package com.bbva.net.webservices.accounts.impl;

import java.util.List;

import org.apache.cxf.common.util.StringUtils;
import org.apache.cxf.jaxrs.client.WebClient;
import org.springframework.beans.factory.annotation.Value;

import com.bbva.czic.dto.net.AccMovementsResume;
import com.bbva.czic.dto.net.Account;
import com.bbva.czic.dto.net.Check;
import com.bbva.czic.dto.net.MonthlyBalances;
import com.bbva.net.webservices.accounts.AccountsService;
import com.bbva.net.webservices.core.pattern.AbstractBbvaRestService;
import com.bbva.net.webservices.core.stereotype.RestService;

@RestService(value = "accountsService")
public class AccountsServiceImpl extends AbstractBbvaRestService implements AccountsService {

	@Value("${fiql.filter.parameter}")
	private String FILTER;

	@Override
	public Account getAccount(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Check> getListCheck(String accountId, String filter, String status, String paginationKey,
			String pageSize) {

		WebClient wc = getJsonWebClient(URL_BASE_ACCOUNTS+ accountId + URL_CHECK);
		if (!StringUtils.isEmpty(filter)) wc.query(FILTER, filter);

		return (List<Check>)wc.getCollection(Check.class);
	}

	// Pinta Grafica Cupo rotaativo
	@Override
	public List<MonthlyBalances> getAccountMonthlyBalance(String id, String $filter, String $fields, String $expands,
			String $sort) {
		// TODO Auto-generated method stub
		return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<AccMovementsResume> getAccMovementResume(String id, String $filter, String $fields, String $expands,
			String $sort) {
		WebClient wc = getJsonWebClient(URL_BASE_ACCOUNTS + id + URL_ACCOUNTS);
		wc.query("filtro", $filter);
		return (List<AccMovementsResume>)wc.getCollection(AccMovementsResume.class);
	}

}
