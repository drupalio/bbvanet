package com.bbva.net.webservices.executives.impl;

import org.apache.commons.lang.StringUtils;
import org.apache.cxf.jaxrs.client.WebClient;
import org.springframework.web.client.RestClientException;

import com.bbva.czic.dto.net.Executive;
import com.bbva.net.webservices.core.pattern.AbstractBbvaRestService;
import com.bbva.net.webservices.core.stereotype.RestService;
import com.bbva.net.webservices.executives.ExecutiveService;

/**
 * @author Entelgy
 */
@RestService(value = "executiveService")
public class ExecutiveServiceImpl extends AbstractBbvaRestService implements ExecutiveService {

	/**
	 * 
	 */
	@Override
	public Executive getExecutive(final String filter, final String fields, final String expands, final String sort) {

		try {
			final WebClient webC = getJsonWebClient(URL_BASE_EXECUTIVE);
			if (!StringUtils.isEmpty(filter)) webC.query("$filter", filter);
			return webC.get(Executive.class);

		} catch (Exception e) {
			throw new RestClientException("Servicio no disponible. - oznr");

		}
	}

}
