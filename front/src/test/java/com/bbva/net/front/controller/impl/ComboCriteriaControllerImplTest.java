package com.bbva.net.front.controller.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import com.bbva.net.back.entity.MultiValueGroup;
import com.bbva.net.back.facade.MultiValueGroupFacade;
import com.bbva.net.back.model.globalposition.ProductDto;
import com.bbva.net.back.model.movements.MovementDto;
import com.bbva.net.front.test.utils.AbstractBbvaControllerTest;

public class ComboCriteriaControllerImplTest extends AbstractBbvaControllerTest {

    private static final String DEFAULT_PRODUCT = "00112345678909954345";

    private static final String DEFAULT_USER = "01123456";

    private ComboCriteriaControllerImpl comboCriteriaControllerImpl;

    private MovementDto movementDto;

    private ProductDto productDto;

    private List<MultiValueGroup> multivalueGroupList;

    private MultiValueGroup multiValueGroup;

    @Resource(name = "multiValueGroupFacade")
    private transient MultiValueGroupFacade multiValueGroupFacade;

    @Before
    public void init() {

        this.multiValueGroupFacade = Mockito.mock(MultiValueGroupFacade.class);
        this.multiValueGroup = new MultiValueGroup();
        this.multiValueGroup.setId(1L);
        this.multiValueGroup.setTypeId(2);
        this.multiValueGroup.setValue("Quieros");
        this.multiValueGroup.setValueId(1);

        this.multivalueGroupList = new ArrayList<MultiValueGroup>();
        this.multivalueGroupList.add(multiValueGroup);

        this.movementDto = new MovementDto();
        this.productDto = new ProductDto();
        this.productDto.setProductId("7855857657657");
        this.productDto.setOperationOnline(true);
        this.comboCriteriaControllerImpl = new ComboCriteriaControllerImpl();
        this.comboCriteriaControllerImpl.setDefaultUser(DEFAULT_USER);
        this.comboCriteriaControllerImpl.setSelectedMovements(movementDto);
        this.comboCriteriaControllerImpl.setSelectedProduct(productDto);
        this.comboCriteriaControllerImpl.setMultiValueGroupFacade(multiValueGroupFacade);

        Mockito.when(this.multiValueGroupFacade.getMultiValueTypes(2)).thenReturn(multivalueGroupList);

        this.comboCriteriaControllerImpl.init();

    }

    @Test
    public void checkGetListQuieroAccounts() {
        Mockito.when(this.multiValueGroupFacade.getMultiValueTypes(6)).thenReturn(multivalueGroupList);
        List<MultiValueGroup> multivalGroup = this.comboCriteriaControllerImpl.getListQuieroAccounts(this.productDto);
        Assert.assertNotNull(multivalGroup);

        this.productDto.setOperationOnline(false);
        multivalGroup = this.comboCriteriaControllerImpl.getListQuieroAccounts(this.productDto);
        Assert.assertNotNull(multivalGroup);

        Mockito.verify(this.multiValueGroupFacade, Mockito.atLeastOnce()).getMultiValueTypes(6);
        Assert.assertNotEquals(this.multiValueGroup, this.comboCriteriaControllerImpl.getMultiValueList());
        Assert.assertNotEquals(this.multiValueGroup, this.comboCriteriaControllerImpl.getMultiValuePeriod());
    }

    @Test
    public void checkGetListQuieroCards() {
        Mockito.when(this.multiValueGroupFacade.getMultiValueTypes(7)).thenReturn(multivalueGroupList);
        List<MultiValueGroup> multivalGroup = this.comboCriteriaControllerImpl.getListQuieroCards();
        Assert.assertNotNull(multivalGroup);
        Mockito.verify(this.multiValueGroupFacade, Mockito.atLeastOnce()).getMultiValueTypes(7);
    }

    @Test
    public void checkGetListQuieroQuota() {
        Mockito.when(this.multiValueGroupFacade.getMultiValueTypes(8)).thenReturn(multivalueGroupList);

        List<MultiValueGroup> multivalGroup = this.comboCriteriaControllerImpl.getListQuieroQuota(this.productDto);

        this.productDto.setOperationOnline(false);
        multivalGroup = this.comboCriteriaControllerImpl.getListQuieroQuota(this.productDto);

        Assert.assertNotNull(multivalGroup);
        Mockito.verify(this.multiValueGroupFacade, Mockito.atLeastOnce()).getMultiValueTypes(8);
    }

    @Test
    public void checkGetQuieroLoan() {

        Mockito.when(this.multiValueGroupFacade.getMultiValueTypes(9)).thenReturn(multivalueGroupList);
        List<MultiValueGroup> multivalGroup = this.comboCriteriaControllerImpl.getQuieroLoan();
        Assert.assertNotNull(multivalGroup);
        Mockito.verify(this.multiValueGroupFacade, Mockito.atLeastOnce()).getMultiValueTypes(9);
    }

    @Test
    public void checkGetQuieroDeposit() {

        Mockito.when(this.multiValueGroupFacade.getMultiValueTypes(10)).thenReturn(multivalueGroupList);
        List<MultiValueGroup> multivalGroup = this.comboCriteriaControllerImpl.getQuieroDeposit();
        Assert.assertNotNull(multivalGroup);
        Mockito.verify(this.multiValueGroupFacade, Mockito.atLeastOnce()).getMultiValueTypes(10);
    }

    @Test
    public void checkGetQuieroFund() {

        Mockito.when(this.multiValueGroupFacade.getMultiValueTypes(11)).thenReturn(multivalueGroupList);
        List<MultiValueGroup> multivalGroup = this.comboCriteriaControllerImpl.getQuieroFund();
        Assert.assertNotNull(multivalGroup);
        Mockito.verify(this.multiValueGroupFacade, Mockito.atLeastOnce()).getMultiValueTypes(11);
    }

    @Test
    public void checkGetQuieroLeasing() {

        Mockito.when(this.multiValueGroupFacade.getMultiValueTypes(12)).thenReturn(multivalueGroupList);
        List<MultiValueGroup> multivalGroup = this.comboCriteriaControllerImpl.getQuieroLeasing();
        Assert.assertNotNull(multivalGroup);
        Mockito.verify(this.multiValueGroupFacade, Mockito.atLeastOnce()).getMultiValueTypes(12);
    }
}
