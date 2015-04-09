package com.bbva.net.back.predicate;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.bbva.net.back.model.globalposition.ProductDto;

public class VisibleProductPredicateTest {

	@Test
	public void checkVisibleProductPredicatedTrue() {

		//
		final VisibleProductPredicate visibleProductPredicated = new VisibleProductPredicate();

		final ProductDto productDto = new ProductDto();
		productDto.setVisible(true);

		// Check true
		assertTrue(visibleProductPredicated.eval(productDto));

	}

	@Test
	public void checkHiddenProductPredicatedFalse() {

		//
		final VisibleProductPredicate visibleProductPredicated = new VisibleProductPredicate();

		final ProductDto productDto = new ProductDto();
		productDto.setVisible(false);

		// Check
		assertFalse(visibleProductPredicated.eval(null));
		// Check false
		assertFalse(visibleProductPredicated.eval(productDto));
	}

}
