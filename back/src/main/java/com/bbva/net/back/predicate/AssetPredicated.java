/**
 * 
 */
package com.bbva.net.back.predicate;

import co.com.bbva.services.transactions.globalposition.schema.Product;

import com.bbva.net.core.collection.BbvaPredicate;

/**
 * @author User
 */
public class AssetPredicated extends BbvaPredicate<Product> {

	@Override
	protected boolean eval(Product product) {

		return product.isAsset();
	}

}
