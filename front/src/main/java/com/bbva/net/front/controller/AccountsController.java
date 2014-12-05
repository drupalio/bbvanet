package com.bbva.net.front.controller;

import java.util.List;

import co.com.bbva.services.transactions.globalposition.schema.Account;

import com.bbva.net.back.facade.AccountsFacade;

public interface AccountsController {

	public List<Account> getCustomerAccounts();

	void setAccountsFacade(AccountsFacade accountsFacade);

}
