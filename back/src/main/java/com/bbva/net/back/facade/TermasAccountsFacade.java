package com.bbva.net.back.facade;

import com.bbva.net.back.model.accounts.TermsAccountsDto;

/**
 * Clase que retorna las condiciones de un priducto
 * 
 * @author Entelgy
 */
public interface TermasAccountsFacade {

	/**
	 * @param numCuenta
	 * @return
	 */
	public TermsAccountsDto getAllConditions(String numCuenta);
}
