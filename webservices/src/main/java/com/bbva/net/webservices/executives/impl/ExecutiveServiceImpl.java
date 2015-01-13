package com.bbva.net.webservices.executives.impl;

import com.bbva.czic.dto.net.Executive;
import com.bbva.net.webservices.core.pattern.AbstractBbvaRestService;
import com.bbva.net.webservices.core.stereotype.RestService;
import com.bbva.net.webservices.executives.ExecutiveService;

@RestService(value = "executiveService")
public class ExecutiveServiceImpl extends AbstractBbvaRestService implements ExecutiveService {

	@Override
	public Executive getExecutive(String filter, String $fields, String $expands, String $sort) {
		final Executive executive = restTemplate.getForObject(URL_BASE_EXECUTIVE, Executive.class);
		return executive;
	}

}
