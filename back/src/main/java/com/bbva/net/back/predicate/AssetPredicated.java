/**
 * 
 */
package com.bbva.net.back.predicate;

import com.bbva.net.back.model.globalposition.ProductDto;
import com.bbva.net.core.collection.BbvaPredicate;

/**
 * @author User
 */
public class AssetPredicated extends BbvaPredicate<ProductDto> {

	@Override
	protected boolean eval(ProductDto product) {
		return product.isAsset();
	}

}
