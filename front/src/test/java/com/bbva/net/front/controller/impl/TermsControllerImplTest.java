package com.bbva.net.front.controller.impl;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.web.client.RestClientException;

import com.bbva.net.back.facade.TermasAccountsFacade;
import com.bbva.net.back.model.accounts.TermsAccountsDto;
import com.bbva.net.back.model.globalposition.ProductDto;
import com.bbva.net.front.test.utils.AbstractBbvaControllerTest;

public class TermsControllerImplTest extends AbstractBbvaControllerTest {

	private static final String DEFAULT_ID = "0013044300020000949";

	private TermsControllerImpl termsController;

	private TermasAccountsFacade detallesCuenta;

	private ProductDto productDto;

	@Before
	public void init() {
		// inicializar controlador
		this.termsController = new TermsControllerImpl();
		// Mockear el producto y el facade
		this.productDto = Mockito.mock(ProductDto.class);
		this.detallesCuenta = Mockito.mock(TermasAccountsFacade.class);
		// Setear el facade
		this.termsController.setDetallesCuenta(detallesCuenta);
	}

	@Test
	public void checkGetAllConditions() {
		// inicializar Dto
		TermsAccountsDto termsAccountsDto = new TermsAccountsDto();
		// Mockar el producto
		// Mockito.when(termsController.getSelectedProduct()).thenReturn(productDto);
		// Mockito.when(productDto.getProductId()).thenReturn(DEFAULT_ID);
		// Mockear la respuesta
		Mockito.when(this.termsController.getAllConditions()).thenReturn(termsAccountsDto);
		// llamar al metodo getAllConditions
		termsAccountsDto = this.termsController.getAllConditions();
		// mirar que la respuesta no venga vacia
		Assert.assertNotNull(termsAccountsDto);
	}

	@Test
	public void wormGetConditions() {
		// Mockar el producto
		Mockito.when(termsController.getSelectedProduct()).thenReturn(productDto);
		Mockito.when(productDto.getProductId()).thenReturn(DEFAULT_ID);
		// Mockear la respuesta
		Mockito.when(this.detallesCuenta.getAllConditions(DEFAULT_ID)).thenThrow(new RestClientException("OK"));

		this.termsController.getAllConditions();
	}

}
