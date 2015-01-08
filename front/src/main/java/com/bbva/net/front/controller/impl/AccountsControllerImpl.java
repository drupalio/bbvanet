package com.bbva.net.front.controller.impl;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.primefaces.event.SelectEvent;

import com.bbva.net.back.facade.AccountsFacade;
import com.bbva.net.back.model.globalposition.AccountDto;
import com.bbva.net.front.controller.AccountsController;
import com.bbva.net.front.core.AbstractBbvaController;

@ManagedBean
@ViewScoped
public class AccountsControllerImpl extends AbstractBbvaController implements AccountsController {

	private static final long serialVersionUID = 5726824668267606699L;

	@Resource(name = "accountsFacade")
	private transient AccountsFacade accountsFacade;

	@PostConstruct
	public void init() {
		LOGGER.info("Initialize AccountsController");
	}

	public void setAccountsFacade(final AccountsFacade accountsFacade) {
		this.accountsFacade = accountsFacade;
	}

	@Override
	public List<AccountDto> getCustomerAccounts() {
		return this.accountsFacade.getAccountsByUser(getCurrentUser());
	}

	@Override
	public List<AccountDto> getCustomerAccountsHidden() {
		return this.accountsFacade.getAccountsByUserHidden(getCurrentUser());
	}

	@Override
	public void onProductSelected(SelectEvent selectEvent) {
		super.onProductSelected(selectEvent);
		this.sendAction("accountSelected");
	}

}
