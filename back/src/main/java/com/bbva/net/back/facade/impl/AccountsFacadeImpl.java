package com.bbva.net.back.facade.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import com.bbva.net.back.core.pattern.facade.AbstractBbvaFacade;
import com.bbva.net.back.core.stereotype.Facade;
import com.bbva.net.back.facade.AccountsFacade;
import com.bbva.net.back.model.globalposition.AccountDto;
import com.bbva.net.back.model.globalposition.AdquirenceAccountDto;
import com.bbva.net.back.model.globalposition.BalanceDto;
import com.bbva.net.back.model.globalposition.GlobalProductsDto;
import com.bbva.net.back.predicate.HiddenProductPredicate;
import com.bbva.net.back.predicate.VisibleProductPredicate;
import com.bbva.net.back.service.ProductService;

@Facade(value = "accountsFacade")
public class AccountsFacadeImpl extends AbstractBbvaFacade implements AccountsFacade {
    
    private static final long serialVersionUID = -7965898288210045100L;
    
    // <!-- Entelgy / SPRING 3 / 17112015 / INICIO -->
    
    @Resource(name = "productService")
    private ProductService productService;
    
    @Override
    public List<AccountDto> getAccountsByUser(final GlobalProductsDto globalProductsDTO) {
        List<AccountDto> accounts = new ArrayList<AccountDto>();
        accounts = productService.select(globalProductsDTO, new VisibleProductPredicate()).getAccounts();
        return accounts;
    }
    
    @Override
    public List<AccountDto> getAccountsByUserHidden(final GlobalProductsDto globalProductsDTO) {
        List<AccountDto> accounts = new ArrayList<AccountDto>();
        accounts = productService.select(globalProductsDTO, new HiddenProductPredicate()).getAccounts();
        return accounts;
    }
    
    @Override
    public List<AdquirenceAccountDto> getAccountsByUserAqui(final GlobalProductsDto globalProductsDTO) {
        List<AdquirenceAccountDto> accounts = new ArrayList<AdquirenceAccountDto>();
        accounts = productService.select(globalProductsDTO, new HiddenProductPredicate()).getAdquirencia();
        return accounts;
    }
    
    @Override
    public Map<String, BalanceDto> getAccountsTotals(final GlobalProductsDto globalProducts) {
        Map<String, BalanceDto> balance = new HashMap<String, BalanceDto>();
        if ( globalProducts != null ) {
            balance = productService.getTotalsAccounts(globalProducts);
        }
        return balance;
    }
    
    public void setProductService(ProductService productService) {
        this.productService = productService;
    }
    
    // <!-- Entelgy / SPRING 3 / 17112015 / FIN -->
}
