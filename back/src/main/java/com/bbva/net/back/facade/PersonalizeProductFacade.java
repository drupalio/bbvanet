package com.bbva.net.back.facade;

import com.bbva.net.back.model.globalposition.ProductDto;

public interface PersonalizeProductFacade {

	public Boolean updateProductOperability(String idProduct, ProductDto productDto);

	public Boolean updateProductVisibility(String idProduct, ProductDto productDto);

}
