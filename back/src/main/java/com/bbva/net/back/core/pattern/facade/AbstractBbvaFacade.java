package com.bbva.net.back.core.pattern.facade;

import java.io.Serializable;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

// import org.apache.cxf.jaxrs.client.ResponseReader;

/**
 * @author Entelgy
 */
public abstract class AbstractBbvaFacade implements Serializable {

	private static final long serialVersionUID = -7094218995274928374L;

	protected static final Logger LOG = LoggerFactory.getLogger(AbstractBbvaFacade.class);

}
