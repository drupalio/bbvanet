package com.bbva.net.back.facade.impl;

import java.util.List;

import javax.annotation.Resource;

import com.bbva.net.back.core.pattern.facade.AbstractBbvaFacade;
import com.bbva.net.back.core.stereotype.Facade;
import com.bbva.net.back.facade.AccountsFacade;
import com.bbva.net.back.facade.GlobalPositionFacade;
import com.bbva.net.back.model.globalposition.AccountDTO;
import com.bbva.net.back.model.globalposition.GlobalProductsDTO;
import com.bbva.net.back.predicate.HiddenProductPredicate;
import com.bbva.net.back.predicate.VisibleProductPredicate;
import com.bbva.net.back.service.ProductService;

@Facade(value = "accountsFacade")
public class AccountsFacadeImpl extends AbstractBbvaFacade implements AccountsFacade {

	private static final long serialVersionUID = -7965898288210045100L;

	@Resource(name = "globalPositionFacade")
	private GlobalPositionFacade globalPositionFacade;

	@Resource(name = "productService")
	private ProductService productService;

	@Override
	public List<AccountDTO> getAccountsByUser(String user) {

		final GlobalProductsDTO globalProductsDTO = this.globalPositionFacade.getGlobalProductsByUser(user);
		return productService.select(globalProductsDTO, new VisibleProductPredicate()).getAccounts();
	}

	@Override
	public List<AccountDTO> getAccountsByUserHidden(String user) {
		final GlobalProductsDTO globalProductsDTO = this.globalPositionFacade.getGlobalProductsByUser(user);
		return productService.select(globalProductsDTO, new HiddenProductPredicate()).getAccounts();
	}

	public void setGlobalPositionFacade(GlobalPositionFacade globalPositionFacade) {
		this.globalPositionFacade = globalPositionFacade;
	}

}
