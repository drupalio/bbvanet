package com.bbva.net.back.model.movements;

import java.io.Serializable;
import java.util.List;

public class GlobalResumeMovementsDTO implements Serializable {

	private static final long serialVersionUID = 3416944562783875982L;

	private List<MovementsResumeDTO> movementsResumeDTO;

	public List<MovementsResumeDTO> getMovementsResumeDTO() {
		return movementsResumeDTO;
	}

	public void setMovementsResumeDTO(List<MovementsResumeDTO> movementsResumeDTO) {
		this.movementsResumeDTO = movementsResumeDTO;
	}

}
