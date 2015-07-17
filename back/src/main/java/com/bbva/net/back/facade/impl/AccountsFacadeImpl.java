package com.bbva.net.back.facade.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import com.bbva.net.back.core.pattern.facade.AbstractBbvaFacade;
import com.bbva.net.back.core.stereotype.Facade;
import com.bbva.net.back.facade.AccountsFacade;
import com.bbva.net.back.facade.GlobalPositionFacade;
import com.bbva.net.back.model.globalposition.AccountDto;
import com.bbva.net.back.model.globalposition.GlobalProductsDto;
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
	public List<AccountDto> getAccountsByUser() {
		List<AccountDto> accounts = new ArrayList<AccountDto>();
		final GlobalProductsDto globalProductsDTO = this.globalPositionFacade.getGlobalProductsByUser();
		if (globalProductsDTO != null) {
			accounts = productService.select(globalProductsDTO, new VisibleProductPredicate()).getAccounts();
		}
		return accounts;
	}

	@Override
	public List<AccountDto> getAccountsByUserHidden() {
		List<AccountDto> accounts = new ArrayList<AccountDto>();
		final GlobalProductsDto globalProductsDTO = this.globalPositionFacade.getGlobalProductsByUser();
		if (globalProductsDTO != null) {
			accounts = productService.select(globalProductsDTO, new HiddenProductPredicate()).getAccounts();
		}
		return accounts;
	}

	public void setGlobalPositionFacade(GlobalPositionFacade globalPositionFacade) {
		this.globalPositionFacade = globalPositionFacade;
	}

}
