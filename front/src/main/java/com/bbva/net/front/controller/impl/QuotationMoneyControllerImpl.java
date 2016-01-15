package com.bbva.net.front.controller.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.faces.event.ActionEvent;
import com.bbva.net.back.facade.QuotationMoneyFacade;
import com.bbva.net.back.model.turnsClient.DivisaDto;
import com.bbva.net.back.model.turnsClient.QuotationMoneyDto;
import com.bbva.net.back.model.turnsClient.turnsClientDetailDto;
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

    private turnsClientDetailDto clientTurn;

    private List<DivisaDto> moneyList;

    private List<String> accountsList;

    private List<String> typeOperList;

    @PostConstruct
    public void init() {
        this.moneyList = new ArrayList<DivisaDto>();
        this.accountsList = new ArrayList<String>();
        this.typeOperList = new ArrayList<String>();
        this.clientTurn = new turnsClientDetailDto();
        QuotationMoneyDto rates = new QuotationMoneyDto();
        this.clientTurn.setRates(rates);
        DivisaDto divisa = new DivisaDto();
        rates.setMoney(divisa);
        this.typeOperList.add("Giros Hacia");
        this.typeOperList.add("Giros Desde");
        this.accountsList = quotationMoneyFacade.getAccountsList();
        this.moneyList = quotationMoneyFacade.getListTypesMoney();
    }

    @Override
    public void onSelectPassInfo(ActionEvent event) {
        this.clientTurn = new turnsClientDetailDto();
        // super.onTurnsDetail(actionEvent);
        this.clientTurn = super.getTurnDetail();
    }

    // setters and getters

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

    /**
     * @return the moneyList
     */
    public List<DivisaDto> getMoneyList() {
        return moneyList;
    }

    /**
     * @param moneyList the moneyList to set
     */
    public void setMoneyList(List<DivisaDto> moneyList) {
        this.moneyList = moneyList;
    }

    /**
     * @return the accountsList
     */
    public List<String> getAccountsList() {
        return accountsList;
    }

    /**
     * @return the clientTurn
     */
    public turnsClientDetailDto getClientTurn() {
        return clientTurn;
    }

    /**
     * @param clientTurn the clientTurn to set
     */
    public void setClientTurn(turnsClientDetailDto clientTurn) {
        this.clientTurn = clientTurn;
    }
}
