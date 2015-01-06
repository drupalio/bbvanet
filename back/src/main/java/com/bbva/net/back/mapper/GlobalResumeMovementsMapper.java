package com.bbva.net.back.mapper;

import java.util.List;

import com.bbva.czic.dto.net.AccMovementsResume;
import com.bbva.net.back.model.movements.GlobalResumeMovementsDto;

public interface GlobalResumeMovementsMapper {

	GlobalResumeMovementsDto map(List<AccMovementsResume> movementsResume);

}
