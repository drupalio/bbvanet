package com.bbva.net.back.facade;

import java.util.List;

import com.bbva.net.back.model.globalposition.AccountDTO;

/**
 * @author Entelgy
 */
public interface AccountsFacade {

	/**
	 * @param user
	 * @return
	 */
	List<AccountDTO> getAccountsByUser(String user);

	/**
	 * @param user
	 * @return
	 */
	List<AccountDTO> getAccountsByUserHidden(String user);

}
