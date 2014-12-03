package com.bbva.net.back.facade;

import co.com.bbva.services.transactions.globalposition.schema.GlobalProducts;

public interface LoanFacade {

	public GlobalProducts getLoansByUser(String user);

}
