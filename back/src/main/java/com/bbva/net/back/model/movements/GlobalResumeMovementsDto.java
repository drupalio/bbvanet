package com.bbva.net.back.model.movements;

import java.io.Serializable;
import java.util.List;

public class GlobalResumeMovementsDto implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3416944562783875982L;

	/**
	 * 
	 */
	private List<MovementsResumeDto> movementsResumeDTO;

	/**
	 * @return
	 */
	public List<MovementsResumeDto> getMovementsResumeDto() {
		return movementsResumeDTO;
	}

	/**
	 * @param movementsResumeDTO
	 */
	public void setMovementsResumeDto(final List<MovementsResumeDto> movementsResumeDTO) {
		this.movementsResumeDTO = movementsResumeDTO;
	}

}