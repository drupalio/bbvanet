package com.bbva.net.front.controller.impl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.faces.event.ActionEvent;

import org.apache.commons.collections.ListUtils;
import org.apache.commons.lang.StringUtils;
import org.primefaces.event.SelectEvent;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.bbva.net.back.facade.FavoriteOperationsFacade;
import com.bbva.net.back.model.favoriteOperations.FavoriteOperationDto;
import com.bbva.net.front.controller.FavoriteOperationsController;
import com.bbva.net.front.controller.OperationPasswordController;
import com.bbva.net.front.core.AbstractBbvaController;
import com.bbva.net.front.helper.MessagesHelper;

/**
 * @author Entelgy
 */
@Controller(value = "favoriteOperationsController")
@Scope(value = "globalSession")
public class FavoriteOperationsControllerImpl extends AbstractBbvaController implements FavoriteOperationsController {
    
    /**
     *
     */
    private static final long serialVersionUID = -9133966635827463062L;
    
    /**
     *
     */
    private List<FavoriteOperationDto> favoriteOperations;
    
    private FavoriteOperationDto selectOperation = new FavoriteOperationDto();
    
    // <!-- Entelgy / GP13137 / 14092015 / INICIO -->
    
    @Resource(name = "operationController")
    private transient OperationPasswordController operationPass;
    
    // <!-- Entelgy / GP13137 / 14092015 / FIN -->
    
    private String operPass = StringUtils.EMPTY;
    
    private boolean status = false;
    
    /**
     * Facade favoriteOperations
     */
    @Resource(name = "favoriteOperationsFacade")
    private transient FavoriteOperationsFacade favoriteOperationsFacade;
    
    // <!-- Entelgy / GP13137 / 30102015 / INICIO -->
    
    private String nameOperation;
    
    // <!-- Entelgy / GP13137 / 30102015 / FIN -->
    
    /**
     * init if FavoriteOperationsController
     */
    @PostConstruct
    public void init() {
        LOGGER.info("obtiene el usuario de sesion " + getSession().getAttribute("codClient"));
        if ( getSession().getAttribute("codClient") != null ) {
            try {
                LOGGER.info("Metodo init de FavoriteOperationController con usuario de la sesión "
                        + getSession().getAttribute("codClient").toString());
                favoriteOperations = favoriteOperationsFacade.getListFavoriteOperations(getSession().getAttribute(
                        "codClient").toString());
                getNames();
            } catch (Exception e) {
                LOGGER.info("Excepción en Metodo init de FavoriteOperationController con usuario de la sesión "
                        + e.getMessage());
                favoriteOperations = new ArrayList<FavoriteOperationDto>();
            }
        } else {
            try {
                LOGGER.info("Metodo init de FavoriteOperationController sin usuario de la sesión ");
                favoriteOperations = favoriteOperationsFacade.getListFavoriteOperations("123");
                getNames();
            } catch (Exception e) {
                LOGGER.info("Excepción en Metodo init de FavoriteOperationController sin usuario de la sesión "
                        + e.getMessage());
                favoriteOperations = new ArrayList<FavoriteOperationDto>();
            }
        }
        
    }
    
    /**
     * Muestra
     *
     * @return favoriteOperations
     */
    @Override
    public List<FavoriteOperationDto> getListFavoriteOperations() {
        
        if ( favoriteOperations.size() <= 3 ) {
            return favoriteOperations;
        } else {
            return favoriteOperations.subList(0, 3);
        }
    }
    
    /**
     * Favorite operations hidden
     *
     * @return favoriteOperations
     */
    @SuppressWarnings("unchecked")
    @Override
    public List<FavoriteOperationDto> getListFavoriteOperationsHidden() {
        
        if ( favoriteOperations.size() <= 3 ) {
            return ListUtils.EMPTY_LIST;
        } else {
            return favoriteOperations.subList(3, favoriteOperations.size());
        }
    }
    
    // <!-- Entelgy / GP13137 / 03112015 / INICIO -->
    /**
     *
     */
    public void onFavoriteSelected(final SelectEvent selectEvent) {
        selectOperation = (FavoriteOperationDto)selectEvent.getObject();
        LOGGER.info("ON productSelected\n: " + ((FavoriteOperationDto)selectEvent.getObject()).getAmount());
        System.out.print("favorito seleccionado" + selectOperation.getContractId());
    }
    
    // <!-- Entelgy / GP13137 / 03112015 / FIN -->
    
    /**
     * @param transactionDate
     * @return
     */
    public String getDate(final Date transactionDate) {
        LOGGER.info("Formater de fecha de FavoriteOperations");
        if ( transactionDate != null ) {
            final SimpleDateFormat dateFormat = new SimpleDateFormat(
                    MessagesHelper.INSTANCE.getStringI18("date.pattner.dd-mm-yyyy"));
            return dateFormat.format(transactionDate);
        }
        return "";
    }
    
