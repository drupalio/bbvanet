package com.bbva.net.back.model.accounts;

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
