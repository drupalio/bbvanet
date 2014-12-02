package com.bbva.net.front.controller.impl;

import java.util.List;

import javax.faces.event.ActionEvent;

import org.springframework.stereotype.Controller;

import com.bbva.net.back.facade.NewsAlertsFacade;
import com.bbva.net.back.model.newsAlerts.NewsAlertsDTO;
import com.bbva.net.front.controller.NewsAlertsController;
import com.bbva.net.front.core.AbstractBbvaController;

/**
 * 
 * 
 * @author Entelgy
 *
 */
@Controller
public class NewsAlertsControllerImpl extends AbstractBbvaController implements
		NewsAlertsController {

	private static final long serialVersionUID = 7099605458774926871L;

	private NewsAlertsFacade newsAlertFacade;
	private List<NewsAlertsDTO> newsAlertSelectedList;

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
	public List<NewsAlertsDTO> getNewsAlertsList() {	
		return this.newsAlertFacade.getNewsAlertsList();
	}

	/**
	 * @return the newsAlertFacade
	 */
	public NewsAlertsFacade getNewsAlertFacade() {
		return newsAlertFacade;
	}

	/**
	 * @param newsAlertFacade
	 *            the newsAlertFacade to set
	 */
	public void setNewsAlertFacade(NewsAlertsFacade newsAlertFacade) {
		this.newsAlertFacade = newsAlertFacade;
	}

	/**
	 * @return the newsAlertSelectedList
	 */
	public List<NewsAlertsDTO> getNewsAlertSelectedList() {
		return newsAlertSelectedList;
	}

	/**
	 * @param newsAlertSelectedList
	 *            the newsAlertSelectedList to set
	 */
	public void setNewsAlertSelectedList(List<NewsAlertsDTO> newsAlertSelectedList) {
		this.newsAlertSelectedList = newsAlertSelectedList;
	}



}
