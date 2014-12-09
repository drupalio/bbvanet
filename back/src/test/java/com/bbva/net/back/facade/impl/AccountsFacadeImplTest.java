package com.bbva.net.back.facade.impl;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import com.bbva.net.webservices.globalposition.GlobalPositionService;

public class AccountsFacadeImplTest {

	private static final String DEFAULT_USER = "123";

	private AccountsFacadeImpl accountsFacade;

	private GlobalPositionService globalPositionService;

	@Before
	public void init() {

		this.accountsFacade = new AccountsFacadeImpl();
		globalPositionService = Mockito.mock(GlobalPositionService.class);
		this.accountsFacade.setGlobalPositionService(globalPositionService);

	}

	@Test
	public void checkGetCustomerAccounts_OK() {
		// invoca metodo a probar

		// List<Account> h = new ArrayList<Account>();

		// Mockito.doReturn(h).when(this.globalPositionService.get(DEFAULT_USER).getAccounts());

		// final List<Account> accounts = this.accountsFacade.getAccountsByUser(DEFAULT_USER);

		// Comprobar resultados Assert.assertNotNull(accounts);

		// Mockito.verify(this.globalPositionService, Mockito.atLeastOnce()).get(DEFAULT_USER).getAccounts();

	}

	@Test
	public void checkGetCustomerAccounts_NO_OK() {

	}

}
