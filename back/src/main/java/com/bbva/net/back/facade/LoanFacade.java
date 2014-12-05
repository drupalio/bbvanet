package com.bbva.net.back.facade;

import java.util.List;

import co.com.bbva.services.transactions.globalposition.schema.GlobalProducts;
import co.com.bbva.services.transactions.globalposition.schema.Leasing;
import co.com.bbva.services.transactions.globalposition.schema.RotatingAccount;

public interface LoanFacade {

	public List<Leasing> getLeasingByUser(String defaultUser);

	public List<RotatingAccount> getRotatingAccountByUser(String defaultUser);

	public GlobalProducts getLoansByUser(String defaultUser);

}
