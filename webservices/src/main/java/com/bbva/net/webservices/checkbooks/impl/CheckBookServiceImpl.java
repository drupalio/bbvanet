/**
 * 
 */
package com.bbva.net.webservices.checkbooks.impl;

import java.util.List;

import org.apache.cxf.jaxrs.client.WebClient;
import org.springframework.beans.factory.annotation.Value;

import com.bbva.czic.dto.net.Check;
import com.bbva.czic.dto.net.Checkbook;
import com.bbva.net.webservices.checkbooks.CheckBookService;
import com.bbva.net.webservices.core.pattern.AbstractBbvaRestService;
import com.bbva.net.webservices.core.stereotype.RestService;

/**
 * @author User
 */
@RestService(value = "checkBookService")
public class CheckBookServiceImpl extends AbstractBbvaRestService implements CheckBookService {

	@Value("${rest.base.check.books.url}")
	private String URL_BASE_CHECK;

	@Value("${rest.checkBook.url}")
	private String URL_CHECKBOOK;

	@Override
	public Check getChecks(String checkId, String $filter, String $fields, String $expands, String $sort) {

		WebClient wc = getJsonWebClient(URL_BASE_CHECK +URL_CHECKBOOK+ checkId);
		
		if($filter!=null){
			wc.query("filtro", $filter);
		}
		return (Check)wc.get(Check.class);

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Checkbook> getCheckbooks(String checkbookId, String $filter, String $fields, String $expands,
			String $sort) {
		WebClient wc = getJsonWebClient(URL_BASE_CHECK + checkbookId);
		wc.query("filtro", $filter);
		return (List<Checkbook>)wc.getCollection(Checkbook.class);

	}

}
