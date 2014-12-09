package com.bbva.net.front.controller.impl;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

import org.springframework.stereotype.Controller;

import co.com.bbva.services.transactions.globalposition.schema.GlobalProducts;

import com.bbva.net.back.entity.MultiValueGroup;
import com.bbva.net.back.facade.GlobalPositionFacade;
import com.bbva.net.back.facade.MultiValueGroupFacade;
import com.bbva.net.front.controller.GlobalPositionController;
import com.bbva.net.front.core.AbstractBbvaController;

@Controller
public class GlobalPositionControllerImpl extends AbstractBbvaController
		implements GlobalPositionController {

	private static final long serialVersionUID = 5726824668267506699L;

	private static final String DEFAULT_USER = "123";
	// private GraphicUI graphicUI;
	private Integer LISTA_QUIEROS = 1;

	@Resource(name = "globalPositionFacade")
	private transient GlobalPositionFacade globalPositionFacade;

	@Resource(name = "multiValueGroupFacade")
	private transient MultiValueGroupFacade multiValueGroupFacade;

	@PostConstruct
	public void init() {
		/*
		 * if (listMultiValueLikes == null) { getMultiValueTypesLikes(); }
		 */
	}

	@Override
	public GlobalProducts getCustomerProducts() {

		return this.globalPositionFacade.getGlobalProductsByUser(DEFAULT_USER);
		// this.graphicPieDelegate.convertToUI(glopalProducts)
	}

	public void setGlobalPositionFacade(
			final GlobalPositionFacade globalPositionFacade) {
		this.globalPositionFacade = globalPositionFacade;
	}

	public void ButtonMenuState() {

	}

	/**
	 * @return the listMultiValueLikes
	 */
	public List<MultiValueGroup> getListMultiValueLikes() {
		return this.multiValueGroupFacade.getMultiValueTypes(LISTA_QUIEROS);
	}

	/**
	 * @return the multiValueGroupFacade
	 */
	public MultiValueGroupFacade getMultiValueGroupFacade() {
		return multiValueGroupFacade;
	}

	/**
	 * @param multiValueGroupFacade
	 *            the multiValueGroupFacade to set
	 */
	public void setMultiValueGroupFacade(
			MultiValueGroupFacade multiValueGroupFacade) {
		this.multiValueGroupFacade = multiValueGroupFacade;
	}

}
