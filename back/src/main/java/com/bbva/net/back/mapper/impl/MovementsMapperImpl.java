package com.bbva.net.back.mapper.impl;

import java.util.List;

import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.ConfigurableMapper;

import com.bbva.czic.dto.net.Movement;
import com.bbva.net.back.core.stereotype.Mapper;
import com.bbva.net.back.mapper.MovementsMapper;
import com.bbva.net.back.mapper.converter.MoneyConverter;
import com.bbva.net.back.model.movements.MovementDetailDto;
import com.bbva.net.back.model.movements.MovementDto;

@Mapper(value = "movementsMapper")
public class MovementsMapperImpl extends ConfigurableMapper implements MovementsMapper {

	@Override
	protected void configure(final MapperFactory factory) {
		// Add Money Converter
		factory.getConverterFactory().registerConverter(new MoneyConverter());
		
		// Map Check DTO
		factory.classMap(Movement.class, MovementDto.class).field("id", "movementId").field("concept", "movementConcept")
				.field("transactionDate", "movementDate").field("operationDate", "movementDetailDTO.operationDate").field("operation.code", "movementDetailDTO.operationCode").field("operation.description", "movementDetailDTO.operationDescription")
				.field("office.name", "movementDetailDTO.plaza").field("office.location", "movementDetailDTO.originCenterMovement").field("status", "movementDetailDTO.state").field("value", "movementValue")
				.field("balance", "totalBalance").field("numberOfQuotas", "quotaNumber").byDefault().register();
	}
	

	@Override
	public MovementDetailDto mapMovement(Movement movement) {
		final MovementDetailDto movementDetailDto = map(movement, MovementDetailDto.class);
		return movementDetailDto;
	}
	
	@Override
	public List<MovementDto> mapMovementDtoList(List<Movement> movementList) {
		final List<MovementDto> movementDtoList = mapAsList(movementList, MovementDto.class);
		return movementDtoList;
	}
	

}
