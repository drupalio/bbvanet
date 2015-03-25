package com.bbva.net.back.facade.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import com.bbva.net.back.facade.GlobalPositionFacade;
import com.bbva.net.back.model.globalposition.BalanceDto;
import com.bbva.net.back.model.globalposition.GlobalProductsDto;
import com.bbva.net.back.model.globalposition.LeasingDto;
import com.bbva.net.back.model.globalposition.LoanDto;
import com.bbva.net.back.model.globalposition.RotatingAccountDto;
import com.bbva.net.back.predicate.HiddenProductPredicate;
import com.bbva.net.back.predicate.VisibleProductPredicate;
import com.bbva.net.back.service.ProductService;

public class LoanFacadeImplTest {

	private LoanFacadeImpl loanFacade;

	private GlobalPositionFacade globalPositionFacade;

	private ProductService productService;

	private GlobalProductsDto globalProduct;

	@Before
	public void init() {
		// Inicializar controlador
		this.loanFacade = new LoanFacadeImpl();
		// Mockitos
		this.globalPositionFacade = Mockito.mock(GlobalPositionFacade.class);
		this.productService = Mockito.mock(ProductService.class);
		this.globalProduct = new GlobalProductsDto();
		// Datos
		LoanDto loan = new LoanDto();
		loan.setVisible(true);
		List<LoanDto> lista = new ArrayList<LoanDto>();
		lista.add(loan);
		// Set
		this.loanFacade.setGlobalPositionFacade(globalPositionFacade);
		this.loanFacade.setProductService(productService);
		this.globalProduct.setLoan(lista);
	}

	@Test
	public void getLoanProducts() {
		// Mockitos
		Mockito.when(this.globalPositionFacade.getGlobalProductsByUser()).thenReturn(globalProduct);
		// Llamar método getLoanProducts
		this.globalProduct = this.loanFacade.getLoanProducts();
		// verificar que no venga nulo
		Assert.assertNotNull(this.globalProduct);
		// Verificar método getGlobalProductsByUser
		Mockito.verify(this.globalPositionFacade, Mockito.atLeastOnce()).getGlobalProductsByUser();
	}

	@Test
	@SuppressWarnings("unchecked")
	public void getLoanTotals() {
		Map<String, BalanceDto> totals = Mockito.mock(HashMap.class);
		// Mockitos
		Mockito.when(this.productService.getLoanTotals(globalProduct)).thenReturn(totals);
		// Llamar método getLoanTotals
		totals = this.loanFacade.getLoanTotals(globalProduct);
		// verificar que no venga nulo
		Assert.assertNotNull(totals);
		// Verificar método getLoanTotals
		Mockito.verify(this.productService, Mockito.atLeastOnce()).getLoanTotals(globalProduct);
	}

	public void getLeasingByUser() {
		GlobalProductsDto global = Mockito.mock(GlobalProductsDto.class);
		List<LeasingDto> listLe = new ArrayList<LeasingDto>();
		LeasingDto a = new LeasingDto();
		a.setVisible(true);
		listLe.add(a);
		globalProduct.setLeasings(listLe);
		// Mockitos
		Mockito.when(global.getLeasings()).thenReturn(listLe);
		Mockito.when(productService.select(globalProduct, new VisibleProductPredicate())).thenReturn(global);
		// Llamar método getLeasingByUser
		Mockito.when(this.loanFacade.getLeasingByUser(globalProduct)).thenReturn(listLe);
		// verificar que no venga nulo
		Assert.assertNotNull(listLe);
		// Verificar método select
		Mockito.verify(this.productService, Mockito.atLeastOnce()).select(global, new VisibleProductPredicate())
				.getLeasings();
	}

	public void getRotatingAccountByUser() {
		List<RotatingAccountDto> listRo = new ArrayList<RotatingAccountDto>();
		// Mockitos
		Mockito.when(this.productService.select(globalProduct, new VisibleProductPredicate()).getRotatingAccounts())
				.thenReturn(listRo);
		// Llamar método getRotatingAccountByUser
		listRo = this.loanFacade.getRotatingAccountByUser(globalProduct);
		// verificar que no venga nulo
		Assert.assertNotNull(listRo);
		// Verificar método select
		Mockito.verify(this.productService, Mockito.atLeastOnce()).select(globalProduct, new VisibleProductPredicate())
				.getRotatingAccounts();
	}

	public void getRotatingAccountByUserHidden() {
		List<RotatingAccountDto> listRo = new ArrayList<RotatingAccountDto>();
		// Mockitos
		Mockito.when(this.productService.select(globalProduct, new HiddenProductPredicate()).getRotatingAccounts())
				.thenReturn(listRo);
		// Llamar método getRotatingAccountByUserHidden
		listRo = this.loanFacade.getRotatingAccountByUserHidden(globalProduct);
		// verificar que no venga nulo
		Assert.assertNotNull(listRo);
		// Verificar método select
		Mockito.verify(this.productService, Mockito.atLeastOnce()).select(globalProduct, new HiddenProductPredicate())
				.getRotatingAccounts();
	}

	public void getLoansByUser() {
		List<LoanDto> listLo = new ArrayList<LoanDto>();
		// Mockitos
		Mockito.when(this.productService.select(globalProduct, new VisibleProductPredicate()).getLoan()).thenReturn(
				listLo);
		// Llamar método getLoansByUser
		listLo = this.loanFacade.getLoansByUser(globalProduct);
		// verificar que no venga nulo
		Assert.assertNotNull(listLo);
		// Verificar método select
		Mockito.verify(this.productService, Mockito.atLeastOnce()).select(globalProduct, new VisibleProductPredicate())
				.getLoan();
	}

	public void getLeasingByUserHidden() {
		List<LeasingDto> listLe = new ArrayList<LeasingDto>();
		// Mockitos
		Mockito.when(this.productService.select(globalProduct, new HiddenProductPredicate()).getLeasings()).thenReturn(
				listLe);
		// Llamar método getLeasingByUserHidden
		listLe = this.loanFacade.getLeasingByUserHidden(globalProduct);
		// verificar que no venga nulo
		Assert.assertNotNull(listLe);
		// Verificar método select
		Mockito.verify(this.productService, Mockito.atLeastOnce()).select(globalProduct, new HiddenProductPredicate())
				.getLeasings();
	}

	public void getLoansByUserHidden() {
		List<LoanDto> lisLo = new ArrayList<LoanDto>();
		// Mockitos
		Mockito.when(this.productService.select(globalProduct, new HiddenProductPredicate()).getLoan()).thenReturn(
				lisLo);
		// Llamar método getLoansByUserHidden
		lisLo = this.loanFacade.getLoansByUserHidden(globalProduct);
		// verificar que no venga nulo
		Assert.assertNotNull(lisLo);
		// Verificar método select
		Mockito.verify(this.productService, Mockito.atLeastOnce()).select(globalProduct, new HiddenProductPredicate())
				.getLoan();
	}
}
