package com.bbva.net.back.predicate;

import com.bbva.net.back.model.globalposition.ProductDto;
import com.bbva.net.core.collection.BbvaPredicate;

public class HiddenProductPredicate extends BbvaPredicate<ProductDto> {

	@Override
	protected boolean eval(ProductDto productDTO) {
		
		if (productDTO!=null && productDTO.isVisible()!=null ){
				return !productDTO.isVisible();
		}
		return false;
	}

}
