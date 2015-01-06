package com.bbva.net.back.facade;

import java.util.List;

import com.bbva.net.back.model.globalposition.FundDTO;

public interface FundsTypeFacade {

	List<FundDTO> getFundsDataGraphic(String usuario);

}
