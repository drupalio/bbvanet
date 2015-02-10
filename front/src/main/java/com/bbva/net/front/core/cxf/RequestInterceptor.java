package com.bbva.net.front.core.cxf;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import org.apache.cxf.interceptor.AbstractOutDatabindingInterceptor;
import org.apache.cxf.interceptor.Fault;
import org.apache.cxf.message.Message;
import org.apache.cxf.phase.Phase;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.faces.webflow.FlowFacesContext;

/**
 * @author Entelgy
 */
public class RequestInterceptor extends AbstractOutDatabindingInterceptor {

	protected static final Logger LOGGER = LoggerFactory.getLogger(RequestInterceptor.class);

	private enum TSecType {
		tsec
	}

	public RequestInterceptor() {
		super(Phase.SEND);
	}

	@SuppressWarnings("unchecked")
	@Override
	public void handleMessage(Message outMessage) throws Fault {
		try {

			final FacesContext facesContext = FlowFacesContext.getCurrentInstance();

			LOGGER.info("INTERCEPTANDO PETICION: " + facesContext.getExternalContext().getRequest().toString());
			final HttpSession session = (HttpSession)facesContext.getExternalContext().getSession(false);
			final Map<String, List<String>> headers = (Map<String, List<String>>)outMessage
					.get(Message.PROTOCOL_HEADERS);
			final List<String> tsecHeader = new ArrayList<String>();
			String tsec = (String)session.getAttribute(TSecType.tsec.name());
			LOGGER.info("Recogiendo TSEC de la Sesión y añadiendo a cabecera:" + tsec);
			tsecHeader.add(tsec);
			headers.put(TSecType.tsec.name(), tsecHeader);
		} catch (final Exception exception) {
			LOGGER.info("ERROR REQUEST INTERCEPTOR: " + exception.getMessage());
		}

	}
}
