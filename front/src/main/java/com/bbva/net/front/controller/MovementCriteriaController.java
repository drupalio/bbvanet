/**
 * 
 */
package com.bbva.net.front.controller;

import javax.faces.event.ActionEvent;
import javax.faces.event.ComponentSystemEvent;

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
	 * Method to clean filters
	 */
	void cleanFilters();

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

}