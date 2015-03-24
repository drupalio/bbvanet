package com.bbva.net.front.delegate;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import com.bbva.net.back.model.accounts.GlobalMonthlyBalanceDto;
import com.bbva.net.back.model.accounts.MonthBalanceDto;
import com.bbva.net.back.model.commons.Money;
import com.bbva.net.back.model.movements.MovementDto;
import com.bbva.net.front.delegate.impl.GraphicLineDelegateImpl;
import com.bbva.net.front.test.utils.AbstractBbvaControllerTest;
import com.bbva.net.front.ui.line.LineConfigUI;

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
		listMonth.add(monthBalance);

		// prepara Mock
		Mockito.when(this.globalMonthlyBalance.getMonthlyBalanceList()).thenReturn(listMonth);

		// Ejecuta Método
		this.lineConfig = this.graphicLineDelegate.getMonthlyBalance(globalMonthlyBalance);

		// Verificaciones
		Assert.assertNotNull(lineConfig);
		Mockito.verify(this.globalMonthlyBalance, Mockito.atLeastOnce()).getMonthlyBalanceList();

	}

	@Test
	public void checkGetMovementAccount() {

		MovementDto movement = new MovementDto();
		List<MovementDto> listMovement = new ArrayList<MovementDto>();
		listMovement.add(movement);

		// Ejecuta el método
		this.lineConfig = this.graphicLineDelegate.getMovementAccount(listMovement);

		// Verificaciones
		Assert.assertNotNull(lineConfig);

	}

}
