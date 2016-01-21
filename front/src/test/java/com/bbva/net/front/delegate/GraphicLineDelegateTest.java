package com.bbva.net.front.delegate;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import org.powermock.reflect.Whitebox;

import com.bbva.net.back.model.accounts.GlobalMonthlyBalanceDto;
import com.bbva.net.back.model.accounts.MonthBalanceDto;
import com.bbva.net.back.model.commons.Money;
import com.bbva.net.back.model.movements.MovementDto;
import com.bbva.net.front.delegate.impl.GraphicLineDelegateImpl;
import com.bbva.net.front.test.utils.AbstractBbvaControllerTest;
import com.bbva.net.front.ui.line.LineConfigUI;
import com.bbva.net.front.ui.line.LineItemUI;

public class GraphicLineDelegateTest extends AbstractBbvaControllerTest {

    private GraphicLineDelegateImpl graphicLineDelegate;

    private GlobalMonthlyBalanceDto globalMonthlyBalance;

    private LineConfigUI lineConfig;

    private Money money;

    @Before
    public void init() {

        this.graphicLineDelegate = new GraphicLineDelegateImpl();
        lineConfig = new LineConfigUI();
        this.globalMonthlyBalance = Mockito.mock(GlobalMonthlyBalanceDto.class);

        this.money = new Money();
        money.setAmount(new BigDecimal(30));
        money.setCurrency("$");
    }

    @Test
    public void checkGetMonthlyBalance() {
        // Prepara Objetos
        MonthBalanceDto monthBalance = new MonthBalanceDto();
        monthBalance.setBalance(money);
        monthBalance.setDay("2");
        List<MonthBalanceDto> listMonth = new ArrayList<MonthBalanceDto>();
        Mockito.when(this.globalMonthlyBalance.getMonthlyBalanceList()).thenReturn(listMonth);

        // empty Ejecuta Método
        this.lineConfig = this.graphicLineDelegate.getMonthlyBalance(globalMonthlyBalance);
        listMonth.add(monthBalance);
        // Ejecuta Método
        this.lineConfig = this.graphicLineDelegate.getMonthlyBalance(globalMonthlyBalance);

        // Verificaciones
        Assert.assertNotNull(lineConfig);
        Mockito.verify(this.globalMonthlyBalance, Mockito.atLeastOnce()).getMonthlyBalanceList();

    }

    @Test
    public void checkGetMovementAccount() {
        List<MovementDto> listMovement = new ArrayList<MovementDto>();
        MovementDto movement = new MovementDto();
        movement.setTotalBalance(new Money(new BigDecimal(2000)));
        MovementDto movement2 = new MovementDto();
        movement2.setTotalBalance(new Money(new BigDecimal(1000)));
        // empty Ejecuta el método
        this.lineConfig = this.graphicLineDelegate.getMovementAccount(listMovement);
        // Ejecuta el método
        listMovement.add(movement);
        listMovement.add(movement2);
        this.lineConfig = this.graphicLineDelegate.getMovementAccount(listMovement);
        // Ejecuta el método
        Whitebox.setInternalState(listMovement, "size", 15);
        this.lineConfig = this.graphicLineDelegate.getMovementAccount(listMovement);
        // null
        this.lineConfig = this.graphicLineDelegate.getMovementAccount(null);
        // Verificaciones
        Assert.assertNotNull(lineConfig);
    }

    @Test
    public void checkGetLinesValues() {
        List<LineItemUI> listValues = new ArrayList<LineItemUI>();
        LineItemUI lineItem = new LineItemUI();
        lineItem.setValue(new Money(new BigDecimal(2000)));
        lineItem = new LineItemUI();
        lineItem.setValue(new Money(new BigDecimal(1000)));
        // empty Ejecuta el método
        List<BigDecimal> lineValue = graphicLineDelegate.getLinesValues(listValues);
        // Ejecuta el método
        listValues.add(lineItem);
        listValues.add(lineItem);
        lineValue = graphicLineDelegate.getLinesValues(listValues);
        Assert.assertNotNull(lineValue);
    }

    @Test
    public void wormGetLinesValues() {
        List<LineItemUI> listValues = new ArrayList<LineItemUI>();
        LineItemUI lineItem = new LineItemUI();
        listValues.add(lineItem);
        graphicLineDelegate.getLinesValues(listValues);
    }
}
