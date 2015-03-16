package com.bbva.net.back.mapper.impl;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.bbva.czic.dto.net.CardCharge;
import com.bbva.net.back.model.cards.CardsChargesDto;

/**
 * @author Entelgy
 */
public class CardsMapperImplTest {

	private CardsMapperImpl cardsMapper;

	@Before
	public void init() {
		this.cardsMapper = new CardsMapperImpl();

	}

	@Test
	public void checkgetCardsChargesByUser() {
		List<CardCharge> cardCharge = new ArrayList<CardCharge>();
		List<CardsChargesDto> cardChargeDto = cardsMapper.map(cardCharge);
		Assert.assertNotNull(cardChargeDto);

	}
}
