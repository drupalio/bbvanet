/**
 * 
 */
package com.bbva.net.front.controller;

import javax.faces.event.ActionEvent;

import com.bbva.net.back.model.accounts.TermsAccountsDto;

/**
 * @author User
 */
public interface QuotaController {

	/**
	 * Method to get all conditions of a quota
	 */
	TermsAccountsDto getAllConditions();

	/***
	 * Method to select the date type is called when you click on the date oneRadio menu component
	 */
	void oneSelectDate();

	/**
	 * Method to set partial customdate
	 */
	void setCustomDate(ActionEvent event);

	/**
	 * Method to set partial customdate
	 */
	void clean();

}
