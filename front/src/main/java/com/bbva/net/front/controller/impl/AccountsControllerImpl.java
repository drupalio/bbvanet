package com.bbva.net.front.controller.impl;

import javax.annotation.Resource;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import org.primefaces.event.SelectEvent;
import org.primefaces.event.UnselectEvent;
import org.springframework.stereotype.Controller;

import co.com.bbva.services.transactions.globalposition.schema.GlobalProducts;

import com.bbva.net.back.facade.GlobalPositionFacade;
import com.bbva.net.front.controller.AccountsController;
import com.bbva.net.front.core.AbstractBbvaController;

@Controller
public class AccountsControllerImpl extends AbstractBbvaController implements
		AccountsController {

	private static final String DEFAULT_USER = "123";

	private static final long serialVersionUID = 5726824668267606699L;

	@Resource(name = "globalPositionFacade")
	private transient GlobalPositionFacade globalPositionFacade;

	@Override
	public GlobalProducts getCustomerAccounts() {
		return this.globalPositionFacade.getGlobalProductsByUser(DEFAULT_USER);
	}

	@Override
	public void setAccountsFacade(
			final GlobalPositionFacade globalPositionFacade) {
		this.globalPositionFacade = globalPositionFacade;
	}


}
