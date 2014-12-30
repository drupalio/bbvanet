package com.bbva.net.back.model.quota;

import com.bbva.net.back.model.accounts.ProductInformationDto;
import com.bbva.net.back.model.commons.Money;

public class QuotaDetailDto {

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

}
