/**
 * 
 */
package com.bbva.net.back.model.cards;

import java.math.BigDecimal;

import org.junit.Assert;
import org.junit.Test;

import com.bbva.net.back.model.commons.Money;
import com.bbva.net.core.test.AbstractBbvaDTOTest;

/**
 * @author Entelgy
 */
public class CardsChargesDtoTest extends AbstractBbvaDTOTest<CardsChargesDto> {

	private CardsChargesDto cardsChargesDto;

	@Override
	protected CardsChargesDto getInstance() {
		this.cardsChargesDto = new CardsChargesDto();
		return this.cardsChargesDto;
	}

	@Test
	public void checkCardsChargesDto() {
		cardsChargesDto = new CardsChargesDto("TC", new Money(new BigDecimal(1000)));
		Assert.assertNotNull(cardsChargesDto);
		Assert.assertEquals(cardsChargesDto.getAmmount().getAmount(), new BigDecimal(1000));
	}
}
