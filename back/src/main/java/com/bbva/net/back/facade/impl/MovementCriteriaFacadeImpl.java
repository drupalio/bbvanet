package com.bbva.net.back.facade.impl;

import javax.annotation.Resource;

import com.bbva.net.back.core.pattern.facade.AbstractBbvaFacade;
import com.bbva.net.back.core.stereotype.Facade;
import com.bbva.net.back.facade.MovementCriteriaFacade;
import com.bbva.net.back.mapper.GlobalPositionMapper;
import com.bbva.net.back.service.ProductService;
import com.bbva.net.webservices.globalposition.GlobalPositionService;

@Facade(value = "movementCriteriaFacade")
public class MovementCriteriaFacadeImpl extends AbstractBbvaFacade implements MovementCriteriaFacade {

	private static final long serialVersionUID = 1L;

	// CLIENTE REST
	@Resource(name = "globalPositionService")
	private GlobalPositionService globalPositionService;

	@Resource(name = "globalPositionMapper")
	private GlobalPositionMapper globalPositionMapper;

	@Resource(name = "productService")
	private ProductService productService;

}
