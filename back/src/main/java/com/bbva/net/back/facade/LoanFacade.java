package com.bbva.net.back.facade;

import java.util.List;
import java.util.Map;

import com.bbva.net.back.model.globalposition.BalanceDto;
import com.bbva.net.back.model.globalposition.LeasingDto;
import com.bbva.net.back.model.globalposition.LoanDto;
import com.bbva.net.back.model.globalposition.RotatingAccountDto;

/**
 * @author Entelgy
 */
public interface LoanFacade {

	/**
	 * @return
	 */
	List<LeasingDto> getLeasingByUser();

	/**
	 * @return
	 */
	List<LeasingDto> getLeasingByUserHidden();

	/**
	 * @return
	 */
	List<RotatingAccountDto> getRotatingAccountByUserHidden();

	/**
	 * @return
	 */
	List<RotatingAccountDto> getRotatingAccountByUser();

	/**
	 * @return
	 */
	List<LoanDto> getLoansByUser();

	/**
	 * @return
	 */
	List<LoanDto> getLoansByUserHidden();

	/**
	 * @return
	 */
	Map<String, BalanceDto> getLoanTotals();

}
