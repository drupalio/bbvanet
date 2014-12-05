package com.bbva.net.front.controller;

import java.util.List;

import co.com.bbva.services.transactions.globalposition.schema.GlobalProducts;
import co.com.bbva.services.transactions.globalposition.schema.Leasing;
import co.com.bbva.services.transactions.globalposition.schema.RotatingAccount;

public interface LoanController {

	public GlobalProducts getCustomerLoan();

	public List<RotatingAccount> getCustomerRotatingAccount();

	public List<Leasing> getCustomerLeasing();

}
