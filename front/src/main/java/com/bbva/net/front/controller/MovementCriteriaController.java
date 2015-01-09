/**
 * 
 */
package com.bbva.net.front.controller;

import java.util.List;

import javax.faces.event.ActionEvent;
import javax.faces.event.AjaxBehaviorEvent;
import javax.faces.event.ComponentSystemEvent;

import com.bbva.net.back.entity.MultiValueGroup;
import com.bbva.net.back.model.checkbook.CheckDto;
import com.bbva.net.back.model.checkbook.CheckbookDto;

/**
 * @author User
 */
public interface MovementCriteriaController {

	/***
	 * Search movements by personalized search
	 * 
	 * @param event
	 */
	void searchMovementByFilter(ActionEvent event);

	/***
	 * Method to select the date type is called when you click on the date oneRadio menu component
	 */
	void oneSelectDate();

	/**
	 * method to set starting values of the balance
	 * 
	 * @param event
	 */
	void setBalanceRange(ActionEvent event);

	/**
	 * Method to set starting values of the income or expenses filter
	 * 
	 * @param event
	 */
	void setIncomeExpensesFilter(ActionEvent event);

	/**
	 * Method to get states from checks or books
	 */
	void actionState();

	/**
	 * Method to set a check or book, according filters given
	 * 
	 * @param event
	 */
	void setNumberCheckOrBook(ActionEvent event);

	/**
	 * Method to search a check or book, according filters given
	 * 
	 * @param event
	 */
	void searchNumberCheckOrBook(ActionEvent event);

	/**
	 * Method to clean filters
	 */
	void cleanFilters();

	/**
	 * Method to get MultiValueGroup List, list to check status
	 * 
	 * @return List<MultiValueGroup>
	 */
	List<MultiValueGroup> getListMultiValueLikes();

	/**
	 * Method to buil a message for balanceFilter
	 */
	void buildMessage();

	/**
	 * Method to validate a balance range
	 */
	void balanceValidator();

	/***
	 * @param event
	 */
	void preRender(ComponentSystemEvent event);

	/**
	 * @param event
	 */
	void setCustomDate(ActionEvent event);

	void captureDate(AjaxBehaviorEvent e);

	List<CheckDto> getCheckId(int idCheck, String status);

	List<CheckbookDto> getCheckbookDto(int idCheck);

}
