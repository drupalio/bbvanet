package com.bbva.net.webservices.core.pattern;

import java.io.IOException;

import javax.annotation.Resource;
import javax.ws.rs.core.Response;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

public abstract class AbstractBbvaRestService {


	
	@Resource(name="restTemplate")
	protected RestTemplate restTemplate;

	/**
	 * 
	 * @param response
	 * @param entityClass
	 * @return
	 * @throws RestClientException 
	*/
	
	protected <T> T readJsonValue(Response response, Class<T> entityClass) throws RestClientException {
		
		try {
			return new ObjectMapper().readValue((String)response.getEntity(), entityClass);
		} catch (final JsonParseException e) {
			throwsRestClientException(e);
		} catch (final JsonMappingException e) {
			throwsRestClientException(e);
		} catch (final IOException e) {
			throwsRestClientException(e);
		}
		
		return null;
	}

	

	private void throwsRestClientException(final Exception exception) throws RestClientException {
		throw new RestClientException("Rest Client ERROR ",exception);
	}



	public void setRestTemplate(RestTemplate restTemplate) {
		this.restTemplate = restTemplate;
	}
	
}
