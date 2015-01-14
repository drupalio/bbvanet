package com.bbva.net.back.facade.impl;

import java.util.ArrayList;

import javax.annotation.Resource;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import com.bbva.czic.dto.net.CardCharge;
import com.bbva.net.webservices.customers.CustomerService;

// import com.bbva.net.webservices.globalposition.GlobalPositionService;

public class CardsFacadeImplTest {

	private static final String DEFAULT_USER = "123";

	private CardsFacadeImpl cardsFacade;

	@Resource(name = "customerService")
	private CustomerService cardsCustomerService;

	@Before
	public void init() {
		this.cardsFacade = new CardsFacadeImpl();
		cardsCustomerService = Mockito.mock(CustomerService.class);
		this.cardsFacade.setCardsCustomerService(cardsCustomerService);
	}

	@Test
	public void checkgetCardsChargesByUser() {

		Mockito.when(cardsCustomerService.listCreditCardsCharges(DEFAULT_USER, "filtro")).thenReturn(
				new ArrayList<CardCharge>());
		// List<CardsChargesDto> value = cardsFacade.getCardsChargesByUser(DEFAULT_USER, dateRange);
		// Assert.assertNull(value);
		// Mockito.verify(this.cardsCustomerService, Mockito.atLeastOnce()).listCreditCardsCharges(DEFAULT_USER, filtro);

	}
}
