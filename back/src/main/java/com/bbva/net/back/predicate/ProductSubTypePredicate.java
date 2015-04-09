/**
 * 
 */
package com.bbva.net.back.predicate;

import com.bbva.net.back.model.globalposition.ProductDto;
import com.bbva.net.core.collection.BbvaPredicate;

/**
 * @author User
 */
public class ProductSubTypePredicate extends BbvaPredicate<ProductDto> {

	private String subProductType;

	public ProductSubTypePredicate(final String subProductType) {
		this.subProductType = subProductType;
	}

	@Override
	protected boolean eval(final ProductDto product) {
		return product != null && product.getSubTypeProd() != null && product.getSubTypeProd().equals(subProductType);
	}

}
