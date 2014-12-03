package com.bbva.net.front.controller.impl;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.web.client.RestClientException;

import co.com.bbva.services.transactions.globalposition.schema.GlobalProducts;

import com.bbva.net.back.facade.LoanFacade;

/**
 * 
 * @author Entelgy
 *
 */
public class LoanControllerImplTest {

	private static final String DEFAULT_USER = "123";

	private LoanControllerImpl loanController;
	private LoanFacade loanFacade;

	@Before
	public void init() {

		this.loanController = new LoanControllerImpl();

		loanFacade = Mockito.mock(LoanFacade.class);
		loanController.setLoanFacade(loanFacade);

	}

	/**
	 * 
	 * @throws RestClientException
	 */
	@Test
	public void checkGetCustomerProducts_OK() {

		// prepara el test
		Mockito.when(loanFacade.getLoansByUser(DEFAULT_USER)).thenReturn(
				new GlobalProducts());

		// invoca metodo a probar
		final GlobalProducts globalProducts = this.loanController
				.getCustomerLoan();

		// Comprobar resultados
		Assert.assertNotNull(globalProducts);
		Mockito.verify(this.loanFacade, Mockito.atLeastOnce()).getLoansByUser(
				DEFAULT_USER);

	}

	/**
	 * 
	 * @throws RestClientException
	 */
	@Test(expected = RestClientException.class)
	public void checkGetCustomerProducts_NO_OK() {

		Mockito.when(loanFacade.getLoansByUser(DEFAULT_USER)).thenThrow(
				new RestClientException(""));
		this.loanController.getCustomerLoan();

	}

}
