package com.bbva.net.front.controller;

import java.util.List;

import javax.faces.event.ActionEvent;

import com.bbva.net.back.entity.MultiValueGroup;

public interface RecoveryClientController {

	/***
	 * Method that return a rule navigation.
	 * 
	 * @return start
	 */
	String next();

	/***
	 * Method that return a rule navigation.
	 * 
	 * @return start
	 */
	String close();

	/***
	 * Method that return MultivalueList of type documents.
	 * 
	 * @return start
	 */
	List<MultiValueGroup> getListMultiValueDocuments();

	void recoveryUSer(ActionEvent event);

}
