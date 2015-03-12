package com.bbva.net.back.facade.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import com.bbva.net.back.core.pattern.facade.AbstractBbvaFacade;
import com.bbva.net.back.core.stereotype.Facade;
import com.bbva.net.back.facade.FavoriteOperationsFacade;
import com.bbva.net.back.mapper.FavoriteOperationsMapper;
import com.bbva.net.back.model.commons.Money;
import com.bbva.net.back.model.favoriteOperations.FavoriteOperationDto;
import com.bbva.net.webservices.agileOperations.AgileOperationsService;

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

	/**
	 * list all FavoriteOperations
	 */
	@Override
	public List<FavoriteOperationDto> getListFavoriteOperations() {
		List<FavoriteOperationDto> favoriteOperations;
		favoriteOperations = new ArrayList<FavoriteOperationDto>();
		FavoriteOperationDto favorite = new FavoriteOperationDto();
		Money ammount = new Money();
		ammount.setAmount(new BigDecimal(1000));
		ammount.setCurrency("COP");
		favorite.setAmount(ammount);
		favorite.setContractId("1234");
		favorite.setDestination("ccc");
		favorite.setIdOperation("1");
		favorite.setOrigin("clabe");
		favorite.setTransactionDate(new Date());
		favoriteOperations.add(favorite);
		favorite = new FavoriteOperationDto();
		ammount = new Money();
		ammount.setAmount(new BigDecimal(2000));
		ammount.setCurrency("COP");
		favorite.setAmount(ammount);
		favorite.setContractId("1234");
		favorite.setDestination("cardNumber");
		favorite.setIdOperation("1");
		favorite.setOrigin("creditNumber");
		favorite.setTransactionDate(new Date());
		favoriteOperations.add(favorite);
		// final List<AgileOperation> response = agileOperationsService.getAgileOperations("123");
		// List<FavoriteOperationDto> hola = favoriteOperationsMapper.map(response);
		// return hola;
		return favoriteOperations;
	}
}
