package com.bbva.net.front.controller.impl;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.web.client.RestClientException;

import com.bbva.net.back.facade.AccountsFacade;
import com.bbva.net.back.facade.GlobalPositionFacade;
import com.bbva.net.back.model.globalposition.AccountDto;
import com.bbva.net.back.model.globalposition.GlobalProductsDto;

/**
 * @author Entelgy
 */
public class AccountsControllerImplTest {

    private AccountsControllerImpl accountsController;

    private AccountsFacade accountsFacade;

    private GlobalPositionFacade globalPositionFacade;

    @Before
    public void init() {

        this.accountsController = new AccountsControllerImpl();

        globalPositionFacade = Mockito.mock(GlobalPositionFacade.class);
        this.accountsController.setGlobalPositionFacade(globalPositionFacade);

        accountsFacade = Mockito.mock(AccountsFacade.class);
        this.accountsController.setAccountsFacade(accountsFacade);

        this.accountsController.init();
    }

    /**
     * @throws RestClientException
     */
    @Test
    public void checkGetCustomerAccounts_OK() {
        // prepara el test
        List<AccountDto> h = new ArrayList<AccountDto>();
        Mockito.when(accountsFacade.getAccountsByUser(new GlobalProductsDto())).thenReturn(h);
        // invoca metodo a probar
        final List<AccountDto> customerAccounts = this.accountsController.getCustomerAccounts();
        // Comprobar resultados
        Assert.assertNotNull(customerAccounts);

    }
}
