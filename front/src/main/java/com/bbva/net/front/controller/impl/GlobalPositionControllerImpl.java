package com.bbva.net.front.controller.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;

import co.com.bbva.services.transactions.globalposition.schema.GlobalProducts;

import com.bbva.net.back.facade.GlobalPositionFacade;
import com.bbva.net.front.controller.GlobalPositionController;
import com.bbva.net.front.core.AbstractBbvaController;

@Controller
public class GlobalPositionControllerImpl extends AbstractBbvaController
		implements GlobalPositionController {

	private static final long serialVersionUID = 5726824668267506699L;

	private static final String DEFAULT_USER = "123";

	private boolean globalPositionb = true;

	@Resource(name = "globalPositionFacade")
	private transient GlobalPositionFacade globalPositionFacade;

	public boolean isGlobalPositionb() {
		return globalPositionb;
	}

	public void setGlobalPositionb(boolean globalPositionb) {
		this.globalPositionb = globalPositionb;
	}

	@Override
	public GlobalProducts getCustomerProducts() {
		return this.globalPositionFacade.getGlobalProductsByUser(DEFAULT_USER);

	}

	public void setGlobalPositionFacade(
			final GlobalPositionFacade globalPositionFacade) {
		this.globalPositionFacade = globalPositionFacade;
	}

}
