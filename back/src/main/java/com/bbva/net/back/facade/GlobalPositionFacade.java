package com.bbva.net.back.facade;

import com.bbva.net.back.model.globalposition.GlobalProductsDTO;

public interface GlobalPositionFacade {

	GlobalProductsDTO getGlobalProductsByUserVisible(String defaultUser, boolean b);

	GlobalProductsDTO getGlobalProductsByUser(String user);

}
