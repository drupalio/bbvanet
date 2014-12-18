package com.bbva.net.back.facade.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.web.client.RestClientException;

import com.bbva.czic.dto.net.EnumProductType;
import com.bbva.czic.dto.net.Product;
import com.bbva.net.back.core.pattern.facade.AbstractBbvaFacade;
import com.bbva.net.back.core.stereotype.Facade;
import com.bbva.net.back.facade.GlobalPositionFacade;
import com.bbva.net.back.mapper.GlobalPositionMapper;
import com.bbva.net.back.model.commons.Money;
import com.bbva.net.back.model.globalposition.GlobalProductsDTO;
import com.bbva.net.back.predicate.HiddenProductPredicate;
import com.bbva.net.back.predicate.VisibleProductPredicate;
import com.bbva.net.back.service.ProductService;
import com.bbva.net.webservices.globalposition.GlobalPositionService;

// import com.bbva.net.webservices.globalposition.GlobalPositionService;

@Facade(value = "globalPositionFacade")
public class GlobalPositionFacadeImpl extends AbstractBbvaFacade implements GlobalPositionFacade {

	private static final long serialVersionUID = -8133045188591147282L;

	// CLIENTE REST
	@Resource(name = "globalPositionService")
	private GlobalPositionService globalPositionService;

	@Resource(name = "globalPositionMapper")
	private GlobalPositionMapper globalPositionMapper;

	@Resource(name = "productService")
	private ProductService productService;

	@Override
	public GlobalProductsDTO getGlobalProductsByUser(final String user) throws RestClientException {

		final List<Product> response = this.globalPositionService.getExtractGlobalBalance(user, null, null, null, null);
		return globalPositionMapper.map(response);

	}

	@Override
	public GlobalProductsDTO getGlobalProductsVisibles(final GlobalProductsDTO globalProductsDTO) {
		return productService.select(globalProductsDTO, new VisibleProductPredicate());
	}

	@Override
	public GlobalProductsDTO getGlobalProductsHidden(final GlobalProductsDTO globalProductsDTO) {
		return productService.select(globalProductsDTO, new HiddenProductPredicate());
	}

	@Override
	public Map<EnumProductType, Money> getTotalsByProduct(GlobalProductsDTO globalProductsDTO) {
		return productService.getTotals(globalProductsDTO);
	}

	/**
	 * @param globalPositionService
	 */
	public void setGlobalPositionService(final GlobalPositionService globalPositionService) {
		this.globalPositionService = globalPositionService;
	}

	/**
	 * @param globalPositionMapper
	 */
	public void setGlobalPositionMapper(GlobalPositionMapper globalPositionMapper) {
		this.globalPositionMapper = globalPositionMapper;
	}

	/**
	 * @param productService
	 */
	public void setProductService(ProductService productService) {
		this.productService = productService;
	}

}
