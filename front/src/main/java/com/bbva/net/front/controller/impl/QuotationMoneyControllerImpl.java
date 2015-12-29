package com.bbva.net.front.controller.impl;

import com.bbva.net.back.model.turnsClient.QuotationMoneyDto;

/**
 * @author Entelgy
 */
public class QuotationMoneyControllerImpl {
    
    private QuotationMoneyDto quotationDto;
    
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
}
