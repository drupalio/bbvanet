package com.bbva.net.front.controller.impl;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.faces.event.ActionEvent;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import org.powermock.reflect.Whitebox;
import org.primefaces.event.SelectEvent;

import com.bbva.net.back.facade.MovementsAccountFacade;
import com.bbva.net.back.facade.MultiValueGroupFacade;
import com.bbva.net.back.model.citeriaMovements.MovementCriteriaDto;
import com.bbva.net.back.model.commons.BalanceRangeDto;
import com.bbva.net.back.model.commons.DateRangeDto;
import com.bbva.net.back.model.commons.Money;
import com.bbva.net.back.model.enums.RenderAttributes;
import com.bbva.net.back.model.globalposition.ProductDto;
import com.bbva.net.back.model.movements.MovementDetailDto;
import com.bbva.net.back.model.movements.MovementDto;
import com.bbva.net.front.delegate.GraphicLineDelegate;
import com.bbva.net.front.test.utils.AbstractBbvaControllerTest;
import com.bbva.net.front.ui.line.LineConfigUI;
import com.bbva.net.front.ui.line.LineItemUI;

public class MovementCriteriaControllerImplTest extends AbstractBbvaControllerTest {

	private static final String DEFAULT_ID = "0013044300020000949";

	private static final String DEFAULT_ID_MOV = "554654";

	private MovementCriteriaControllerImpl movementCriteriaController;

	private Map<String, Boolean> renderComponents;

	private MultiValueGroupFacade multiValueGroupFacade;

	private MovementsAccountFacade movementsFacade;

	private GraphicLineDelegate graphicLineDelegate;

	private LineConfigUI lineConfigUI;

	private MovementCriteriaDto movementCriteriaDto;

	private ProductDto productDto;

	private List<MovementDto> lista;

	private DateRangeDto date;

	private ActionEvent eventAction;

	private SelectEvent eventSelect;

	@Before
	public void init() {
		// Mockitos
		this.movementCriteriaController = new MovementCriteriaControllerImpl();
		this.renderComponents = new HashMap<String, Boolean>();
		this.movementCriteriaDto = new MovementCriteriaDto();
		this.multiValueGroupFacade = Mockito.mock(MultiValueGroupFacade.class);
		this.movementsFacade = Mockito.mock(MovementsAccountFacade.class);
		this.graphicLineDelegate = Mockito.mock(GraphicLineDelegate.class);
		this.lineConfigUI = Mockito.mock(LineConfigUI.class);
		this.productDto = Mockito.mock(ProductDto.class);
		this.eventSelect = Mockito.mock(SelectEvent.class);
		this.eventAction = Mockito.mock(ActionEvent.class);
		this.lista = new ArrayList<MovementDto>();
		Mockito.when(movementCriteriaController.getSelectedProduct()).thenReturn(productDto);
		Mockito.when(productDto.getSubTypeProd()).thenReturn("AA");
		Mockito.when(productDto.getProductId()).thenReturn(DEFAULT_ID);
		// Metodo init
		this.movementCriteriaController.init();
		// DateRangeDto
		this.date = new DateRangeDto();
		date.setDateSince(new Date());
		date.setDateTo(new Date());
		this.movementCriteriaController.setDateRange(date);
		// set de facades al controlador
		this.movementCriteriaController.setMultiValueGroupFacade(multiValueGroupFacade);
		this.movementCriteriaController.getMultiValueGroupFacade();
		this.movementCriteriaController.setGraphicLineDelegate(graphicLineDelegate);
		this.movementCriteriaController.getGraphicLineDelegate();
		this.movementCriteriaController.setMovementsFacade(movementsFacade);
		// methodos
		this.movementCriteriaController.cleanFilters(eventAction);
		this.movementCriteriaController.selectDateSince(eventSelect);
		this.movementCriteriaController.selectDateTo(eventSelect);
	}

