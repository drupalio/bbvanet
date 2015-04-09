package com.bbva.net.back.mapper.impl;

import java.util.List;

import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.ConfigurableMapper;

import org.apache.commons.logging.Log;

import com.bbva.czic.dto.net.Movement;
import com.bbva.jee.arq.spring.core.log.I18nLogFactory;
import com.bbva.net.back.core.stereotype.Mapper;
import com.bbva.net.back.mapper.MovementsMapper;
import com.bbva.net.back.mapper.converter.MoneyConverter;
import com.bbva.net.back.mapper.converter.StringToDateConverter;
import com.bbva.net.back.model.movements.MovementDetailDto;
import com.bbva.net.back.model.movements.MovementDto;

@Mapper(value = "movementsMapper")
public class MovementsMapperImpl extends ConfigurableMapper implements MovementsMapper {

	protected static final Log LOGGER = I18nLogFactory.getLog(MovementsMapperImpl.class);

	@Override
	protected void configure(final MapperFactory factory) {
		// Add Money Converter
		factory.getConverterFactory().registerConverter(new MoneyConverter());
		// Add Date Converter
		factory.getConverterFactory().registerConverter(new StringToDateConverter("yyyy-MM-dd"));

		// Map Movement DTO
		factory.classMap(Movement.class, MovementDto.class).field("id", "movementId")
				.field("id", "movementDetailDto.id").field("concept", "movementConcept")
				.field("concept", "movementDetailDto.concept").field("transactionDate", "movementDate")
				.field("transactionDate", "movementDetailDto.transactionDate").field("operationDate", "operationDate")
				.field("operationDate", "movementDetailDto.operationDate")
				.field("operation.code", "movementDetailDto.operationCode")
				.field("operation.description", "movementDetailDto.operationDescription")
				.field("office.name", "movementDetailDto.originCenterMovement")
				.field("office.location.city.name", "movementDetailDto.plaza")
				.field("status", "movementDetailDto.state").field("value", "movementValue")
				.field("value", "movementDetailDto.operationValue").field("balance", "movementDetailDto.valueslope")
				.field("balance", "totalBalance").byDefault().register();

		factory.classMap(Movement.class, MovementDetailDto.class).field("id", "id").field("concept", "concept")
				.field("transactionDate", "transactionDate").field("operationDate", "operationDate")
				.field("operation.code", "operationCode").field("operation.description", "operationDescription")
				.field("office.name", "originCenterMovement").field("office.location.city.name", "plaza")
				.field("value", "operationValue").field("balance", "valueslope").byDefault().register();
	}

	@Override
	public MovementDetailDto mapMovement(Movement movement) {
		final MovementDetailDto movementDetailDto = map(movement, MovementDetailDto.class);
		LOGGER.info("DETALLE DE MOVIMIENTO CAPTURADO: " + movementDetailDto);
		return movementDetailDto;
	}

	@Override
	public List<MovementDto> mapMovementDtoList(List<Movement> movementList) {
		return mapAsList(movementList, MovementDto.class);
	}

}
