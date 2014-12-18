package com.bbva.net.back.predicate;

import com.bbva.net.back.model.globalposition.ProductDTO;
import com.bbva.net.core.collection.BbvaPredicate;

public class HiddenProductPredicate extends BbvaPredicate<ProductDTO> {

	/*
	 * @Override protected boolean eval(ProductDTO product) { return product.equals(false); }
	 */
	@Override
	protected boolean eval(ProductDTO productDTO) {
		return !productDTO.isVisible();
	}

}