	@Test
	public void checkIncomeExpress() {
		// Mockear el render
		Mockito.when(this.movementCriteriaController.getRenderComponents()).thenReturn(renderComponents);
		// Cuando setIncomesOrExpenses =1
		this.movementCriteriaDto.setIncomesOrExpenses("1");
		this.movementCriteriaController.setMovementCriteria(movementCriteriaDto);
		this.movementCriteriaController.setIncomeExpensesFilter(eventAction);
		// Cuando setIncomesOrExpenses =2
		this.movementCriteriaDto.setIncomesOrExpenses("2");
		this.movementCriteriaController.setMovementCriteria(movementCriteriaDto);
		this.movementCriteriaController.setIncomeExpensesFilter(eventAction);
		// Cuando setIncomesOrExpenses = cualquiera
		this.movementCriteriaDto.setIncomesOrExpenses("3");
		this.movementCriteriaController.setMovementCriteria(movementCriteriaDto);
		this.movementCriteriaController.setIncomeExpensesFilter(eventAction);
		this.movementCriteriaController.getMovementCriteria();
		this.movementCriteriaController.getTitleInOrExp();
	}

	@Test
	public void checkMovementConcept() {
		// Mockear el render
		Mockito.when(this.movementCriteriaController.getRenderComponents()).thenReturn(renderComponents);
		// Llamar al metodo setMovementConcept
		this.movementCriteriaController.setMovementConcept(eventAction);
	}

	@Test
	public void checkBalanceValidator() {
		// Mockear el render
		Mockito.when(this.movementCriteriaController.getRenderComponents()).thenReturn(renderComponents);
		// nulos balanceSince y BalanceTo
		BalanceRangeDto balanceRange = new BalanceRangeDto();
		this.movementCriteriaDto.setBalanceRange(balanceRange);
		this.movementCriteriaController.setMovementCriteria(movementCriteriaDto);
		this.movementCriteriaController.balanceValidator();
		// no nulo balanceSince, nulo BalanceTo
		balanceRange.setBalanceSince(new BigDecimal(1000));
		this.movementCriteriaDto.setBalanceRange(balanceRange);
		this.movementCriteriaController.setMovementCriteria(movementCriteriaDto);
		this.movementCriteriaController.balanceValidator();
		// no nulos balanceSince menor que BalanceTo
		balanceRange.setBalanceSince(new BigDecimal(1000));
		balanceRange.setBalanceTo(new BigDecimal(20000));
		this.movementCriteriaDto.setBalanceRange(balanceRange);
		this.movementCriteriaController.setMovementCriteria(movementCriteriaDto);
		this.movementCriteriaController.balanceValidator();
		// no nulos balanceSince mayor a BalanceTo
		balanceRange.setBalanceSince(new BigDecimal(20000));
		balanceRange.setBalanceTo(new BigDecimal(1000));
		this.movementCriteriaDto.setBalanceRange(balanceRange);
		this.movementCriteriaController.setMovementCriteria(movementCriteriaDto);
		this.movementCriteriaController.balanceValidator();
		// Setear y obtener balanceRange del controlador
		this.movementCriteriaController.setBalanceRange(balanceRange);
		this.movementCriteriaController.getBalanceRange();
		this.movementCriteriaController.setMessageBalance(new StringBuilder());
		this.movementCriteriaController.getMessageBalance();
	}

	@Test
	public void checkCustomDate() {
		// Mockear el render
		Mockito.when(this.movementCriteriaController.getRenderComponents()).thenReturn(renderComponents);
		// nullos y concreteDate igual
		this.movementCriteriaController.setCustomDate(eventAction);
		// setSinceDate no nula, toDate nula y concreteDate igual
		this.movementCriteriaController.setSinceDate(new Date());
		this.movementCriteriaController.setCustomDate(eventAction);
		// no nulos y concreteDate igual
		this.movementCriteriaController.setTitleDateSince("Since");
		this.movementCriteriaController.setSinceDate(new Date());
		this.movementCriteriaController.setTitleDateTo("To");
		this.movementCriteriaController.setToDate(new Date());
		this.movementCriteriaController.setCustomDate(eventAction);
		// setToDate no nula, setSinceDate nulo y concreteDate igual
		this.movementCriteriaController.setSelectDate("null");
		this.movementCriteriaController.setToDate(new Date());
		this.movementCriteriaController.setCustomDate(eventAction);
		this.movementCriteriaController.setDateFormat(new SimpleDateFormat());
		this.movementCriteriaController.getDateFormat();
		this.movementCriteriaController.getSinceDatestr();
		this.movementCriteriaController.getToDatestr();
		this.movementCriteriaController.getDateRange();
		this.movementCriteriaController.getTitleDateSince();
		this.movementCriteriaController.getTitleDateTo();
	}

