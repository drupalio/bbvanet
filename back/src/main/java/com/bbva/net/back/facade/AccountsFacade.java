package com.bbva.net.back.facade;

import java.util.List;

import com.bbva.net.back.model.globalposition.AccountDto;

/**
 * @author Entelgy
 */
public interface AccountsFacade {

	/**
	 * @param user
	 * @return
	 */
	List<AccountDto> getAccountsByUser(String user);

	/**
	 * @param user
	 * @return
	 */
	List<AccountDto> getAccountsByUserHidden(String user);

}
