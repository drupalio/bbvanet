package com.bbva.net.back.facade;

import java.util.List;

import com.bbva.net.back.model.globalposition.LeasingDto;
import com.bbva.net.back.model.globalposition.LoanDto;
import com.bbva.net.back.model.globalposition.RotatingAccountDto;

/**
 * @author Entelgy
 */
public interface LoanFacade {

	/**
	 * @param user
	 * @return
	 */
	List<LeasingDto> getLeasingByUser(String user);

	
	/**
	 * @param user
	 * @return
	 */
	List<LeasingDto> getLeasingByUserHidden(String user);

	/**
	 * @param user
	 * @return
	 */
	List<RotatingAccountDto> getRotatingAccountByUserHidden(String user);
	
	/**
	 * @param user
	 * @return
	 */
	List<RotatingAccountDto> getRotatingAccountByUser(String user);


	/**
	 * @param user
	 * @return
	 */
	List<LoanDto> getLoansByUser(String user);

	/**
	 * @param user
	 * @return
	 */
	List<LoanDto> getLoansByUserHidden(String user);

}
