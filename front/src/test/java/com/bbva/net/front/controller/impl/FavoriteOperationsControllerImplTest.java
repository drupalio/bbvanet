package com.bbva.net.front.controller.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.faces.event.ActionEvent;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import org.primefaces.event.SelectEvent;

import com.bbva.net.back.facade.FavoriteOperationsFacade;
import com.bbva.net.back.model.commons.Money;
import com.bbva.net.back.model.favoriteOperations.FavoriteOperationDto;
import com.bbva.net.front.controller.OperationPasswordController;
import com.bbva.net.front.test.utils.AbstractBbvaControllerTest;

/**
 * @author Entelgy
 */
public class FavoriteOperationsControllerImplTest extends AbstractBbvaControllerTest {

    private FavoriteOperationsFacade favoriteOperations;

    private OperationPasswordController operationPass;

    private FavoriteOperationsControllerImpl favoriteOperationsController;

    private SelectEvent selectEvent;

    private ActionEvent actionEvent;

    private List<FavoriteOperationDto> favoList;

    @Before
    public void init() {
        this.favoriteOperationsController = new FavoriteOperationsControllerImpl();
        this.favoriteOperations = Mockito.mock(FavoriteOperationsFacade.class);
        this.operationPass = Mockito.mock(OperationPasswordController.class);
        this.favoriteOperationsController.setOperationPass(operationPass);
        this.favoriteOperationsController.setFavoriteOperationsFacade(favoriteOperations);
        this.favoList = new ArrayList<FavoriteOperationDto>();
        FavoriteOperationDto fav = new FavoriteOperationDto(new Date(), new Money(new BigDecimal(2000)), "ccc", "cable", "123", "3423", "fav", "");
        this.favoList.add(fav);
        // sin client
        Mockito.when(favoriteOperations.getListFavoriteOperations("123")).thenReturn(null);
        this.favoriteOperationsController.init();
        // con client
        Mockito.when(httpSession.getAttribute("codClient")).thenReturn("123");
        Mockito.when(httpSession.getAttribute("codClient").toString()).thenReturn("123");
        Mockito.when(favoriteOperations.getListFavoriteOperations("123")).thenReturn(this.favoList);
        this.favoriteOperationsController.init();
        // get
        this.selectEvent = Mockito.mock(SelectEvent.class);
        this.actionEvent = Mockito.mock(ActionEvent.class);
        this.favoriteOperationsController.getFavoriteOperations();
        this.favoriteOperationsController.getFavoriteOperationsFacade();
        this.favoriteOperationsController.getOperationPass();
        this.favoriteOperationsController.isStatus();
    }

    @Test
    public void wormInint() {
        Mockito.when(favoriteOperations.getListFavoriteOperations("123")).thenThrow(Exception.class);
        // con client throw
        this.favoriteOperationsController.init();
        // sin client throw
        Mockito.when(httpSession.getAttribute("codClient")).thenReturn(null);
        this.favoriteOperationsController.init();
        // Throw getNames
        Mockito.when(httpSession.getAttribute("codClient")).thenReturn("123");
        Mockito.when(httpSession.getAttribute("codClient").toString()).thenThrow(Exception.class);
        this.favoriteOperationsController.setFavoriteOperations(this.favoList);
        this.favoriteOperationsController.getNames();
    }

    @Test
    public void checkInit() {
        Mockito.when(httpSession.getAttribute("docIdUser")).thenReturn("123");
        this.favoriteOperationsController.init();
    }

    @Test
    public void checkFavoritesOperations_OK() {
        Assert.assertNotNull(this.favoriteOperationsController.getListFavoriteOperations());

        List<FavoriteOperationDto> favoriteOperations = new ArrayList<FavoriteOperationDto>();
        FavoriteOperationDto favorite = new FavoriteOperationDto();
        favoriteOperations.add(favorite);
        favoriteOperations.add(favorite);
        favoriteOperations.add(favorite);
        favoriteOperations.add(favorite);
        this.favoriteOperationsController.setFavoriteOperations(favoriteOperations);
        Assert.assertNotNull(this.favoriteOperationsController.getListFavoriteOperations());

        Mockito.verify(this.favoriteOperations, Mockito.atLeastOnce()).getListFavoriteOperations("123");
    }

