package com.bbva.net.front.controller.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;

import co.com.bbva.services.transactions.globalposition.schema.GlobalProducts;

import com.bbva.net.back.facade.AccountsFacade;
import com.bbva.net.front.controller.AccountsController;
import com.bbva.net.front.core.AbstractBbvaController;

@Controller
public class AccountsControllerImpl extends AbstractBbvaController implements
		AccountsController {

	private static final String DEFAULT_USER = "123";

	private static final long serialVersionUID = 5726824668267606699L;

	@Resource(name = "accountsFacade")
	private transient AccountsFacade accountsFacade;

	@Override
	public GlobalProducts getCustomerAccounts() {
		return this.accountsFacade.getAccountsByUser(DEFAULT_USER);
	}

	public void setAccountsFacade(final AccountsFacade accountsFacade) {
		this.accountsFacade = accountsFacade;
	}

}
