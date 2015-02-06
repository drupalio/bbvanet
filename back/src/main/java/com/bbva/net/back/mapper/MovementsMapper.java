/**
 * 
 */
package com.bbva.net.back.mapper;

import java.util.List;

import com.bbva.czic.dto.net.Movement;
import com.bbva.net.back.model.movements.MovementDetailDto;
import com.bbva.net.back.model.movements.MovementDto;


/**
 * Class to mapping Movement Canonical to MovementDto and MovementDetailDto
 * @author User
 *
 */
public interface MovementsMapper {

	/***
	 * Method for mapping a movement to MovementDetailDto
	 * @param movement
	 * @return MovementDetailDto
	 */
	MovementDetailDto mapMovement(Movement movement);

	/****
	 * Mapping for mapping a movement to movementDto list
	 * @param movementList
	 * @return List<MovementDto> 
	 */
	List<MovementDto> mapMovementDtoList(List<Movement> movementList);

}
