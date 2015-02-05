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

	@Value("${granting.consumerId}")
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

		ConsumerContext consumerContext = new ConsumerContext();
		Authentication acutentication = new Authentication();
		UserPreferences userPreferences = new UserPreferences();
		AuthenticationData authenticationData = new AuthenticationData();

		// Authentication-Data
		authenticationData.setIdAuthenticationData(IV_TICKET_SERVICE);
		authenticationData.getAuthenticationData().add(ivTicket);

		// Authentication
		/**
		 * Concatenaciópn de Nick Usuario (identificación) + Tipo de documento (identificationType) + Usuario de acceso
		 */
		acutentication.setAccessCode(identification + identificationType + user);
		acutentication.setAuthenticationType(AUTH_TYPE);
		acutentication.setClient(null);
		acutentication.setConsumerId(CONSUMER);
		acutentication.setUserId(StringUtils.EMPTY);

		// UserPreferences

		userPreferences.setLanguage(LANGUAGE);

		// ConsumerContext
		consumerContext.setDialogId(null);
		consumerContext.setBackendSession(null);
		consumerContext.setAddressIp(null);
		consumerContext.setUserPreferences(userPreferences);
		consumerContext.setAuthentication(acutentication);

		return this.grantingTicket.createTicket(consumerContext);
	}

	public void setGrantingTicket(SrvCOGrantingTicket grantingTicket) {
		this.grantingTicket = grantingTicket;
	}

}
