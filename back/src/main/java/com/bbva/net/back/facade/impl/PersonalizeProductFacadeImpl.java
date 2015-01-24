package com.bbva.net.back.facade.impl;

import javax.annotation.Resource;

import com.bbva.net.back.core.pattern.facade.AbstractBbvaFacade;
import com.bbva.net.back.core.stereotype.Facade;
import com.bbva.net.back.facade.GlobalPositionFacade;
import com.bbva.net.back.facade.PersonalizeProductFacade;
import com.bbva.net.back.mapper.GlobalPositionMapper;
import com.bbva.net.webservices.globalposition.GlobalPositionService;

@Facade(value = "personalizeProductAccountFacade")
public class PersonalizeProductFacadeImpl extends AbstractBbvaFacade
		implements
			PersonalizeProductFacade {

	private static final long serialVersionUID = -8535409693026365524L;

	@Resource(name = "globalPositionFacade")
	private GlobalPositionFacade globalPositionFacade;

	@Resource(name = "globalPositionMapper")
	private GlobalPositionMapper globalPositionMapper;

	// CLIENTE REST
	@Resource(name = "globalPositionService")
	private GlobalPositionService globalPositionService;

	public void setGlobalPositionFacade(
			GlobalPositionFacade globalPositionFacade) {
		this.globalPositionFacade = globalPositionFacade;
	}

	public void setGlobalPositionService(
			GlobalPositionService globalPositionService) {
		this.globalPositionService = globalPositionService;
	}

	public void setGlobalPositionMapper(
			GlobalPositionMapper globalPositionMapper) {
		this.globalPositionMapper = globalPositionMapper;
	}
}
