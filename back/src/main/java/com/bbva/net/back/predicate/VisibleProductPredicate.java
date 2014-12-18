package com.bbva.net.back.predicate;

import com.bbva.net.back.model.globalposition.ProductDTO;
import com.bbva.net.core.collection.BbvaPredicate;

public class VisibleProductPredicate extends BbvaPredicate<ProductDTO> {

	@Override
	protected boolean eval(ProductDTO productDTO) {
		return productDTO.isVisible();
	}

}
