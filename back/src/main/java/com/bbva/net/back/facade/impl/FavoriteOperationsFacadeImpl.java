package com.bbva.net.back.facade.impl;

import java.util.List;

import javax.annotation.Resource;

import com.bbva.net.back.core.pattern.facade.AbstractBbvaFacade;
import com.bbva.net.back.core.stereotype.Facade;
import com.bbva.net.back.facade.FavoriteOperationsFacade;
import com.bbva.net.back.mapper.FavoriteOperationsMapper;
import com.bbva.net.back.model.favoriteOperations.FavoriteOperationDto;
import com.bbva.net.back.service.FiqlService;
import com.bbva.net.webservices.agileOperations.AgileOperationsService;
import com.bbva.zic.agileoperations.v01.AgileOperation;

/**
 * @author Entelgy
 */
@Facade(value = "favoriteOperationsFacade")
public class FavoriteOperationsFacadeImpl extends AbstractBbvaFacade implements FavoriteOperationsFacade {
    
    /**
     *
     */
    private static final long serialVersionUID = 4324772858898315010L;
    
    /**
     * Service AgileOperationsService
     */
    @Resource(name = "agileOperationsService")
    private AgileOperationsService agileOperationsService;
    
    /**
     * call mapper FavoriteOperationsMapper
     */
    @Resource(name = "favoriteOperationsMapper")
    private FavoriteOperationsMapper favoriteOperationsMapper;
    
    @Resource(name = "fiqlService")
    private FiqlService fiqlService;
    
    // <!-- Entelgy / GP13137 / 22102015 / INICIO -->
    /**
     * list all FavoriteOperations
     */
    @Override
    public List<FavoriteOperationDto> getListFavoriteOperations(String user) {
        LOGGER.info("Inicia Método getListFavoriteOperations de FavoriteOperationsFacade");
        final String filter = fiqlService.getFiqlQuerybyCustomer(user);
        final List<AgileOperation> response = agileOperationsService.listAgileOperations(filter).getAgileOperations();
        List<FavoriteOperationDto> favoriteOperations = favoriteOperationsMapper.map(response);
        return favoriteOperations;
    }

    @Override
    public String deleteFavoriteOperations(String operationId, String user) {
        LOGGER.info("Inicia Método deleteFavoriteOperations de FavoriteOperationsFacade");
        final String contactID = fiqlService.getFiqlQuerybyCustomer(user);
        return agileOperationsService.deleteAgileOperation(operationId, contactID);
    }
    
    @Override
    public boolean modifyFavoriteoperations(FavoriteOperationDto favoriteOperation) {
        LOGGER.info("Inicia Método modifyFavoriteoperations de FavoriteOperationsFacade");
        AgileOperation agileOperation = favoriteOperationsMapper.map(favoriteOperation);
        return this.agileOperationsService.modifyAgileOperation(favoriteOperation.getIdOperation(),
                agileOperation);
    }

    // <!-- Entelgy / GP13137 / 22102015 / FIN -->
    
    public void setFiqlService(FiqlService fiqlService) {
        this.fiqlService = fiqlService;
        
    }
    
    public void setAgileOperationsService(AgileOperationsService agileOperationsService) {
        this.agileOperationsService = agileOperationsService;
    }
    
    public void setFavoriteOperationsMapper(FavoriteOperationsMapper favoriteOperationsMapper) {
        this.favoriteOperationsMapper = favoriteOperationsMapper;
    }
    
    @Override
    public boolean validateOperation(String user) {
        LOGGER.info("Inicia Método validateOperation de FavoriteOperationsFacade");
        String fiql = fiqlService.getFiqlQuerybyCustomer(user);
        return agileOperationsService.validateAgileOperation(fiql);
    }
    
    @Override
    public boolean addOperation(FavoriteOperationDto operacionFavorita) {
        LOGGER.info("Inicia Método addOperation de FavoriteOperationsFacade");
        AgileOperation agileOperation = favoriteOperationsMapper.map(operacionFavorita);
        return agileOperationsService.addAgileOperation(agileOperation);
    }
}
