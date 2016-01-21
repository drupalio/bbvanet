package com.bbva.net.front.controller.impl;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import org.primefaces.event.SelectEvent;
import org.springframework.web.client.RestClientException;

import com.bbva.net.back.facade.AccountsFacade;
import com.bbva.net.back.facade.GlobalPositionFacade;
import com.bbva.net.back.model.globalposition.AccountDto;
import com.bbva.net.back.model.globalposition.AdquirenceAccountDto;
import com.bbva.net.back.model.globalposition.GlobalProductsDto;
import com.bbva.net.back.model.globalposition.ProductDto;
import com.bbva.net.front.test.utils.AbstractBbvaControllerTest;

/**
 * @author Entelgy
 */
public class AccountsControllerImplTest extends AbstractBbvaControllerTest {

    private AccountsControllerImpl accountsController;

    private AccountsFacade accountsFacade;

    private GlobalPositionFacade globalPositionFacade;

    private SelectEvent selectEvent;

    @Before
    public void init() {

        this.accountsController = new AccountsControllerImpl();

        globalPositionFacade = Mockito.mock(GlobalPositionFacade.class);
        this.accountsController.setGlobalPositionFacade(globalPositionFacade);

        accountsFacade = Mockito.mock(AccountsFacade.class);
        this.accountsController.setAccountsFacade(accountsFacade);

        this.globalPositionFacade.getGlobalProductsByUser();

        this.accountsController.getGlobalProductsDTO();
        this.accountsController.getTotalsProducts();

        this.selectEvent = Mockito.mock(SelectEvent.class);
        ProductDto prouct = new ProductDto();
        prouct.setProductId("1223123124");
        Mockito.when(((ProductDto)selectEvent.getObject())).thenReturn(prouct);
        this.accountsController.onProductSelected(selectEvent);

        // not null
        Mockito.when(globalPositionFacade.getGlobalProductsByUser()).thenReturn(new GlobalProductsDto());
        this.accountsController.init();
        // null
        Mockito.when(globalPositionFacade.getGlobalProductsByUser()).thenThrow(Exception.class);
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

        final List<AccountDto> customerAccountsHidden = this.accountsController.getCustomerAccountsHidden();
        // Comprobar resultados
        Assert.assertNotNull(customerAccountsHidden);

        final List<AdquirenceAccountDto> customerAccountsAqui = this.accountsController.getCustomerAccountsAdqui();
        // Comprobar resultados
        Assert.assertNotNull(customerAccountsAqui);

    }
}
