/**
 * 
 */
package com.bbva.net.back.model.cards;

import org.junit.Assert;
import org.mockito.Mockito;

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

	/**
	 * Invoke Equals Method
	 */
	@Override
	public void checkEqualsMethod() {
		Assert.assertNotNull(this.cardsChargesDto.equals(null));
		Mockito.when(this.cardsChargesDto.equals(null)).thenReturn(true);
		// Assert.assertSame(expected, actual);
	}

}
