package com.bbva.net.front.controller.impl;

import javax.faces.event.ActionEvent;
import javax.faces.event.AjaxBehaviorEvent;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.web.client.RestClientException;

import com.bbva.net.back.facade.PersonalizeProductFacade;
import com.bbva.net.back.facade.UpdateAliasFacade;
import com.bbva.net.back.model.globalposition.ProductDto;
import com.bbva.net.back.model.personalize.PersonalizeAccountDto;
import com.bbva.net.back.model.updateAlias.UpdateAccountDto;
import com.bbva.net.front.controller.OperationPasswordController;
import com.bbva.net.front.test.utils.AbstractBbvaControllerTest;

public class PersonalizeProductControllerImplTest extends AbstractBbvaControllerTest {

    private static final String DEFAULT_ID = "0013044300020000949";

    private PersonalizeProductControllerImpl personalizeController;

    private ActionEvent eventAction;

    private AjaxBehaviorEvent ajaxEvent;

    private OperationPasswordController operationPass;

    private PersonalizeProductFacade personalizeFacade;

    private UpdateAliasFacade updateAliasFacade;

    private ProductDto productDto;

    private ProductDto product;

    private UpdateAccountDto update;

    @Before
    public void init() throws Exception {
        super.setUp();
        this.personalizeController = new PersonalizeProductControllerImpl();
        this.eventAction = Mockito.mock(ActionEvent.class);
        this.ajaxEvent = Mockito.mock(AjaxBehaviorEvent.class);
        this.personalizeController.offMessageSuccesful(ajaxEvent);
        this.personalizeController.offMessageOpenKey(null);
        this.personalizeController.getMenSuccessful();
        this.personalizeController.getMenOperationKey();

        this.operationPass = Mockito.mock(OperationPasswordController.class);
        this.personalizeFacade = Mockito.mock(PersonalizeProductFacade.class);

        this.updateAliasFacade = Mockito.mock(UpdateAliasFacade.class);
        this.personalizeController.setUpdateAliasFacade(updateAliasFacade);

        this.personalizeController.setOperationPass(this.operationPass);
        this.personalizeController.setPersonalizeProductAccountFacade(personalizeFacade);

        this.productDto = Mockito.mock(ProductDto.class);
        this.update = Mockito.mock(UpdateAccountDto.class);
        this.product = new ProductDto();
        this.personalizeController.setProductDto(product);
        this.personalizeController.setPersonalizeProductAccountDto(new PersonalizeAccountDto());
        this.personalizeController.getPersonalizeProductAccountDto();
    }

    @Test
    public void checkInit() {
        // null
        this.personalizeController.init();
        // Caso Esitoso.
        Mockito.when(personalizeController.getSelectedProduct()).thenReturn(productDto);
        this.personalizeController.init();
        // Producto Nulo, OperationOnline no nulo y Visible null
        Mockito.when(productDto.isVisible()).thenReturn(null);
        this.personalizeController.init();
        // Producto no nulo, OperationOnline nulo y Visible no nulo
        Mockito.when(productDto.getOperationOnline()).thenReturn(null);
        this.personalizeController.init();

        // set y get
        this.personalizeController.operationkey();
        this.personalizeController.getOperationKey();
        this.personalizeController.setOperationKey("12312");
        this.personalizeController.getOperationPass();
    }

    @Test
    public void checkOperKey() {
        // null false
        Mockito.when(operationPass.validateOperation(null)).thenReturn(true);
        this.personalizeController.operKey(eventAction);
        // null true
        Mockito.when(operationPass.validateOperation(null)).thenReturn(false);
        this.personalizeController.operKey(eventAction);
        // setr product
        this.product.setProductId("0013044300020000949");
        this.product.setOperationOnline(true);
        this.product.setVisible(true);
        this.personalizeController.setProductDto(product);
        this.personalizeController.getProductDto();
        // verdaderos
        Mockito.when(operationPass.validateOperation(null)).thenReturn(true);
        Mockito.when(this.personalizeFacade.updateProductOperability(DEFAULT_ID, product)).thenReturn(true);
        Mockito.when(this.personalizeFacade.updateProductVisibility(DEFAULT_ID, product)).thenReturn(true);
        this.personalizeController.operKey(eventAction);
        // operationOnline falso
        Mockito.when(operationPass.validateOperation(null)).thenReturn(true);
        Mockito.when(this.personalizeFacade.updateProductOperability(DEFAULT_ID, product)).thenReturn(false);
        this.personalizeController.operKey(eventAction);
        // visible falso
        Mockito.when(operationPass.validateOperation(null)).thenReturn(true);
        Mockito.when(this.personalizeFacade.updateProductVisibility(DEFAULT_ID, product)).thenReturn(false);
        this.personalizeController.operKey(eventAction);
        Mockito.verify(this.personalizeFacade, Mockito.atLeastOnce()).updateProductOperability(DEFAULT_ID, product);
        Mockito.verify(this.personalizeFacade, Mockito.atLeastOnce()).updateProductVisibility(DEFAULT_ID, product);
        // ClientException
        Mockito.when(operationPass.validateOperation(null)).thenReturn(true);
        Mockito.when(this.personalizeFacade.updateProductOperability(DEFAULT_ID, product)).thenThrow(
                new RestClientException("OK"));
        Mockito.when(this.personalizeFacade.updateProductVisibility(DEFAULT_ID, product)).thenThrow(
                new RestClientException("OK"));
        this.personalizeController.operKey(eventAction);
    }

    @Test
    public void checkUpdateAlias() {
        Mockito.when(productDto.getProductNumber()).thenReturn("12345");
        this.personalizeController.setProductDto(productDto);
        this.personalizeController.setAlias("Alias");
        UpdateAccountDto acc = new UpdateAccountDto();
        this.personalizeController.setUpdateAccountIn(acc);
        this.personalizeController.setUpdateAccountOut(acc);
        this.personalizeController.getUpdateAccountOut();
        // folio not null
        Mockito.when(updateAliasFacade.updateSubject("22222222", this.personalizeController.getUpdateAccountIn())).thenReturn(acc);
        acc.setFolio("Folio");
        personalizeController.updateAlias();
        // folio null
        Mockito.when(updateAliasFacade.updateSubject("22222222", this.personalizeController.getUpdateAccountIn())).thenReturn(new UpdateAccountDto());
        personalizeController.updateAlias();
        // Throw
        Mockito.when(updateAliasFacade.updateSubject("22222222", this.personalizeController.getUpdateAccountIn())).thenThrow(Exception.class);
        personalizeController.updateAlias();
    }
}
