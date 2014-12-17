package com.bbva.net.back.model.accounts;

import com.bbva.net.back.core.pattern.dto.Dto;

public class TermsAccountsDto implements Dto {

	/**
	 * 
	 */
	private static final long serialVersionUID = -991855557764879895L;

	private ProductInformationDto informacionProducto;

	private InvolvedDto intervinientes;

	private DetailConditionsDto detalleCondiciones;

	private PostalAddresDto direccionPostal;

	public ProductInformationDto getInformacionProducto() {
		return informacionProducto;
	}

	public void setInformacionProducto(ProductInformationDto informacionProducto) {
		this.informacionProducto = informacionProducto;
	}

	public InvolvedDto getIntervinientes() {
		return intervinientes;
	}

	public void setIntervinientes(InvolvedDto intervinientes) {
		this.intervinientes = intervinientes;
	}

	public DetailConditionsDto getDetalleCondiciones() {
		return detalleCondiciones;
	}

	public void setDetalleCondiciones(DetailConditionsDto detalleCondiciones) {
		this.detalleCondiciones = detalleCondiciones;
	}

	public PostalAddresDto getDireccionPostal() {
		return direccionPostal;
	}

	public void setDireccionPostal(PostalAddresDto direccionPostal) {
		this.direccionPostal = direccionPostal;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public boolean equals(Object arg0) {
		// TODO Auto-generated method stub
		return super.equals(arg0);
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
