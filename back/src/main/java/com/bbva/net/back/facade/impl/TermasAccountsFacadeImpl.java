package com.bbva.net.back.facade.impl;

import javax.annotation.Resource;

import com.bbva.czic.dto.net.Conditions;
import com.bbva.net.back.core.pattern.facade.AbstractBbvaFacade;
import com.bbva.net.back.core.stereotype.Facade;
import com.bbva.net.back.facade.TermasAccountsFacade;
import com.bbva.net.back.mapper.ConditionsMapper;
import com.bbva.net.back.model.accounts.TermsAccountsDto;
import com.bbva.net.webservices.products.ProductsService;

@Facade(value = "TermsFacade")
public class TermasAccountsFacadeImpl extends AbstractBbvaFacade implements TermasAccountsFacade {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4227089419683594718L;

	@Resource(name = "productsService")
	private ProductsService productsService;

	@Resource(name = "conditionsMapper")
	private ConditionsMapper mapper;

	@Override
	public TermsAccountsDto getAllConditions(String numCuenta) {
		final Conditions condiciones = this.productsService.getConditions(numCuenta);
		return mapper.map(condiciones);
	}


	/**
	 * @param productsService the productsService to set
	 */

	public void setProductsService(ProductsService productsService) {
		this.productsService = productsService;
	}

	/**
	 * @param mapper the mapper to set
	 */

	public void setMapper(ConditionsMapper mapper) {
		this.mapper = mapper;
	}

}
