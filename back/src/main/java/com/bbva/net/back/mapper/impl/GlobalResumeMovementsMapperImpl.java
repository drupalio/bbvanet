package com.bbva.net.back.mapper.impl;

import java.util.List;

import ma.glasnost.orika.impl.ConfigurableMapper;

import com.bbva.czic.dto.net.AccMovementsResume;
import com.bbva.net.back.core.stereotype.Mapper;
import com.bbva.net.back.mapper.GlobalResumeMovementsMapper;
import com.bbva.net.back.model.movements.GlobalResumeMovementsDTO;

@Mapper(value = "globalResumeMovementsMapper")
public class GlobalResumeMovementsMapperImpl extends ConfigurableMapper implements GlobalResumeMovementsMapper {

	@Override
	public GlobalResumeMovementsDTO map(List<AccMovementsResume> movementsResume) {

		GlobalResumeMovementsDTO globalResumeMovement = new GlobalResumeMovementsDTO();

		// Implementar mapeo entre objetos del servicio y los objetos DTO de negocio

		return globalResumeMovement;
	}

}
