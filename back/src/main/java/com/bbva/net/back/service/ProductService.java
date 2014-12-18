/**
 * 
 */
package com.bbva.net.back.service;

import java.util.List;

import com.bbva.czic.dto.net.EnumProductType;
import com.bbva.net.back.model.commons.Money;
import com.bbva.net.back.model.globalposition.GlobalProductsDTO;
import com.bbva.net.back.model.globalposition.ProductDTO;

/**
 * @author User
 */
public interface ProductService {

	/**
	 * @param products
	 * @return
	 */
	Money getTotalCash(List<ProductDTO> products);

	/**
	 * @param products
	 * @return
	 */
	Money getTotalAssets(List<ProductDTO> products);

	/**
	 * @param products
	 * @return
	 */
	Money getTotalFinanciacion(List<ProductDTO> products);

	/**
	 * @param products
	 * @return
	 */
	Money getTotalProductsByType(List<ProductDTO> products, EnumProductType type);

	/***
	 * @param globalProduct
	 * @return
	 */
	List<ProductDTO> getProducts(GlobalProductsDTO globalProduct);

}
