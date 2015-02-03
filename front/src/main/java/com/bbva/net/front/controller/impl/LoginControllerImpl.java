package com.bbva.net.front.controller.impl;

import javax.annotation.Resource;
import javax.faces.context.FacesContext;

import org.springframework.faces.webflow.FlowFacesContext;

import com.bbva.net.back.facade.LoginFacade;
import com.bbva.net.front.controller.LoginController;
import com.bbva.net.front.core.AbstractBbvaController;

public class LoginControllerImpl extends AbstractBbvaController implements LoginController {

	private static final long serialVersionUID = 1L;

	@Resource(name = "loginFacade")
	private LoginFacade loginFacade;

	@Override
	public void login() {

		// 1 Create Session;
		final FacesContext facesContext = FlowFacesContext.getCurrentInstance();
		facesContext.getExternalContext().getSession(true);

		// 2. Invocar al GrantingTicket y recuperar tsec
		final String tsec = this.loginFacade.login(getRequestParameter("usuario"), getRequestParameter("password2"),
				getRequestParameter("NumeroId"), getRequestParameter("TipoId"));

		// 3. Almacenar tsec en la session
		this.getSession().setAttribute(SessionParamenterType.TSEC.name(), tsec);

		// 3. Redirigir a Posición global
		// this.initFlow("globalPosition");

	}
}
