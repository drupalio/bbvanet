package com.bbva.net.front.controller;

import java.util.List;

import com.bbva.net.back.model.globalposition.AccountDTO;

/**
 * @author Entelgy
 */
public interface AccountsController {

	/**
	 * @return accountList for user logged
	 */
	List<AccountDTO> getCustomerAccounts();

	/**
	 * @return
	 */
	List<AccountDTO> getCustomerAccountsHidden();

}
