package com.bbva.net.back.predicate;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.bbva.net.back.model.extract.ExtractDto;

public class ExtractPeriodPredicateTest {

	private static final String YEAR = "2005";

	@Test
	public void checkExtractPeriodPredicatedTrue() {

		// Check Negative Amount
		final ExtractPeriodPredicate extractPeriodPredicated = new ExtractPeriodPredicate(YEAR);

		final ExtractDto extractDto = new ExtractDto();
		extractDto.setYear(YEAR);

		// Check
		assertTrue(extractPeriodPredicated.eval(extractDto));

	}

	@Test
	public void checkExtractPeriodPredicatedFalse() {

		final ExtractPeriodPredicate extractPeriodPredicated = new ExtractPeriodPredicate(YEAR);

		final ExtractDto extractDto = new ExtractDto();
		extractDto.setYear(YEAR + 1);
		// Check another
		assertFalse(extractPeriodPredicated.eval(extractDto));

		// Check Null
		assertFalse(extractPeriodPredicated.eval(null));

		// Check NO Year
		assertFalse(extractPeriodPredicated.eval(new ExtractDto()));

		// Check extract year Null
		extractDto.setYear(null);
		assertFalse(extractPeriodPredicated.eval(extractDto));

	}

}
