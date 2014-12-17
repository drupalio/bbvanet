package com.bbva.net.back.predicate;

import org.apache.commons.collections.CollectionUtils;

import co.com.bbva.services.transactions.globalposition.schema.Account;
import co.com.bbva.services.transactions.globalposition.schema.Product;

import com.bbva.net.back.model.globalposition.PersonalAccountDTO;
import com.bbva.net.back.model.globalposition.ProductDTO;
import com.bbva.net.core.collection.BbvaPredicate;

public class HiddenProductPredicate extends BbvaPredicate{

/*	@Override
	protected boolean eval(ProductDTO product) {
		
		return product.equals(false);
	}
*/
	@Override
	protected boolean eval(Object object) {
		
		ProductDTO product=(ProductDTO) object;
		System.out.println(product.getProductID());
		return product.getProductID().equalsIgnoreCase("19");
		
		//Account product=(Account) object;
		//return product.getProduct().getProductId().equalsIgnoreCase("19");
	}	
	
}
