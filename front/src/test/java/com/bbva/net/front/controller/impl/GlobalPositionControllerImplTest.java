package com.bbva.net.front.controller.impl;

import org.junit.Before;
import org.junit.Test;

import com.bbva.net.back.facade.AccountMovementsResumeFacade;
import com.bbva.net.back.facade.CardsFacade;
import com.bbva.net.back.facade.GlobalPositionFacade;
import com.bbva.net.back.facade.MonthBalanceFacade;
import com.bbva.net.back.model.comboFilter.EnumPeriodType;
import com.bbva.net.back.model.commons.DateRangeDto;
import com.bbva.net.front.delegate.GraphicBarLineDelegate;
import com.bbva.net.front.delegate.GraphicLineDelegate;
import com.bbva.net.front.delegate.GraphicPieDelegate;
import com.bbva.net.front.test.utils.AbstractBbvaControllerTest;

/**
 * @author Entelgy
 */
public class GlobalPositionControllerImplTest extends AbstractBbvaControllerTest {

	private static final String DEFAULT_USER = "12345678";

	private GlobalPositionControllerImpl globalPositionController;

	// Mocks
	private GlobalPositionFacade globalPositionFacade;

	private GraphicPieDelegate graphicPieDelegate;

	private CardsFacade cardsFacade;

	private GraphicBarLineDelegate graphicBarLineDelegate;

	private GraphicLineDelegate graphicLineDelegate;

	private AccountMovementsResumeFacade globalMovementsFacade;

	private MonthBalanceFacade accountMonthBalanceFacade;

	DateRangeDto dateRange;

	EnumPeriodType periodType;

	@Before
	public void init() {

		this.globalPositionController = new GlobalPositionControllerImpl();

	}

	@Test
	public void checkOnComboSelectCard() {
		// globalPositionController.setPeriodCardSelected(Mockito.anyString());
		// Assert.assertNotNull(globalPositionController.getPeriodCardSelected());
		// globalPositionController.onComboSelectedCard();
	}
}