    @Test
    public void checkFavoritesOperationsHidden_OK() {
        List<FavoriteOperationDto> favoriteOperations = new ArrayList<FavoriteOperationDto>();
        FavoriteOperationDto favorite = new FavoriteOperationDto();
        favoriteOperations.add(favorite);
        favoriteOperations.add(favorite);
        this.favoriteOperationsController.setFavoriteOperations(favoriteOperations);
        Assert.assertNotNull(this.favoriteOperationsController.getListFavoriteOperationsHidden());

        favoriteOperations.add(favorite);
        favoriteOperations.add(favorite);
        this.favoriteOperationsController.setFavoriteOperations(favoriteOperations);
        Assert.assertNotNull(this.favoriteOperationsController.getListFavoriteOperationsHidden());

        Mockito.verify(this.favoriteOperations, Mockito.atLeastOnce()).getListFavoriteOperations("123");
    }

    @Test
    public void checkFavoriteSelect() {
        FavoriteOperationDto fav = new FavoriteOperationDto();
        fav.setIdOperation("1223123124");
        Mockito.when(((FavoriteOperationDto)selectEvent.getObject())).thenReturn(fav);
        this.favoriteOperationsController.onFavoriteSelected(selectEvent);

        this.favoriteOperationsController.add(new FavoriteOperationDto());
    }

    @Test
    public void checkGetDate() {
        // null
        String stringDate = this.favoriteOperationsController.getDate(null);
        Assert.assertNotNull(stringDate);
        // not null
        stringDate = this.favoriteOperationsController.getDate(new Date());
        Assert.assertNotNull(stringDate);
    }

    @Test
    public void checkaddFvo() {
        this.favoriteOperationsController.add(new FavoriteOperationDto());
    }

    @Test
    public void checkmodifyFvo() {
        this.favoriteOperationsController.setStatus(true);
        // true
        this.favoriteOperationsController.setOperPass("123");
        Mockito.when(operationPass.validateOperation(this.favoriteOperationsController.getOperPass())).thenReturn(true);
        this.favoriteOperationsController.modify(actionEvent);
        // false
        this.favoriteOperationsController.setOperPass("123");
        Mockito.when(operationPass.validateOperation(this.favoriteOperationsController.getOperPass())).thenReturn(false);
        this.favoriteOperationsController.modify(actionEvent);
        // Throw
        Mockito.when(operationPass.validateOperation(this.favoriteOperationsController.getOperPass())).thenReturn(true);
        Mockito.when(favoriteOperations.modifyFavoriteoperations(new FavoriteOperationDto())).thenThrow(Exception.class);
        this.favoriteOperationsController.modify(actionEvent);
    }

    @Test
    public void checkdeleteFvo() {
        this.favoriteOperationsController.setStatus(true);
        // true
        this.favoriteOperationsController.setOperPass("123");
        Mockito.when(httpSession.getAttribute("codClient")).thenReturn("123");
        Mockito.when(httpSession.getAttribute("codClient").toString()).thenReturn("123");
        Mockito.when(operationPass.validateOperation(this.favoriteOperationsController.getOperPass())).thenReturn(true);
        // equals F
        Mockito.when(favoriteOperations.deleteFavoriteOperations(null, "123")).thenReturn("F");
        this.favoriteOperationsController.delete(actionEvent);
        // not equals F
        this.favoriteOperationsController.setOperPass("123");
        Mockito.when(favoriteOperations.deleteFavoriteOperations(null, "123")).thenReturn("N");
        this.favoriteOperationsController.delete(actionEvent);
        // false
        this.favoriteOperationsController.setOperPass("123");
        Mockito.when(operationPass.validateOperation(this.favoriteOperationsController.getOperPass())).thenReturn(false);
        this.favoriteOperationsController.delete(actionEvent);
        // Throw
        Mockito.when(operationPass.validateOperation(this.favoriteOperationsController.getOperPass())).thenReturn(true);
        Mockito.when(favoriteOperations.deleteFavoriteOperations(null, "123")).thenThrow(Exception.class);
        this.favoriteOperationsController.delete(actionEvent);
    }

    @Test
    public void checkSelectFavorite() {
        FavoriteOperationDto fav = new FavoriteOperationDto();
        fav.setName("favorito");
        fav.setAmount(new Money(new BigDecimal(2000)));
        this.favoriteOperationsController.setNameOperation("");
        this.favoriteOperationsController.setSelectOperation(new FavoriteOperationDto());
        this.favoriteOperationsController.getSelectOperation();
    }
}
