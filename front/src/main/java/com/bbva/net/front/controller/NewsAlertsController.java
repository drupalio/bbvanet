package com.bbva.net.front.controller;

import java.util.List;

import javax.faces.event.ActionEvent;

import com.bbva.net.back.model.newsAlerts.NewsAlertsDTOTest;

/**
 * 
 * @author User
 *
 */
public interface NewsAlertsController {

	/**
	 * 
	 * @param actionEvent
	 */
	void deleteNewsAlertsFacade(ActionEvent actionEvent);

	/**
	 * 
	 * @param actionEvent
	 */
	void changeNoViewedState(ActionEvent actionEvent);

	/**
	 * 
	 * @param actionEvent
	 */
	void changeViewedState(ActionEvent actionEvent);

	/**
	 * 
	 * @return
	 */
	List<NewsAlertsDTOTest> getNewsAlertsList();

}
