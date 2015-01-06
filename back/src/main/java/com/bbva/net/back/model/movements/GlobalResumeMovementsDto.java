package com.bbva.net.back.model.movements;

import java.io.Serializable;
import java.util.List;

public class GlobalResumeMovementsDto implements Serializable {

	private static final long serialVersionUID = 3416944562783875982L;

	private List<MovementsResumeDto> globalMovementsDTO;

	public List<MovementsResumeDto> getGlobalMovementsDTO() {
		return globalMovementsDTO;
	}

	public void setGlobalMovementsDTO(List<MovementsResumeDto> globalMovementsDTO) {
		this.globalMovementsDTO = globalMovementsDTO;
	}

}
