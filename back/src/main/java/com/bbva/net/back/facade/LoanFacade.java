package com.bbva.net.back.facade;

import java.util.List;

import com.bbva.net.back.model.globalposition.GlobalProductsDTO;
import com.bbva.net.back.model.globalposition.LeasingDTO;
import com.bbva.net.back.model.globalposition.RotatingAccountDTO;

public interface LoanFacade {

	public List<LeasingDTO> getLeasingByUser(String defaultUser);

	public List<RotatingAccountDTO> getRotatingAccountByUser(String defaultUser);

	public GlobalProductsDTO getLoansByUser(String defaultUser);

}
