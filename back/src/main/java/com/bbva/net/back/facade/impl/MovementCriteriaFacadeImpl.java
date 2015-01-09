package com.bbva.net.back.facade.impl;

import java.util.List;

import javax.annotation.Resource;

import com.bbva.net.back.core.pattern.facade.AbstractBbvaFacade;
import com.bbva.net.back.core.stereotype.Facade;
import com.bbva.net.back.facade.MovementCriteriaFacade;
import com.bbva.net.back.mapper.GlobalPositionMapper;
import com.bbva.net.back.model.checkbook.CheckDto;
import com.bbva.net.back.model.checkbook.CheckbookDto;
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

	@Override
	public List<CheckDto> getCheck(int idCheck, String status) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CheckbookDto> getCheckbookDto(int idCheck) {
		// TODO Auto-generated method stub
		return null;
	}

}
