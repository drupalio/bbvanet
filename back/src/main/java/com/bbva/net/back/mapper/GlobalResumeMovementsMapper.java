package com.bbva.net.back.mapper;

import java.util.List;

import com.bbva.czic.dto.net.AccMovementsResume;
import com.bbva.net.back.model.movements.MovementsResumeDTO;

public interface GlobalResumeMovementsMapper {

	/**
	 * @param movementsResume
	 * @return
	 */
	// GlobalResumeMovementsDTO map(List<AccMovementsResume> movementsResume);

	List<MovementsResumeDTO> map(final List<AccMovementsResume> movementsResume);

}
