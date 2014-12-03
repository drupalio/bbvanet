package com.bbva.net.front.controller.impl;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.web.client.RestClientException;

import co.com.bbva.services.transactions.globalposition.schema.GlobalProducts;

import com.bbva.net.back.facade.AccountsFacade;

/**
 * 
 * @author Entelgy
 *
 */
public class AccountsControllerImplTest {

	private static final String DEFAULT_USER = "123";

	private AccountsControllerImpl accountsController;
	private AccountsFacade accountsFacade;

	@Before
	public void init() {

		this.accountsController = new AccountsControllerImpl();

		accountsFacade = Mockito.mock(AccountsFacade.class);
		accountsController.setAccountsFacade(accountsFacade);

	}

	/**
	 * 
	 * @throws RestClientException
	 */
	@Test
	public void checkGetCustomerAccounts_OK() {

		// prepara el test
		Mockito.when(accountsFacade.getAccountsByUser(DEFAULT_USER))
				.thenReturn(new GlobalProducts());

		// invoca metodo a probar
		final GlobalProducts globalProducts = this.accountsController
				.getCustomerAccounts();

		// Comprobar resultados
		Assert.assertNotNull(globalProducts);
		Mockito.verify(this.accountsFacade, Mockito.atLeastOnce())
				.getAccountsByUser(DEFAULT_USER);

	}

	/**
	 * 
	 * @throws RestClientException
	 */
	@Test(expected = RestClientException.class)
	public void checkGetCustomerAccounts_NO_OK() {

		Mockito.when(accountsFacade.getAccountsByUser(DEFAULT_USER)).thenThrow(
				new RestClientException(""));
		this.accountsController.getCustomerAccounts();

	}

}
