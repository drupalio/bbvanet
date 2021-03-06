package com.bbva.net.back.mapper.impl;

import java.util.List;

import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.ConfigurableMapper;

import com.bbva.czic.dto.net.Movement;
import com.bbva.net.back.core.stereotype.Mapper;
import com.bbva.net.back.mapper.MovementsMapper;
import com.bbva.net.back.mapper.converter.MoneyConverter;
import com.bbva.net.back.mapper.converter.StringToDateConverter;
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
                .field("operationDate", "operationDate").field("balance", "totalBalance")
                .field("concept", "movementDetailDto.concept").field("value", "movementValue")
                .field("operation.description", "movementDetailDto.operationDescription")
                .field("status", "status").byDefault().register();
        
        // <!-- Entelgy / SPRING 3 / 26102015 / INICIO -->
        factory.classMap(Movement.class, MovementDetailDto.class).field("id", "id").field("concept", "concept")
                .field("transactionDate", "transactionDate").field("operationDate", "operationDate")
                .field("transactionDate", "operationHour").field("operation.code", "operationCode")
                .field("operation.description", "operationDescription").field("office.name", "originCenterMovement")
                .field("status", "state").field("office.location.state.name", "plaza.name").field("office.location.city.name", "plaza.city")
                .field("office.code", "plaza.code").field("value", "operationValue").field("balance", "valueslope").byDefault().register();
        // <!-- Entelgy / SPRING 3 / 26102015 / FIN -->
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
