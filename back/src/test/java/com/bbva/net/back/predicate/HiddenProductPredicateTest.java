package com.bbva.net.back.predicate;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.bbva.net.back.model.globalposition.ProductDto;

public class HiddenProductPredicateTest {

	@Test
	public void checkHiddenProductPredicatedTrue() {

		//
		final HiddenProductPredicate hiddenProductPredicated = new HiddenProductPredicate();

		final ProductDto productDto = new ProductDto();
		productDto.setVisible(false);

		// Check true
		assertTrue(hiddenProductPredicated.eval(productDto));

	}

	@Test
	public void checkHiddenProductPredicatedFalse() {

		//
		final HiddenProductPredicate hiddenProductPredicated = new HiddenProductPredicate();

		final ProductDto productDto = new ProductDto();
		productDto.setVisible(true);

		// Check
		assertFalse(hiddenProductPredicated.eval(null));
		// Check false
		assertFalse(hiddenProductPredicated.eval(productDto));
	}

}
