package com.bbva.net.back.mapper;

import java.util.List;

import com.bbva.czic.dto.net.AccMovementsResume;
import com.bbva.net.back.model.movements.GlobalResumeMovementsDTO;

public interface GlobalResumeMovementsMapper {

	GlobalResumeMovementsDTO map(List<AccMovementsResume> movementsResume);

}
