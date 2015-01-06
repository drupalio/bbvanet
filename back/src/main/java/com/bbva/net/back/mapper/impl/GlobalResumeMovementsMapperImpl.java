package com.bbva.net.back.mapper.impl;

import java.util.List;

import ma.glasnost.orika.impl.ConfigurableMapper;

import com.bbva.czic.dto.net.AccMovementsResume;
import com.bbva.net.back.core.stereotype.Mapper;
import com.bbva.net.back.mapper.GlobalResumeMovementsMapper;
import com.bbva.net.back.model.movements.GlobalResumeMovementsDto;

@Mapper(value = "globalResumeMovementsMapper")
public class GlobalResumeMovementsMapperImpl extends ConfigurableMapper implements GlobalResumeMovementsMapper {

	@Override
	public GlobalResumeMovementsDto map(List<AccMovementsResume> movementsResume) {

		GlobalResumeMovementsDto globalResumeMovement = new GlobalResumeMovementsDto();

		// Implementar mapeo entre objetos del servicio y los objetos DTO de negocio

		return globalResumeMovement;
	}

}
