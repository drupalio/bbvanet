package com.bbva.net.back.model.globalposition;

import java.io.Serializable;

import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

public class Cuenta implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 86690448817143549L;

	private String alias;

	private String idProduct;

	private String name;

	private String tradeBalance;

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

	@Override
	public boolean equals(Object obj) {
		return (obj instanceof Cuenta) && this.getIdProduct().equals(((Cuenta)obj).getIdProduct());
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder().append(getIdProduct()).toHashCode();
	}

	@Override
	public String toString() {
		return new ToStringBuilder(this).append("alas", getAlias()).append("idProducto", getIdProduct())
				.append("name", getName()).append("tradeBalance", getTradeBalance()).toString();
	}
}
