package com.bbva.net.front.controller;

import java.util.List;

import co.com.bbva.services.transactions.globalposition.schema.Leasing;
import co.com.bbva.services.transactions.globalposition.schema.RotatingAccount;

/**
 * @author Entelgy
 */
public interface LoanController {

	/**
	 * @return
	 */
	public List<RotatingAccount> getCustomerRotatingAccount();

	/**
	 * @return
	 */
	public List<Leasing> getCustomerLeasing();

}
