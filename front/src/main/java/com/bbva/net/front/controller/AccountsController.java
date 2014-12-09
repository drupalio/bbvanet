package com.bbva.net.front.controller;

import java.util.List;

import co.com.bbva.services.transactions.globalposition.schema.Account;

/**
 * @author Entelgy
 */
public interface AccountsController {

	/**
	 * @return accountList for user logged
	 */
	List<Account> getCustomerAccounts();

}
