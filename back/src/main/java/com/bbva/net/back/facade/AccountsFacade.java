package com.bbva.net.back.facade;

import java.util.List;
import java.util.Map;

import com.bbva.net.back.model.globalposition.AccountDto;
import com.bbva.net.back.model.globalposition.AdquirenceAccountDto;
import com.bbva.net.back.model.globalposition.BalanceDto;
import com.bbva.net.back.model.globalposition.GlobalProductsDto;

/**
 * @author Entelgy
 */
public interface AccountsFacade {
    
    /**
     * @param user
     * @return
     */
    List<AccountDto> getAccountsByUser(final GlobalProductsDto globalProductsDTO);
    
    /**
     * @param user
     * @return
     */
    List<AccountDto> getAccountsByUserHidden(final GlobalProductsDto globalProductsDTO);
    
    /**
     * @param globalProducts
     * @return
     */
    Map<String, BalanceDto> getAccountsTotals(final GlobalProductsDto globalProducts);
    
    /**
     * @param globalProductsDTO
     * @return
     */
    List<AdquirenceAccountDto> getAccountsByUserAqui(final GlobalProductsDto globalProductsDTO);
}
