package com.bbva.net.back.model.globalposition;

import java.io.Serializable;

public class Cuenta implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 86690448817143549L;
	private String alias;
	private String idProduct;
	private String name;
	private String tradeBalance;
	
	
	
	public Cuenta(String alias, String idProduct, String name,
			String tradeBalance) {
		super();
		this.alias = alias;
		this.idProduct = idProduct;
		this.name = name;
		this.tradeBalance = tradeBalance;
	}
	public String getAlias() {
		return alias;
	}
	public void setAlias(String alias) {
		this.alias = alias;
	}
	public String getIdProduct() {
		return idProduct;
	}
	public void setIdProduct(String idProduct) {
		this.idProduct = idProduct;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTradeBalance() {
		return tradeBalance;
	}
	public void setTradeBalance(String tradeBalance) {
		this.tradeBalance = tradeBalance;
	}
	
	

}
