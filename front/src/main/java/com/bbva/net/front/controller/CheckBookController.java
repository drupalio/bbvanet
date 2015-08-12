package com.bbva.net.front.controller;

import java.util.List;

import javax.faces.event.ActionEvent;
import javax.faces.event.AjaxBehaviorEvent;

import com.bbva.net.back.entity.MultiValueGroup;
import com.bbva.net.back.model.checkbook.CheckDto;
import com.bbva.net.back.model.checkbook.CheckbookDto;

public interface CheckBookController {

	/***
	 * Method to select the date type is called when you click on the date oneRadio menu component
	 */
	void oneSelectDate();

	/**
	 * Method to get states from checks or books
	 */
	void radioActionState();

	/**
	 * Method to set a check or book, according filters given
	 * 
	 * @param event
	 */
	void setNumberCheckOrBook(AjaxBehaviorEvent event);

	/**
	 * Method to get MultiValueGroup List, list to check status
	 * 
	 * @return List<MultiValueGroup>
	 */
	List<MultiValueGroup> getListMultiValueChecks();

	/**
	 * Method to set partial customdate
	 */
	void setCustomDate(AjaxBehaviorEvent event);

	/**
	 * Method to search checks or checksbooks
	 */
	void showResults(AjaxBehaviorEvent event);

	/****
	 * Method to
	 * 
	 * @param List<CheckDto> cheksList
	 */
	void hasMoreElementsCheck(List<CheckDto> cheksList);

	/**
	 * @param cheksBookList
	 */
	void hasMoreElementsCheckBook(List<CheckbookDto> cheksBookList);

	/**
	 * @param event
	 */
	void cleanFilters(ActionEvent event);

	/**
	 * 
	 */
	String clean();

	/**
	 * 
	 */
	void exportDocCheckBookPdf();

	/**
	  * 
	  */

	void exportDocCheckPdf();

	/**
	 * 
	 */
	void exportDocCheckBookExcel();

	/**
	 * 
	 */

	void exportDocCheckExcel();

	/**
	 * 
	 */
	void printCheck();

	/**
	  * 
	  */
	void printCheckBook();
}