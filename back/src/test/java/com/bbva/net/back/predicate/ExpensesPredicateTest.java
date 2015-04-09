package com.bbva.net.back.predicate;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.math.BigDecimal;

import org.junit.Test;

import com.bbva.net.back.model.commons.Money;
import com.bbva.net.back.model.movements.MovementDto;

public class ExpensesPredicateTest {

	private static final Money NEGATIVE_AMOUNT = new Money(new BigDecimal("-15.15"));

	private static final Money POSITIVE_AMOUNT = new Money(new BigDecimal("37.28"));

	@Test
	public void checkExpensesPredicatedTrue() {

		// Check Negative Amount
		final ExpensesPredicate expensesPredicated = new ExpensesPredicate();

		final MovementDto movementDto = new MovementDto();
		movementDto.setMovementValue(NEGATIVE_AMOUNT);

		// Check
		assertTrue(expensesPredicated.eval(movementDto));

	}

	@Test
	public void checkExpensesPredicatedFalse() {

		final ExpensesPredicate expensesPredicated = new ExpensesPredicate();

		final MovementDto movementDto = new MovementDto();
		movementDto.setMovementValue(POSITIVE_AMOUNT);

		// Check Positive
		assertFalse(expensesPredicated.eval(movementDto));

		// Check Null
		assertFalse(expensesPredicated.eval(null));

		// Check NO Amount
		assertFalse(expensesPredicated.eval(new MovementDto()));

		// Check amount Null
		movementDto.getMovementValue().setAmount(null);
		assertFalse(expensesPredicated.eval(movementDto));

	}

}
