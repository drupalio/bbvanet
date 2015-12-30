package com.bbva.net.front.controller.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import com.bbva.net.back.facade.QuotationMoneyFacade;
import com.bbva.net.back.model.turnsClient.QuotationMoneyDto;
import com.bbva.net.front.controller.QuotationMoneyController;
import com.bbva.net.front.core.AbstractBbvaController;

/**
 * @author Entelgy
 */
public class QuotationMoneyControllerImpl extends AbstractBbvaController implements QuotationMoneyController {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    @Resource(name = "quotationMoneyFacade")
    private transient QuotationMoneyFacade quotationMoneyFacade;
    
    private QuotationMoneyDto quotationDto;

    private List<String> moneyList;
    
    private List<String> accountsList;

    private List<String> typeOperList;
    
    public void init() {
        this.quotationDto = new QuotationMoneyDto();
        this.moneyList = new ArrayList<String>();
        this.accountsList = new ArrayList<String>();
        this.typeOperList = new ArrayList<String>();
        this.typeOperList.add("Giros Hacia");
        this.typeOperList.add("Giros Desde");
        this.accountsList = quotationMoneyFacade.getAccountsList();
        this.moneyList = quotationMoneyFacade.getListTypesMoney();
    }

    // setters and getters

    /**
     * @return the quotationDto
     */
    public QuotationMoneyDto getQuotationDto() {
        return quotationDto;
    }

    /**
     * @param quotationDto the quotationDto to set
     */
    public void setQuotationDto(QuotationMoneyDto quotationDto) {
        this.quotationDto = quotationDto;
    }

    /**
     * @return the moneyList
     */
    public List<String> getMoneyList() {
        return moneyList;
    }

    /**
     * @param moneyList the moneyList to set
     */
    public void setMoneyList(List<String> moneyList) {
        this.moneyList = moneyList;
    }

    /**
     * @return the accountsList
     */
    public List<String> getAccountsList() {
        return accountsList;
    }

    /**
     * @param accountsList the accountsList to set
     */
    public void setAccountsList(List<String> accountsList) {
        this.accountsList = accountsList;
    }

    /**
     * @param quotationMoneyFacade the quotationMoneyFacade to set
     */
    public void setQuotationMoneyFacade(QuotationMoneyFacade quotationMoneyFacade) {
        this.quotationMoneyFacade = quotationMoneyFacade;
    }

    /**
     * @return the typeOperList
     */
    public List<String> getTypeOperList() {
        return typeOperList;
    }

    /**
     * @param typeOperList the typeOperList to set
     */
    public void setTypeOperList(List<String> typeOperList) {
        this.typeOperList = typeOperList;
    }
}
