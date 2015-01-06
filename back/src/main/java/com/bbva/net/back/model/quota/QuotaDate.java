package com.bbva.net.back.model.quota;

import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

import com.bbva.net.back.core.pattern.dto.Dto;

public class QuotaDate implements Dto {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1749393294688787370L;

	private String vencimiento;

	private String pago;

	private String anterior;

	public QuotaDate() {

	}

	/**
	 * @param vencimiento
	 * @param pago
	 * @param anterior
	 */

	public QuotaDate(String vencimiento, String pago, String anterior) {
		this.vencimiento = vencimiento;
		this.pago = pago;
		this.anterior = anterior;
	}

	public String getVencimiento() {
		return vencimiento;
	}

	public void setVencimiento(String vencimiento) {
		this.vencimiento = vencimiento;
	}

	public String getPago() {
		return pago;
	}

	public void setPago(String pago) {
		this.pago = pago;
	}

	public String getAnterior() {
		return anterior;
	}

	public void setAnterior(String anterior) {
		this.anterior = anterior;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public boolean equals(Object obj) {
		return (obj instanceof QuotaDate) && this.getVencimiento().equals(((QuotaDate)obj).getVencimiento())
				&& this.getPago().equals(((QuotaDate)obj).getPago())
				&& this.getAnterior().equals(((QuotaDate)obj).getAnterior());
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder().append(getVencimiento()).append(getPago()).append(getAnterior()).toHashCode();
	}

	@Override
	public String toString() {
		return new ToStringBuilder(this).append("Vencimiento ", getVencimiento()).append("Pago ", getPago())
				.append("Anterior ", getAnterior()).toString();
	}

}
