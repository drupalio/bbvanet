package com.bbva.net.back.command;

import java.util.List;

import com.bbva.czic.dto.net.CardCharge;
import com.bbva.czic.dto.net.Product;
import com.bbva.net.back.model.globalposition.AccountDTO;
import com.bbva.net.back.model.globalposition.AdquirenceAccountDTO;
import com.bbva.net.back.model.globalposition.CreditCardDTO;
import com.bbva.net.back.model.globalposition.DepositDTO;
import com.bbva.net.back.model.globalposition.FundDTO;
import com.bbva.net.back.model.globalposition.LeasingDTO;
import com.bbva.net.back.model.globalposition.LoanDTO;
import com.bbva.net.back.model.globalposition.RotatingAccountDTO;
import com.bbva.net.core.pattern.VisitorCommand;

public abstract class CardVisitorCommand extends VisitorCommand<CardCharge> {

	public CardVisitorCommand(List<CardCharge> list) {
		super(list);
	}

	/************************************ ABSTRACT METHODS **********************************/

	
	/**
	 * @param product
	 */
	public abstract void executeCards(final CardCharge product, final String name);

	/**
	 * 
	 */
	@Override
	protected void execute(CardCharge product) {
		switch (product.getCategory()) {
		case BASIC_COMMERCE:
			this.executeCards(product,"Comercio básico");
			break;
		case CHANNEL_SALES:
			this.executeCards(product,"Ventas por canales");
			break;
		case CLOTHING:
			this.executeCards(product,"Ropa, calzado y personal");
			break;
		case GIFT_BOOK_DISC:
			this.executeCards(product,"Regalos,libros,discos");
			break;
		case LEISURE:
			this.executeCards(product,"Ocio");
			break;
		case OTHERS:
			this.executeCards(product,"Varios");
			break;
		
		}
			

	}

}
