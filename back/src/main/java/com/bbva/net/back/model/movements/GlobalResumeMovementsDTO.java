package com.bbva.net.back.model.movements;

import java.io.Serializable;
import java.util.List;

public class GlobalResumeMovementsDTO implements Serializable {

	private static final long serialVersionUID = 3416944562783875982L;

	private List<MovementsResumeDTO> globalMovementsDTO;

	public List<MovementsResumeDTO> getGlobalMovementsDTO() {
		return globalMovementsDTO;
	}

	public void setGlobalMovementsDTO(List<MovementsResumeDTO> globalMovementsDTO) {
		this.globalMovementsDTO = globalMovementsDTO;
	}

}
