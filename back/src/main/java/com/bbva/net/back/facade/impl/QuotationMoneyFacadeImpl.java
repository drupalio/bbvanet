package com.bbva.net.back.facade.impl;

import java.util.ArrayList;
import java.util.List;

import com.bbva.net.back.core.pattern.facade.AbstractBbvaFacade;
import com.bbva.net.back.core.stereotype.Facade;
import com.bbva.net.back.facade.QuotationMoneyFacade;

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
    public List<String> getListTypesMoney() {
        List<String> moneyList = new ArrayList<String>();
        moneyList.add("CAD");
        moneyList.add("CHF");
        moneyList.add("CNY");
        moneyList.add("COP");
        moneyList.add("EUR");
        moneyList.add("GBP");
        moneyList.add("JPY");
        moneyList.add("MXN");
        moneyList.add("SEK");
        moneyList.add("USD");
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
