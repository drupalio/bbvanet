package com.bbva.net.back.facade.impl;

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
	public Boolean updateProductOperability(String idProduct, ProductDto productDto) {
		boolean respuesta = false;
		this.product = new Product();
		LOGGER.info("Comenzando mapeo del servicio de updateProductOperability (ProductoDto -> Product)"
				+ " ProductId: " + idProduct);
		this.product = personalizeAccountProductMapper.map(productDto);
		LOGGER.info("Llamando al servicio de updateProductOperability" + " product Id: " + product.getId());
		if (this.globalPositionService.updateProductOperability(idProduct, product).getStatus() == 200) {
			respuesta = true;
		}
		LOGGER.info("finalizando llamado de updateProductOperability" + " " + respuesta);
		return respuesta;
	}

	@Override
	public Boolean updateProductVisibility(String idProduct, ProductDto productDto) {
		boolean respuesta = false;
		this.product = new Product();
		LOGGER.info("Comenzando mapeo del servicio de updateProductVisibility (ProductoDto -> Product)"
				+ " ProductId: " + idProduct);
		this.product = personalizeAccountProductMapper.map(productDto);
		LOGGER.info("Llamando al servicio de updateProductVisibility" + " product Id: " + product.getId());
		if (this.globalPositionService.updateProductVisibility(idProduct, product).getStatus() == 200) {
			respuesta = true;
			LOGGER.info("finalizando llamado de updateProductVisibility" + " " + respuesta);
		}

		return respuesta;
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
