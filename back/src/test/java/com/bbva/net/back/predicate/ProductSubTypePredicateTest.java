package com.bbva.net.back.predicate;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.bbva.net.back.model.globalposition.ProductDto;

public class ProductSubTypePredicateTest {

	private static final String PRODUCT_SUB_TYPE = "AH";

	private static final String ANOTHER_SUB_TYPE = "LS";

	@Test
	public void checkSubProductTypePredicatedFalse() {

		// Check Negative Amount
		final ProductSubTypePredicate productSubTypePredicate = new ProductSubTypePredicate(PRODUCT_SUB_TYPE);
		final ProductDto productDto = new ProductDto();
		// Check
		assertFalse(productSubTypePredicate.eval(productDto));

		// Check another
		productDto.setSubTypeProd(ANOTHER_SUB_TYPE);
		assertFalse(productSubTypePredicate.eval(productDto));

		// Check Null
		assertFalse(productSubTypePredicate.eval(null));

	}

	@Test
	public void checkSubProductTypePredicatedTrue() {

		final ProductSubTypePredicate productSubTypePredicate = new ProductSubTypePredicate(PRODUCT_SUB_TYPE);

		final ProductDto productDto = new ProductDto();
		productDto.setSubTypeProd(PRODUCT_SUB_TYPE);

		// Check Positive
		assertTrue(productSubTypePredicate.eval(productDto));

	}

}
