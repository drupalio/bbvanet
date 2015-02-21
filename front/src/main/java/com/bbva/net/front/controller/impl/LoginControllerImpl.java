package com.bbva.net.front.controller.impl;

import javax.annotation.Resource;
import javax.faces.context.FacesContext;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.faces.webflow.FlowFacesContext;

import com.bbva.net.back.facade.LoginFacade;
import com.bbva.net.front.controller.LoginController;
import com.bbva.net.front.core.AbstractBbvaController;
import com.bbva.saz.co.grantingticket.v01.AuthenticationState;

public class LoginControllerImpl extends AbstractBbvaController implements LoginController {

	private static final long serialVersionUID = 1L;

	@Resource(name = "loginFacade")
	private LoginFacade loginFacade;

	@Value("${granting.ivTicketId}")
	private String IV_TICKET_SERVICE;

	@Override
	public void login() {

		LOGGER.info("LOGIN BBVA NET .................");
		// 1 Create Session;
		final FacesContext facesContext = FlowFacesContext.getCurrentInstance();
		facesContext.getExternalContext().getSession(true);

		LOGGER.info("Leyendo de cabecera ... " + IV_TICKET_SERVICE);
		// 2. Get iv_ticketService from header
		final String ivTicketValue = getRequest().getHeader("iv_ticketService");

		// 3. Get codigo cliente and iv-user
		final String clientId = getRequest().getHeader("codigo_cliente");
		final String ivUser = getRequest().getHeader("iv-user");

		LOGGER.info("Seteando CLIENT_ID a sesion" + clientId);
		this.getSession().setAttribute("CLIENT_ID", clientId);

		this.setDefaultUser(clientId);

		LOGGER.info("Login with Codigo Cliente: " + clientId);
		LOGGER.info("iv_ticketService: " + ivTicketValue);

		// 4. Invocar al GrantingTicket y almacenar AuthenticationState
		final AuthenticationState authenticationState = this.loginFacade.login(ivTicketValue, ivUser);

		// 5. Put in Session
		this.getSession().setAttribute(SessionParamenterType.AUTHENTICATION_STATE.name(), authenticationState);
		this.getSession().setAttribute("userName", ivUser.substring(0, 8));
		this.getSession().setAttribute("docTypeUser", ivUser.substring(8, 10));
		this.getSession().setAttribute("docIdUser", ivUser.substring(10, 25));
	}
}
