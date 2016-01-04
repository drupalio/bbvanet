package com.bbva.net.front.controller;

import java.util.List;

import javax.faces.event.AjaxBehaviorEvent;

import org.primefaces.event.SelectEvent;

import com.bbva.net.back.model.globalposition.ProductDto;
import com.bbva.net.back.model.turnsClient.turnsClientDetailDto;
import com.bbva.net.back.model.turnsClient.turnsClientDto;

public interface TurnsOutwardsController {
    
    /**
     * @return
     */
    ProductDto getSelectedProduct();
    
    /**
     * @return
     */
    List<turnsClientDto> allTurnsClientOutside();
    
    /**
     * @param selectEvent
     * @return
     */
    turnsClientDetailDto onTurnDetail(SelectEvent selectEvent);
    
    /**
     *
     */
    void oneSelectDate();
    
    /**
     * @param event
     */
    void setCustomDate(final AjaxBehaviorEvent event);
    
    /**
     * @param event
     */
    void searchTurnsByFilter(final AjaxBehaviorEvent event);
    
    /**
     * @param selectEvent
     */
    void onProductTurnsSelected(SelectEvent selectEvent);

    /**
     * @param event
     */
    void cleanFilters(AjaxBehaviorEvent event);
}
