/**
 * 
 */
package com.bbva.net.back.predicate;

import com.bbva.czic.dto.net.EnumProductType;
import com.bbva.net.back.model.globalposition.ProductDto;
import com.bbva.net.core.collection.BbvaPredicate;

/**
 * @author User
 */
public class ProductTypePredicate extends BbvaPredicate<ProductDto> {

	private EnumProductType productType;

	public ProductTypePredicate(final EnumProductType productType) {
		this.productType = productType;
	}

	@Override
	protected boolean eval(final ProductDto product) {
		return product.getTypeProd().equals(productType);
	}

}
