package com.bbva.net.back.facade;


import com.bbva.net.back.model.globalposition.GlobalProductsDTO;


public interface GlobalPositionFacade {

	public GlobalProductsDTO getGlobalProductsByUser(String user);
		
}
