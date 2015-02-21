package com.bbva.net.front.controller.impl;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.bbva.net.back.facade.HeaderFacade;
import com.bbva.net.back.model.header.CustomerDto;
import com.bbva.net.back.model.header.ExecutiveDto;
import com.bbva.net.front.controller.HeaderController;
import com.bbva.net.front.core.AbstractBbvaController;

@Controller(value = "headerController")
@Scope(value = "session")
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
		if (ejecutivo == null) {
			try {
				return headerFacade.getExecutive();
			} catch (final Exception exception) {
			}
			return new ExecutiveDto();
		}
		return ejecutivo;

	}

	@Override
	public CustomerDto getCustomer() {

		if (cliente == null) {
			try {
				return headerFacade.getCustomer();
			} catch (final Exception exception) {
			}
			return new CustomerDto();
		}

		return cliente;

	}

	public ExecutiveDto getEjecutivo() {
		return ejecutivo;
	}

	public CustomerDto getCliente() {
		return cliente;
	}

}
