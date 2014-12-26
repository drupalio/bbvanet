package com.bbva.net.back.facade;

import java.util.List;

import com.bbva.net.back.model.globalposition.LeasingDTO;
import com.bbva.net.back.model.globalposition.LoanDTO;
import com.bbva.net.back.model.globalposition.RotatingAccountDTO;

/**
 * @author Entelgy
 */
public interface LoanFacade {

	/**
	 * @param user
	 * @return
	 */
	List<LeasingDTO> getLeasingByUser(String user);

	
	/**
	 * @param user
	 * @return
	 */
	List<LeasingDTO> getLeasingByUserHidden(String user);

	/**
	 * @param user
	 * @return
	 */
	List<RotatingAccountDTO> getRotatingAccountByUserHidden(String user);
	
	/**
	 * @param user
	 * @return
	 */
	List<RotatingAccountDTO> getRotatingAccountByUser(String user);


	/**
	 * @param user
	 * @return
	 */
	List<LoanDTO> getLoansByUser(String user);

	/**
	 * @param user
	 * @return
	 */
	List<LoanDTO> getLoansByUserHidden(String user);

}
