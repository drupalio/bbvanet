package com.bbva.net.front.controller.impl;

import javax.ws.rs.core.Response;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import com.bbva.net.back.facade.PersonalizeProductFacade;
import com.bbva.net.back.model.globalposition.ProductDto;

public class PersonalizeProductAccountControllerImplTest {

	private static final String DEFAULT_ID = "0013044300020000949";

	private PersonalizeProductControllerImpl personalizeProductAccountControllerImpl;

	private PersonalizeProductFacade personalizeProductAccountFacade;

	private ProductDto productDto;

	@Before
	public void init() throws Exception {
		this.personalizeProductAccountControllerImpl = new PersonalizeProductControllerImpl();
		this.personalizeProductAccountControllerImpl.offMessageSuccesful(null);
		this.personalizeProductAccountControllerImpl.offMessageOpenKey(null);
		this.personalizeProductAccountControllerImpl.successful(null);
		this.personalizeProductAccountFacade = Mockito.mock(PersonalizeProductFacade.class);

		productDto = Mockito.mock(ProductDto.class);
		productDto.setProductId(DEFAULT_ID);
		productDto.setVisible(true);
		productDto.setOperationOnline(false);

	}

	@Test
	public void checkGetPersonalizeUpdateOperability() {
		Response response = Mockito.mock(Response.class);

		Mockito.when(personalizeProductAccountFacade.updateProductOperability(DEFAULT_ID, productDto)).thenReturn(
				response);
		response = personalizeProductAccountFacade.updateProductOperability(DEFAULT_ID, this.productDto);
		Assert.assertNotNull(response);
		Mockito.verify(this.personalizeProductAccountFacade, Mockito.atLeastOnce()).updateProductOperability(
				DEFAULT_ID, productDto);
	}

	@Test
	public void checkGetPersonalizeUpdateVisibility() {
		Response response = Mockito.mock(Response.class);

		Mockito.when(personalizeProductAccountFacade.updateProductVisibility(DEFAULT_ID, productDto)).thenReturn(
				response);
		response = personalizeProductAccountFacade.updateProductVisibility(DEFAULT_ID, this.productDto);
		Assert.assertNotNull(response);
		Mockito.verify(this.personalizeProductAccountFacade, Mockito.atLeastOnce()).updateProductVisibility(DEFAULT_ID,
				productDto);
	}

}
