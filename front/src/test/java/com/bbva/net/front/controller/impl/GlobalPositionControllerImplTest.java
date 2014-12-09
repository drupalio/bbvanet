package com.bbva.net.front.controller.impl;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.web.client.RestClientException;

import co.com.bbva.services.transactions.globalposition.schema.GlobalProducts;

import com.bbva.net.back.entity.MultiValueGroup;
import com.bbva.net.back.facade.GlobalPositionFacade;
import com.bbva.net.back.facade.MultiValueGroupFacade;

/**
 * 
 * @author Entelgy
 *
 */
public class GlobalPositionControllerImplTest {

	private static final String DEFAULT_USER = "123";

	private GlobalPositionControllerImpl globalPositionController;
	private GlobalPositionFacade globalPositionFacade;
	private MultiValueGroupFacade multiValueGroupFacade;

	@Before
	public void init() {

		this.globalPositionController = new GlobalPositionControllerImpl();

		globalPositionFacade = Mockito.mock(GlobalPositionFacade.class);
		globalPositionController.setGlobalPositionFacade(globalPositionFacade);

		multiValueGroupFacade = Mockito.mock(MultiValueGroupFacade.class);
		globalPositionController
				.setMultiValueGroupFacade(multiValueGroupFacade);

	}

	/**
	 * 
	 * @throws RestClientException
	 */
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

	@Test
	public void getMultiValue() {

		Mockito.when(multiValueGroupFacade.getMultiValueTypes(1)).thenReturn(
				new ArrayList<MultiValueGroup>());

		final List<MultiValueGroup> list = this.globalPositionController
				.getListMultiValueLikes();

		Assert.assertNotNull(list);
		Mockito.verify(multiValueGroupFacade, Mockito.atLeastOnce())
				.getMultiValueTypes(1);

		Mockito.verify(multiValueGroupFacade, Mockito.never())
				.getMultiValueTypes(null);

	}

}
