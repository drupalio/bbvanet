package com.bbva.net.front.controller.impl;

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
