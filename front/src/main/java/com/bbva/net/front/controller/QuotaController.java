/**
 * 
 */
package com.bbva.net.front.controller;

import java.util.List;

import javax.faces.event.ActionEvent;
import javax.faces.event.AjaxBehaviorEvent;

import com.bbva.net.back.model.movements.MovementDto;


/**
 * @author User
 */
 // <!-- Entelgy / SPRING 3 / 08092015 / INICIO -->
public interface QuotaController {

	/***
	 * Method to select the date type is called when you click on the date oneRadio menu component
	 */
	void oneSelectDate();

	/**
	 * Method to set partial customdate
	 */
	void setCustomDate(AjaxBehaviorEvent event);

	/**
	 * Method to set partial customdate
	 */
	void searchQuotaByFilter(final AjaxBehaviorEvent event);

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
	void cleanFilters(AjaxBehaviorEvent event);

    /**
     * Method nextPage movements
     *
	 * @param event
	 */

	void nextPage(ActionEvent event);

	/**
	 * 
	 */
	void criteriaSearch();

	/**
	 * 
	 */
	void exportDocumentPdf();

	/**
	 * 
	 */
	void exportDocumentExcel();

	/**
	 * 
	 */
	void exportDocDetailPdf();

	/**
	 * 
	 */
	void printMovesQuota();

	/**
	 * 
	 */
	void printMoveDetailQuota();

	/**
	 * 
	 */
	void sendMail();
}
// <!-- Entelgy / SPRING 3 / 08092015 / FIN -->