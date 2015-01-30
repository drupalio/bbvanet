package com.bbva.net.front.core.cxf;

import java.util.List;
import java.util.Map;

import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import org.apache.cxf.interceptor.AbstractInDatabindingInterceptor;
import org.apache.cxf.interceptor.Fault;
import org.apache.cxf.message.Message;
import org.apache.cxf.phase.Phase;
import org.springframework.faces.webflow.FlowFacesContext;

/**
 * @author Entelgy
 */
public class ResponseInterceptor extends AbstractInDatabindingInterceptor {

	private enum TSecType {
		tsec
	}

	public ResponseInterceptor() {
		super(Phase.RECEIVE);
	}

	@SuppressWarnings("unchecked")
	@Override
	public void handleMessage(final Message outMessage) throws Fault {

		final FacesContext facesContext = FlowFacesContext.getCurrentInstance();
		final HttpSession session = (HttpSession)facesContext.getExternalContext().getSession(false);
		final Map<String, List<String>> headers = (Map<String, List<String>>)outMessage.get(Message.PROTOCOL_HEADERS);
		session.setAttribute(TSecType.tsec.name(), headers.get(TSecType.tsec.name()).get(0));

	}
}
