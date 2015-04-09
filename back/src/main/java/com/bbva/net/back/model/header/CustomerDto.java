package com.bbva.net.back.model.header;

import java.util.Date;

import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

import com.bbva.net.back.core.pattern.dto.Dto;

/**
 * @author Entelgy
 */
public class CustomerDto implements Dto {

	/**
	 * 
	 */
	private static final long serialVersionUID = -907569225803522803L;

	/**
	 * 
	 */
	private String nombre;

	/**
	 * 
	 */
	private Date date;

	/**
	 * 
	 */
	public CustomerDto() {
	}

	/**
	 * @param nombre
	 * @param date
	 */
	public CustomerDto(final String nombre, final Date date) {
		this.nombre = nombre;
		this.date = date;
	}

	/**
	 * 
	 */
	@Override
	public boolean equals(final Object obj) {
		return (obj != null) && (obj instanceof CustomerDto) && this.getDate().equals(((CustomerDto)obj).getDate())
				&& this.getNombre().equals(((CustomerDto)obj).getNombre());
	}

	/**
	 * 
	 */
	@Override
	public int hashCode() {
		return new HashCodeBuilder().append(getDate()).append(getDate()).append(getNombre()).toHashCode();
	}

	/**
	 * 
	 */
	@Override
	public String toString() {
		return new ToStringBuilder(this).append("Ultima Fecha", getDate()).append("Nombre", getNombre()).toString();
	}

	// Setters and getters

	/**
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * @param nombre the nombre to set
	 */
	public void setNombre(final String nombre) {
		this.nombre = nombre;
	}

	/**
	 * @return the date
	 */
	public Date getDate() {
		return date;
	}

	/**
	 * @param date the date to set
	 */
	public void setDate(final Date date) {
		this.date = date;
	}
}
