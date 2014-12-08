package com.bbva.net.front.controller;

import co.com.bbva.services.transactions.globalposition.schema.GlobalProducts;

/**
 * @author Entelgy
 */
public interface GlobalPositionController {

	/**
	 * @return
	 */
	GlobalProducts getCustomerProducts();

}
