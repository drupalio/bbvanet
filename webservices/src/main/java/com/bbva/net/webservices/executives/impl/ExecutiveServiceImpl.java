package com.bbva.net.webservices.executives.impl;

import org.apache.commons.lang.StringUtils;
import org.apache.cxf.jaxrs.client.WebClient;

import com.bbva.czic.dto.net.Executive;
import com.bbva.net.webservices.core.pattern.AbstractBbvaRestService;
import com.bbva.net.webservices.core.stereotype.RestService;
import com.bbva.net.webservices.executives.ExecutiveService;
import com.google.gson.Gson;

@RestService(value = "executiveService")
public class ExecutiveServiceImpl extends AbstractBbvaRestService implements ExecutiveService {

	@Override
	public Executive getExecutive(String filter, String $fields, String $expands, String $sort) {

		WebClient wc = getJsonWebClient(URL_BASE_EXECUTIVE);

		LOGGER.info("PETICION: " + wc.getCurrentURI());
		if (!StringUtils.isEmpty(filter)) wc.query("$filter", filter);
		final Executive executive = wc.get(Executive.class);
		final Gson gson = new Gson();
		String json = gson.toJson(executive);
		LOGGER.info("JSON EXECUTIVE: " + json);

		return executive;

	}

}
