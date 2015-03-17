package com.bbva.net.front.controller.impl;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import com.bbva.net.back.facade.PersonalizeProductFacade;
import com.bbva.net.back.model.globalposition.ProductDto;

public class PersonalizeProductAccountControllerImplTest {

	private static final String DEFAULT_ID = "0013044300020000949";

	private PersonalizeProductControllerImpl personalizeController;

	private PersonalizeProductFacade personalizeFacade;

	private ProductDto productDto;

	@Before
	public void init() throws Exception {
		this.personalizeController = new PersonalizeProductControllerImpl();
		this.personalizeController.offMessageSuccesful();
		this.personalizeController.offMessageOpenKey(null);
		this.personalizeFacade = Mockito.mock(PersonalizeProductFacade.class);
		this.personalizeController.setPersonalizeProductAccountFacade(personalizeFacade);
		productDto = new ProductDto();
		productDto.setProductId("0013044300020000949");
		productDto.setOperationOnline(true);
		productDto.setVisible(true);
		this.personalizeController.setProductDto(productDto);
	}

	@Test
	public void checkOperKey() {
		Mockito.when(this.personalizeFacade.updateProductOperability(DEFAULT_ID, productDto)).thenReturn(true);
		Mockito.when(this.personalizeFacade.updateProductVisibility(DEFAULT_ID, productDto)).thenReturn(true);
		this.personalizeController.operKey();
		Mockito.when(this.personalizeFacade.updateProductOperability(DEFAULT_ID, productDto)).thenReturn(false);
		this.personalizeController.operKey();
		Mockito.when(this.personalizeFacade.updateProductVisibility(DEFAULT_ID, productDto)).thenReturn(false);
		this.personalizeController.operKey();
		Mockito.when(this.personalizeFacade.updateProductOperability(DEFAULT_ID, productDto)).thenReturn(false);
		Mockito.when(this.personalizeFacade.updateProductVisibility(DEFAULT_ID, productDto)).thenReturn(false);
		this.personalizeController.operKey();
		Mockito.verify(this.personalizeFacade, Mockito.atLeastOnce()).updateProductOperability(DEFAULT_ID, productDto);
		Mockito.verify(this.personalizeFacade, Mockito.atLeastOnce()).updateProductVisibility(DEFAULT_ID, productDto);
	}

}
