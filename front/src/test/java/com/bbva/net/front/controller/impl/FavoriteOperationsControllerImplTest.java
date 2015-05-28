package com.bbva.net.front.controller.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import com.bbva.net.back.facade.FavoriteOperationsFacade;
import com.bbva.net.back.model.commons.Money;
import com.bbva.net.back.model.favoriteOperations.FavoriteOperationDto;
import com.bbva.net.front.test.utils.AbstractBbvaControllerTest;

/**
 * @author Entelgy
 */
public class FavoriteOperationsControllerImplTest extends AbstractBbvaControllerTest {

	private FavoriteOperationsFacade favoriteOperations;

	private FavoriteOperationsControllerImpl favoriteOperationsController;

	private Date date;

	@Before
	public void init() {
		this.favoriteOperationsController = new FavoriteOperationsControllerImpl();
		this.favoriteOperations = Mockito.mock(FavoriteOperationsFacade.class);
		this.favoriteOperationsController.setFavoriteOperationsFacade(favoriteOperations);
		this.favoriteOperationsController.init();
		this.favoriteOperationsController.getFavoriteOperations();
		this.favoriteOperationsController.getFavoriteOperationsFacade();
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
	public void checkGetNames() {
		List<FavoriteOperationDto> favoriteOperations = new ArrayList<FavoriteOperationDto>();
		FavoriteOperationDto favorite = new FavoriteOperationDto();
		Money ammount = new Money();
		ammount.setAmount(new BigDecimal(1000));
		ammount.setCurrency("COP");
		favorite.setAmount(ammount);
		favorite.setContractId("1234");
		favorite.setDestination("ccc");
		favorite.setIdOperation("1");
		favorite.setOrigin("clabe");
		favorite.setTransactionDate(new Date());
		favoriteOperations.add(favorite);
		this.favoriteOperationsController.setFavoriteOperations(favoriteOperations);
		this.favoriteOperationsController.getNames();
	}

	// @Test
	// public void checkGetDate() {
	// Date date = new Date();
	// Assert.assertNotNull(this.favoriteOperationsController.getDate(date));
	// }
}
