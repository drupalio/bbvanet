package com.bbva.net.front.controller.impl;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.bbva.net.back.facade.OperationPasswordFacade;
import com.bbva.net.front.controller.OperationPasswordController;
import com.bbva.net.front.core.AbstractBbvaController;

@Controller(value = "operationController")
@Scope(value = "globalSession")
public class OperationPasswordControllerImpl extends AbstractBbvaController implements OperationPasswordController {

    /**
     *
     */

    private static final long serialVersionUID = -644413335739689554L;

    @Resource(name = "operationPasswordFacade")
    private transient OperationPasswordFacade operationPassword;

    @Override
    public boolean validateOperation(String operationPass) {
        LOGGER.info("Se Valida clave de operaciones en OperationPasswordControllerImpl");
        String user = (String)this.getSession().getAttribute("userName")
                + this.getSession().getAttribute("docTypeUser") + this.getSession().getAttribute("docIdUser");
        return operationPassword.validateOperation(user, operationPass);
    }

	// <!-- Entelgy / SPRING 3 / 17112015 / INICIO -->
	
    public void setOperationPassword(OperationPasswordFacade operationPassword) {
        this.operationPassword = operationPassword;
    }
	
	// <!-- Entelgy / SPRING 3 / 17112015 / FIN -->
}
