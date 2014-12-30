package com.bbva.net.back.facade;

import java.util.Map;

import com.bbva.net.back.model.globalposition.BalanceDTO;
import com.bbva.net.back.model.globalposition.GlobalProductsDTO;

/**
 * @author Entelgy
 */
public interface GlobalPositionFacade {

	/**
	 * @param user
	 * @return
	 */
	GlobalProductsDTO getGlobalProductsByUser(String user);

	/**
	 * @return
	 */
	GlobalProductsDTO getGlobalProductsVisibles(GlobalProductsDTO globalProductsDTO);

	/**
	 * @return
	 */
	GlobalProductsDTO getGlobalProductsHidden(GlobalProductsDTO globalProductsDTO);

	/**
	 * @param globalProductsDTO
	 * @return
	 */
	Map<String, BalanceDTO> getTotalsByProduct(GlobalProductsDTO globalProductsDTO);
}
