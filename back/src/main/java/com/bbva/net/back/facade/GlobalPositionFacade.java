package com.bbva.net.back.facade;

import java.util.List;
import java.util.Map;

import com.bbva.net.back.model.globalposition.BalanceDto;
import com.bbva.net.back.model.globalposition.GlobalProductsDto;

/**
 * @author Entelgy
 */
public interface GlobalPositionFacade {

	/**
	 * @param user
	 * @return
	 */
	GlobalProductsDto getGlobalProductsByUser(String user);

	/**
	 * @return
	 */
	GlobalProductsDto getGlobalProductsVisibles(GlobalProductsDto globalProductsDTO);

	/**
	 * @return
	 */
	GlobalProductsDto getGlobalProductsHidden(GlobalProductsDto globalProductsDTO);

	/**
	 * @param globalProductsDTO
	 * @return
	 */
	Map<String, BalanceDto> getTotalsByProduct(GlobalProductsDto globalProductsDTO);
	
	/**
	 * 
	 * @param globalProducts
	 * @return
	 */
	Map<String, List<String>> getNamesProducts(GlobalProductsDto globalProducts);
}
