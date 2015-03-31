package com.bbva.net.back.model.globalposition;

import java.math.BigDecimal;

import org.junit.Assert;
import org.junit.Test;

import com.bbva.net.back.model.cards.CardsChargesDto;
import com.bbva.net.back.model.commons.Money;
import com.bbva.net.core.test.AbstractBbvaDTOTest;

public class CreditCardDtoTest extends AbstractBbvaDTOTest<CreditCardDto> {

	@Override
	protected CreditCardDto getInstance() {
		return new CreditCardDto();
	}

	@Test
	public void checkCardsChargesDto() {
		CardsChargesDto cards = new CardsChargesDto("TC", new Money(new BigDecimal(1000)));
		Assert.assertNotNull(cards);
		Assert.assertEquals(cards.getAmmount().getAmount(), new BigDecimal(1000));
	}
}