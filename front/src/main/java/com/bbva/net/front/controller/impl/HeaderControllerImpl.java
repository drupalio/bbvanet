package com.bbva.net.front.controller.impl;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import org.apache.commons.lang.StringUtils;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.bbva.net.back.facade.HeaderFacade;
import com.bbva.net.back.model.header.CustomerDto;
import com.bbva.net.back.model.header.ExecutiveDto;
import com.bbva.net.front.controller.HeaderController;
import com.bbva.net.front.core.AbstractBbvaController;

@Controller(value = "headerController")
@Scope(value = "globalSession")
public class HeaderControllerImpl extends AbstractBbvaController implements HeaderController {

	@Resource(name = "headerFacade")
	private transient HeaderFacade headerFacade;

	/**
	 * 
	 */
	private ExecutiveDto ejecutivo;

	private CustomerDto cliente;

	private static final long serialVersionUID = 5284952254890332374L;

	@PostConstruct
	public void init() {

		this.cliente = this.getCustomer();
		this.ejecutivo = this.getExecutive();
	}

	@Override
	public ExecutiveDto getExecutive() {

		try {
			return headerFacade.getExecutive();
		} catch (Exception e) {
			FacesContext ctx = FacesContext.getCurrentInstance();
			ctx.addMessage("getCardsChargesByUser ", new FacesMessage(e.getMessage()));
			return new ExecutiveDto();

		}
	}

	public ExecutiveDto getEjecutivo() {
		return ejecutivo;
	}

	public CustomerDto getCliente() {

		return cliente;
	}

	public void setHeaderFacade(HeaderFacade headerFacade) {
		this.headerFacade = headerFacade;
	}

	@Override
	public CustomerDto getCustomer() {

		LOGGER.info("====================================== GET CUSTOMER ==============================");
		if (this.cliente == null) {
			final String userName = (getSession().getAttribute("userName") == null) ? StringUtils.EMPTY : getSession()
					.getAttribute("userName").toString();

			LOGGER.info("CLIENTE: " + userName);
			final String docTypeUser = (getSession().getAttribute("docTypeUser") == null) ? StringUtils.EMPTY
					: getSession().getAttribute("docTypeUser").toString();
			LOGGER.info("DOC TYPE USER" + docTypeUser);
			final String docIdUser = (getSession().getAttribute("docIdUser") == null) ? StringUtils.EMPTY
					: getSession().getAttribute("docIdUser").toString();
			LOGGER.info("DOC ID USER" + docIdUser);

			try {
				this.cliente = headerFacade.getCustomer(userName, docTypeUser, docIdUser);
				LOGGER.info("CLIENT TOSTRING(): " + cliente.toString());
			} catch (final Exception exception) {
				LOGGER.info("Error header controller getCustomer: " + exception.getMessage());
				FacesContext ctx = FacesContext.getCurrentInstance();
				ctx.addMessage("getCustomer ", new FacesMessage(exception.getMessage()));
				this.cliente = new CustomerDto();
			}
		}
		return cliente;
	}
}
