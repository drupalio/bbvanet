package com.bbva.net.front.controller.impl;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.web.client.RestClientException;

import com.bbva.net.back.facade.AccountsFacade;
import com.bbva.net.back.model.globalposition.AccountDto;

/**
 * @author Entelgy
 */
public class AccountsControllerImplTest {

	private static final String DEFAULT_USER = "12345678";

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
		List<AccountDto> h = new ArrayList<AccountDto>();
		Mockito.when(accountsFacade.getAccountsByUser()).thenReturn(h);

		// invoca metodo a probar
		final List<AccountDto> customerAccounts = this.accountsController.getCustomerAccounts();

		// Comprobar resultados
		Assert.assertNotNull(customerAccounts);
		Mockito.verify(this.accountsFacade, Mockito.atLeastOnce()).getAccountsByUser();

	}

	/**
	 * @throws RestClientException
	 */
	@Test(expected = RestClientException.class)
	public void checkGetCustomerAccounts_NO_OK() {

		// Creación del mock
		Mockito.when(accountsFacade.getAccountsByUser()).thenThrow(new RestClientException(""));

		// Invocación al método
		final List<AccountDto> customerAccounts = this.accountsController.getCustomerAccounts();
		Assert.assertNull(customerAccounts);

	}

}
