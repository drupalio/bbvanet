/**
 * 
 */
package com.bbva.net.back.predicate;

import com.bbva.czic.dto.net.EnumProductType;
import com.bbva.net.back.model.globalposition.ProductDTO;
import com.bbva.net.core.collection.BbvaPredicate;

/**
 * @author User
 */
public class ProductTypePredicate extends BbvaPredicate<ProductDTO> {

	private EnumProductType productType;

	public ProductTypePredicate(final EnumProductType productType) {
		this.productType = productType;
	}

	@Override
	protected boolean eval(final ProductDTO product) {
		return product.getTypeProd().equals(productType);
	}

}
