/**
 * 
 */
package com.bbva.net.front.controller;

import java.util.List;

import javax.faces.event.ActionEvent;

import com.bbva.net.back.model.accounts.TermsAccountsDto;
import com.bbva.net.back.model.globalposition.ProductDto;
import com.bbva.net.back.model.movements.MovementDto;

/**
 * @author User
 */
public interface QuotaController {

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
	void searchQuotaByFilter(final ActionEvent event);

	/**
	 * Method to get all movements of quota
	 * 
	 * @return
	 */

	List<MovementDto> getAllQuotamovenDtos();

	/**
	 * Method to reset to "render" of quota with click
	 * 
	 * @param event
	 */
	void cleanFilters(ActionEvent event);

	/**
	 * Method to reset filters of quota
	 */

	void cleanFilters();

	/**
	 * Method nextPage movements
	 * 
	 * @param event
	 */

	void nextPage(ActionEvent event);

	/**
	 * Product Data
	 * 
	 * @return
	 */

	ProductDto getSelectProduct();

}
