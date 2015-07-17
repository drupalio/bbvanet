package com.bbva.net.back.facade.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

	@Override
	public GlobalProductsDto getLoanProducts() {
		final GlobalProductsDto globalProductDto = this.globalPositionFacade.getGlobalProductsByUser();
		return globalProductDto;
	}

	@Override
	public List<LeasingDto> getLeasingByUser(final GlobalProductsDto globalProducts) {
		List<LeasingDto> leasing = new ArrayList<LeasingDto>();
		if (globalProducts != null) {
			leasing = productService.select(globalProducts, new VisibleProductPredicate()).getLeasings();
		}
		return leasing;
	}

	@Override
	public List<RotatingAccountDto> getRotatingAccountByUser(final GlobalProductsDto globalProducts) {
		List<RotatingAccountDto> rotating = new ArrayList<RotatingAccountDto>();
		if (globalProducts != null) {
			rotating = productService.select(globalProducts, new VisibleProductPredicate()).getRotatingAccounts();
		}
		return rotating;
	}

	@Override
	public Map<String, BalanceDto> getLoanTotals(final GlobalProductsDto globalProducts) {
		Map<String, BalanceDto> balance = new HashMap<String, BalanceDto>();
		if (globalProducts != null) {
			balance = productService.getLoanTotals(globalProducts);
		}
		return balance;
	}

	@Override
	public List<RotatingAccountDto> getRotatingAccountByUserHidden(final GlobalProductsDto globalProducts) {
		List<RotatingAccountDto> rotatingHidden = new ArrayList<RotatingAccountDto>();
		if (globalProducts != null) {
			rotatingHidden = productService.select(globalProducts, new HiddenProductPredicate()).getRotatingAccounts();
		}
		return rotatingHidden;
	}

	@Override
	public List<LoanDto> getLoansByUser(final GlobalProductsDto globalProducts) {
		List<LoanDto> loan = new ArrayList<LoanDto>();
		if (globalProducts != null) {
			loan = productService.select(globalProducts, new VisibleProductPredicate()).getLoan();
		}
		return loan;
	}

	@Override
	public List<LeasingDto> getLeasingByUserHidden(final GlobalProductsDto globalProducts) {
		List<LeasingDto> leasingHidden = new ArrayList<LeasingDto>();
		if (globalProducts != null) {
			leasingHidden = productService.select(globalProducts, new HiddenProductPredicate()).getLeasings();
		}
		return leasingHidden;
	}

	@Override
	public List<LoanDto> getLoansByUserHidden(final GlobalProductsDto globalProducts) {
		List<LoanDto> loanHidden = new ArrayList<LoanDto>();
		if (globalProducts != null) {
			loanHidden = productService.select(globalProducts, new HiddenProductPredicate()).getLoan();
		}
		return loanHidden;
	}

	/*********************************** SETTERS BEANS **************************************/

	public void setGlobalPositionFacade(final GlobalPositionFacade globalPositionFacade) {
		this.globalPositionFacade = globalPositionFacade;
	}

	public void setProductService(ProductService productService) {
		this.productService = productService;
	}

}
