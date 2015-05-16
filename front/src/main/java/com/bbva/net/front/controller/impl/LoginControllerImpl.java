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

		// 3. Set CurrentUser
		final String user = getRequest().getHeader("iv-user");
		this.setDefaultUser(user);

		LOGGER.info("Login with User: " + user);
		LOGGER.info("iv_ticketService: " + ivTicketValue);

		// 4. Invocar al GrantingTicket y almacenar AuthenticationState
		final AuthenticationState authenticationState = this.loginFacade.login(ivTicketValue, user,
				getRequestParameter("pass"), getRequestParameter("numero"), getRequestParameter("tipo"));

		// 5. Put in Session
		this.getSession().setAttribute(SessionParamenterType.AUTHENTICATION_STATE.name(), authenticationState);
		this.getSession().setAttribute("userName", user.substring(0, 8));
		this.getSession().setAttribute("docTypeUser", user.substring(8, 10));
		this.getSession().setAttribute("docIdUser", user.substring(10, 25));
	}

	/**
	 * @param loginFacade
	 */
	public void setLoginFacade(LoginFacade loginFacade) {
		this.loginFacade = loginFacade;
	}

}
