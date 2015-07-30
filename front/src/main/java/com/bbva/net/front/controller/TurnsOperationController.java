package com.bbva.net.front.controller;

import java.util.List;

import javax.faces.event.ActionEvent;

import org.primefaces.event.SelectEvent;

import com.bbva.net.back.model.globalposition.ProductDto;
import com.bbva.net.back.model.turnsClient.turnsClientDto;

public interface TurnsOperationController {

	/**
	 * @return
	 */
	ProductDto getSelectedProduct();

	/**
	 * @return
	 */
	List<turnsClientDto> allTurnsClientOutside();

	/**
	 * @return
	 */
	List<turnsClientDto> allTurnsClientRecived();

	/**
	 * @param selectEvent
	 */
	void onTurnDetail(SelectEvent selectEvent);

	/**
	 * @return
	 */
	List<turnsClientDto> getAllMovementsInitial();

	/**
	 * 
	 */
	void oneSelectDate();

	/**
	 * @param event
	 */
	void setCustomDate(final ActionEvent event);

	/**
	 * @param event
	 */
	void searchTurnsByFilter(final ActionEvent event);
}
