package com.bbva.net.front.controller.impl;

import org.primefaces.event.SelectEvent;
import org.springframework.stereotype.Controller;

import com.bbva.net.front.controller.UserRecoverPassword;
import com.bbva.net.front.core.AbstractBbvaController;

@Controller(value = "userRecoverPassword")
public class UserRecoverPasswordImpl extends AbstractBbvaController implements
		UserRecoverPassword {

	private static final long serialVersionUID = 6795761532672076491L;

	/**
	 * action to send in current flow
	 */
	@Override
	public void changePageDialog() {
		this.sendAction("changePageDialog");
	}
}
