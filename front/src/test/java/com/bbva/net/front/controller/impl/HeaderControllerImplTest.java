package com.bbva.net.front.controller.impl;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.web.client.RestClientException;

import com.bbva.net.back.facade.HeaderFacade;
import com.bbva.net.back.model.header.CustomerDto;
import com.bbva.net.back.model.header.ExecutiveDto;
import com.bbva.net.front.test.utils.AbstractBbvaControllerTest;

public class HeaderControllerImplTest extends AbstractBbvaControllerTest {

	private HeaderControllerImpl headerController;

	@Resource(name = "headerFacade")
	private transient HeaderFacade headerFacade;

	@Before
	public void init() {
		super.setUp();
		headerController = new HeaderControllerImpl();
		headerFacade = Mockito.mock(HeaderFacade.class);

	}

	@Test
	public void getCustomerOk() {
		CustomerDto customer = new CustomerDto();
		customer.setSegment("");
		Mockito.when(headerFacade.getCustomer(StringUtils.EMPTY, StringUtils.EMPTY, StringUtils.EMPTY)).thenReturn(
				customer);
		headerController.setHeaderFacade(headerFacade);
		headerController.init();
		CustomerDto cliente = headerController.getCustomer();
		Assert.assertNotNull(cliente);
		Mockito.when(httpSession.getAttribute("userName")).thenReturn("Name");
		Mockito.when(httpSession.getAttribute("docTypeUser")).thenReturn("CC");
		Mockito.when(httpSession.getAttribute("docIdUser")).thenReturn("1010101010");
		cliente = headerController.getCustomer();
		this.headerController.getCliente();
		Assert.assertNull(cliente);
	}

	@Test
	public void wormGetCustomer() {

		Mockito.when(headerFacade.getCustomer(StringUtils.EMPTY, StringUtils.EMPTY, StringUtils.EMPTY)).thenThrow(
				new RestClientException("OK"));

		headerController.getCustomer();
	}

	@Test
	public void getExecutiveOk() {
		ExecutiveDto executive = new ExecutiveDto();
		Mockito.when(headerFacade.getExecutive()).thenReturn(executive);
		executive = headerController.getEjecutivo();
		Assert.assertNull(executive);

	}

	@Test
	public void wormGetExecutive() {
		Mockito.when(headerFacade.getExecutive()).thenThrow(new RestClientException("Ok"));
		this.headerController.getExecutive();
	}
}
