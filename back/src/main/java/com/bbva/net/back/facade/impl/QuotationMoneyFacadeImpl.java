package com.bbva.net.back.facade.impl;

import java.util.ArrayList;
import java.util.List;

import com.bbva.net.back.core.pattern.facade.AbstractBbvaFacade;
import com.bbva.net.back.core.stereotype.Facade;
import com.bbva.net.back.facade.QuotationMoneyFacade;
import com.bbva.net.back.model.turnsClient.DivisaDto;

/**
 * @author Entelgy
 */
@Facade(value = "quotationMoneyFacade")
public class QuotationMoneyFacadeImpl extends AbstractBbvaFacade implements QuotationMoneyFacade {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    @Override
    public List<DivisaDto> getListTypesMoney() {
        List<DivisaDto> moneyList = new ArrayList<DivisaDto>();

        moneyList.add(new DivisaDto("CAD", "1"));
        moneyList.add(new DivisaDto("CHF", "2"));
        moneyList.add(new DivisaDto("CNY", "3"));
        moneyList.add(new DivisaDto("COP", "4"));
        moneyList.add(new DivisaDto("EUR", "5"));
        moneyList.add(new DivisaDto("GBP", "6"));
        moneyList.add(new DivisaDto("JPY", "7"));
        moneyList.add(new DivisaDto("MXN", "8"));
        moneyList.add(new DivisaDto("SEK", "9"));
        moneyList.add(new DivisaDto("USD", "10"));
        return moneyList;
    }

    @Override
    public void getTasas() {

    }

    @Override
    public List<String> getAccountsList() {
        List<String> accountsList = new ArrayList<String>();
        accountsList.add("00130443000200009402");
        accountsList.add("00130443000200009405");
        accountsList.add("00130443000200009406");
        return accountsList;
    }
}
