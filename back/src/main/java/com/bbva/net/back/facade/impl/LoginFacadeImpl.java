package com.bbva.net.back.facade.impl;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Value;

import com.bbva.net.back.core.pattern.facade.AbstractBbvaFacade;
import com.bbva.net.back.core.stereotype.Facade;
import com.bbva.net.back.facade.LoginFacade;
import com.bbva.net.webservices.grantingticket.SrvCOGrantingTicket;
import com.bbva.saz.co.grantingticket.v01.Authentication;
import com.bbva.saz.co.grantingticket.v01.AuthenticationData;
import com.bbva.saz.co.grantingticket.v01.ConsumerContext;
import com.bbva.saz.co.grantingticket.v01.UserPreferences;

@Facade(value = "loginFacade")
public class LoginFacadeImpl extends AbstractBbvaFacade implements LoginFacade {

	// CLIENTE REST
	@Resource(name = "grantingTicket")
	private SrvCOGrantingTicket grantingTicket;

	@Value("${granting.consumerId}")
	private String CONSUMER;

	@Value("${granting.consumerId}")
	private String AUTH_TYPE;

	@Value("${granting.language}")
	private String LANGUAGE;

	/**
	 * 
	 */
	private static final long serialVersionUID = 6609387805859744761L;

	@Override
	public String login(String user, String password, String identification, String identificationType) {

		ConsumerContext consumerContext = new ConsumerContext();
		Authentication acutentication = new Authentication();
		UserPreferences userPreferences = new UserPreferences();
		AuthenticationData authenticationData = new AuthenticationData();

		// Authentication-Data
		authenticationData.setIdAuthenticationData("iv_ticketService");

		// Authentication
		acutentication.setAccessCode(identification);
		acutentication.setAuthenticationType(AUTH_TYPE);
		acutentication.setClient(null);
		acutentication.setConsumerId(CONSUMER);
		acutentication.setUserId(user);

		// UserPreferences

		userPreferences.setLanguage(LANGUAGE);

		// ConsumerContext
		consumerContext.setDialogId(null);
		consumerContext.setBackendSession(null);
		consumerContext.setAddressIp(null);
		consumerContext.setUserPreferences(userPreferences);
		consumerContext.setAuthentication(acutentication);

		return this.grantingTicket.createTicket(consumerContext).getAuthenticationState();
	}

	public void setGrantingTicket(SrvCOGrantingTicket grantingTicket) {
		this.grantingTicket = grantingTicket;
	}

}
