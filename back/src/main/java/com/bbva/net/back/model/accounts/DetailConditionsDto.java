package com.bbva.net.back.model.accounts;

import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

import com.bbva.net.back.core.pattern.dto.Dto;

public class DetailConditionsDto implements Dto {

	public DetailConditionsDto() {

	}

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
	public String toString() {
		return new ToStringBuilder(this).append("categoria", getCategoria()).append("descripcion", getDescripcion())
				.append("fechaApertura", getFechaApertura()).append("comisiones", getComisiones()).toString();
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder().append(getCategoria()).append(getDescripcion()).append(getFechaApertura())
				.append(getComisiones()).toHashCode();
	}

	@Override
	public boolean equals(Object obj) {

		return (obj instanceof DetailConditionsDto)
				&& this.getCategoria().equals(((DetailConditionsDto)obj).getCategoria())
				&& this.getDescripcion().equals(((DetailConditionsDto)obj).getDescripcion())
				&& this.getFechaApertura().equals(((DetailConditionsDto)obj).getFechaApertura())
				&& this.getComisiones().equals(((DetailConditionsDto)obj).getComisiones());

	}

}