	@Test
	public void checkOnMovement() {
		// inicializar mockitos de los Dtos
		MovementDto movement = Mockito.mock(MovementDto.class);
		MovementDetailDto movementDetailDto = new MovementDetailDto();
		// Setear y obtener los dtos del controlador
		this.movementCriteriaController.setMovementDetail(movementDetailDto);
		this.movementCriteriaController.getMovementDetail();
		// Mokear el producto y el movimiento seleccionado
		Mockito.when(movementCriteriaController.getSelectedProduct()).thenReturn(productDto);
		Mockito.when(productDto.getProductId()).thenReturn(DEFAULT_ID);
		Mockito.when(productDto.getTypeProd()).thenReturn(super.enumProductType);
		Mockito.when(movementCriteriaController.getSelectedMovements()).thenReturn(movement);
		Mockito.when(movement.getMovementId()).thenReturn(DEFAULT_ID_MOV);
		// Llamar el metodo SetMovement
		this.movementCriteriaController.onMovementSelected(eventSelect);
	}

	@Test
	public void checkHandle() {
		// handleDateSelect event.getObject nullo
		this.movementCriteriaController.handleDateSelect(eventSelect);
		// handleDateSelect event.getObject no nullo
		Mockito.when(eventSelect.getObject()).thenReturn(new Date());
		this.movementCriteriaController.handleDateSelect(eventSelect);
	}

	@Test
	public void checkMethod() {
		// Mockear el render y el producto
		Mockito.when(this.movementCriteriaController.getRenderComponents()).thenReturn(renderComponents);
		Mockito.when(movementCriteriaController.getSelectedProduct()).thenReturn(productDto);
		Mockito.when(productDto.getSubTypeProd()).thenReturn("Account");
		// onselectDate concreteDate igual
		this.movementCriteriaController.oneSelectDate();
		// onselectDate concreteDate diferente
		this.movementCriteriaController.setSelectDate("null");
		this.movementCriteriaController.oneSelectDate();
		// Balance Range
		this.movementCriteriaController.setBalanceRange(eventAction);
		this.movementCriteriaController.getSinceText();
		this.movementCriteriaController.getToText();
		// Criteria Search paginator
		// this.movementCriteriaController.criteriaSearch();
	}

	@Test
	public void valuesLinesGraphic() {
		// inicializar los valores de la grafica
		Money moneyMenor = new Money();
		moneyMenor.setCurrency("$");
		moneyMenor.setAmount(new BigDecimal(1000));
		Money money = new Money();
		money.setCurrency("$");
		money.setAmount(new BigDecimal(20000));
		Money moneyMayor = new Money();
		moneyMayor.setCurrency("$");
		moneyMayor.setAmount(new BigDecimal(300000));
		// inicializar la lista de elementos
		List<LineItemUI> ListLineItemUI = new ArrayList<LineItemUI>();
		// inicializar los elementos
		LineItemUI lineItemUI = new LineItemUI();
		LineItemUI lineItemUI2 = new LineItemUI();
		LineItemUI lineItemUI3 = new LineItemUI();
		// llenar los elementos
		lineItemUI.setDay("5");
		lineItemUI.setLabel("Día");
		lineItemUI.setValue(money);
		lineItemUI2.setDay("5");
		lineItemUI2.setLabel("Día");
		lineItemUI2.setValue(moneyMenor);
		lineItemUI3.setDay("5");
		lineItemUI3.setLabel("Día");
		lineItemUI3.setValue(moneyMayor);
		// añadir los elementos a la lista
		ListLineItemUI.add(lineItemUI);
		ListLineItemUI.add(lineItemUI2);
		ListLineItemUI.add(lineItemUI3);
		// Setear y obtener la lista en el controlador
		this.movementCriteriaController.setGraphicLineMovements(lineConfigUI);
		this.movementCriteriaController.setValuesLinesGraphic(ListLineItemUI);
		this.movementCriteriaController.getValuesLinesGraphic();
		// Mockear la respuesta
		Mockito.when(this.lineConfigUI.getLineItemUIList()).thenReturn(ListLineItemUI);
		// Llamar el metodo valuesLinesGraphic
		this.movementCriteriaController.valuesLinesGraphic(lineConfigUI);
	}

