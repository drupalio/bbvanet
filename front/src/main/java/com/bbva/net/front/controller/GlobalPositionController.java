package com.bbva.net.front.controller;

import co.com.bbva.services.transactions.globalposition.schema.GlobalProducts;

/**
 * @author Entelgy
 */
public interface GlobalPositionController {

	/**
	 * @return
	 */
	public GlobalProducts getCustomerProducts();
	
	public GlobalProducts getCustomerProductsVisible();
	
	public GlobalProducts getCustomerProductsNotVisible();
	
}
