package com.bbva.net.front.controller.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

import org.primefaces.event.SelectEvent;

import com.bbva.net.back.facade.AccountsFacade;
import com.bbva.net.back.facade.GlobalPositionFacade;
import com.bbva.net.back.model.globalposition.AccountDto;
import com.bbva.net.back.model.globalposition.AdquirenceAccountDto;
import com.bbva.net.back.model.globalposition.BalanceDto;
import com.bbva.net.back.model.globalposition.GlobalProductsDto;
import com.bbva.net.front.controller.AccountsController;
import com.bbva.net.front.core.AbstractBbvaController;

public class AccountsControllerImpl extends AbstractBbvaController implements AccountsController {

    private static final long serialVersionUID = 5726824668267606699L;
    
	// <!-- Entelgy / SPRING 3 / 17112015 / INICIO -->

    @Resource(name = "accountsFacade")
    private transient AccountsFacade accountsFacade;

    @Resource(name = "globalPositionFacade")
    private GlobalPositionFacade globalPositionFacade;

    private GlobalProductsDto globalProductsDTO;

    private Map<String, BalanceDto> totalsProducts;
	
	@PostConstruct
	public void init() {
		LOGGER.info("Initialize AccountsController");
        try {
            this.globalProductsDTO = this.globalPositionFacade.getGlobalProductsByUser();
        } catch (Exception e) {
            this.globalProductsDTO = new GlobalProductsDto();
        }
        this.totalsProducts = this.accountsFacade.getAccountsTotals(globalProductsDTO);
    }

    @Override
    public List<AccountDto> getCustomerAccounts() {
        return this.accountsFacade.getAccountsByUser(globalProductsDTO);
    }

    @Override
    public List<AccountDto> getCustomerAccountsHidden() {
        return this.accountsFacade.getAccountsByUserHidden(globalProductsDTO);
    }

    @Override
    public List<AdquirenceAccountDto> getCustomerAccountsAdqui() {
        return this.accountsFacade.getAccountsByUserAqui(globalProductsDTO);
    }

    @Override
    public void onProductSelected(SelectEvent selectEvent) {
        super.onProductSelected(selectEvent);
        this.sendAction("accountSelected");
    }
	
	// <!-- Entelgy / SPRING 3 / 17112015 / FIN -->
		

    // <!-- Entelgy / SPRING 3 / 17112015 / INICIO -->
	
    public void setAccountsFacade(final AccountsFacade accountsFacade) {
        this.accountsFacade = accountsFacade;
    }

    public void setGlobalPositionFacade(GlobalPositionFacade globalPositionFacade) {
        this.globalPositionFacade = globalPositionFacade;
    }

    public GlobalProductsDto getGlobalProductsDTO() {
        return globalProductsDTO;
    }

    public Map<String, BalanceDto> getTotalsProducts() {
        return totalsProducts;
    }

    // <!-- Entelgy / SPRING 3 / 17112015 / FIN -->
}
