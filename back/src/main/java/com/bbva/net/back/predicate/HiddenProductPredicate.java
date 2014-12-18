package com.bbva.net.back.predicate;

import com.bbva.net.back.model.globalposition.ProductDTO;
import com.bbva.net.core.collection.BbvaPredicate;

public class HiddenProductPredicate extends BbvaPredicate {

	@Override
	protected boolean eval(Object object) {

		ProductDTO product = (ProductDTO)object;
		System.out.println(product.getProductID());
		// return product.getVisible().equalsIgnoreCase(true);
		return false;

	}

}
