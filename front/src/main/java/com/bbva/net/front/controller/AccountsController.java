package com.bbva.net.front.controller;

import java.util.List;

import co.com.bbva.services.transactions.globalposition.schema.Account;

public interface AccountsController {

	List<Account> getCustomerAccounts();

}
