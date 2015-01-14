package com.bbva.net.back.facade.impl;

import java.util.ArrayList;
import java.util.Date;

import javax.annotation.Resource;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import com.bbva.czic.dto.net.CardCharge;
import com.bbva.net.back.model.commons.DateRangeDto;
import com.bbva.net.back.service.FiqlService;
import com.bbva.net.webservices.customers.CustomerService;

// import com.bbva.net.webservices.globalposition.GlobalPositionService;

public class CardsFacadeImplTest {

	private static final String DEFAULT_USER = "123";

	private CardsFacadeImpl cardsFacade;

	@Resource(name = "customerService")
	private CustomerService cardsCustomerService;

	@Resource(name = "fiqlService")
	private FiqlService fiqlService;

	DateRangeDto dateRange;

	@Before
	public void init() {
		this.cardsFacade = new CardsFacadeImpl();
		cardsCustomerService = Mockito.mock(CustomerService.class);
		this.cardsFacade.setCardsCustomerService(cardsCustomerService);
		dateRange = new DateRangeDto();
		Date a = new Date();
		dateRange.setDateSince(a);
		dateRange.setDateTo(a);

	}

	@Test
	public void checkgetCardsChargesByUser() {

		// Mockito.when(fiqlService.getFiqlQueryByDateRange(dateRange));
		Mockito.when(cardsCustomerService.listCreditCardsCharges(DEFAULT_USER, "filtro")).thenReturn(
				new ArrayList<CardCharge>());
		// List<CardsChargesDto> value = cardsFacade.getCardsChargesByUser(DEFAULT_USER, dateRange);
		// Assert.assertNull(value);
		// Mockito.verify(this.cardsCustomerService, Mockito.atLeastOnce()).listCreditCardsCharges(DEFAULT_USER, "filtro");

	}
}
