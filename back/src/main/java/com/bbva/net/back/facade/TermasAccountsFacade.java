package com.bbva.net.back.facade;

import com.bbva.net.back.model.accounts.TermsAccountsDto;

public interface TermasAccountsFacade {

	public TermsAccountsDto getAllConditions(String numCuenta, String usuario);
}
