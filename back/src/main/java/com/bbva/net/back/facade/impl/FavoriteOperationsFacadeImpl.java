package com.bbva.net.back.facade.impl;

import java.util.List;

import javax.annotation.Resource;

import com.bbva.net.back.core.pattern.facade.AbstractBbvaFacade;
import com.bbva.net.back.core.stereotype.Facade;
import com.bbva.net.back.facade.FavoriteOperationsFacade;
import com.bbva.net.back.mapper.FavoriteOperationsMapper;
import com.bbva.net.back.model.favoriteOperations.FavoriteOperationDto;
import com.bbva.net.webservices.agileOperations.AgileOperationsService;
import com.bbva.zic.agileoperations.v01.AgileOperation;

@Facade(value = "favoriteOperationsFacade")
public class FavoriteOperationsFacadeImpl extends AbstractBbvaFacade implements FavoriteOperationsFacade {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4324772858898315010L;

	@Resource(name = "agileOperationsService")
	private AgileOperationsService agileOperationsService;

	@Resource(name = "favoriteOperationsMapper")
	private FavoriteOperationsMapper favoriteOperationsMapper;

	@Override
	public List<FavoriteOperationDto> getListFavoriteOperations() {

		final List<AgileOperation> response = agileOperationsService.getAgileOperations("123");
		List<FavoriteOperationDto> hola = favoriteOperationsMapper.map(response);
		return hola;

	}
}
