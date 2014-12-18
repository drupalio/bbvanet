package com.bbva.net.back.mapper;

import java.util.List;

import com.bbva.czic.dto.net.Product;
import com.bbva.net.back.model.globalposition.GlobalProductsDTO;

/**
 * @author Entelgy
 */
public interface GlobalPositionMapper {

	/**
	 * @param products
	 * @return
	 */
	GlobalProductsDTO map(List<Product> products);

}
