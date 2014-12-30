package com.bbva.net.back.facade.impl;

import java.util.List;

import com.bbva.net.back.core.pattern.facade.AbstractBbvaFacade;
import com.bbva.net.back.core.stereotype.Facade;
import com.bbva.net.back.facade.MovementCriteriaFacade;
import com.bbva.net.back.model.checkbook.CheckbookDto;

@Facade(value = "movementCriteriaFacade")
public class MovementCriteriaFacadeImpl extends AbstractBbvaFacade implements MovementCriteriaFacade {

	private static final long serialVersionUID = 1L;

	@Override
	public List<CheckbookDto> getCheckBookssByUser(String user) {
		// TODO Auto-generated method stub
		return null;
	}

}
