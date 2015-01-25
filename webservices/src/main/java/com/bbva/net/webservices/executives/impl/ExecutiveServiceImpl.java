package com.bbva.net.webservices.executives.impl;

import org.apache.commons.lang.StringUtils;
import org.apache.cxf.jaxrs.client.WebClient;

import com.bbva.czic.dto.net.Executive;
import com.bbva.net.webservices.core.pattern.AbstractBbvaRestService;
import com.bbva.net.webservices.core.stereotype.RestService;
import com.bbva.net.webservices.executives.ExecutiveService;

@RestService(value = "executiveService")
public class ExecutiveServiceImpl extends AbstractBbvaRestService implements ExecutiveService {

	@Override
	public Executive getExecutive(String filter, String $fields, String $expands, String $sort) {

		WebClient wc = getJsonWebClient(URL_BASE_EXECUTIVE);
		if (!StringUtils.isEmpty(filter)) wc.query("$filter", filter);
		return wc.get(Executive.class);
	}

}
