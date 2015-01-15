package com.bbva.net.front.controller;

import java.util.List;

import com.bbva.net.back.entity.MultiValueGroup;

public interface RecoverPasswordController {

	/**
	 *Method action to send in current flow
	 */
	String showMessageCheck();

	/***
	 * Method that return a  rule navigation.
	 * @return start
	 */
	String respuesta();

	/***
	 * Method that return MultivalueList of type documents.
	 * @return start
	 */
	List<MultiValueGroup> getListMultiValueDocuments();

}
