package com.bbva.net.back.facade.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import com.bbva.czic.dto.net.EnumFundsType;
import com.bbva.net.back.core.pattern.facade.AbstractBbvaFacade;
import com.bbva.net.back.core.stereotype.Facade;
import com.bbva.net.back.facade.FundsTypeFacade;
import com.bbva.net.back.model.commons.Money;
import com.bbva.net.back.model.globalposition.FundDto;

@Facade(value = "fundsTypeFacade")
public class FundsTypeFacadeImpl extends AbstractBbvaFacade implements FundsTypeFacade {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4243379878856215155L;

	@Override
	public List<FundDto> getFundsDataGraphic(String usuario) {

		List<FundDto> funds = new ArrayList<FundDto>();

		FundDto graphicFundsFa = new FundDto();
		FundDto graphicFundsBd = new FundDto();
		FundDto graphicFundsBf = new FundDto();
		FundDto graphicFundsPa = new FundDto();
		FundDto graphicFundsBp = new FundDto();
		FundDto graphicFundsFn = new FundDto();
		FundDto graphicFundsFc = new FundDto();
		FundDto graphicFundsFe = new FundDto();
		FundDto graphicFundsFz = new FundDto();
		FundDto graphicFundsAn = new FundDto();
		FundDto graphicFundsFg = new FundDto();
		FundDto graphicFundsMd = new FundDto();
		FundDto graphicFundsFr = new FundDto();
		FundDto graphicFundsFb = new FundDto();

		Money money = new Money();
		money.setAmount(new BigDecimal(700000));
		money.setCurrency("$");
		Money moneyTwo = new Money();
		moneyTwo.setAmount(new BigDecimal(300000));
		moneyTwo.setCurrency("$");

		graphicFundsFa.setTypefunds(EnumFundsType.FA);
		graphicFundsFa.setTotalCash(money);
		graphicFundsBd.setTypefunds(EnumFundsType.BD);
		graphicFundsBd.setTotalCash(money);
		graphicFundsBf.setTypefunds(EnumFundsType.BF);
		graphicFundsBf.setTotalCash(money);
		graphicFundsPa.setTypefunds(EnumFundsType.PA);
		graphicFundsPa.setTotalCash(money);
		graphicFundsBp.setTypefunds(EnumFundsType.BP);
		graphicFundsBp.setTotalCash(money);
		graphicFundsFn.setTypefunds(EnumFundsType.FN);
		graphicFundsFn.setTotalCash(money);
		graphicFundsFc.setTypefunds(EnumFundsType.FC);
		graphicFundsFc.setTotalCash(money);
		graphicFundsFe.setTypefunds(EnumFundsType.FE);
		graphicFundsFe.setTotalCash(moneyTwo);
		graphicFundsFz.setTypefunds(EnumFundsType.FZ);
		graphicFundsFz.setTotalCash(moneyTwo);
		graphicFundsAn.setTypefunds(EnumFundsType.AN);
		graphicFundsAn.setTotalCash(moneyTwo);
		graphicFundsFg.setTypefunds(EnumFundsType.FG);
		graphicFundsFg.setTotalCash(moneyTwo);
		graphicFundsMd.setTypefunds(EnumFundsType.MD);
		graphicFundsMd.setTotalCash(moneyTwo);
		graphicFundsFr.setTypefunds(EnumFundsType.FR);
		graphicFundsFr.setTotalCash(moneyTwo);
		graphicFundsFb.setTypefunds(EnumFundsType.FB);
		graphicFundsFb.setTotalCash(moneyTwo);

		funds.add(graphicFundsFa);
		funds.add(graphicFundsBd);
		funds.add(graphicFundsBf);
		funds.add(graphicFundsPa);
		funds.add(graphicFundsBp);
		funds.add(graphicFundsFn);
		funds.add(graphicFundsFc);
		funds.add(graphicFundsFe);
		funds.add(graphicFundsFz);
		funds.add(graphicFundsAn);
		funds.add(graphicFundsFg);
		funds.add(graphicFundsMd);
		funds.add(graphicFundsFr);
		funds.add(graphicFundsFb);

		return funds;
	}
}
