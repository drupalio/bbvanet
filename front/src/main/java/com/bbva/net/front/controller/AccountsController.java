package com.bbva.net.front.controller;

import java.util.List;

import com.bbva.net.back.model.globalposition.AccountDto;

/**
 * @author Entelgy
 */
public interface AccountsController {

	/**
	 * @return accountList for user logged
	 */
	List<AccountDto> getCustomerAccounts();

	/**
	 * @return
	 */
	List<AccountDto> getCustomerAccountsHidden();

}
