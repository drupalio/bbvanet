package com.bbva.net.back.facade.impl;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Value;

import com.bbva.net.back.core.pattern.facade.AbstractBbvaFacade;
import com.bbva.net.back.core.stereotype.Facade;
import com.bbva.net.back.facade.LoginFacade;
import com.bbva.net.webservices.grantingticket.SrvCOGrantingTicket;
import com.bbva.saz.co.grantingticket.v01.Authentication;
import com.bbva.saz.co.grantingticket.v01.AuthenticationData;
import com.bbva.saz.co.grantingticket.v01.AuthenticationState;
import com.bbva.saz.co.grantingticket.v01.ConsumerContext;
import com.bbva.saz.co.grantingticket.v01.UserPreferences;

@Facade(value = "loginFacade")
public class LoginFacadeImpl extends AbstractBbvaFacade implements LoginFacade {

	// CLIENTE REST
	@Resource(name = "grantingTicket")
	private SrvCOGrantingTicket grantingTicket;

	@Value("${granting.consumerId}")
	private String CONSUMER;

	@Value("${granting.authenType}")
	private String AUTH_TYPE;

	@Value("${granting.language}")
	private String LANGUAGE;

	@Value("${granting.ivTicketId}")
	private String IV_TICKET_SERVICE;

	/**
	 * 
	 */
	private static final long serialVersionUID = 6609387805859744761L;

	@Override
	public AuthenticationState login(String ivTicket, String user, String password, String identification,
			String identificationType) {

		LOGGER.info("LOGIN FACADE ");
		LOGGER.info("User: " + user);
		LOGGER.info("Password: " + password);
		LOGGER.info("Identificacion: " + identification);

		ConsumerContext consumerContext = new ConsumerContext();
		Authentication autentication = new Authentication();
		UserPreferences userPreferences = new UserPreferences();
		AuthenticationData authenticationData = new AuthenticationData();

		// Authentication-Data
		authenticationData.setKey(IV_TICKET_SERVICE);
		authenticationData.getValue().add(ivTicket);

		// Authentication
		/**
		 * Concatenaciópn de Nick Usuario + Tipo de documento (identificationType) + Identification
		 */
		autentication.setUserId(user + identificationType + identification);
		autentication.setConsumerId(CONSUMER);
		autentication.setAuthenticationType(AUTH_TYPE);
		autentication.getAuthenticationData().add(authenticationData);

		// UserPreferences
		userPreferences.setUserId(StringUtils.EMPTY);
		userPreferences.setAccessCode(user + identificationType + identification);
		userPreferences.setDialogId(StringUtils.EMPTY);
		// ConsumerContext
		consumerContext.setUserPreferences(userPreferences);
		consumerContext.setAuthentication(autentication);

		return this.grantingTicket.createTicket(consumerContext);
	}

	public void setGrantingTicket(SrvCOGrantingTicket grantingTicket) {
		this.grantingTicket = grantingTicket;
	}

}
