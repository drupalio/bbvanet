/**
 * 
 */
package com.bbva.net.back.service;

import java.util.List;

import co.com.bbva.services.transactions.globalposition.schema.GlobalProducts;
import co.com.bbva.services.transactions.globalposition.schema.Product;

import com.bbva.net.back.model.commons.Money;

/**
 * @author User
 */
public interface ProductService {

	/**
	 * @param products
	 * @return
	 */
	Money getTotalCash(List<Product> products);

	/**
	 * @param products
	 * @return
	 */
	Money getTotalAssets(List<Product> products);

	/**
	 * @param products
	 * @return
	 */
	Money getTotalFinanciacion(List<Product> products);

	/**
	 * @param products
	 * @return
	 */
	Money getTotalProductsByType(List<Product> products, String type);

	
	
	/***
	 * 
	 * @param globalProduct
	 * @return
	 */
	List<Product> getProducts(GlobalProducts globalProduct);

}
