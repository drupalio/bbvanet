package com.bbva.net.front.controller.impl;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

import org.springframework.stereotype.Controller;

import com.bbva.net.back.facade.AccountsFacade;
import com.bbva.net.back.model.globalposition.AccountDTO;
import com.bbva.net.front.controller.AccountsController;
import com.bbva.net.front.core.AbstractBbvaController;

@Controller
public class AccountsControllerImpl extends AbstractBbvaController implements AccountsController {

	private static final long serialVersionUID = 5726824668267606699L;

	@Resource(name = "accountsFacade")
	private transient AccountsFacade accountsFacade;

	@PostConstruct
	public void init() {

	}

	public void setAccountsFacade(final AccountsFacade accountsFacade) {
		this.accountsFacade = accountsFacade;
	}

	@Override
	public List<AccountDTO> getCustomerAccounts() {
		return this.accountsFacade.getAccountsByUser(getCurrentUser());
	}

	@Override
	public List<AccountDTO> getCustomerAccountsHidden() {
		return this.accountsFacade.getAccountsByUserHidden(getCurrentUser());
	}

}
