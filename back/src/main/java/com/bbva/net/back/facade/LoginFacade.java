package com.bbva.net.back.facade;

import com.bbva.saz.co.grantingticket.v01.AuthenticationState;

/**
 * @author Entelgy
 */
public interface LoginFacade {

	/**
	 * @param user
	 * @param password
	 * @param identification
	 * @param identificationType
	 */
	AuthenticationState login(String ivTicket, String user, String password, String identification,
			String identificationType);

}
