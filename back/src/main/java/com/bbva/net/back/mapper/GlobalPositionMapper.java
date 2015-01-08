package com.bbva.net.back.mapper;

import java.util.List;

import com.bbva.czic.dto.net.Product;
import com.bbva.net.back.model.globalposition.GlobalProductsDto;

public interface GlobalPositionMapper {

	/**
	 * @param products
	 * @return
	 */
	GlobalProductsDto map(List<Product> products);
}
