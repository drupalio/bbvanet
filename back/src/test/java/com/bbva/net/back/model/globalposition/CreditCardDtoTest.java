package com.bbva.net.back.model.globalposition;

import java.math.BigDecimal;

import org.junit.Assert;
import org.junit.Test;

import com.bbva.net.back.model.commons.Money;
import com.bbva.net.core.test.AbstractBbvaDTOTest;

public class CreditCardDtoTest extends AbstractBbvaDTOTest<CreditCardDto> {

	private CreditCardDto creditCard;

	@Override
	protected CreditCardDto getInstance() {
		this.creditCard = new CreditCardDto();
		return creditCard;
	}

	@Test
	public void checkBinCreditCard() {
		creditCard.setBin(new Money(new BigDecimal(1000)));
		Assert.assertEquals(creditCard.getBin().getAmount(), new BigDecimal(1000));
	}

	@Test
	public void checkBinCard() {
		this.creditCard = new CreditCardDto();
		Assert.assertFalse(this.creditCard.isSetBin());

		this.creditCard = new CreditCardDto(new Money(new BigDecimal(1000)));
		Assert.assertTrue(this.creditCard.isSetBin());
	}
}