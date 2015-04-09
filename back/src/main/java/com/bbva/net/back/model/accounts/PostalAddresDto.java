package com.bbva.net.back.model.accounts;

import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import com.bbva.net.back.core.pattern.dto.Dto;

public class PostalAddresDto implements Dto {

	private static final long serialVersionUID = -693031896070043693L;

	private String nombreOficina;

	private String direccionPostal;

	public PostalAddresDto() {
	}

	/**
	 * @param nombreOficina
	 * @param direccionPostal
	 */
	public PostalAddresDto(String nombreOficina, String direccionPostal) {
		this.nombreOficina = nombreOficina;
		this.direccionPostal = direccionPostal;
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder().append(getDireccionPostal()).append(getNombreOficina()).toHashCode();
	}

	@Override
	public boolean equals(Object obj) {
		return (obj != null) && (obj instanceof PostalAddresDto)
				&& this.getDireccionPostal().equals(((PostalAddresDto)obj).getDireccionPostal())
				&& this.getNombreOficina().equals(((PostalAddresDto)obj).getNombreOficina());
	}

	@Override
	public String toString() {
		return new ToStringBuilder(this).append("direccionPostal", getDireccionPostal())
				.append("nombreOficina", getNombreOficina()).toString();
	}

	// Setters and getters

	/**
	 * @return the nombreOficina
	 */
	public String getNombreOficina() {
		return nombreOficina;
	}

	/**
	 * @param nombreOficina the nombreOficina to set
	 */
	public void setNombreOficina(String nombreOficina) {
		this.nombreOficina = nombreOficina;
	}

	/**
	 * @return the direccionPostal
	 */
	public String getDireccionPostal() {
		return direccionPostal;
	}

	/**
	 * @param direccionPostal the direccionPostal to set
	 */
	public void setDireccionPostal(String direccionPostal) {
		this.direccionPostal = direccionPostal;
	}

}
