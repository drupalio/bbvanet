package com.bbva.net.front.controller.impl;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

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
			// FacesContext ctx = FacesContext.getCurrentInstance();
			// ctx.addMessage("getExecutive ", new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", e.getMessage()));
			return new ExecutiveDto();
		}
	}

	@Override
	public CustomerDto getCustomer() {
		final String userName = (getSession().getAttribute("userName") == null) ? StringUtils.EMPTY : getSession()
				.getAttribute("userName").toString();
		final String docTypeUser = (getSession().getAttribute("docTypeUser") == null) ? StringUtils.EMPTY
				: getSession().getAttribute("docTypeUser").toString();
		final String docIdUser = (getSession().getAttribute("docIdUser") == null) ? StringUtils.EMPTY : getSession()
				.getAttribute("docIdUser").toString();
		try {
			return headerFacade.getCustomer(userName, docTypeUser, docIdUser);
		} catch (Exception e) {
			// FacesContext ctx = FacesContext.getCurrentInstance();
			// ctx.addMessage("getCustomer", new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", e.getMessage()));
			return new CustomerDto();
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
}
