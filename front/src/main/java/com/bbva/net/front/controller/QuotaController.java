/**
 * 
 */
package com.bbva.net.front.controller;

import javax.faces.event.ActionEvent;
import javax.faces.event.AjaxBehaviorEvent;

import com.bbva.net.back.model.accounts.TermsAccountsDto;
import com.bbva.net.back.model.personalize.PersonalizeAccountDto;
import com.bbva.net.back.model.quota.QuotaDetailDto;

/**
 * @author User
 */
public interface QuotaController {

	QuotaDetailDto getQuotaDetail();

	/**
	 * Method to customize a quota
	 */
	PersonalizeAccountDto getPersonalizeAccountDto();

	/**
	 * Method to get all conditions of a quota
	 */
	TermsAccountsDto getAllConditions();

	/***
	 * Method to set criteria parameters
	 * 
	 * @param event
	 */
	void setCriteriaDate(ActionEvent event);

	/***
	 * Method to search quota movements by personalized date*
	 * 
	 * @param event
	 */
	void searchQuotaMovement(ActionEvent event);

	/***
	 * Method to flag select date
	 * 
	 * @param event
	 */
	void oneSelectDate(AjaxBehaviorEvent event);

	// show Results.... moved MovementCriteriaControllerImpl

	void searchMovementByFilter(final ActionEvent event);

	// List<QuotaRotatingDto> getQuotaRotary();

}
