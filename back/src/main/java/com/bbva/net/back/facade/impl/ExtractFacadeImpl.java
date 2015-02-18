package com.bbva.net.back.facade.impl;

import java.util.List;

import javax.annotation.Resource;

import com.bbva.net.back.core.pattern.facade.AbstractBbvaFacade;
import com.bbva.net.back.core.stereotype.Facade;
import com.bbva.net.back.facade.ExtractFacade;
import com.bbva.net.back.model.extract.ExtractDto;
import com.bbva.net.webservices.products.ProductsService;

@Facade(value = "extractFacade")
public class ExtractFacadeImpl extends AbstractBbvaFacade implements ExtractFacade {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3532178233798826755L;

	@Resource(name = "productsService")
	protected ProductsService productsService;

	@Override
	public List<ExtractDto> getExtractAvailablePeriod(String productId, String filter) {
		productsService.listExtracts(productId, filter);
		return null;
	}

}
