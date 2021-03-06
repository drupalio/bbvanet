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

/**
 * @author Entelgy
 */
@Facade(value = "globalPositionFacade")
public class GlobalPositionFacadeImpl extends AbstractBbvaFacade implements GlobalPositionFacade {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8133045188591147282L;

	/**
	 * CLIENTE REST
	 */
	@Resource(name = "globalPositionService")
	private transient GlobalPositionService globalPositionService;

	/**
	 * 
	 */
	@Resource(name = "globalPositionMapper")
	private transient GlobalPositionMapper globalPositionMapper;

	/**
	 * 
	 */
	@Resource(name = "productService")
	private transient ProductService productService;

	/**
	 * 
	 */
	@Override
	public GlobalProductsDto getGlobalProductsByUser() throws RestClientException {

		final List<Product> response = this.globalPositionService.getExtractGlobalBalance(StringUtils.EMPTY);

		return globalPositionMapper.map(response);

	}

	/**
	 * 
	 */
	@Override
	public GlobalProductsDto getGlobalProductsVisibles(final GlobalProductsDto globalProductsDTO) {
		return productService.select(globalProductsDTO, new VisibleProductPredicate());
	}

	/**
	 * 
	 */
	@Override
	public GlobalProductsDto getGlobalProductsHidden(final GlobalProductsDto globalProductsDTO) {
		return productService.select(globalProductsDTO, new HiddenProductPredicate());
	}

	/**
	 * 
	 */
	@Override
	public Map<String, BalanceDto> getTotalsByProduct(final GlobalProductsDto globalProductsDTO) {
		return productService.getTotals(globalProductsDTO);
	}

	/**
	 * 
	 */
	@Override
	public Map<String, List<String>> getNamesProducts(final GlobalProductsDto globalProducts) {
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
	 * @param productService
	 */
	public void setProductService(final ProductService productService) {
		this.productService = productService;
	}

	/**
	 * @param globalPositionMapper
	 */
	public void setGlobalPositionMapper(GlobalPositionMapper globalPositionMapper) {
		this.globalPositionMapper = globalPositionMapper;
	}

}
