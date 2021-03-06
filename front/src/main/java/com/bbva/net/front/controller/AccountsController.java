package com.bbva.net.front.controller;

import java.util.List;

import com.bbva.net.back.model.globalposition.AccountDto;

import org.primefaces.event.SelectEvent;
import com.bbva.net.back.model.globalposition.AdquirenceAccountDto;

/**
 * @author Entelgy
 */
public interface AccountsController {
    
    /**
     * @return accountList for user logged
     */
    List<AccountDto> getCustomerAccounts();
    
    /**
     * @return
     */
    List<AccountDto> getCustomerAccountsHidden();
    
    // <!-- Entelgy / SPRING 3 / 17112015 / INICIO -->
    
    /**
     * @return
     */
    List<AdquirenceAccountDto> getCustomerAccountsAdqui();
    
    /**
     * @param selectEvent
     */
    void onProductSelected(SelectEvent selectEvent);
    
    // <!-- Entelgy / SPRING 3 / 17112015 / FIN -->
}
