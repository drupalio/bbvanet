package com.bbva.net.back.facade.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import com.bbva.czic.dto.net.CardCharge;
import com.bbva.net.back.mapper.CardsMapper;
import com.bbva.net.back.model.cards.CardsChargesDto;
import com.bbva.net.back.model.commons.DateRangeDto;
import com.bbva.net.back.service.FiqlService;
import com.bbva.net.webservices.cards.CardService;
import com.bbva.net.webservices.customers.CustomerService;

// import com.bbva.net.webservices.globalposition.GlobalPositionService;

public class CardsFacadeImplTest {

	private static final String DEFAULT_USER = "123";

	private CardsFacadeImpl cardsFacade;

	@Resource(name = "customerService")
	private CustomerService cardsCustomerService;

	@Resource(name = "fiqlService")
	private FiqlService fiqlService;

	@Resource(name = "cardsMapper")
	private CardsMapper cardsMapper;

	@Resource(name = "cardService")
	private CardService cardChargeService;

	DateRangeDto dateRange;

	@Before
	public void init() {
		this.cardsFacade = new CardsFacadeImpl();
		this.fiqlService = Mockito.mock(FiqlService.class);
		this.cardsCustomerService = Mockito.mock(CustomerService.class);
		this.cardChargeService = Mockito.mock(CardService.class);
		this.cardsMapper = Mockito.mock(CardsMapper.class);
		this.cardsFacade.setFiqlService(fiqlService);
		this.cardsFacade.setCardsCustomerService(cardsCustomerService);
		this.cardsFacade.setCardsMapper(cardsMapper);
		this.cardsFacade.setCardChargeService(cardChargeService);
	}

	@Test
	public void checkgetCardsChargesByUser() {
		dateRange = new DateRangeDto();
		Date a = new Date();
		dateRange.setDateSince(a);
		dateRange.setDateTo(a);

		Mockito.when(fiqlService.getFiqlQueryByDateRange(dateRange, null, null)).thenReturn("");
		List<CardCharge> cardCharge = new ArrayList<CardCharge>();
		Mockito.when(cardsCustomerService.listCreditCardsCharges(DEFAULT_USER, "")).thenReturn(cardCharge);

		Mockito.when(cardsMapper.map(cardCharge)).thenReturn(new ArrayList<CardsChargesDto>());

		List<CardsChargesDto> value = cardsFacade.getCardsChargesByUser(DEFAULT_USER, dateRange);
		Assert.assertNotNull(value);
		Mockito.verify(this.cardsCustomerService, Mockito.atLeastOnce()).listCreditCardsCharges(DEFAULT_USER, "");

	}

	@Test
	public void checkgetCardsChargesFilter() {
		dateRange = new DateRangeDto();
		Date a = new Date();
		dateRange.setDateSince(a);
		dateRange.setDateTo(a);

		Mockito.when(fiqlService.getFiqlQueryByDateRange(dateRange, null, null)).thenReturn("");
		List<CardCharge> cardCharge = new ArrayList<CardCharge>();
		Mockito.when(cardChargeService.getCreditCardCharges(DEFAULT_USER, "", "", "", "")).thenReturn(cardCharge);

		Mockito.when(cardsMapper.map(cardCharge)).thenReturn(new ArrayList<CardsChargesDto>());

		List<CardsChargesDto> value = cardsFacade.getCardsChargesFilter(DEFAULT_USER, dateRange);
		Assert.assertNotNull(value);
		Mockito.verify(this.cardChargeService, Mockito.atLeastOnce())
				.getCreditCardCharges(DEFAULT_USER, "", "", "", "");

	}
}
