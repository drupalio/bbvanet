package com.bbva.net.back.model.accounts;

import com.bbva.net.back.core.pattern.dto.Dto;

public class DetailConditionsDto implements Dto {

	public DetailConditionsDto(String categoria, String descripcion, String fechaApertura, String comisiones) {
		super();
		this.categoria = categoria;
		this.descripcion = descripcion;
		this.fechaApertura = fechaApertura;
		this.comisiones = comisiones;
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1246945866316983419L;

	private String categoria;

	private String descripcion;

	private String fechaApertura;

	private String comisiones;

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getFechaApertura() {
		return fechaApertura;
	}

	public void setFechaApertura(String fechaApertura) {
		this.fechaApertura = fechaApertura;
	}

	public String getComisiones() {
		return comisiones;
	}

	public void setComisiones(String comisiones) {
		this.comisiones = comisiones;
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
