package com.bbva.net.front.controller;

import java.util.Map;

import com.bbva.net.back.model.globalposition.BalanceDto;
import com.bbva.net.back.model.globalposition.GlobalProductsDto;

/**
 * @author Entelgy
 */
public interface CardsController {

	/**
	 * @return
	 */
	GlobalProductsDto getCustomerProducts();

}
