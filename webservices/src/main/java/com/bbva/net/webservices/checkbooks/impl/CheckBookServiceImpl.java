/**
 * 
 */
package com.bbva.net.webservices.checkbooks.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
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

	@Value("${rest.base.check.url}")
	private String URL_BASE_CHECK;

	@Value("${rest.checkBook.url}")
	private String URL_CHECKBOOK;

	@Override
	public List<Check> getChecks(String checkId, String $filter, String $fields, String $expands, String $sort) {
		final List<Check> checkList = new ArrayList<Check>();

		final Check[] check = restTemplate.getForObject(URL_BASE_CHECK + URL_CHECKBOOK + checkId, Check[].class);

		CollectionUtils.addAll(checkList, check);

		return checkList;
	}

	@Override
	public List<Checkbook> getCheckbooks(String checkbookId, String $filter, String $fields, String $expands,
			String $sort) {
		List<Checkbook> listCheckBook = new ArrayList<Checkbook>();

		final Checkbook[] check = restTemplate.getForObject(URL_BASE_CHECK + checkbookId, Checkbook[].class);

		CollectionUtils.addAll(listCheckBook, check);

		return listCheckBook;
	}

}
