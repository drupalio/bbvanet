package com.bbva.net.front.controller.impl;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;

import javax.faces.event.ValueChangeEvent;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Matchers;
import org.mockito.Mockito;

import com.bbva.net.back.entity.MultiValueGroup;
import com.bbva.net.back.facade.MultiValueGroupFacade;
import com.bbva.net.back.model.globalposition.ProductDto;
import com.bbva.net.front.test.utils.AbstractBbvaControllerTest;

public class ApplicationControllerTest extends AbstractBbvaControllerTest {

    private ApplicationControllerImpl applicationControler;

    private MultiValueGroupFacade multiValueGroupFacade;

    private ValueChangeEvent valueChange;

    @Before
    public void init() {

        super.setUp();

        this.valueChange = Mockito.mock(ValueChangeEvent.class);

        this.applicationControler = new ApplicationControllerImpl();
        this.multiValueGroupFacade = mock(MultiValueGroupFacade.class);
        this.applicationControler.setMultiValueGroupFacade(multiValueGroupFacade);
        this.applicationControler.getMultiValueGroupFacade();
        this.applicationControler.setProduct(new ProductDto());
        this.applicationControler.getProduct();
    }

    @Test
    public void onLikeAccount_OK() {

        when(this.multiValueGroupFacade.getMultiValueTypes(Matchers.anyInt())).thenReturn(
                new ArrayList<MultiValueGroup>());

        Mockito.when(valueChange.getNewValue()).thenReturn("2131234");
        this.applicationControler.onLikeAccount(valueChange);

        Mockito.when(valueChange.getNewValue()).thenReturn("Ver saldos y movimientos");
        this.applicationControler.onLikeAccount(valueChange);

        Mockito.when(valueChange.getNewValue()).thenReturn("Ver más opciones");
        this.applicationControler.onLikeAccount(valueChange);

    }

    @Test
    public void onLike_OK() {
        this.applicationControler.onLike(valueChange);
    }

    @Test
    public void onLikeQuota_OK() {
        Mockito.when(valueChange.getNewValue()).thenReturn("2131234");
        this.applicationControler.onLikeQuota(valueChange);

        Mockito.when(valueChange.getNewValue()).thenReturn("Ver movimientos");
        this.applicationControler.onLikeQuota(valueChange);

        Mockito.when(valueChange.getNewValue()).thenReturn("Ver más opciones");
        this.applicationControler.onLikeQuota(valueChange);
    }
}
