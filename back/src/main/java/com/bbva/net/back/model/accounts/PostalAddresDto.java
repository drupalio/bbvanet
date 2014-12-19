package com.bbva.net.back.model.accounts;

import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

import com.bbva.net.back.core.pattern.dto.Dto;

public class PostalAddresDto implements Dto {

	public PostalAddresDto() {
		// TODO Auto-generated constructor stub
	}

	public PostalAddresDto(String nombreOficina, String direccionPostal) {
		super();
		this.nombreOficina = nombreOficina;
		this.direccionPostal = direccionPostal;
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = -693031896070043693L;

	private String nombreOficina;

	private String direccionPostal;

	public String getNombreOficina() {
		return nombreOficina;
	}

	public void setNombreOficina(String nombreOficina) {
		this.nombreOficina = nombreOficina;
	}

	public String getDireccionPostal() {
		return direccionPostal;
	}

	public void setDireccionPostal(String direccionPostal) {
		this.direccionPostal = direccionPostal;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return new ToStringBuilder(this).append("nombreOficina", getNombreOficina())
				.append("direccionPostal", getDireccionPostal()).toString();
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder().append(getNombreOficina()).append(getDireccionPostal()).toHashCode();
	}

	@Override
	public boolean equals(Object obj) {

		return (obj instanceof PostalAddresDto)
				&& this.getNombreOficina().equals(((PostalAddresDto)obj).getNombreOficina())
				&& this.getDireccionPostal().equals(((PostalAddresDto)obj).getDireccionPostal());

	}

}
