package com.bbva.net.front.controller.impl;

import java.util.List;

import javax.faces.event.ActionEvent;

import com.bbva.net.back.facade.NewsAlertsFacade;
import com.bbva.net.back.model.newsAlerts.NewsAlertsDto;
import com.bbva.net.front.controller.NewsAlertsController;
import com.bbva.net.front.core.AbstractBbvaController;

/**
 * @author Entelgy
 */
public class NewsAlertsControllerImpl extends AbstractBbvaController implements NewsAlertsController {

	private static final long serialVersionUID = 7099605458774926871L;

	private NewsAlertsFacade newsAlertFacade;

	private List<NewsAlertsDto> newsAlertSelectedList;

	@Override
	public void deleteNewsAlertsFacade(ActionEvent actionEvent) {
		this.newsAlertFacade.deleteNewsAlertsFacade(newsAlertSelectedList);

	}

	@Override
	public void changeNoViewedState(ActionEvent actionEvent) {
		this.newsAlertFacade.changeNoViewedState(newsAlertSelectedList);
	}

	@Override
	public void changeViewedState(ActionEvent actionEvent) {
		this.newsAlertFacade.changeViewedState(newsAlertSelectedList);

	}

	@Override
	public List<NewsAlertsDto> getNewsAlertsList() {
		return this.newsAlertFacade.getNewsAlertsList();
	}

	/**
	 * @return the newsAlertFacade
	 */
	public NewsAlertsFacade getNewsAlertFacade() {
		return newsAlertFacade;
	}

	/**
	 * @param newsAlertFacade the newsAlertFacade to set
	 */
	public void setNewsAlertFacade(NewsAlertsFacade newsAlertFacade) {
		this.newsAlertFacade = newsAlertFacade;
	}

	/**
	 * @return the newsAlertSelectedList
	 */
	public List<NewsAlertsDto> getNewsAlertSelectedList() {
		return newsAlertSelectedList;
	}

	/**
	 * @param newsAlertSelectedList the newsAlertSelectedList to set
	 */
	public void setNewsAlertSelectedList(List<NewsAlertsDto> newsAlertSelectedList) {
		this.newsAlertSelectedList = newsAlertSelectedList;
	}

}