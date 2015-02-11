package com.bbva.net.front.core.cxf;

import java.util.List;
import java.util.Map;

import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang.StringUtils;
import org.apache.cxf.interceptor.AbstractInDatabindingInterceptor;
import org.apache.cxf.interceptor.Fault;
import org.apache.cxf.message.Message;
import org.apache.cxf.phase.Phase;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.faces.webflow.FlowFacesContext;

/**
 * @author Entelgy
 */
public class ResponseInterceptor extends AbstractInDatabindingInterceptor {

	protected static final Logger LOGGER = LoggerFactory.getLogger(ResponseInterceptor.class);

	private enum TSecType {
		tsec
	}

	public ResponseInterceptor() {
		super(Phase.RECEIVE);
	}

	@SuppressWarnings("unchecked")
	@Override
	public void handleMessage(final Message outMessage) throws Fault {

		String uri = StringUtils.EMPTY;

		try {

			uri = (String)outMessage.get(Message.REQUEST_URL);
			final FacesContext facesContext = FlowFacesContext.getCurrentInstance();

			LOGGER.info("INTERCEPTANDO RESPUESTA : " + uri);
			final HttpSession session = (HttpSession)facesContext.getExternalContext().getSession(false);
			final Map<String, List<String>> headers = (Map<String, List<String>>)outMessage
					.get(Message.PROTOCOL_HEADERS);
			final String tsec = headers.get(TSecType.tsec.name()).get(0);

			LOGGER.info("Recogiendo TSEC y añadiendo a sesión:" + tsec);
			session.setAttribute(TSecType.tsec.name(), tsec);

		} catch (final Exception exception) {
			LOGGER.info("ERROR RESPONSE INTERCEPTOR CON URI: " + uri);
		}

	}
}
