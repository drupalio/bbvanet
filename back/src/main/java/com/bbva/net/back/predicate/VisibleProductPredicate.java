package com.bbva.net.back.predicate;

import com.bbva.net.back.model.globalposition.ProductDto;
import com.bbva.net.core.collection.BbvaPredicate;

public class VisibleProductPredicate extends BbvaPredicate<ProductDto> {

	@Override
	protected boolean eval(ProductDto productDTO) {
		return productDTO ==null || productDTO.isVisible()==null || productDTO.isVisible();
	}

}
