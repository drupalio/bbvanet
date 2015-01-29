package com.bbva.net.front.controller;

/**
 * 
 *
 */
public interface LoginController {

	/**
	 * @param user
	 * @param password
	 * @param identification
	 * @param identificationType
	 */
	void login(String user, String password, String identification, String identificationType);

}
