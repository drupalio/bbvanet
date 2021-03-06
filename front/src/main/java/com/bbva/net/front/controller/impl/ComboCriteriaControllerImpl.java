package com.bbva.net.front.controller.impl;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.bbva.net.back.entity.MultiValueGroup;
import com.bbva.net.back.facade.MultiValueGroupFacade;
import com.bbva.net.back.model.globalposition.ProductDto;
import com.bbva.net.back.predicate.ValueMultiGroupPredicate;
import com.bbva.net.front.controller.ComboCriteriaController;
import com.bbva.net.front.core.AbstractBbvaController;

/**
 * Clase controladora que obtiene itmes combo filtro
 *
 * @author Entelgy
 */
@Controller(value = "comboCriteriaController")
@Scope(value = "globalSession")
public class ComboCriteriaControllerImpl extends AbstractBbvaController implements ComboCriteriaController {

    /*
     * GP12834 Cheques y chequeras - Entelgy - inicio
     */

    private static final Integer LIST_CHECK_STATUS = 3;

    /**
     *
     */
    private static final Integer LIST_CHECKBOOK_STATUS = 2;

    /**
     *
     */
    private transient List<MultiValueGroup> multiValueList;

    /*
     * GP12834 Cheques y chequeras - Entelgy - fin
     */

    /**
     *
     */
    private transient List<MultiValueGroup> multiValuePeriod;

    private transient List<MultiValueGroup> listMultiValuePeriod;

    private transient List<MultiValueGroup> listMultiValueChecks;

    private transient List<MultiValueGroup> listQuieroAccounts;

    private transient List<MultiValueGroup> listQuieroCards;

    private transient List<MultiValueGroup> listQuieroQuota;

    private transient List<MultiValueGroup> quieroLoan;

    private transient List<MultiValueGroup> quieroDeposit;

    private transient List<MultiValueGroup> quieroFund;

    private transient List<MultiValueGroup> quieroLeasing;

    /**
     *
     */

    private static final long serialVersionUID = -8550174788177930813L;

    /**
     * Facade MultivalueGroups
     */
    @Resource(name = "multiValueGroupFacade")
    private transient MultiValueGroupFacade multiValueGroupFacade;

    /**
     * Inicialización de Combos
     */
    @PostConstruct
    public void init() {
        
        /*
         * GP12834 Cheques y chequeras - Entelgy - inicio
         */
        this.listMultiValuePeriod = this.multiValueGroupFacade.getMultiValueTypes(LIST_CHECK_STATUS);
        this.listMultiValueChecks = this.multiValueGroupFacade.getMultiValueTypes(LIST_CHECKBOOK_STATUS);
        this.multiValueList = this.getListMultiValueChecks();
        
        /*
         * GP12834 Cheques y chequeras - Entelgy - fin
         */
        
        this.listQuieroAccounts = this.multiValueGroupFacade.getMultiValueTypes(6);
        this.listQuieroCards = this.multiValueGroupFacade.getMultiValueTypes(7);
        this.listQuieroQuota = this.multiValueGroupFacade.getMultiValueTypes(8);
        this.quieroLoan = this.multiValueGroupFacade.getMultiValueTypes(9);
        this.quieroDeposit = this.multiValueGroupFacade.getMultiValueTypes(10);
        this.quieroFund = this.multiValueGroupFacade.getMultiValueTypes(11);
        this.quieroLeasing = this.multiValueGroupFacade.getMultiValueTypes(12);
        this.multiValuePeriod = this.getListMultiValuePeriod();
    }

    /**
     * Método que obtiene los items del combo filtro en grafica cuentas
     */
    @Override
    public List<MultiValueGroup> getListMultiValuePeriod() {
        return this.listMultiValuePeriod;
    }

    /*
     * GP12834 Cheques y chequeras - Entelgy - inicio // Método que obtiene los items del combo en cheques
     */
    @Override
    public List<MultiValueGroup> getListMultiValueChecks() {
        return this.listMultiValueChecks;
    }

    /*
     * GP12834 Cheques y chequeras - Entelgy - fin
     */

    /**
     * Método que obtiene los items del combo quiero de cuentas
     */

    @Override
    @SuppressWarnings("unchecked")
    public List<MultiValueGroup> getListQuieroAccounts(ProductDto product) {
        LOGGER.info("Prodcuto " + product.getAlias());
        if ( !product.getOperationOnline() ) {
            List<MultiValueGroup> seeMore = (List<MultiValueGroup>)CollectionUtils.select(listQuieroAccounts,
                    new ValueMultiGroupPredicate("quiero.seeMoreOptions"));
            listQuieroAccounts.removeAll(seeMore);
        }
        return this.listQuieroAccounts;
    }

    /**
     * Método que obtiene los items del combo quiero de tarjetas
     */
    @Override
    public List<MultiValueGroup> getListQuieroCards() {
        return this.listQuieroCards;
    }

    /**
     * Método que obtiene los items del combo quiero de cupo
     */
    @Override
    @SuppressWarnings("unchecked")
    public List<MultiValueGroup> getListQuieroQuota(ProductDto product) {
        LOGGER.info("Prodcuto " + product.getAlias());
        if ( !product.getOperationOnline() ) {
            List<MultiValueGroup> seeMore = (List<MultiValueGroup>)CollectionUtils.select(listQuieroQuota,
                    new ValueMultiGroupPredicate("quiero.seeMoreOptions"));
            listQuieroQuota.removeAll(seeMore);
        }
        return this.listQuieroQuota;
    }

    /**
     * Método que obtiene los items del combo quiero de prestamo
     */
    @Override
    public List<MultiValueGroup> getQuieroLoan() {
        return quieroLoan;
    }

    /**
     * Método que obtiene los items del combo quiero de despositos
     */
    @Override
    public List<MultiValueGroup> getQuieroDeposit() {
        return quieroDeposit;
    }

    /**
     * Método que obtiene los items del combo quiero de fondos
     */
    @Override
    public List<MultiValueGroup> getQuieroFund() {
        return quieroFund;
    }

    /**
     * Método que obtiene los items del combo quiero de leasing
     */
    @Override
    public List<MultiValueGroup> getQuieroLeasing() {
        return quieroLeasing;
    }

    // ************* Getters Methods *************

    /**
     * @param multiValueGroupFacade
     */
    public void setMultiValueGroupFacade(final MultiValueGroupFacade multiValueGroupFacade) {
        this.multiValueGroupFacade = multiValueGroupFacade;
    }

    /**
     * @return
     */
    public List<MultiValueGroup> getMultiValuePeriod() {
        return multiValuePeriod;
    }

    /*
     * GP12834 Cheques y chequeras - Entelgy - inicio
     */

    public List<MultiValueGroup> getMultiValueList() {
        return multiValueList;
    }

    /*
     * GP12834 Cheques y chequeras - Entelgy - fin
     */

}
