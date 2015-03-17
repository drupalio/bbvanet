package com.bbva.net.webservices.subjects.impl;

import org.apache.cxf.jaxrs.client.WebClient;

import com.bbva.net.webservices.core.pattern.AbstractBbvaRestService;
import com.bbva.net.webservices.core.stereotype.RestService;
import com.bbva.net.webservices.subjects.SubjetsService;
import com.bbva.zic.subjects.v01.UpdateAccountOut;
import com.bbva.zic.subjects.v01.UpdateSubjectIn;

@RestService(value = "subjetsService")
public class SubjetsServiceImpl extends AbstractBbvaRestService implements SubjetsService {

	@Override
	public UpdateAccountOut updateSubject(String contractNumber, UpdateSubjectIn updatesubjectin) {
		final WebClient webc = getJsonWebClient(URL_SUBJETS);
		webc.put(updatesubjectin);
		if (webc.getResponse().getStatus() == 200) {
			return webc.get(UpdateAccountOut.class);
		}
		return null;
	}
}
