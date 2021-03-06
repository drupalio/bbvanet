package com.bbva.net.back.mapper;

import java.util.List;

import com.bbva.czic.dto.net.AccMovementsResume;
import com.bbva.net.back.model.movements.MovementsResumeDto;

public interface GlobalResumeMovementsMapper {

	/**
	 * Mapea la lista resumen de movimientos del servicio, al objeto DTO de negocio
	 * 
	 * @param movementsResume
	 */
	List<MovementsResumeDto> map(final List<AccMovementsResume> movementsResume);

}
