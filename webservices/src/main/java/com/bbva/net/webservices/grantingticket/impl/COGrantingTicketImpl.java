package com.bbva.net.webservices.grantingticket.impl;

import org.apache.cxf.jaxrs.client.WebClient;

import com.bbva.net.webservices.core.pattern.AbstractBbvaRestService;
import com.bbva.net.webservices.core.stereotype.RestService;
import com.bbva.net.webservices.grantingticket.SrvCOGrantingTicket;
import com.bbva.saz.co.grantingticket.v01.AuthenticationState;
import com.bbva.saz.co.grantingticket.v01.ConsumerContext;

@RestService(value = "grantingTicket")
public class COGrantingTicketImpl extends AbstractBbvaRestService implements SrvCOGrantingTicket {

	@Override
	public void deleteTicket() {
		// TODO Auto-generated method stub

	}

	@Override
	public AuthenticationState createTicket(ConsumerContext consumercontext) {

		WebClient wc = getJsonWebClient(URL_GRANTING);
		wc.put(consumercontext);
		return (AuthenticationState)wc.getCollection(AuthenticationState.class);
	}

}
