package com.bbva.net.back.core.pattern.facade;

import java.io.Serializable;

import com.bbva.jee.arq.spring.core.log.I18nLog;
import com.bbva.jee.arq.spring.core.log.I18nLogFactory;

// import org.apache.cxf.jaxrs.client.ResponseReader;

/**
 * @author Entelgy
 */
public abstract class AbstractBbvaFacade implements Serializable {

	private static final long serialVersionUID = -7094218995274928374L;

	protected static final I18nLog LOGGER = I18nLogFactory.getLogI18n(AbstractBbvaFacade.class);

}
