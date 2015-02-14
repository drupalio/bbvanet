package com.bbva.net.back.mapper.impl;

import java.util.List;

import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.ConfigurableMapper;

import com.bbva.czic.dto.net.Movement;
import com.bbva.net.back.core.stereotype.Mapper;
import com.bbva.net.back.mapper.MovementsMapper;
import com.bbva.net.back.mapper.converter.StringToDateConverter;
import com.bbva.net.back.mapper.converter.MoneyConverter;
import com.bbva.net.back.model.movements.MovementDetailDto;
import com.bbva.net.back.model.movements.MovementDto;

@Mapper(value = "movementsMapper")
public class MovementsMapperImpl extends ConfigurableMapper implements MovementsMapper {

	@Override
	protected void configure(final MapperFactory factory) {
		// Add Money Converter
		factory.getConverterFactory().registerConverter(new MoneyConverter());
		// Add Date Converter
		factory.getConverterFactory().registerConverter(new StringToDateConverter("yyyy-MM-dd'T'HH:mm:ss.SSSZ"));

		// Map Movement DTO
		factory.classMap(Movement.class, MovementDto.class).field("id", "movementId")
				.field("concept", "movementConcept").field("transactionDate", "movementDate")
				.field("operationDate", "movementDetailDto.operationDate")
				.field("operation.code", "movementDetailDto.operationCode")
				.field("operation.description", "movementDetailDto.operationDescription")
				.field("office.name", "movementDetailDto.plaza")
				.field("office.location.city.name", "movementDetailDto.originCenterMovement")
				.field("status", "movementDetailDto.state").field("value", "movementValue")
				.field("balance", "totalBalance").field("numberOfQuotas", "quotaNumber").byDefault().register();

	}

	@Override
	public MovementDetailDto mapMovement(Movement movement) {
		final MovementDetailDto movementDetailDto = map(movement, MovementDetailDto.class);
		return movementDetailDto;
	}

	@Override
	public List<MovementDto> mapMovementDtoList(List<Movement> movementList) {
		return mapAsList(movementList, MovementDto.class);
	}

}
