package com.bbva.net.front.controller;

import java.util.List;

import javax.faces.event.ActionEvent;
import javax.faces.event.AjaxBehaviorEvent;

import org.primefaces.event.SelectEvent;

import com.bbva.net.back.model.turnsClient.TurnsClientDetailDto;

public interface TurnsOutwardsController {

	/**
	 * @return
	 */
	List<TurnsClientDetailDto> allTurnsClientOutside();

	/**
	 * @param selectEvent
	 * @return
	 */
	TurnsClientDetailDto onTurnDetail(SelectEvent selectEvent);

	/**
     *
     */
	void oneSelectDate();

	/**
	 * @param event
	 */
	void setCustomDate(final AjaxBehaviorEvent event);

	/**
	 * @param event
	 */
	void searchTurnsByFilter(final AjaxBehaviorEvent event);

	/**
	 * @param event
	 */
	void cleanFilters(AjaxBehaviorEvent event);

	/**
	 * @param event
	 */
	void nextPage(ActionEvent event);
}
