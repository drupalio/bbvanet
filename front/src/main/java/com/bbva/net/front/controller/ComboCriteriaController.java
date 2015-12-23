package com.bbva.net.front.controller;

import java.util.List;

import com.bbva.net.back.entity.MultiValueGroup;
import com.bbva.net.back.model.globalposition.ProductDto;

public interface ComboCriteriaController {
    
    List<MultiValueGroup> getListMultiValuePeriod();
    
    List<MultiValueGroup> getListMultiValueChecks();
    
    List<MultiValueGroup> getListQuieroAccounts(ProductDto product);
    
    List<MultiValueGroup> getListQuieroCards();
    
    List<MultiValueGroup> getListQuieroQuota(ProductDto product);
    
    List<MultiValueGroup> getQuieroLoan();
    
    List<MultiValueGroup> getQuieroDeposit();
    
    List<MultiValueGroup> getQuieroFund();
    
    List<MultiValueGroup> getQuieroLeasing();
    
    List<MultiValueGroup> getListQuieroDivisas();
    
}
