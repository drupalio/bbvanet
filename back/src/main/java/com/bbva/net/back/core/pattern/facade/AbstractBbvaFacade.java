package com.bbva.net.back.core.pattern.facade;

import java.io.Serializable;

import org.apache.commons.logging.Log;

import com.bbva.jee.arq.spring.core.log.I18nLogFactory;

// import org.apache.cxf.jaxrs.client.ResponseReader;

/**
 * @author Entelgy
 */
public abstract class AbstractBbvaFacade implements Serializable {

	private static final long serialVersionUID = -7094218995274928374L;

	protected static final Log LOGGER = I18nLogFactory.getLog(AbstractBbvaFacade.class);

}
