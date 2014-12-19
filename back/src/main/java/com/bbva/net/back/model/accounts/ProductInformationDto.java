package com.bbva.net.back.model.accounts;

import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

import com.bbva.net.back.core.pattern.dto.Dto;

public class ProductInformationDto implements Dto {

	public ProductInformationDto() {
		// TODO Auto-generated constructor stub
	}

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
	public String toString() {
		return new ToStringBuilder(this).append("alias", getAlias()).append("numCuenta", getNumCuenta())
				.append("tipoCuenta", getTipoCuenta()).toString();
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder().append(getAlias()).append(getNumCuenta()).append(getTipoCuenta()).toHashCode();
	}

	@Override
	public boolean equals(Object obj) {

		return (obj instanceof ProductInformationDto)
				&& this.getAlias().equals(((ProductInformationDto)obj).getAlias())
				&& this.getNumCuenta().equals(((ProductInformationDto)obj).getNumCuenta())
				&& this.getTipoCuenta().equals(((ProductInformationDto)obj).getTipoCuenta());

	}

}
