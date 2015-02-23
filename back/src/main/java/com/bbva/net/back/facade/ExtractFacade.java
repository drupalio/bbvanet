package com.bbva.net.back.facade;

import java.util.List;

import com.bbva.net.back.model.extract.ExtractDto;

public interface ExtractFacade {

	List<ExtractDto> getExtractAvailablePeriod(String productId, String filter);

}
