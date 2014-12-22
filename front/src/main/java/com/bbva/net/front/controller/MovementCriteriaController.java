/**
 * 
 */
package com.bbva.net.front.controller;

import java.util.List;

import javax.faces.event.ActionEvent;

import com.bbva.net.back.entity.MultiValueGroup;

/**
 * @author User
 */
public interface MovementCriteriaController {

	/***
	 * Search movements by personalized search
	 * @param event
	 */
	void searchMovementByFilter(ActionEvent event);
	
	
	/***
	 * method to select the date type is called when you click on the date oneRadio menu component
	 */
	public void oneSelectDate();
	
	
	/**
	 * method to set starting values of the balance
	 * @param event
	 */
	public void setBalanceRange(ActionEvent event);
	
	/**
	 * Method to set starting values of the income or expenses filter
	 * @param event
	 */
	public void setIncomeExpensesFilter(ActionEvent event);
	
	
	/**
	 * Method to get states from checks or books
	 */
	public void actionState();
	
	/**
	 * Method to search a check or book, according filters given
	 * @param event
	 */
	public void searchNumberCheckOrBook(ActionEvent event);
	
	
	/**
	 * Method to clean filters
	 * @param event
	 */
	public void cleanFilters();
	
	/**
	 * Method to get MultiValueGrou List, list to check status
	 * @return List<MultiValueGroup>
	 */
	List<MultiValueGroup> getListMultiValueLikes();

}
