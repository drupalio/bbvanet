package com.bbva.net.front.core.cxf;

import java.util.List;
import java.util.Map;

import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;
import javax.ws.rs.core.Context;

import org.apache.cxf.interceptor.AbstractOutDatabindingInterceptor;
import org.apache.cxf.interceptor.Fault;
import org.apache.cxf.jaxrs.ext.MessageContext;
import org.apache.cxf.message.Message;
import org.apache.cxf.phase.Phase;
import org.springframework.faces.webflow.FlowFacesContext;

public class RequestInterceptor extends AbstractOutDatabindingInterceptor {

	@Context
	private MessageContext messageContext;

	public RequestInterceptor() {
		super(Phase.SEND);
	}

	@SuppressWarnings("unchecked")
	@Override
	public void handleMessage(Message outMessage) throws Fault {

		final FacesContext facesContext = FlowFacesContext.getCurrentInstance();
		HttpSession session = (HttpSession)facesContext.getExternalContext().getSession(false);

		Map<String, List<String>> headers = (Map<String, List<String>>)outMessage.get(Message.PROTOCOL_HEADERS);

	}
}