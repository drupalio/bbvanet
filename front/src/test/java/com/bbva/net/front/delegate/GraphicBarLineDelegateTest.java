package com.bbva.net.front.delegate;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import com.bbva.net.back.model.commons.Money;
import com.bbva.net.back.model.movements.GlobalResumeMovementsDto;
import com.bbva.net.back.model.movements.MovementsResumeDto;
import com.bbva.net.front.delegate.impl.GraphicBarLineDelegateImpl;
import com.bbva.net.front.test.utils.AbstractBbvaControllerTest;
import com.bbva.net.front.ui.globalposition.AccountBarLineUI;

public class GraphicBarLineDelegateTest extends AbstractBbvaControllerTest {

	private GraphicBarLineDelegate graphicBarLineDelegate;

	private GlobalResumeMovementsDto globalResumeMovementsDto;

	@Before
	public void init() {

		this.graphicBarLineDelegate = new GraphicBarLineDelegateImpl();
		this.globalResumeMovementsDto = Mockito.mock(GlobalResumeMovementsDto.class);

	}

	@Test
	public void chekGetInOutBalanceAccount() {
		Money money = Mockito.mock(Money.class);
		MovementsResumeDto movementsResume = Mockito.mock(MovementsResumeDto.class);
		List<MovementsResumeDto> listMovementsResume = new ArrayList<MovementsResumeDto>();
		listMovementsResume.add(movementsResume);

		// Mock para que entre al primer IF
		Mockito.when(globalResumeMovementsDto.getMovementsResumeDto()).thenReturn(listMovementsResume);

		// Mock para que entre al IF inCome != null
		Mockito.when(globalResumeMovementsDto.getMovementsResumeDto().get(0).getInCome()).thenReturn(money);

		// Mock para que entre al IF outCome
		Mockito.when(globalResumeMovementsDto.getMovementsResumeDto().get(0).getOutCome()).thenReturn(money);

		// Mock para que entre al IF balance
		Mockito.when(globalResumeMovementsDto.getMovementsResumeDto().get(0).getBalance()).thenReturn(money);

		AccountBarLineUI accountBarLine = this.graphicBarLineDelegate.getInOutBalanceAccount(globalResumeMovementsDto);
		Assert.assertNotNull(accountBarLine);

	}

}
