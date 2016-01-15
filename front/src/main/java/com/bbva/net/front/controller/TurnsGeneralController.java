package com.bbva.net.front.controller;

import com.bbva.net.back.model.commons.DateRangeDto;

/**
 * @author Entelgy
 */
public interface TurnsGeneralController {

    /**
     *
     */
    void exportDocumentPdf();

    /**
     *
     */
    void exportDocumentDetailPdf();

    /**
     * @param date
     * @return
     */
    DateRangeDto calculateDate(String date);
}
