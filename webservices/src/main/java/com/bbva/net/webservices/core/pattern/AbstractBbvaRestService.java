package com.bbva.net.webservices.core.pattern;

import java.util.List;

import javax.annotation.Resource;
import javax.ws.rs.core.Response;

import org.apache.commons.logging.Log;
import org.apache.cxf.jaxrs.client.JAXRSClientFactoryBean;
import org.apache.cxf.jaxrs.client.WebClient;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import com.bbva.jee.arq.spring.core.log.I18nLogFactory;

public abstract class AbstractBbvaRestService {

	protected static final Log LOGGER = I18nLogFactory.getLog(AbstractBbvaRestService.class);

	@Resource(name = "restTemplate")
	protected RestTemplate restTemplate;

	@Resource(name = "factoryBean")
	private JAXRSClientFactoryBean factoryBean;

	@Value("${rest.base.url}")
	protected String URL_BASE;

	@Value("${rest.global.base}")
	protected String URL_GLOBAL_BASE;

	@Value("${rest.base.customer.url}")
	protected String URL_BASE_CUSTOMER;

	@Value("${rest.quotaRotary.base.url}")
	protected String URL_BASE_ROTARYQUOTA;

	@Value("${rest.quotaRotary.move.url}")
	protected String URL_ROTARYQUOTA_MOVE;

	@Value("${rest.quotaRotary.moves.url}")
	protected String URL_ROTARYQUOTA_MOVES;

	@Value("${rest.base.executive.url}")
	protected String URL_BASE_EXECUTIVE;
	
	@Value("${rest.executive.url}")
	protected String URL_GETEXECUTIVE;
	
	@Value("${rest.base.getexecutive.url}")
	protected String URL_GETCUSTOMER;

	@Value("${rest.base.cards.url}")
	protected String URL_BASE_CARDS;

	@Value("${rest.base.products.url}")
	protected String URL_BASE_PRODUCTS;

	@Value("${rest.products.url}")
	protected String URL_PRODUCTS;

	@Value("${rest.base.accounts.url}")
	protected String URL_BASE_ACCOUNTS;

	@Value("${rest.accounts.url}")
	protected String URL_ACCOUNTS;

	@Value("${rest.list.check.url}")
	protected String URL_CHECK_LIST;

	@Value("${rest.mounthBalance.url}")
	protected String URL_MOUNTHBALANCE;

	@Value("${rest.granting.url}")
	protected String URL_GRANTING;

	@Value("${rest.movements.url}")
	protected String URL_MOVEMENTS;

	@Value("${rest.extract.url}")
	protected String UR_EXTRACT;

	@Value("${rest.agileOperations.url}")
	protected String URL_BASE_OPERATIONS;

	@Value("${rest.subjets.url}")
	protected String URL_SUBJETS;
	
	@Value("${rest.agileValidated.url}")
	protected String URL_VALIDATED;

	/**
	 * @param response
	 * @param entityClass
	 * @return
	 * @throws RestClientException
	 */
	protected <T> T readJsonValue(Response response, Class<T> entityClass) throws RestClientException {

		try {
			return new ObjectMapper().readValue((String)response.getEntity(), entityClass);
		} catch (final Exception exception) {
			throwsRestClientException(exception);
		}

		return null;
	}

	/**
	 * @param URL
	 * @return
	 */
	protected WebClient getJsonWebClient(String URL) {
		factoryBean.setAddress(URL);
		final WebClient webClient = factoryBean.createWebClient();
		webClient.accept("application/json").type("application/json");
		factoryBean.getInInterceptors();

		return webClient;

	}

	/**
	 * @param URL
	 * @return
	 */
	@SuppressWarnings("unchecked")
	protected <T> List<T> getJsonCollection(final String URL, Class<T> clazz) {
		return (List<T>)getJsonWebClient(URL).getCollection(clazz);
	}

	/**
	 * @param exception
	 * @throws RestClientException
	 */
	protected void throwsRestClientException(final Exception exception) throws RestClientException {
		throw new RestClientException("Rest Client ERROR ", exception);
	}

	/**
	 * @param restTemplate
	 */
	public void setRestTemplate(RestTemplate restTemplate) {
		this.restTemplate = restTemplate;
	}

	/**
	 * @param factoryBean
	 */
	public void setFactoryBean(JAXRSClientFactoryBean factoryBean) {
		this.factoryBean = factoryBean;
	}

	/**
	 * @param URL
	 */
	public void setURL_BASE(String URL) {
		this.URL_BASE = URL;
	}

}
