package com.bbva.net.back.predicate;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.math.BigDecimal;

import org.junit.Test;

import com.bbva.net.back.model.commons.Money;
import com.bbva.net.back.model.movements.MovementDto;

public class IncomesPredicateTest {

	private static final Money NEGATIVE_AMOUNT = new Money(new BigDecimal("-15.15"));

	private static final Money POSITIVE_AMOUNT = new Money(new BigDecimal("37.28"));

	@Test
	public void checkIncomesPredicatedFalse() {

		// Check Negative Amount
		final IncomesPredicate incomesPredicated = new IncomesPredicate();

		final MovementDto movementDto = new MovementDto();
		movementDto.setMovementValue(NEGATIVE_AMOUNT);

		// Check
		assertFalse(incomesPredicated.eval(movementDto));

		// Check Null
		assertFalse(incomesPredicated.eval(null));

		// Check NO Amount
		assertFalse(incomesPredicated.eval(new MovementDto()));

		// Check amount Null
		movementDto.getMovementValue().setAmount(null);
		assertFalse(incomesPredicated.eval(movementDto));

	}

	@Test
	public void checkIncomesPredicatedTrue() {

		final IncomesPredicate incomesPredicated = new IncomesPredicate();

		final MovementDto movementDto = new MovementDto();
		movementDto.setMovementValue(POSITIVE_AMOUNT);

		// Check Positive
		assertTrue(incomesPredicated.eval(movementDto));

	}
}
