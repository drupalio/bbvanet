package com.bbva.net.front.controller.impl;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import com.bbva.net.back.facade.OperationPasswordFacade;
import com.bbva.net.front.test.utils.AbstractBbvaControllerTest;

public class OperationPasswordControllerImplTest extends AbstractBbvaControllerTest {
    
    private OperationPasswordFacade operationPasswordFacade;
    
    private OperationPasswordControllerImpl operationController;
    
    @Before
    public void init() {
        
        super.setUp();
        
        this.operationController = new OperationPasswordControllerImpl();
        this.operationPasswordFacade = Mockito.mock(OperationPasswordFacade.class);
        this.operationController.setOperationPassword(this.operationPasswordFacade);
    }
    
    @Test
    public void validateOperation() {
        this.operationController.validateOperation("contraseña");
    }
    
}
