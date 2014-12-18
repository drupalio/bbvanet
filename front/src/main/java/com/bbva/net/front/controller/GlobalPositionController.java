package com.bbva.net.front.controller;

import java.util.Map;

import com.bbva.czic.dto.net.EnumProductType;
import com.bbva.net.back.model.commons.Money;
import com.bbva.net.back.model.globalposition.GlobalProductsDTO;

/**
 * @author Entelgy
 */
public interface GlobalPositionController {

	/**
	 * @return
	 */
	GlobalProductsDTO getCustomerProducts();

	/**
	 * @return
	 */
	GlobalProductsDTO getCustomerProductsHidden();

	/**
	 * 
	 */
	void renderPieSituation();

	/**
	 * 
	 */
	void renderPieAssets();

	/**
	 * 
	 */
	void renderPieFinanciation();

	/**
	 * @return
	 */
	Map<EnumProductType, Money> getTotalsProducts();

}
