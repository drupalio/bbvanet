package com.bbva.net.back.facade.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

import com.bbva.net.back.core.pattern.facade.AbstractBbvaFacade;
import com.bbva.net.back.core.stereotype.Facade;
import com.bbva.net.back.facade.GlobalPositionFacade;
import com.bbva.net.back.facade.LoanFacade;
import com.bbva.net.back.model.globalposition.BalanceDto;
import com.bbva.net.back.model.globalposition.GlobalProductsDto;
import com.bbva.net.back.model.globalposition.LeasingDto;
import com.bbva.net.back.model.globalposition.LoanDto;
import com.bbva.net.back.model.globalposition.RotatingAccountDto;
import com.bbva.net.back.predicate.HiddenProductPredicate;
import com.bbva.net.back.predicate.VisibleProductPredicate;
import com.bbva.net.back.service.ProductService;

@Facade(value = "loanFacade")
public class LoanFacadeImpl extends AbstractBbvaFacade implements LoanFacade {

	private static final long serialVersionUID = -6967081195758241814L;

	@Resource(name = "globalPositionFacade")
	private GlobalPositionFacade globalPositionFacade;

	@Resource(name = "productService")
	private ProductService productService;

	public GlobalProductsDto getLoanProducts() {
		final GlobalProductsDto globalProductDto = this.globalPositionFacade.getGlobalProductsByUser();
		return globalProductDto;
	}

	@Override
	public List<LeasingDto> getLeasingByUser(final GlobalProductsDto globalProducts) {
		return productService.select(globalProducts, new VisibleProductPredicate()).getLeasings();

	}

	@Override
	public List<RotatingAccountDto> getRotatingAccountByUser(final GlobalProductsDto globalProducts) {
		return productService.select(globalProducts, new VisibleProductPredicate()).getRotatingAccounts();
	}

	@Override
	public Map<String, BalanceDto> getLoanTotals(final GlobalProductsDto globalProducts) {
		return productService.getLoanTotals(globalProducts);
	}

	@Override
	public List<RotatingAccountDto> getRotatingAccountByUserHidden(final GlobalProductsDto globalProducts) {
		return productService.select(globalProducts, new HiddenProductPredicate()).getRotatingAccounts();
	}

	@Override
	public List<LoanDto> getLoansByUser(final GlobalProductsDto globalProducts) {
		return productService.select(globalProducts, new VisibleProductPredicate()).getLoan();
	}

	@Override
	public List<LeasingDto> getLeasingByUserHidden(final GlobalProductsDto globalProducts) {
		return productService.select(globalProducts, new HiddenProductPredicate()).getLeasings();
	}

	@Override
	public List<LoanDto> getLoansByUserHidden(final GlobalProductsDto globalProducts) {
		return productService.select(globalProducts, new HiddenProductPredicate()).getLoan();
	}

	/*********************************** SETTERS BEANS **************************************/

	public void setGlobalPositionFacade(final GlobalPositionFacade globalPositionFacade) {
		this.globalPositionFacade = globalPositionFacade;
	}

	public void setProductService(ProductService productService) {
		this.productService = productService;
	}

}
