package com.bbva.net.back.facade;

import java.util.List;
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
	
	/**
	 * 
	 * @param globalProducts
	 * @return
	 */
	Map<String, List<String>> getNamesProducts(GlobalProductsDTO globalProducts);
}
