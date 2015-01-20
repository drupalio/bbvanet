package com.bbva.net.back.facade.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.springframework.web.client.RestClientException;

import com.bbva.czic.dto.net.Product;
import com.bbva.net.back.core.pattern.facade.AbstractBbvaFacade;
import com.bbva.net.back.core.stereotype.Facade;
import com.bbva.net.back.facade.GlobalPositionFacade;
import com.bbva.net.back.mapper.GlobalPositionMapper;
import com.bbva.net.back.model.globalposition.BalanceDto;
import com.bbva.net.back.model.globalposition.GlobalProductsDto;
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
	public GlobalProductsDto getGlobalProductsByUser(final String user) throws RestClientException {

		final List<Product> response = this.globalPositionService.getExtractGlobalBalance(user, StringUtils.EMPTY,
				StringUtils.EMPTY, StringUtils.EMPTY, StringUtils.EMPTY);

		// return globalPositionMapper.map(response);
		return globalPositionMapper.map(response);

	}

	@Override
	public GlobalProductsDto getGlobalProductsVisibles(final GlobalProductsDto globalProductsDTO) {
		return productService.select(globalProductsDTO, new VisibleProductPredicate());
	}

	@Override
	public GlobalProductsDto getGlobalProductsHidden(final GlobalProductsDto globalProductsDTO) {
		return productService.select(globalProductsDTO, new HiddenProductPredicate());
	}

	@Override
	public Map<String, BalanceDto> getTotalsByProduct(GlobalProductsDto globalProductsDTO) {
		return productService.getTotals(globalProductsDTO);
	}

	@Override
	public Map<String, List<String>> getNamesProducts(GlobalProductsDto globalProducts) {
		return productService.getProductsName(globalProducts);
	}

	/********************************** DEPENDENCY INJECTIONS ***********************************/

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
