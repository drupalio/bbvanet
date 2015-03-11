package com.bbva.net.back.predicate;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.bbva.net.back.model.extract.ExtractDto;

public class ExtractDocumentPredicateTest {

	private static final String MONTH = "01";

	private static final String YEAR = "2005";

	@Test
	public void checkExtractDocumentPredicatedTrue() {

		// Check Negative Amount
		final ExtractDocumentPredicate extractDocumentPredicated = new ExtractDocumentPredicate(MONTH, YEAR);

		final ExtractDto extractDto = new ExtractDto();
		extractDto.setMonth(MONTH);
		extractDto.setYear(YEAR);

		// Check
		assertTrue(extractDocumentPredicated.eval(extractDto));

	}

	@Test
	public void checkExtractDocumentPredicatedFalse() {

		final ExtractDocumentPredicate extractDocumentPredicated = new ExtractDocumentPredicate(MONTH, YEAR);

		final ExtractDto extractDto = new ExtractDto();
		extractDto.setMonth(MONTH + 1);
		extractDto.setYear(YEAR + 1);

		// Check another
		assertFalse(extractDocumentPredicated.eval(extractDto));

		extractDto.setMonth(MONTH);
		extractDto.setYear(YEAR + 1);
		// Check another
		assertFalse(extractDocumentPredicated.eval(extractDto));

		extractDto.setMonth(MONTH + 1);
		extractDto.setYear(YEAR);
		// Check another
		assertFalse(extractDocumentPredicated.eval(extractDto));
		// Check Null
		assertFalse(extractDocumentPredicated.eval(null));

		// Check NO Extract
		assertFalse(extractDocumentPredicated.eval(new ExtractDto()));

		// Check extract month Null
		extractDto.setMonth(null);
		assertFalse(extractDocumentPredicated.eval(extractDto));

		// Check extract year Null
		extractDto.setYear(null);
		assertFalse(extractDocumentPredicated.eval(extractDto));

	}

}
