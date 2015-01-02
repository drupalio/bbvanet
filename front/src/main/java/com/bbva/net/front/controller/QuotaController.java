/**
 * 
 */
package com.bbva.net.front.controller;

import javax.faces.event.ActionEvent;

import com.bbva.net.back.model.accounts.TermsAccountsDto;
import com.bbva.net.back.model.movements.PersonalizeAccountDTO;


/**
 * @author User
 *
 */
public interface QuotaController {
	
	/**
	 * Method to customize a quota
	 * 
	 */
	PersonalizeAccountDTO getPersonalizeProductAccountDto();
	
	/**
	 * Method to get all conditions of a quota
	 * 
	 */
	TermsAccountsDto getAllConditions();
	
	/***
	 * Method to set criteria parameters
	 * @param event
	 */
	void setCriteriaDate(ActionEvent event);
	
	/***
	 * Method to search quota movements by personalized date* 
	 * @param event
	 */
	void searchQuotaMovement(ActionEvent event);

	
	/***
	 * Method to flag select date 
	 * @param event
	 */
	void oneSelectDate();
	
	
	


}
