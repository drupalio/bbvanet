/**
 * 
 */
package com.bbva.net.back.service;

import java.util.List;
import java.util.Map;

import com.bbva.czic.dto.net.EnumProductType;
import com.bbva.net.back.model.commons.Money;
import com.bbva.net.back.model.globalposition.GlobalProductsDTO;
import com.bbva.net.back.model.globalposition.ProductDTO;
import com.bbva.net.core.collection.BbvaPredicate;

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
	List<ProductDTO> getProducts(GlobalProductsDTO globalProducts);

	/**
	 * @param globalProducts
	 * @return
	 */
	Map<EnumProductType, Money> getTotals(GlobalProductsDTO globalProducts);

	/**
	 * @param globalProducts
	 * @param predicate
	 * @return
	 */
	GlobalProductsDTO select(final GlobalProductsDTO globalProducts, BbvaPredicate<ProductDTO> predicate);

}