    // <!-- Entelgy / GP13137 / 26102015 / INICIO -->
    /**
     *
     */
    public void getNames() {
        LOGGER.info("Metodo getNames de favoriteOperations");
        if ( favoriteOperations != null ) {
            LOGGER.info("Metodo getNames de favoriteOperations no es null");
            try {
                for (int i = 0; i < favoriteOperations.size(); i++) {
                    final String origen = MessagesHelper.INSTANCE.getFavOperationsPrefix(this.favoriteOperations.get(i)
                            .getOrigin());
                    final String destino = MessagesHelper.INSTANCE.getFavOperationsPrefix(this.favoriteOperations.get(i)
                            .getDestination());
                    this.favoriteOperations.get(i).setOrigin(origen);
                    this.favoriteOperations.get(i).setDestination(destino);
                    this.favoriteOperations.get(i).setContractId(getSession().getAttribute("codClient").toString());
                }
            } catch (Exception e) {
                LOGGER.info("Excepción en Metodo getNames de FavoriteOperationController" + e.getMessage());
            }
        }
    }
    
    // <!-- Entelgy / GP13137 / 26102015 / FIN -->
    
    /**
     *
     */
    @Override
    public void add(FavoriteOperationDto favoriteOperation) {
        favoriteOperationsFacade.addOperation(favoriteOperation);
    }
    
    // <!-- Entelgy / GP13137 / 18112015 / INICIO -->
    /**
     *
     */
    @Override
    public void modify(ActionEvent actionEvent) {
        LOGGER.info("Operacion modificada ..." + selectOperation.getAmount());
        this.status = operationPass.validateOperation(operPass);
        if ( status ) {
            try {
                selectOperation.setName(getNameOperation());
                selectOperation.setTransactionDate(null);
                this.status = favoriteOperationsFacade.modifyFavoriteoperations(selectOperation);
                init();
            } catch (Exception e) {
                LOGGER.info("Fallo la Operacion modificada ..." + selectOperation.getAmount() + e.getMessage());
                this.status = false;
            }
            operPass = StringUtils.EMPTY;
        }
    }
    
    // <!-- Entelgy / GP13137 / 18112015 / FIN -->
    
    // <!-- Entelgy / GP13137 / 03112015 / INICIO -->
    /**
     *
     */
    @Override
    public void delete(ActionEvent actionEvent) {
        LOGGER.info("Operacion a eliminar ..." + selectOperation.getAmount());
        this.status = operationPass.validateOperation(operPass);
        if ( status ) {
            try {
                String transactionReference = favoriteOperationsFacade.deleteFavoriteOperations(
                        selectOperation.getIdOperation(), getSession().getAttribute("codClient").toString());
                this.status = false;
                if ( !transactionReference.equals("F") ) {
                    this.status = true;
                    init();
                }
            } catch (Exception e) {
                LOGGER.info("Fallo la Operacion eliminar ..." + selectOperation.getAmount() + e.getMessage());
                this.status = false;
            }
            operPass = StringUtils.EMPTY;
        }
    }
    
    // <!-- Entelgy / GP13137 / 03112015 / FIN -->
    
    /**
     * @return favoriteOperations
     */
    public List<FavoriteOperationDto> getFavoriteOperations() {
        return favoriteOperations;
    }
    
    /**
     * @param favoriteOperations
     */
    public void setFavoriteOperations(final List<FavoriteOperationDto> favoriteOperations) {
        this.favoriteOperations = favoriteOperations;
    }
    
    /**
     * @return favoriteOperationsFacade
     */
    public FavoriteOperationsFacade getFavoriteOperationsFacade() {
        return favoriteOperationsFacade;
    }
    
    /**
     * @param favoriteOperationsFacade
     */
    public void setFavoriteOperationsFacade(final FavoriteOperationsFacade favoriteOperationsFacade) {
        this.favoriteOperationsFacade = favoriteOperationsFacade;
    }
    
    public FavoriteOperationDto getSelectOperation() {
        return selectOperation;
    }
    
    // <!-- Entelgy / GP13137 / 30102015 / INICIO -->
    public void setSelectOperation(FavoriteOperationDto selectOperation) {
        LOGGER.info("Operacion seleccionada ..." + selectOperation.getAmount());
        this.operPass = StringUtils.EMPTY;
        this.selectOperation = selectOperation;
        this.nameOperation = selectOperation.getName();
    }
    
    // <!-- Entelgy / GP13137 / 30102015 / FIN -->
    
    // <!-- Entelgy / GP13137 / 14092015 / INICIO -->
    public OperationPasswordController getOperationPass() {
        return operationPass;
    }
    
    public void setOperationPass(OperationPasswordController operationPass) {
        this.operationPass = operationPass;
    }
    
    // <!-- Entelgy / GP13137 / 14092015 / FIN -->
    
    public String getOperPass() {
        return operPass;
    }
    
    public void setOperPass(String operPass) {
        this.operPass = operPass;
    }
    
    public boolean isStatus() {
        return status;
    }
    
    public void setStatus(boolean status) {
        this.status = status;
    }
    
    // <!-- Entelgy / GP13137 / 30102015 / INICIO -->
    /**
     * @return the nameOperation
     */
    public String getNameOperation() {
        return nameOperation;
    }
    
    /**
     * @param nameOperation the nameOperation to set
     */
    public void setNameOperation(String nameOperation) {
        this.nameOperation = nameOperation;
    }
    // <!-- Entelgy / GP13137 / 30102015 / FIN -->
}