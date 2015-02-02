package com.bbva.net.back.facade.impl;

import javax.ws.rs.core.Response;
import javax.annotation.Resource;

import com.bbva.czic.dto.net.Product;
import com.bbva.net.back.core.pattern.facade.AbstractBbvaFacade;
import com.bbva.net.back.core.stereotype.Facade;
import com.bbva.net.back.facade.PersonalizeProductFacade;
import com.bbva.net.back.mapper.PersonalizeAccountProductMapper;
import com.bbva.net.back.model.globalposition.ProductDto;
import com.bbva.net.webservices.globalposition.GlobalPositionService;

@Facade(value = "personalizeProductAccountFacade")
public class PersonalizeProductFacadeImpl extends AbstractBbvaFacade implements PersonalizeProductFacade {

	private static final long serialVersionUID = -8535409693026365524L;

	// CLIENTE REST
	@Resource(name = "globalPositionService")
	private GlobalPositionService globalPositionService;

	@Resource(name = "personalizeProductMapper")
	private PersonalizeAccountProductMapper personalizeAccountProductMapper;

	private Product product;

	@Override
	public void updateProductOperability(String idProduct, ProductDto productDto) {
		this.product = personalizeAccountProductMapper.map(productDto);
		this.globalPositionService.updateProductOperability(idProduct, product);
	}

	@Override
	public Response updateProductVisibility(String idProduct, ProductDto productDto) {
		this.product = personalizeAccountProductMapper.map(productDto);
		final Response response = this.globalPositionService.updateProductVisibility(idProduct, product);
		return response;
	}

	public void setGlobalPositionService(GlobalPositionService globalPositionService) {
		this.globalPositionService = globalPositionService;
	}

	public PersonalizeAccountProductMapper getPersonalizeAccountProductMapper() {
		return personalizeAccountProductMapper;
	}

	public void setPersonalizeAccountProductMapper(PersonalizeAccountProductMapper personalizeAccountProductMapper) {
		this.personalizeAccountProductMapper = personalizeAccountProductMapper;
	}

}
