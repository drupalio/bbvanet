package com.bbva.net.front.controller.impl;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.web.client.RestClientException;

import com.bbva.net.back.facade.AccountsFacade;
import com.bbva.net.back.model.globalposition.AccountDTO;

/**
 * @author Entelgy
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
	 * @throws RestClientException
	 */
	@Test
	public void checkGetCustomerAccounts_OK() {

		// prepara el test
		List<AccountDTO> h = new ArrayList<AccountDTO>();
		Mockito.when(accountsFacade.getAccountsByUser(DEFAULT_USER)).thenReturn(h);

		// invoca metodo a probar
		final List<AccountDTO> customerAccounts = this.accountsController.getCustomerAccounts();

		// Comprobar resultados
		Assert.assertNotNull(customerAccounts);
		Mockito.verify(this.accountsFacade, Mockito.atLeastOnce()).getAccountsByUser(DEFAULT_USER);

	}

	/**
	 * @throws RestClientException
	 */
	@Test(expected = RestClientException.class)
	public void checkGetCustomerAccounts_NO_OK() {

		// Creación del mock
		Mockito.when(accountsFacade.getAccountsByUser(DEFAULT_USER)).thenThrow(new RestClientException(""));

		// Invocación al método
		this.accountsController.getCustomerAccounts();

	}

}
