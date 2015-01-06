package com.bbva.net.back.mapper.impl;

import java.util.List;

import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.ConfigurableMapper;

import com.bbva.czic.dto.net.AccMovementsResume;
import com.bbva.net.back.core.stereotype.Mapper;
import com.bbva.net.back.mapper.GlobalResumeMovementsMapper;
import com.bbva.net.back.model.movements.MovementsResumeDTO;

/**
 * Clase de implementa el mapeo entre los objetos de servicio y los objetos DTO para resumen de movimientos en cuentas
 * 
 * @author Entelgy
 */
@Mapper(value = "globalResumeMovementsMapper")
public class GlobalResumeMovementsMapperImpl extends ConfigurableMapper implements GlobalResumeMovementsMapper {

	@Override
	protected void configure(MapperFactory factory) {
		factory.classMap(AccMovementsResume.class, MovementsResumeDTO.class).field("income", "inCome")
				.field("outcome", "outCome").field("balance", "balance").field("month", "month").byDefault().register();
	}

	@Override
	public List<MovementsResumeDTO> map(final List<AccMovementsResume> movementsResume) {
		return mapAsList(movementsResume, MovementsResumeDTO.class);
	}

}
