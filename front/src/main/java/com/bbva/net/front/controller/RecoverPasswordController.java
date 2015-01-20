package com.bbva.net.front.controller;

import java.util.List;

import javax.faces.event.ActionEvent;

import com.bbva.net.back.entity.MultiValueGroup;

public interface RecoverPasswordController {


	/***
	 * Method that return a  rule navigation.
	 * @return start
	 */
	String next();
	
	
	/***
	 * Method that return a rule navigation.
	 * @return start
	 */
	String close();

	/***
	 * Method that return MultivalueList of type documents.
	 * @return start
	 */
	List<MultiValueGroup> getListMultiValueDocuments();

	/**
	 * Method that creates a new password, given user information.
	 * @param event
	 */
	void recoveryPass(ActionEvent event);

}
