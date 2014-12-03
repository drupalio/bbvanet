package com.bbva.net.back.facade.impl;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import co.com.bbva.services.transactions.globalposition.schema.GlobalProducts;

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

		Mockito.when(this.globalPositionService.get(Mockito.anyString()))
				.thenReturn(new GlobalProducts());
		// invoca metodo a probar
		final GlobalProducts globalProducts = this.accountsFacade
				.getAccountsByUser(DEFAULT_USER);

		// Comprobar resultados
		Assert.assertNotNull(globalProducts);
		Mockito.verify(this.globalPositionService, Mockito.atLeastOnce()).get(
				DEFAULT_USER);
	}

	@Test
	public void checkGetCustomerAccounts_NO_OK() {

	}
}
