package com.bbva.net.back.facade;

import java.util.List;

import co.com.bbva.services.transactions.globalposition.schema.Account;

public interface AccountsFacade {

	public List<Account> getAccountsByUser(String user);

}
