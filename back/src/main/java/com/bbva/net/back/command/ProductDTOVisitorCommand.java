package com.bbva.net.back.command;

import java.util.List;

import com.bbva.net.back.model.globalposition.AccountDto;
import com.bbva.net.back.model.globalposition.AdquirenceAccountDto;
import com.bbva.net.back.model.globalposition.CreditCardDto;
import com.bbva.net.back.model.globalposition.LeasingDto;
import com.bbva.net.back.model.globalposition.LoanDto;
import com.bbva.net.back.model.globalposition.ProductDto;
import com.bbva.net.back.model.globalposition.RotatingAccountDto;
import com.bbva.net.core.pattern.VisitorCommand;

public abstract class ProductDTOVisitorCommand extends
		VisitorCommand<ProductDto> {

	public ProductDTOVisitorCommand(List<ProductDto> list) {
		super(list);
	}

	/*
	 * ^********************************* ABSTRACT METHOD
	 * ********************************
	 */

	/**
	 * @param account
	 */
	public abstract void execute(final AccountDto account);

	/**
	 * @param adquirenceAccount
	 */
	public abstract void execute(final AdquirenceAccountDto adquirenceAccount);

	/**
	 * @param creditCard
	 */
	public abstract void execute(final CreditCardDto creditCard);

	/**
	 * @param rotatingAccount
	 */
	public abstract void execute(final RotatingAccountDto rotatingAccount);

	/**
	 * @param leasing
	 */
	public abstract void execute(final LeasingDto leasing);

	/**
	 * @param loan
	 */
	public abstract void execute(final LoanDto loan);

	/**
	 * 
	 */
	@Override
	protected void execute(final ProductDto productDTO) {

		switch (productDTO.getTypeProd()) {
		case PC:
			this.execute((AccountDto) productDTO);
			break;
		case AQ:
			this.execute((AdquirenceAccountDto) productDTO);
			break;
		case TC:
			this.execute((CreditCardDto) productDTO);
			break;
		case RQ:
			this.execute((RotatingAccountDto) productDTO);
			break;
		case LI:
			this.execute((LeasingDto) productDTO);
			break;
		case LO:
			this.execute((LoanDto) productDTO);
			break;
		case SI:
			this.execute(productDTO);
			break;
		case ED:
			this.execute(productDTO);
			break;
		default:
			break;
		}

	}

}
