package com.bbva.net.front.controller.impl;

import java.util.List;

import javax.faces.event.ActionEvent;

import com.bbva.net.back.model.checkbook.CheckbookDto;

public interface CheckBookController {

	

	/***
	 * Method to search a CheckBook
	 */
	List<CheckbookDto> getCheckbookDto();

	/***
	 * Method to select the date type is called when you click on the date oneRadio menu component
	 */
	void oneSelectDate();

	/**
	 * Method to get states from checks or books
	 */
	void actionState();

	/**
	 * Method to search a check, according filters given
	 * 
	 * @param event
	 */
	void searchCheck(ActionEvent event);

}
