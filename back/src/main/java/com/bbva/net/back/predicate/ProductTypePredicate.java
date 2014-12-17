/**
 * 
 */
package com.bbva.net.back.predicate;

import co.com.bbva.services.transactions.globalposition.schema.Product;

import com.bbva.net.core.collection.BbvaPredicate;


/**
 * @author User
 *
 */
public class ProductTypePredicate extends BbvaPredicate<Product> {

	
	private String productType;
	
	

	public ProductTypePredicate(final String productType) {		
		this.productType = productType;
	}

	@Override
	protected boolean eval(final Product product) {
		return product.getProductName().equals(productType);
	}

}
