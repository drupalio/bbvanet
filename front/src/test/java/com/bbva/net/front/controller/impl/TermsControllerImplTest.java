package com.bbva.net.front.controller.impl;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.web.client.RestClientException;

import com.bbva.czic.dto.net.EnumProductType;
import com.bbva.net.back.facade.TermasAccountsFacade;
import com.bbva.net.back.model.accounts.InvolvedDto;
import com.bbva.net.back.model.accounts.TermsAccountsDto;
import com.bbva.net.back.model.globalposition.ProductDto;
import com.bbva.net.front.controller.HeaderController;
import com.bbva.net.front.test.utils.AbstractBbvaControllerTest;

public class TermsControllerImplTest extends AbstractBbvaControllerTest {
    
    private static final String DEFAULT_ID = "0013044300020000949";
    
    private TermsControllerImpl termsController;
    
    private TermasAccountsFacade detallesCuenta;
    
    private HeaderController headerController;
    
    private ProductDto productDto;
    
    @Before
    public void init() {
        // inicializar controlador
        this.termsController = new TermsControllerImpl();
        this.headerController = new HeaderControllerImpl();
        // Mockear el producto y el facade
        this.productDto = Mockito.mock(ProductDto.class);
        this.detallesCuenta = Mockito.mock(TermasAccountsFacade.class);
        // Setear el facade
        this.termsController.setHeaderController(headerController);
        this.termsController.setDetallesCuenta(detallesCuenta);
        
        TermsAccountsDto termsAccountsDto = new TermsAccountsDto();
        List<InvolvedDto> holders = new ArrayList<InvolvedDto>();
        holders.add(new InvolvedDto("Test"));
        termsAccountsDto.setHolders(holders);
        Mockito.when(termsController.getSelectedProduct()).thenReturn(productDto);
        Mockito.when(productDto.getProductId()).thenReturn(DEFAULT_ID);
        Mockito.when(this.detallesCuenta.getAllConditions(termsController.getSelectedProduct().getProductId())).thenReturn(termsAccountsDto);
        // llamar al metodo getAllConditions no account PC
        Mockito.when(productDto.getTypeProd()).thenReturn(EnumProductType.AQ);
        termsAccountsDto = this.termsController.getAllConditions();
        // llamar al metodo getAllConditions
        Mockito.when(productDto.getTypeProd()).thenReturn(EnumProductType.PC);
        termsAccountsDto = this.termsController.getAllConditions();
        // mirar que la respuesta no venga vacia
        Assert.assertNotNull(termsAccountsDto);
    }
    
    @Test
    public void wormGetConditions() {
        // Mockar el producto
        Mockito.when(termsController.getSelectedProduct()).thenReturn(productDto);
        Mockito.when(productDto.getProductId()).thenReturn(DEFAULT_ID);
        // Mockear la respuesta
        Mockito.when(this.detallesCuenta.getAllConditions(DEFAULT_ID)).thenThrow(new RestClientException("OK"));
        this.termsController.getAllConditions();
    }
    
    @Test
    public void exportDocumentPdf() {
        // // llenos
        // this.termsController.getExportPdf();
        // super.executeScript("PrimeFaces.monitorDownload(start, deleteDownload )");
        // // null
        // this.termsController.getExportPdf();
        // super.executeScript("PrimeFaces.monitorDownload(start, deleteDownload )");
    }
    
}
