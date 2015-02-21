package com.bbva.net.back.mapper.impl;

import java.util.ArrayList;
import java.util.List;

import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.ConfigurableMapper;

import com.bbva.net.back.core.stereotype.Mapper;
import com.bbva.net.back.mapper.FavoriteOperationsMapper;
import com.bbva.net.back.mapper.converter.MoneyConverter;
import com.bbva.net.back.mapper.converter.StringToDateConverter;
import com.bbva.net.back.model.favoriteOperations.FavoriteOperationDto;
import com.bbva.net.core.pattern.VisitorCommand;
import com.bbva.zic.agileoperations.v01.AdaptedIDestinationAdapter;
import com.bbva.zic.agileoperations.v01.AdaptedIOriginAdapter;
import com.bbva.zic.agileoperations.v01.AgileOperation;

@Mapper(value = "favoriteOperationsMapper")
public class FavoriteOperationsMapperImpl extends ConfigurableMapper implements FavoriteOperationsMapper {

	/**
	 * 
	 */
	@Override
	protected void configure(MapperFactory factory) {

		factory.getConverterFactory().registerConverter(new MoneyConverter());
		factory.getConverterFactory().registerConverter(new StringToDateConverter("yyyy-MM-dd HH:MM:SS"));

		// Map AgileOperation to FavoriteOperationDto
		factory.classMap(AgileOperation.class, FavoriteOperationDto.class).field("contractId", "contractId")
				.field("amount", "amount").field("id", "idOperation").field("name", "name")
				.field("transactionDate", "transactionDate").field("transactionReference", "transactionReference")
				.byDefault().register();

	}

	@Override
	public List<FavoriteOperationDto> map(List<AgileOperation> favOperations) {
		final List<FavoriteOperationDto> favOperationsDto = new ArrayList<FavoriteOperationDto>();

		new VisitorCommand<AgileOperation>(favOperations) {

			FavoriteOperationDto fav = null;

			@Override
			public void execute(AgileOperation operation) {
				fav = new FavoriteOperationDto();
				fav = map(operation, FavoriteOperationDto.class);
				fav.setOrigin(getNameClassOrigin(operation.getOrigin()));
				fav.setDestination(getNameClassDestination(operation.getDestination()));
				favOperationsDto.add(fav);
			}
		};
		return favOperationsDto;
	}

	public String getNameClassOrigin(AdaptedIOriginAdapter origen) {
		String tipoOrigen = "";
		if (origen.getCardNumber() != null) tipoOrigen = "cardNumber";
		if (origen.getCcc() != null) tipoOrigen = "ccc";
		if (origen.getClabe() != null) tipoOrigen = "clabe";
		if (origen.getCreditNumber() != null) tipoOrigen = "creditNumber";
		if (origen.getMobilePhoneNumber() != null) tipoOrigen = "mobilePhoneNumber";
		return tipoOrigen;
	}

	public String getNameClassDestination(AdaptedIDestinationAdapter origen) {
		String tipoDestination = "";
		if (origen.getCardNumber() != null) tipoDestination = "cardNumber";
		if (origen.getCcc() != null) tipoDestination = "ccc";
		if (origen.getClabe() != null) tipoDestination = "clabe";
		if (origen.getCreditNumber() != null) tipoDestination = "creditNumber";
		if (origen.getMobilePhoneNumber() != null) tipoDestination = "mobilePhoneNumber";
		return tipoDestination;
	}
}