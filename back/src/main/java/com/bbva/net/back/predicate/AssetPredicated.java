/**
 * 
 */
package com.bbva.net.back.predicate;

import com.bbva.net.back.model.globalposition.ProductDTO;
import com.bbva.net.core.collection.BbvaPredicate;

/**
 * @author User
 */
public class AssetPredicated extends BbvaPredicate<ProductDTO> {

	@Override
	protected boolean eval(ProductDTO product) {
		return product.isAsset();
	}

}
