package com.bbva.net.back.facade.impl;

import com.bbva.net.back.core.pattern.facade.AbstractBbvaFacade;
import com.bbva.net.back.core.stereotype.Facade;
import com.bbva.net.back.facade.LoginFacade;

@Facade(value = "loginFacade")
public class LoginFacadeImpl extends AbstractBbvaFacade implements LoginFacade {

	@Override
	public String login(String user, String password, String identification, String identificationType) {
		return null;
	}

}
