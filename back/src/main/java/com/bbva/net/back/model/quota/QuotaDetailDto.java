package com.bbva.net.back.model.quota;

import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

import com.bbva.net.back.core.pattern.dto.Dto;
import com.bbva.net.back.model.accounts.ProductInformationDto;
import com.bbva.net.back.model.commons.Money;

public class QuotaDetailDto implements Dto {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2695099590992664081L;

	private ProductInformationDto informacion;

	private int porcentaje;

	private Money saldoPendiente;

	private Money montoSolicitado;

	private int numCuotas;

	private QuotaDate fechas;

	private String estado;

	private Money pagoMinimo;

	private String horarioCobro;

	private Money saldoDisponible;

	private Money saldoCorteAnterior;

	public QuotaDetailDto() {

	}

	/**
	 * @param informacion
	 * @param porcentaje
	 * @param saldoPendiente
	 * @param montoSolicitado
	 * @param numCuotas
	 * @param fechas
	 * @param estado
	 * @param pagoMinimo
	 * @param horarioCobro
	 * @param saldoDisponible
	 * @param saldoCorteAnterior
	 */

	public QuotaDetailDto(ProductInformationDto informacion, int porcentaje, Money saldoPendiente,
			Money montoSolicitado, int numCuotas, QuotaDate fechas, String estado, Money pagoMinimo,
			String horarioCobro, Money saldoDisponible, Money saldoCorteAnterior) {

		this.informacion = informacion;
		this.porcentaje = porcentaje;
		this.saldoPendiente = saldoPendiente;
		this.montoSolicitado = montoSolicitado;
		this.numCuotas = numCuotas;
		this.fechas = fechas;
		this.estado = estado;
		this.pagoMinimo = pagoMinimo;
		this.horarioCobro = horarioCobro;
		this.saldoDisponible = saldoDisponible;
		this.saldoCorteAnterior = saldoCorteAnterior;
	}

	public ProductInformationDto getInformacion() {
		return informacion;
	}

	public void setInformacion(ProductInformationDto informacion) {
		this.informacion = informacion;
	}

	public int getPorcentaje() {
		return porcentaje;
	}

	public void setPorcentaje(int porcentaje) {
		this.porcentaje = porcentaje;
	}

	public Money getSaldoPendiente() {
		return saldoPendiente;
	}

	public void setSaldoPendiente(Money saldoPendiente) {
		this.saldoPendiente = saldoPendiente;
	}

	public Money getMontoSolicitado() {
		return montoSolicitado;
	}

	public void setMontoSolicitado(Money montoSolicitado) {
		this.montoSolicitado = montoSolicitado;
	}

	public int getNumCuotas() {
		return numCuotas;
	}

	public void setNumCuotas(int numCuotas) {
		this.numCuotas = numCuotas;
	}

	public QuotaDate getFechas() {
		return fechas;
	}

	public void setFechas(QuotaDate fechas) {
		this.fechas = fechas;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public Money getPagoMinimo() {
		return pagoMinimo;
	}

	public void setPagoMinimo(Money pagoMinimo) {
		this.pagoMinimo = pagoMinimo;
	}

	public String getHorarioCobro() {
		return horarioCobro;
	}

	public void setHorarioCobro(String horarioCobro) {
		this.horarioCobro = horarioCobro;
	}

	public Money getSaldoDisponible() {
		return saldoDisponible;
	}

	public void setSaldoDisponible(Money saldoDisponible) {
		this.saldoDisponible = saldoDisponible;
	}

	public Money getSaldoCorteAnterior() {
		return saldoCorteAnterior;
	}

	public void setSaldoCorteAnterior(Money saldoCorteAnterior) {
		this.saldoCorteAnterior = saldoCorteAnterior;
	}

	@Override
	public String toString() {
		return new ToStringBuilder(this).append("informacion", getInformacion()).append("porcentaje", getPorcentaje())
				.append("saldoPendiente", getSaldoPendiente()).append("montoSolicitado", getMontoSolicitado())
				.append("numCuotas", getNumCuotas()).append("fechas", getFechas()).append("estado", getEstado())
				.append("pagoMinimo", getPagoMinimo()).append("horarioCobro", getHorarioCobro())
				.append("saldoDisponible", getSaldoDisponible()).append("saldoCorteAnterior", getSaldoCorteAnterior())
				.toString();
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder().append(getInformacion()).append(getPorcentaje()).append(getSaldoPendiente())
				.append(getMontoSolicitado()).append(getNumCuotas()).append(getFechas()).append(getEstado())
				.append(getPagoMinimo()).append(getHorarioCobro()).append(getSaldoDisponible())
				.append(getSaldoCorteAnterior()).toHashCode();
	}

	@Override
	public boolean equals(Object obj) {

		return (obj instanceof QuotaDetailDto)
				&& this.getMontoSolicitado().equals(((QuotaDetailDto)obj).getMontoSolicitado())
				&& this.getInformacion().equals(((QuotaDetailDto)obj).getInformacion())
				&& this.getPorcentaje() == (((QuotaDetailDto)obj).getPorcentaje())
				&& this.getSaldoPendiente().equals(((QuotaDetailDto)obj).getSaldoPendiente())
				&& this.getNumCuotas() == (((QuotaDetailDto)obj).getNumCuotas())
				&& this.getFechas().equals(((QuotaDetailDto)obj).getFechas())
				&& this.getEstado().equals(((QuotaDetailDto)obj).getEstado())
				&& this.getPagoMinimo().equals(((QuotaDetailDto)obj).getPagoMinimo())
				&& this.getHorarioCobro().equals(((QuotaDetailDto)obj).getHorarioCobro())
				&& this.getSaldoDisponible().equals(((QuotaDetailDto)obj).getSaldoDisponible())
				&& this.getSaldoCorteAnterior().equals(((QuotaDetailDto)obj).getSaldoCorteAnterior());

	}

}
