package com.bbva.net.back.model.header;

import java.util.Date;

import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

import com.bbva.net.back.core.pattern.dto.Dto;

public class CustomerDto implements Dto {

	/**
	 * 
	 */
	private static final long serialVersionUID = -907569225803522803L;

	private String nombre;

	private Date date;

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public boolean equals(Object obj) {
		return (obj instanceof CustomerDto) && this.getDate().equals(((CustomerDto)obj).getDate())
				&& this.getNombre().equals(((CustomerDto)obj).getNombre());
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder().append(getDate()).append(getDate()).append(getNombre()).toHashCode();
	}

	@Override
	public String toString() {
		return new ToStringBuilder(this).append("Ultima Fecha", getDate()).append("Nombre", getNombre()).toString();
	}

}
