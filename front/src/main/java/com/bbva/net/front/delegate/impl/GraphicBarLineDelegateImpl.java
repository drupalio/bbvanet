package com.bbva.net.front.delegate.impl;

import javax.annotation.Resource;

import com.bbva.net.back.service.ProductService;
import com.bbva.net.front.core.stereotype.Delegate;
import com.bbva.net.front.delegate.GraphicBarLineDelegate;
import com.bbva.net.front.ui.globalposition.AccountBarLineUI;

@Delegate(value = "graphicBarLineDelegate")
public class GraphicBarLineDelegateImpl implements GraphicBarLineDelegate {

	@Resource(name = "productService")
	private ProductService productService;

	/**
	 * Método que gestiona los movimientos (Entrada, Salida, Saldo) de producto cuentas
	 * 
	 * @return accountBarLineUI
	 */
	@Override
	public AccountBarLineUI getInOutBalanceByAccount() {

		AccountBarLineUI accountBarLineUI = new AccountBarLineUI();

		// Continurá....

		return accountBarLineUI;
	}

}
