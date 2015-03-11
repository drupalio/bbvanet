package com.bbva.net.back.model.accounts;

import java.util.Date;

import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import com.bbva.net.back.core.pattern.dto.Dto;

public class DetailConditionsDto implements Dto {

	private static final long serialVersionUID = 1246945866316983419L;

	private String categoria;

	private String descripcion;

	private Date fechaApertura;

	private String comisiones;

	public DetailConditionsDto() {
	}

	/**
	 * @param categoria
	 * @param descripcion
	 * @param fechaApertura
	 * @param comisiones
	 */
	public DetailConditionsDto(String categoria, String descripcion, Date fechaApertura, String comisiones) {
		this.categoria = categoria;
		this.descripcion = descripcion;
		this.fechaApertura = fechaApertura;
		this.comisiones = comisiones;
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder().append(getCategoria()).append(getDescripcion()).append(getFechaApertura())
				.append(getComisiones()).toHashCode();
	}

	@Override
	public boolean equals(Object obj) {
		return (obj != null) && (obj instanceof DetailConditionsDto)
				&& this.getCategoria().equals(((DetailConditionsDto)obj).getCategoria())
				&& this.getDescripcion().equals(((DetailConditionsDto)obj).getDescripcion())
				&& this.getFechaApertura().equals(((DetailConditionsDto)obj).getFechaApertura())
				&& this.getComisiones().equals(((DetailConditionsDto)obj).getComisiones());
	}

	@Override
	public String toString() {
		return new ToStringBuilder(this).append("categoria", getCategoria()).append("descripcion", getDescripcion())
				.append("fechaApertura", getFechaApertura()).append("comisiones", getComisiones()).toString();
	}

	// Setters and getters

	/**
	 * @return the categoria
	 */
	public String getCategoria() {
		return categoria;
	}

	/**
	 * @param categoria the categoria to set
	 */
	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	/**
	 * @return the descripcion
	 */
	public String getDescripcion() {
		return descripcion;
	}

	/**
	 * @param descripcion the descripcion to set
	 */
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	/**
	 * @return the fechaApertura
	 */
	public Date getFechaApertura() {
		return fechaApertura;
	}

	/**
	 * @param fechaApertura the fechaApertura to set
	 */
	public void setFechaApertura(Date fechaApertura) {
		this.fechaApertura = fechaApertura;
	}

	/**
	 * @return the comisiones
	 */
	public String getComisiones() {
		return comisiones;
	}

	/**
	 * @param comisiones the comisiones to set
	 */
	public void setComisiones(String comisiones) {
		this.comisiones = comisiones;
	}
}
