package com.bbva.net.back.command;

import java.util.List;

import com.bbva.net.back.model.globalposition.AccountDTO;
import com.bbva.net.back.model.globalposition.AdquirenceAccountDTO;
import com.bbva.net.back.model.globalposition.CreditCardDTO;
import com.bbva.net.back.model.globalposition.DepositDTO;
import com.bbva.net.back.model.globalposition.FundDTO;
import com.bbva.net.back.model.globalposition.LeasingDTO;
import com.bbva.net.back.model.globalposition.LoanDTO;
import com.bbva.net.back.model.globalposition.ProductDTO;
import com.bbva.net.back.model.globalposition.RotatingAccountDTO;
import com.bbva.net.core.pattern.VisitorCommand;

public abstract class ProductDTOVisitorCommand extends VisitorCommand<ProductDTO> {

	public ProductDTOVisitorCommand(List<ProductDTO> list) {
		super(list);
	}

	/* ^********************************* ABSTRACT METHOD ******************************** */

	/**
	 * @param account
	 */
	public abstract void execute(final AccountDTO account);

	/**
	 * @param adquirenceAccount
	 */
	public abstract void execute(final AdquirenceAccountDTO adquirenceAccount);

	/**
	 * @param creditCard
	 */
	public abstract void execute(final CreditCardDTO creditCard);

	/**
	 * @param rotatingAccount
	 */
	public abstract void execute(final RotatingAccountDTO rotatingAccount);

	/**
	 * @param leasing
	 */
	public abstract void execute(final LeasingDTO leasing);

	/**
	 * @param loan
	 */
	public abstract void execute(final LoanDTO loan);

	/**
	 * @param fund
	 */
	public abstract void execute(final FundDTO fund);

	/**
	 * @param deposit
	 */
	public abstract void execute(final DepositDTO deposit);

	/**
	 * 
	 */
	@Override
	protected void execute(final ProductDTO productDTO) {

		switch (productDTO.getTypeProd()) {
		case PC:
			this.execute((AccountDTO)productDTO);
			break;
		case AQ:
			this.execute((AdquirenceAccountDTO)productDTO);
			break;
		case TDC:
			this.execute((CreditCardDTO)productDTO);
			break;
		case RQ:
			this.execute((RotatingAccountDTO)productDTO);
			break;
		case LI:
			this.execute((LeasingDTO)productDTO);
			break;
		case LO:
			this.execute((LoanDTO)productDTO);
			break;
		case SI:
			this.execute((FundDTO)productDTO);
			break;
		case ED:
			this.execute((DepositDTO)productDTO);
			break;
		default:
			break;
		}

	}

}
