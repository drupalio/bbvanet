package com.bbva.net.front.controller.impl;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.web.client.RestClientException;

import co.com.bbva.services.transactions.globalposition.schema.GlobalProducts;

import com.bbva.net.back.facade.GlobalPositionFacade;

/**
 * 
 * @author Entelgy
 *
 */
public class GlobalPositionControllerImplTest {

	private static final String DEFAULT_USER = "123";

	private GlobalPositionControllerImpl globalPositionController;
	private GlobalPositionFacade globalPositionFacade;

	@Before
	public void init() {

		this.globalPositionController = new GlobalPositionControllerImpl();

		globalPositionFacade = Mockito.mock(GlobalPositionFacade.class);
		globalPositionController.setGlobalPositionFacade(globalPositionFacade);

	}

	@Test
	public void checkGetCustomerProducts_OK() {

		// prepara el test
		Mockito.when(globalPositionFacade.getGlobalProductsByUser(DEFAULT_USER))
				.thenReturn(new GlobalProducts());

		// invoca metodo a probar
		final GlobalProducts globalProducts = this.globalPositionController
				.getCustomerProducts();

		// Comprobar resultados
		Assert.assertNotNull(globalProducts);
		Mockito.verify(this.globalPositionFacade, Mockito.atLeastOnce())
				.getGlobalProductsByUser(DEFAULT_USER);

	}

	/**
	 * 
	 * @throws RestClientException
	 */
	@Test(expected = RestClientException.class)
	public void checkGetCustomerProducts_NO_OK() {

		Mockito.when(globalPositionFacade.getGlobalProductsByUser(DEFAULT_USER))
				.thenThrow(new RestClientException(""));
		this.globalPositionController.getCustomerProducts();

	}

}