	@Test
	public void checkGetAllMovements() {
		ProductDto product = new ProductDto();
		product.setProductId("12345");
		DateRangeDto date = new DateRangeDto(new Date(), new Date());
		BalanceRangeDto balance = new BalanceRangeDto(new BigDecimal(1000), new BigDecimal(2000));
		lista = new ArrayList<MovementDto>();
		this.movementCriteriaController.setMovementsFacade(movementsFacade);
		MovementPaginatedController mpc = new MovementPaginatedController();
		mpc.setMovementsFacade(movementsFacade);
		Mockito.when(this.movementCriteriaController.getSelectedProduct()).thenReturn(product);
		Mockito.when(this.movementsFacade.listMovements(product.getProductId(), "AC", date, balance, 0, 0)).thenReturn(
				lista);
		this.movementCriteriaController.getAllMovements();
		this.movementCriteriaController.getGraphicLineMovements();
	}

	@Test
	public void checkCalcuteDate() {
		Assert.assertNotNull(this.movementCriteriaController.calculateDate("Últimos 3 meses"));
		this.movementCriteriaController.setDateRange(null);
		Assert.assertNull(this.movementCriteriaController.calculateDate("Últimos 8 meses"));
	}

	@Test
	public void searchMovementByFilter() {
		// put render
		renderComponents.put(RenderAttributes.MOVEMENTSFILTER.toString(), true);
		renderComponents.put(RenderAttributes.INCOMEOREXPENSESFILTER.toString(), false);
		renderComponents.put(RenderAttributes.BALANCEFILTER.toString(), false);
		renderComponents.put(RenderAttributes.FILTERDATE.toString(), false);
		// Mockear el render
		Mockito.when(this.movementCriteriaController.getRenderComponents()).thenReturn(renderComponents);
		this.movementCriteriaController.setMovementsList(lista);
		this.movementCriteriaController.getMovementsList();
		// MOVEMENTSFILTER filter (true)
		this.movementCriteriaController.searchMovementByFilter(eventAction);
		// INCOMEOREXPENSESFILTER filter (true)
		renderComponents.put(RenderAttributes.MOVEMENTSFILTER.toString(), false);
		renderComponents.put(RenderAttributes.INCOMEOREXPENSESFILTER.toString(), true);
		this.movementCriteriaDto.setIncomesOrExpenses("2");
		this.movementCriteriaController.setMovementCriteria(movementCriteriaDto);
		this.movementCriteriaController.searchMovementByFilter(eventAction);
		this.movementCriteriaDto.setIncomesOrExpenses("1");
		this.movementCriteriaController.setMovementCriteria(movementCriteriaDto);
		this.movementCriteriaController.searchMovementByFilter(eventAction);
		// BALANCEFILTER filter (true)
		renderComponents.put(RenderAttributes.BALANCEFILTER.toString(), true);
		this.movementCriteriaController.searchMovementByFilter(eventAction);
		// FILTERDATE filter (true)
		renderComponents.put(RenderAttributes.BALANCEFILTER.toString(), false);
		renderComponents.put(RenderAttributes.FILTERDATE.toString(), true);
		this.movementCriteriaController.searchMovementByFilter(eventAction);
	}

	@Test
	public void checkNextPage() {
		// Mockear el render
		Mockito.when(this.movementCriteriaController.getRenderComponents()).thenReturn(renderComponents);
		// method nextPage
		this.movementCriteriaController.nextPage(eventAction);
		// setShowMoreStatus lista.size > 10
		Whitebox.setInternalState(lista, "size", 15);
		this.movementCriteriaController.setMovementsList(lista);
		this.movementCriteriaController.setShowMoreStatus();
	}

}
