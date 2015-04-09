package com.bbva.net.front.controller.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import org.primefaces.event.SelectEvent;

import com.bbva.net.back.facade.LoanFacade;
import com.bbva.net.back.model.globalposition.BalanceDto;
import com.bbva.net.back.model.globalposition.GlobalProductsDto;
import com.bbva.net.back.model.globalposition.LeasingDto;
import com.bbva.net.back.model.globalposition.LoanDto;
import com.bbva.net.back.model.globalposition.ProductDto;
import com.bbva.net.back.model.globalposition.RotatingAccountDto;
import com.bbva.net.front.test.utils.AbstractBbvaControllerTest;

/**
 * @author Entelgy
 */
public class LoanControllerImplTest extends AbstractBbvaControllerTest {

	private LoanControllerImpl loanController;

	private LoanFacade loanFacade;

	private Map<String, BalanceDto> totalsProducts;

	private GlobalProductsDto globalProductsDto;

	private SelectEvent eventSelect;

	@SuppressWarnings("unchecked")
	@Before
	public void init() {
		this.loanController = new LoanControllerImpl();
		// inicializar mockitos
		this.eventSelect = Mockito.mock(SelectEvent.class);
		this.globalProductsDto = Mockito.mock(GlobalProductsDto.class);
		this.totalsProducts = Mockito.mock(HashMap.class);
		this.loanFacade = Mockito.mock(LoanFacade.class);
		// Set
		this.loanController.setGlobalProductsDto(globalProductsDto);
		this.loanController.setTotalsProducts(totalsProducts);
		this.loanController.setLoanFacade(loanFacade);
		// get
		this.loanController.getTotalsProducts();
		this.loanController.getGlobalProductsDto();
	}

	@Test
	public void getCustomerRotatingAccount() {
		// inicializar lista
		List<RotatingAccountDto> listRo = new ArrayList<RotatingAccountDto>();
		// Mockear respuesta visibles
		Mockito.when(loanFacade.getRotatingAccountByUser(globalProductsDto)).thenReturn(listRo);
		// Llamar método getCustomerRotatingAccount
		listRo = this.loanController.getCustomerRotatingAccount();
		// Verificar que no llegue nulo
		Assert.assertNotNull(listRo);
		// verificar método getRotatingAccountByUser
		Mockito.verify(loanFacade, Mockito.atLeastOnce()).getRotatingAccountByUser(globalProductsDto);

		// Mockear respuesta ocultos
		Mockito.when(loanFacade.getRotatingAccountByUserHidden(globalProductsDto)).thenReturn(listRo);
		// Llamar método getCustomerRotatingAccountHidden
		listRo = this.loanController.getCustomerRotatingAccountHidden();
		// Verificar que no llegue nulo
		Assert.assertNotNull(listRo);
		// verificar método getRotatingAccountByUserHidden
		Mockito.verify(loanFacade, Mockito.atLeastOnce()).getRotatingAccountByUserHidden(globalProductsDto);

	}

	@Test
	public void getCustomerLeasing() {
		// inicializar lista
		List<LeasingDto> listle = new ArrayList<LeasingDto>();
		// Mockear respuesta visibles
		Mockito.when(loanFacade.getLeasingByUser(globalProductsDto)).thenReturn(listle);
		// Llamar método getCustomerLeasing
		listle = this.loanController.getCustomerLeasing();
		// Verificar que no llegue nulo
		Assert.assertNotNull(listle);
		// verificar método getLeasingByUser
		Mockito.verify(loanFacade, Mockito.atLeastOnce()).getLeasingByUser(globalProductsDto);

		// Mockear respuesta ocultos
		Mockito.when(loanFacade.getLeasingByUserHidden(globalProductsDto)).thenReturn(listle);
		// Llamar método getCustomerLeasingHidden
		listle = this.loanController.getCustomerLeasingHidden();
		// Verificar que no llegue nulo
		Assert.assertNotNull(listle);
		// verificar método getLeasingByUserHidden
		Mockito.verify(loanFacade, Mockito.atLeastOnce()).getLeasingByUserHidden(globalProductsDto);
	}

	@Test
	public void getCustomerLoan() {
		// inicializar lista
		List<LoanDto> listLo = new ArrayList<LoanDto>();
		// Mockear respuesta visibles
		Mockito.when(loanFacade.getLoansByUser(globalProductsDto)).thenReturn(listLo);
		// Llamar método getCustomerLoan
		listLo = this.loanController.getCustomerLoan();
		// Verificar que no llegue nulo
		Assert.assertNotNull(listLo);
		// verificar método getLoansByUser
		Mockito.verify(loanFacade, Mockito.atLeastOnce()).getLoansByUser(globalProductsDto);

		// Mockear respuesta ocultos
		Mockito.when(loanFacade.getLoansByUserHidden(globalProductsDto)).thenReturn(listLo);
		// Llamar getCustomerLoanHidden
		listLo = this.loanController.getCustomerLoanHidden();
		// Verificar que no llegue nulo
		Assert.assertNotNull(listLo);
		// verificar método getLoansByUserHidden
		Mockito.verify(loanFacade, Mockito.atLeastOnce()).getLoansByUserHidden(globalProductsDto);
	}

	@Test
	public void checkProductSelect() {
		// onProductLoanSelected event.getObject
		Mockito.when(eventSelect.getObject()).thenReturn(new ProductDto());
		// onProductLoanSelect
		this.loanController.onProductLoanSelected(eventSelect);
		// init
		this.loanController.init();
	}
}
