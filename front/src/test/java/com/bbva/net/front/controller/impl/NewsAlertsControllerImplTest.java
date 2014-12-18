package com.bbva.net.front.controller.impl;

import java.util.ArrayList;

import javax.faces.event.ActionEvent;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import com.bbva.net.back.facade.NewsAlertsFacade;
import com.bbva.net.back.model.newsAlerts.NewsAlertsDTOTest;

public class NewsAlertsControllerImplTest {

	private NewsAlertsControllerImpl newsAlertsController;

	private NewsAlertsFacade newsAlertsFacade;

	@Before
	public void init() {

		this.newsAlertsController = new NewsAlertsControllerImpl();
		newsAlertsFacade = Mockito.mock(NewsAlertsFacade.class);
		this.newsAlertsController.setNewsAlertFacade(newsAlertsFacade);
	}

	@Test
	public void checkExistNewAlertsFacade() {
		Assert.assertNotNull(this.newsAlertsController.getNewsAlertFacade());
	}

	@Test
	public void deleteNewAlertTrue() {
		this.newsAlertsController.deleteNewsAlertsFacade(Mockito.mock(ActionEvent.class));
		Mockito.verify(this.newsAlertsFacade, Mockito.atLeastOnce()).deleteNewsAlertsFacade(Mockito.anyListOf(NewsAlertsDTOTest.class));
	}

	@Test
	public void changeNoViewedState() {

		this.newsAlertsController.changeNoViewedState(Mockito.mock(ActionEvent.class));
		Mockito.verify(this.newsAlertsFacade, Mockito.atLeastOnce()).changeNoViewedState(Mockito.anyListOf(NewsAlertsDTOTest.class));
	}

	@Test
	public void changeViewedState() {

		this.newsAlertsController.changeViewedState(Mockito.mock(ActionEvent.class));
		Mockito.verify(this.newsAlertsFacade, Mockito.atLeastOnce()).changeViewedState(Mockito.anyListOf(NewsAlertsDTOTest.class));
	}

	@Test
	public void getAlertsNews() {

		Mockito.when(newsAlertsFacade.getNewsAlertsList()).thenReturn(new ArrayList<NewsAlertsDTOTest>());
		/**
		 * Invoke test method
		 */
		Assert.assertNotNull(this.newsAlertsController.getNewsAlertsList());
		Mockito.verify(this.newsAlertsFacade, Mockito.atLeastOnce()).getNewsAlertsList();
		
	}
	

	@Test
	public void getAlertsNewsSelected() {

		/**
		 * Prepare test case
		 */
		newsAlertsController.setNewsAlertSelectedList(new ArrayList<NewsAlertsDTOTest>());
		
		/**
		 * Invoke test method
		 */
		Assert.assertNotNull(this.newsAlertsController.getNewsAlertSelectedList());
		
	}

}