/**
 * 
 */
package com.bbva.net.front.controller;

import javax.faces.event.ActionEvent;
import javax.faces.event.AjaxBehaviorEvent;

import com.bbva.net.back.model.accounts.TermsAccountsDto;
import com.bbva.net.back.model.quota.QuotaMoveDetailDto;

/**
 * @author User
 */
public interface QuotaController {

	/**
	 * Method to get all conditions of a quota
	 */
	TermsAccountsDto getAllConditions();

	/** get id movement **/

	QuotaMoveDetailDto getSelectedMovement();

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

	void setSelectedMovement(QuotaMoveDetailDto selectedProduct);

	// show Results.... moved MovementCriteriaControllerImpl

	void searchMovementByFilter(final ActionEvent event);

	// List<QuotaRotatingDto> getQuotaRotary();

}
