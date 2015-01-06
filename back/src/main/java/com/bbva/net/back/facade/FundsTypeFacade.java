package com.bbva.net.back.facade;

import java.util.List;

import com.bbva.net.back.model.globalposition.FundDto;

public interface FundsTypeFacade {

	List<FundDto> getFundsDataGraphic(String usuario);

}
