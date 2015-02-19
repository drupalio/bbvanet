package com.bbva.net.back.facade.impl;

import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;

import com.bbva.czic.dto.net.Extracto;
import com.bbva.net.back.core.pattern.facade.AbstractBbvaFacade;
import com.bbva.net.back.core.stereotype.Facade;
import com.bbva.net.back.facade.ExtractFacade;
import com.bbva.net.back.mapper.ExtractMapper;
import com.bbva.net.back.model.extract.ExtractDto;
import com.bbva.net.webservices.products.ProductsService;

/**
 * @author Entelgy
 */
@Facade(value = "extractFacade")
public class ExtractFacadeImpl extends AbstractBbvaFacade implements ExtractFacade {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3532178233798826755L;

	/**
	 * 
	 */
	@Resource(name = "productsService")
	protected ProductsService productsService;

	/**
	 * 
	 */
	@Resource(name = "extractMapper")
	protected ExtractMapper extractMapper;

	/**
	 * 
	 */
	@Override
	public List<ExtractDto> getExtractAvailablePeriod(final String productId, final String $filter) {

		final String filter = StringUtils.isEmpty($filter) ? StringUtils.EMPTY : "fiqlService.getFiqlQuery";
		final List<Extracto> response = this.productsService.listExtracts(productId, filter);
		return this.extractMapper.map(response);
	}

	public void setProductsService(ProductsService productsService) {
		this.productsService = productsService;
	}

	public void setExtractMapper(ExtractMapper extractMapper) {
		this.extractMapper = extractMapper;
	}

}
