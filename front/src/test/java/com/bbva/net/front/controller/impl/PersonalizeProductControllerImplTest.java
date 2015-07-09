package com.bbva.net.front.controller.impl;

import javax.faces.event.ActionEvent;
import javax.faces.event.AjaxBehaviorEvent;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.web.client.RestClientException;

import com.bbva.net.back.facade.PersonalizeProductFacade;
import com.bbva.net.back.facade.UpdateAliasFacade;
import com.bbva.net.back.model.globalposition.ProductDto;
import com.bbva.net.back.model.personalize.PersonalizeAccountDto;
import com.bbva.net.back.model.updateAlias.UpdateAccountDto;
import com.bbva.net.front.test.utils.AbstractBbvaControllerTest;

public class PersonalizeProductControllerImplTest extends AbstractBbvaControllerTest {

	private static final String DEFAULT_ID = "0013044300020000949";

	private PersonalizeProductControllerImpl personalizeController;

	private ActionEvent eventAction;

	private AjaxBehaviorEvent ajaxEvent;

	private PersonalizeProductFacade personalizeFacade;

	private UpdateAliasFacade updateAliasFacade;

	private ProductDto productDto;

	private ProductDto product;

	private UpdateAccountDto update;

	@Before
	public void init() throws Exception {
		super.setUp();
		this.personalizeController = new PersonalizeProductControllerImpl();
		this.eventAction = Mockito.mock(ActionEvent.class);
		this.ajaxEvent = Mockito.mock(AjaxBehaviorEvent.class);
		this.personalizeController.offMessageSuccesful(ajaxEvent);
		this.personalizeController.offMessageOpenKey(null);
		this.personalizeController.getMenSuccessful();
		this.personalizeController.getMenOperationKey();
		this.personalizeFacade = Mockito.mock(PersonalizeProductFacade.class);
		this.updateAliasFacade = Mockito.mock(UpdateAliasFacade.class);
		this.personalizeController.setPersonalizeProductAccountFacade(personalizeFacade);
		this.personalizeController.setUpdateAliasFacade(updateAliasFacade);
		this.productDto = Mockito.mock(ProductDto.class);
		this.update = Mockito.mock(UpdateAccountDto.class);
		this.product = new ProductDto();
		this.personalizeController.setProductDto(product);
		this.personalizeController.setPersonalizeProductAccountDto(new PersonalizeAccountDto());
		this.personalizeController.getPersonalizeProductAccountDto();
	}

	@Test
	public void checkInit() {
		// null
		this.personalizeController.init();
		// Caso Esitoso.
		Mockito.when(personalizeController.getSelectedProduct()).thenReturn(productDto);
		this.personalizeController.init();
		// Producto Nulo, OperationOnline no nulo y Visible null
		Mockito.when(productDto.isVisible()).thenReturn(null);
		this.personalizeController.init();
		// Producto no nulo, OperationOnline nulo y Visible no nulo
		Mockito.when(productDto.getOperationOnline()).thenReturn(null);
		this.personalizeController.init();
	}

	@Test
	public void checkOperKey() {
//		// null
//		this.personalizeController.operKey(eventAction);
//		this.product.setProductId("0013044300020000949");
//		this.product.setOperationOnline(true);
//		this.product.setVisible(true);
//		this.personalizeController.setProductDto(product);
//		this.personalizeController.getProductDto();
//		// verdaderos
//		Mockito.when(this.personalizeFacade.updateProductOperability(DEFAULT_ID, product)).thenReturn(true);
//		Mockito.when(this.personalizeFacade.updateProductVisibility(DEFAULT_ID, product)).thenReturn(true);
//		this.personalizeController.operKey(eventAction);
//		// operationOnline falso
//		Mockito.when(this.personalizeFacade.updateProductOperability(DEFAULT_ID, product)).thenReturn(false);
//		this.personalizeController.operKey(eventAction);
//		// visible falso
//		Mockito.when(this.personalizeFacade.updateProductVisibility(DEFAULT_ID, product)).thenReturn(false);
//		this.personalizeController.operKey(eventAction);
//		Mockito.verify(this.personalizeFacade, Mockito.atLeastOnce()).updateProductOperability(DEFAULT_ID, product);
//		Mockito.verify(this.personalizeFacade, Mockito.atLeastOnce()).updateProductVisibility(DEFAULT_ID, product);
//		// ClientException
//		Mockito.when(this.personalizeFacade.updateProductOperability(DEFAULT_ID, product)).thenThrow(
//				new RestClientException("OK"));
//		Mockito.when(this.personalizeFacade.updateProductVisibility(DEFAULT_ID, product)).thenThrow(
//				new RestClientException("OK"));
//		this.personalizeController.operKey(eventAction);

	}

	@Test
	public void checkUpdateAlias() {
		this.product.setSubTypeProd("Account");
		this.personalizeController.setProductDto(product);
		this.personalizeController.setUpdateAccountIn(update);
		this.personalizeController.getUpdateAccountIn();
		this.personalizeController.setUpdateAccountOut(update);
		this.personalizeController.getUpdateAccountOut();
		// folio nulo
		Mockito.when(this.updateAliasFacade.updateSubject("12345656", update)).thenReturn(update);
		this.personalizeController.updateAlias();
		// folio no nulo
		Mockito.when(this.update.getFolio()).thenReturn("123456789");
		this.personalizeController.updateAlias();
		Mockito.verify(this.updateAliasFacade, Mockito.atLeastOnce()).updateSubject("12345656", update);

		// ClientException
		Mockito.when(this.updateAliasFacade.updateSubject("12345656", update)).thenThrow(new RestClientException("OK"));
		this.personalizeController.updateAlias();
	}
}
