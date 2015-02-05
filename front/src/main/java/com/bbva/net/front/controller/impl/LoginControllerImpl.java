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

		// 1 Create Session;
		final FacesContext facesContext = FlowFacesContext.getCurrentInstance();
		facesContext.getExternalContext().getSession(true);

		// 2. Invocar al GrantingTicket (???)
		final String ivTicketValue = getRequest().getHeader(IV_TICKET_SERVICE);

		// 3. Set CurrentUser
		final String user = getRequestParameter("usuario");
		this.setDefaultUser(user);

		// 4. Invocar al GrantingTicket y almacenar AuthenticationState
		final AuthenticationState authenticationState = this.loginFacade.login(ivTicketValue, user,
				getRequestParameter("password2"), getRequestParameter("NumeroId"), getRequestParameter("TipoId"));
		this.getSession().setAttribute(SessionParamenterType.AUTHENTICATION_STATE.name(), authenticationState);

	}
}
