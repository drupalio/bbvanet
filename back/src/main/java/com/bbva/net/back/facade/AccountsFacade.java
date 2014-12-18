package com.bbva.net.back.facade;

import java.util.List;

import com.bbva.net.back.model.globalposition.AccountDTO;

public interface AccountsFacade {

	public List<AccountDTO> getAccountsByUser(String user);

}
