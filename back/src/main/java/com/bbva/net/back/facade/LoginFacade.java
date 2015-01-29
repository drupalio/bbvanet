package com.bbva.net.back.facade;

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
	String login(String user, String password, String identification, String identificationType);

}
