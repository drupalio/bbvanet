package com.bbva.net.back.facade;

import com.bbva.net.back.model.globalposition.ProductDto;

public interface PersonalizeProductFacade {

	public void updateProductOperability(String idProduct, ProductDto productDto);

	public void updateProductVisibility(String idProduct, ProductDto productDto);

}
