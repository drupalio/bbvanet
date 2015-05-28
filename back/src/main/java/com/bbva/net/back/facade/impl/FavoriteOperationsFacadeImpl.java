package com.bbva.net.back.facade.impl;

import java.util.List;

import javax.annotation.Resource;

import com.bbva.net.back.core.pattern.facade.AbstractBbvaFacade;
import com.bbva.net.back.core.stereotype.Facade;
import com.bbva.net.back.facade.FavoriteOperationsFacade;
import com.bbva.net.back.mapper.FavoriteOperationsMapper;
import com.bbva.net.back.model.favoriteOperations.FavoriteOperationDto;
import com.bbva.net.back.service.FiqlService;
import com.bbva.net.webservices.agileOperations.AgileOperationsService;
import com.bbva.zic.agileoperations.v01.AgileOperation;

/**
 * @author Entelgy
 */
@Facade(value = "favoriteOperationsFacade")
public class FavoriteOperationsFacadeImpl extends AbstractBbvaFacade implements FavoriteOperationsFacade {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4324772858898315010L;

	/**
	 * Service AgileOperationsService
	 */
	@Resource(name = "agileOperationsService")
	private AgileOperationsService agileOperationsService;

	/**
	 * call mapper FavoriteOperationsMapper
	 */
	@Resource(name = "favoriteOperationsMapper")
	private FavoriteOperationsMapper favoriteOperationsMapper;

	@Resource(name = "fiqlService")
	private FiqlService fiqlService;

	/**
	 * list all FavoriteOperations
	 */
	@Override
	public List<FavoriteOperationDto> getListFavoriteOperations(String user) {
		LOGGER.info("Inicia Método getListFavoriteOperations de FavoriteOperationsFacade");
		final String filter = fiqlService.getContractId(user);
		final List<AgileOperation> response = agileOperationsService.getAgileOperations(filter);
		List<FavoriteOperationDto> favoriteOperations = favoriteOperationsMapper.map(response);
		return favoriteOperations;
	}

	@Override
	public String deleteFavoriteOperations(String operationId) {
		LOGGER.info("Inicia Método deleteFavoriteOperations de FavoriteOperationsFacade");
		return agileOperationsService.deleteAgileOperation(operationId, null);
	}

	@Override
	public void modifyFavoriteoperations(FavoriteOperationDto favoriteOperation) {
		LOGGER.info("Inicia Método modifyFavoriteoperations de FavoriteOperationsFacade");
		AgileOperation agileOperation = favoriteOperationsMapper.map(favoriteOperation);
		agileOperationsService.modifyAgileOperation(favoriteOperation.getIdOperation(), agileOperation);
	}
}
