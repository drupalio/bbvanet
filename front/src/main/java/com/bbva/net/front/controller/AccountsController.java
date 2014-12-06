package com.bbva.net.front.controller;

import java.util.List;

import co.com.bbva.services.transactions.globalposition.schema.Account;
import co.com.bbva.services.transactions.globalposition.schema.GlobalProducts;

public interface AccountsController {

	GlobalProducts getCustomerAccounts();
	

}
