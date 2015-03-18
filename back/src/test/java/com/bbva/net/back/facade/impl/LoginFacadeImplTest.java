package com.bbva.net.back.facade.impl;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import com.bbva.net.webservices.grantingticket.SrvCOGrantingTicket;
import com.bbva.saz.co.grantingticket.v01.AuthenticationState;

public class LoginFacadeImplTest {

	private LoginFacadeImpl loginFacade;

	private SrvCOGrantingTicket grantingTicket;

	private AuthenticationState autenti;

	@Before
	public void init() {
		this.loginFacade = new LoginFacadeImpl();
		this.grantingTicket = Mockito.mock(SrvCOGrantingTicket.class);
		this.autenti = Mockito.mock(AuthenticationState.class);
		this.loginFacade.setGrantingTicket(grantingTicket);
	}

	@Test
	public void checkLogin() {
		Mockito.when(loginFacade.login("A56VH", "12345678", "8jusjyet", "1192873827", "null")).thenReturn(autenti);
		Assert.assertNotNull(autenti);
	}
}
