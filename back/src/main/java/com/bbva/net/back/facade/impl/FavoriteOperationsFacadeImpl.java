package com.bbva.net.back.facade.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.bbva.net.back.core.pattern.facade.AbstractBbvaFacade;
import com.bbva.net.back.core.stereotype.Facade;
import com.bbva.net.back.facade.FavoriteOperationsFacade;
import com.bbva.net.back.model.commons.Money;
import com.bbva.net.back.model.favoriteOperations.FavoriteOperationDto;

@Facade(value = "favoriteOperationsFacade")
public class FavoriteOperationsFacadeImpl extends AbstractBbvaFacade implements FavoriteOperationsFacade {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4324772858898315010L;

	@Override
	public List<FavoriteOperationDto> getListFavoriteOperations(String contractId) {
		List<FavoriteOperationDto> favoriteOperations;
		favoriteOperations = new ArrayList<FavoriteOperationDto>();
		FavoriteOperationDto favorite = new FavoriteOperationDto();
		Money ammount = new Money();
		ammount.setAmount(new BigDecimal(1000));
		ammount.setCurrency("COP");
		favorite.setAmmount(ammount);
		favorite.setContractId("1234");
		favorite.setDestination("Cuenta ahorro");
		favorite.setIdOperation("1");
		favorite.setOrigin("Cuenta Corriente");
		favorite.setTransactionDate(new Date());
		favoriteOperations.add(favorite);
		favorite = new FavoriteOperationDto();
		ammount = new Money();
		ammount.setAmount(new BigDecimal(2000));
		ammount.setCurrency("COP");
		favorite.setAmmount(ammount);
		favorite.setContractId("1234");
		favorite.setDestination("Ceunta ahorro");
		favorite.setIdOperation("1");
		favorite.setOrigin("Cuenta Corriente");
		favorite.setTransactionDate(new Date());
		favoriteOperations.add(favorite);

		favorite = new FavoriteOperationDto();
		ammount = new Money();
		ammount.setAmount(new BigDecimal(3000));
		ammount.setCurrency("COP");
		favorite.setAmmount(ammount);
		favorite.setContractId("1234");
		favorite.setDestination("Ceunta ahorro");
		favorite.setIdOperation("1");
		favorite.setOrigin("Cuenta Corriente");
		favorite.setTransactionDate(new Date());
		favoriteOperations.add(favorite);

		favorite = new FavoriteOperationDto();
		ammount = new Money();
		ammount.setAmount(new BigDecimal(4000));
		ammount.setCurrency("COP");
		favorite.setAmmount(ammount);
		favorite.setContractId("1234");
		favorite.setDestination("Ceunta ahorro");
		favorite.setIdOperation("1");
		favorite.setOrigin("Cuenta Corriente");
		favorite.setTransactionDate(new Date());
		favoriteOperations.add(favorite);

		favorite = new FavoriteOperationDto();
		ammount = new Money();
		ammount.setAmount(new BigDecimal(5000));
		ammount.setCurrency("COP");
		favorite.setAmmount(ammount);
		favorite.setContractId("1234");
		favorite.setDestination("Ceunta ahorro");
		favorite.setIdOperation("1");
		favorite.setOrigin("Cuenta Corriente");
		favorite.setTransactionDate(new Date());
		favoriteOperations.add(favorite);
		return favoriteOperations;
	}

}
