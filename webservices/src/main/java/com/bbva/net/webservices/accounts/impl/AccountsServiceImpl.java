package com.bbva.net.webservices.accounts.impl;

import java.util.List;

import org.apache.cxf.jaxrs.client.WebClient;

import com.bbva.czic.dto.net.AccMovementsResume;
import com.bbva.czic.dto.net.Account;
import com.bbva.czic.dto.net.Check;
import com.bbva.czic.dto.net.MonthlyBalances;
import com.bbva.net.webservices.accounts.AccountsService;
import com.bbva.net.webservices.core.pattern.AbstractBbvaRestService;
import com.bbva.net.webservices.core.stereotype.RestService;

@RestService(value = "accountsService")
public class AccountsServiceImpl extends AbstractBbvaRestService implements AccountsService {

	@Override
	public Account getAccount(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Check> listCheck(String accountId, String $filter, String $status, String $paginationKey,
			String $pageSize) {
		// TODO Auto-generated method stub
		return null;
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
