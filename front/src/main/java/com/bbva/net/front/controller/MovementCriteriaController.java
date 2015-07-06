package com.bbva.net.front.controller;

import java.util.List;

import javax.faces.event.ActionEvent;
import javax.faces.event.ComponentSystemEvent;

import com.bbva.net.back.model.movements.MovementDto;

/**
 * @author Entelgy
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
	 * Method to set a date
	 * 
	 * @param event
	 */
	void setCustomDate(ActionEvent event);

	List<MovementDto> getAllMovements();

	/***
	 * Method to clean filters
	 * 
	 * @param event
	 */
	void cleanFilters(ActionEvent event);

	/***
	 * Method to set a movement conecept
	 * 
	 * @param event
	 */
	void setMovementConcept(ActionEvent event);

	/**
	 * 
	 */
	void clean();

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
	void printFile();

	/**
	 * 
	 */
	void sendMail();

	/**
	 * 
	 */
	void exportDocumentDetailPdf();
}