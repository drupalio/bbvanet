package com.bbva.net.back.predicate;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.bbva.net.back.model.checkbook.CheckDto;

public class CheckStatusPredicateTest {

	@Test
	public void checkStatusPredicatedTrue() {

		final CheckStatusPredicate checkStatusPredicated = new CheckStatusPredicate();
		final CheckDto checkDto = new CheckDto("1231231");
		// Check 0
		checkDto.setStatus("0");
		assertTrue(checkStatusPredicated.eval(checkDto));

		checkDto.setStatus("1");
		assertTrue(checkStatusPredicated.eval(checkDto));

		checkDto.setStatus("2");
		assertTrue(checkStatusPredicated.eval(checkDto));

		checkDto.setStatus("3");
		assertTrue(checkStatusPredicated.eval(checkDto));

		checkDto.setStatus("4");
		assertTrue(checkStatusPredicated.eval(checkDto));

		checkDto.setStatus("8");
		assertTrue(checkStatusPredicated.eval(checkDto));

	}

	@Test
	public void checkStatusPredicatedFalse() {
		// Check Null
		final CheckStatusPredicate checkStatusPredicated = new CheckStatusPredicate();
		assertFalse(checkStatusPredicated.eval(null));

		// Id Null
		assertFalse(checkStatusPredicated.eval(new CheckDto()));

		// Status Empty
		final CheckDto checkDto = new CheckDto("213123");
		checkDto.setStatus("");
		assertFalse(checkStatusPredicated.eval(checkDto));

	}

}
