package com.bbva.net.front.controller.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;

import com.bbva.net.back.facade.AccountsFacade;
import com.bbva.net.back.model.globalposition.AccountDTO;
import com.bbva.net.front.controller.AccountsController;
import com.bbva.net.front.core.AbstractBbvaController;

@Controller
public class AccountsControllerImpl extends AbstractBbvaController implements AccountsController {

	private static final long serialVersionUID = 5726824668267606699L;

	private boolean stateAccounts = true;

	@Resource(name = "accountsFacade")
	private transient AccountsFacade accountsFacade;

	private AccountDTO selectedAccount;

	public boolean isStateAccounts() {
		return stateAccounts;
	}

	public void setStateAccounts(boolean stateAccounts) {
		this.stateAccounts = stateAccounts;
	}

	public void setAccountsFacade(final AccountsFacade accountsFacade) {
		this.accountsFacade = accountsFacade;
	}

	@Override
	public List<AccountDTO> getCustomerAccounts() {
		return this.accountsFacade.getAccountsByUser(getCurrentUser());
	}

	public AccountDTO getSelectedAccount() {
		return selectedAccount;
	}

	public void setSelectedAccount(AccountDTO selectedAccount) {
		this.selectedAccount = selectedAccount;
	}

}
