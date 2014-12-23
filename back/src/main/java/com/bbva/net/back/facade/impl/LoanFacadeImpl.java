package com.bbva.net.back.facade.impl;

import java.util.List;

import javax.annotation.Resource;

import com.bbva.net.back.core.pattern.facade.AbstractBbvaFacade;
import com.bbva.net.back.core.stereotype.Facade;
import com.bbva.net.back.facade.GlobalPositionFacade;
import com.bbva.net.back.facade.LoanFacade;
import com.bbva.net.back.model.globalposition.GlobalProductsDTO;
import com.bbva.net.back.model.globalposition.LeasingDTO;
import com.bbva.net.back.model.globalposition.LoanDTO;
import com.bbva.net.back.model.globalposition.RotatingAccountDTO;
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

	@Override
	public List<LeasingDTO> getLeasingByUser(final String user) {

		final GlobalProductsDTO globalProducts = this.globalPositionFacade.getGlobalProductsByUser(user);
		return productService.select(globalProducts, new VisibleProductPredicate()).getLeasings();

	}

	@Override
	public List<RotatingAccountDTO> getRotatingAccountByUser(final String user) {

		final GlobalProductsDTO globalProducts = this.globalPositionFacade.getGlobalProductsByUser(user);
		return productService.select(globalProducts, new VisibleProductPredicate()).getRotatingAccounts();
	}

	@Override
	public List<RotatingAccountDTO> getRotatingAccountByUserHidden(final String user) {
		final GlobalProductsDTO globalProducts = this.globalPositionFacade.getGlobalProductsByUser(user);
		return productService.select(globalProducts, new HiddenProductPredicate()).getRotatingAccounts();
	}

	@Override
	public List<LoanDTO> getLoansByUser(final String user) {
		final GlobalProductsDTO globalProducts = this.globalPositionFacade.getGlobalProductsByUser(user);
		return productService.select(globalProducts, new VisibleProductPredicate()).getLoan();
	}

	@Override
	public List<LeasingDTO> getLeasingByUserHidden(final String user) {

		final GlobalProductsDTO globalProducts = this.globalPositionFacade.getGlobalProductsByUser(user);
		return productService.select(globalProducts, new HiddenProductPredicate()).getLeasings();
	}

	@Override
	public List<LoanDTO> getLoansByUserHidden(final String user) {
		final GlobalProductsDTO globalProducts = this.globalPositionFacade.getGlobalProductsByUser(user);
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
