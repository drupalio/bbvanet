package com.bbva.net.back.facade;

import co.com.bbva.services.transactions.globalposition.schema.GlobalProducts;

public interface GlobalPositionFacade {

	public GlobalProducts getGlobalProductsByUser(String user);

	public GlobalProducts getGlobalProductsByUserVisible(String defaultUser, boolean b);

}
