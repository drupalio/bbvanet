/**
 * 
 */
package com.bbva.net.back.command;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;

import com.bbva.net.back.model.globalposition.ProductDTO;

/**
 * @author User
 */
public abstract class ProductVisitorCommand<T> {

	private List<ProductDTO> products = new ArrayList<ProductDTO>();

	/****************************** ABSTRACT METHODS *********************************/

	/**
	 * This pattern executes executes this method for each element in List<T>
	 * 
	 * @param object
	 */
	protected abstract ProductDTO getProduct(T object);

	/**
	 * Constructor and applies this pattern
	 * 
	 * @param list
	 */
	public ProductVisitorCommand(final List<T> list) {

		if (CollectionUtils.isEmpty(list)) {
			return;
		}

		for (final T object : list) {
			this.products.add(getProduct(object));
		}
	}

	public ProductVisitorCommand<T> add(ProductVisitorCommand<?> productVisitor) {

		products.addAll(productVisitor.getProducts());
		return this;
	}

	/**
	 * @return the products
	 */
	public List<ProductDTO> getProducts() {
		return products;
	}

}
