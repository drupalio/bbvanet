package com.bbva.net.front.controller;

import com.bbva.net.back.facade.GlobalPositionFacade;

import co.com.bbva.services.transactions.globalposition.schema.GlobalProducts;

public interface AccountsController {

	GlobalProducts getCustomerAccounts();

	void setAccountsFacade(GlobalPositionFacade globalPositionFacade);

}
