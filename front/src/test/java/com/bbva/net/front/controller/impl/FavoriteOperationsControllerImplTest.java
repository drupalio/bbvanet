package com.bbva.net.front.controller.impl;

import java.util.Date;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import com.bbva.net.back.facade.FavoriteOperationsFacade;

/**
 * @author Entelgy
 */
public class FavoriteOperationsControllerImplTest {

	private FavoriteOperationsFacade favoriteOperations;

	private FavoriteOperationsControllerImpl favoriteOperationsController;

	Date date;

	@Before
	public void init() {
		this.favoriteOperationsController = new FavoriteOperationsControllerImpl();
		this.favoriteOperations = Mockito.mock(FavoriteOperationsFacade.class);
		favoriteOperationsController.setFavoriteOperationsFacade(favoriteOperations);
		favoriteOperationsController.init();

	}

	@Test
	public void checkFavoritesOperations_OK() {

		Assert.assertNotNull(this.favoriteOperationsController.getListFavoriteOperations());
		Mockito.verify(this.favoriteOperations, Mockito.atLeastOnce()).getListFavoriteOperations();
	}

	@Test
	public void checkFavoritesOperationsHidden_OK() {

		Assert.assertNotNull(this.favoriteOperationsController.getListFavoriteOperationsHidden());
		Mockito.verify(this.favoriteOperations, Mockito.atLeastOnce()).getListFavoriteOperations();
	}

}
