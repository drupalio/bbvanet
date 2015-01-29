package com.bbva.net.back.command;

import java.util.List;

import com.bbva.czic.dto.net.CardCharge;
import com.bbva.net.core.pattern.VisitorCommand;

public abstract class CardVisitorCommand extends VisitorCommand<CardCharge> {

	public CardVisitorCommand(List<CardCharge> list) {
		super(list);
	}

	/************************************ ABSTRACT METHODS **********************************/

	/**
	 * @param product
	 */
	public abstract void executeCards(final CardCharge product);

	/**
	 * 
	 */
	@Override
	protected void execute(CardCharge product) {
		switch (product.getCategory()) {
		case OCIO:
			this.executeCards(product);
			break;
		case REGALOS:
			this.executeCards(product);
			break;
		case LIBROS:
			this.executeCards(product);
			break;
		case DISCOS:
			this.executeCards(product);
			break;
		case COMERCIOBASICO:
			this.executeCards(product);
			break;
		case ROPA:
			this.executeCards(product);
			break;
		case CALZADOPERSONAL:
			this.executeCards(product);
			break;
		case VARIOS:
			this.executeCards(product);
			break;
		case COMPRASPORCANALES:
			this.executeCards(product);
			break;
		}

	}

}
