package com.bbva.net.back.predicate;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.bbva.czic.dto.net.EnumProductType;
import com.bbva.net.back.model.globalposition.ProductDto;

public class ProductTypePredicateTest {

	private static final EnumProductType ANOTHER_PRODUCT_TYPE = EnumProductType.LO;

	@Test
	public void checkProductTypePredicatedFalse() {

		// Check Negative Amount
		final ProductTypePredicate productTypePredicate = new ProductTypePredicate(EnumProductType.TC);
		final ProductDto productDto = new ProductDto();
		// Check
		assertFalse(productTypePredicate.eval(productDto));

		// Check another
		productDto.setTypeProd(ANOTHER_PRODUCT_TYPE);
		assertFalse(productTypePredicate.eval(productDto));

		// Check Null
		assertFalse(productTypePredicate.eval(null));

	}

	@Test
	public void checkProductTypePredicatedTrue() {

		final ProductTypePredicate incomesPredicated = new ProductTypePredicate(EnumProductType.TC);

		final ProductDto productDto = new ProductDto();
		productDto.setTypeProd(EnumProductType.TC);

		// Check Positive
		assertTrue(incomesPredicated.eval(productDto));

	}

}
