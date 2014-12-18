package com.bbva.net.front.controller;

import com.bbva.net.back.model.globalposition.GlobalProductsDTO;

/**
 * @author Entelgy
 */
public interface GlobalPositionController {

	/**
	 * @return
	 */

	public GlobalProductsDTO getCustomerProductsVisible();

	public GlobalProductsDTO getCustomerProductsNotVisible();

	GlobalProductsDTO getCustomerProducts();
}
