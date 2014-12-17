package com.bbva.net.back.model.accounts;

import com.bbva.net.back.core.pattern.dto.Dto;

public class ProductInformationDto implements Dto {

	public ProductInformationDto(String alias, String numCuenta, String tipoCuenta) {
		super();
		this.alias = alias;
		this.numCuenta = numCuenta;
		this.tipoCuenta = tipoCuenta;
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = -1625523383260974617L;

	private String alias;

	private String numCuenta;

	private String tipoCuenta;

	public String getAlias() {
		return alias;
	}

	public void setAlias(String alias) {
		this.alias = alias;
	}

	public String getNumCuenta() {
		return numCuenta;
	}

	public void setNumCuenta(String numCuenta) {
		this.numCuenta = numCuenta;
	}

	public String getTipoCuenta() {
		return tipoCuenta;
	}

	public void setTipoCuenta(String tipoCuenta) {
		this.tipoCuenta = tipoCuenta;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		return super.equals(obj);
	}

	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return super.hashCode();
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	}

}
