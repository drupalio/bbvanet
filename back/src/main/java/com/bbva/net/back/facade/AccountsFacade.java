package com.bbva.net.back.facade;

import java.util.Map;
import java.util.List;

import com.bbva.net.back.model.globalposition.AdquirenceAccountDto;
import com.bbva.net.back.model.globalposition.BalanceDto;
import com.bbva.net.back.model.globalposition.AccountDto;
import com.bbva.net.back.model.globalposition.GlobalProductsDto;



/**
 * @author Entelgy
 */
public interface AccountsFacade {
    
    // <!-- Entelgy / SPRING 3 / 17112015 / INICIO -->
    /**
     * @param globalProductsDTO
     * @return
     */
    List<AccountDto> getAccountsByUser(final GlobalProductsDto globalProductsDTO);
    
    /**
     * @param globalProductsDTO
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

    // <!-- Entelgy / SPRING 3 / 17112015 / FIN -->
}
