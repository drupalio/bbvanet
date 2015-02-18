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
@Scope(value = "globalSession")
public class HeaderControllerImpl extends AbstractBbvaController implements HeaderController {

	@Resource(name = "headerFacade")
	private transient HeaderFacade headerFacade;

	/**
	 * 
	 */
	private ExecutiveDto executiveDto;

	private CustomerDto customerDto;

	private static final long serialVersionUID = 5284952254890332374L;

	@PostConstruct
	public void init() {
		this.customerDto = this.getCustomer();
		this.executiveDto = this.getExecutive();
	}

	@Override
	public ExecutiveDto getExecutive() {
		return executiveDto;
	}

	public ExecutiveDto getEjecutivo() {
		return executiveDto;
	}

	public CustomerDto getCliente() {

		return customerDto;
	}

	@Override
	public CustomerDto getCustomer() {
		return customerDto;
	}

}
