package com.bbva.net.back.facade;

import java.util.List;

/**
 * @author Entelgy
 */
public interface QuotationMoneyFacade {
    
    List<String> getListTypesMoney();
    
    void getTasas();

    List<String> getAccountsList();
}
