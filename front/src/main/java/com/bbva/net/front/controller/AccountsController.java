package com.bbva.net.front.controller;

import co.com.bbva.services.transactions.globalposition.schema.GlobalProducts;

import com.bbva.net.back.facade.AccountsFacade;

public interface AccountsController {

	GlobalProducts getCustomerAccounts();

	void setAccountsFacade(AccountsFacade accountsFacade);

}
