package com.bbva.net.back.facade;

import java.util.List;

import com.bbva.net.back.model.turnsClient.DivisaDto;

/**
 * @author Entelgy
 */
public interface QuotationMoneyFacade {

    List<DivisaDto> getListTypesMoney();

    void getTasas();
    
    List<String> getAccountsList();
}
