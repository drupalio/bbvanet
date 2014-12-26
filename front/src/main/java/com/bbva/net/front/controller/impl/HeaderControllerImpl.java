package com.bbva.net.front.controller.impl;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.bbva.net.back.facade.HeaderControllerFacade;
import com.bbva.net.back.model.executive.ExecutiveDto;
import com.bbva.net.front.controller.HeaderController;
import com.bbva.net.front.core.AbstractBbvaController;

@Controller(value = "headerController")
@Scope(value = "globalSession")
public class HeaderControllerImpl extends AbstractBbvaController implements HeaderController {

	@Resource(name = "headerControllerFacade")
	private transient HeaderControllerFacade executive;

	/**
	 * 
	 */
	private ExecutiveDto ejecutivo;

	private static final long serialVersionUID = 5284952254890332374L;

	@PostConstruct
	public void init() {
		this.ejecutivo = this.getExecutive();
	}

	@Override
	public ExecutiveDto getExecutive() {
		return executive.getExecutive();
	}

	public ExecutiveDto getEjecutivo() {
		return ejecutivo;
	}

}
