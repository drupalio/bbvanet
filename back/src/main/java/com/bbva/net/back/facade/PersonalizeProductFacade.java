package com.bbva.net.back.facade;

import javax.ws.rs.core.Response;

import com.bbva.net.back.model.globalposition.ProductDto;

public interface PersonalizeProductFacade {

	public void updateProductOperability(String idProduct, ProductDto productDto);

	public Response updateProductVisibility(String idProduct, ProductDto productDto);

}
