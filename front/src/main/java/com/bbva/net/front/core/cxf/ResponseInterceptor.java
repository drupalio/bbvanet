package com.bbva.net.front.core.cxf;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import org.apache.cxf.interceptor.AbstractInDatabindingInterceptor;
import org.apache.cxf.interceptor.Fault;
import org.apache.cxf.message.Message;
import org.apache.cxf.phase.Phase;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.faces.webflow.FlowFacesContext;

import com.google.common.annotations.VisibleForTesting;

/**
 * @author Entelgy
 */
public class ResponseInterceptor extends AbstractInDatabindingInterceptor implements BbvaInterceptor {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4873323292250777236L;

	protected static final Logger LOGGER = LoggerFactory.getLogger(ResponseInterceptor.class);

	@VisibleForTesting
	protected enum TSecType {
		tsec
	}

	public ResponseInterceptor() {
		super(Phase.RECEIVE);
	}

	@SuppressWarnings("unchecked")
	@Override
	public void handleMessage(final Message outMessage) throws Fault {
		String status = "";
		try {

			status = outMessage.get(Message.RESPONSE_CODE).toString();
			LOGGER.info("service con status::" + status);

			final FacesContext facesContext = FlowFacesContext.getCurrentInstance();
			LOGGER.info("INTERCEPTANDO RESPUESTA : " + facesContext.getExternalContext().getRequestServletPath());
			final HttpSession session = (HttpSession)facesContext.getExternalContext().getSession(false);

			final Map<String, List<String>> headers = (Map<String, List<String>>)outMessage
					.get(Message.PROTOCOL_HEADERS);
			final String tsec = headers.get(TSecType.tsec.name()).get(0);
			LOGGER.info("Recogiendo TSEC y añadiendo a sesión:" + tsec);
			session.setAttribute(TSecType.tsec.name(), tsec);
			session.setAttribute("lastService", new Date());
		} catch (final Exception exception) {

			LOGGER.info("Excepcion con Status :" + status);
			// Muestra el mensaje de error de tsec caducado
			if (status.trim().equals("403")) {
				LOGGER.info("Se Redirecciona a la pagina publica con status:" + status);
				try {
					FacesContext context = FlowFacesContext.getCurrentInstance();
					context.getExternalContext().redirect("/error/error.xhtml");
					// RequestContext.getCurrentInstance().execute("PF('mistake').show();");
				} catch (Exception d) {

				}
			}
			LOGGER.info("ERROR RESPONSE INTERCEPTOR: " + exception.getCause());
		}

	}
}
