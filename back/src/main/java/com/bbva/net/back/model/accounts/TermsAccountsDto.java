package com.bbva.net.back.model.accounts;

import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

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
	public String toString() {
		return new ToStringBuilder(this).append("informacionProducto", getInformacionProducto())
				.append("intervinientes", getIntervinientes()).append("detalleCondiciones", getDetalleCondiciones())
				.append("direccionPostal", getDireccionPostal()).toString();
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder().append(getInformacionProducto()).append(getIntervinientes())
				.append(getDetalleCondiciones()).append(getDireccionPostal()).toHashCode();
	}

	@Override
	public boolean equals(Object obj) {

		return (obj instanceof TermsAccountsDto)
				&& this.getInformacionProducto().equals(((TermsAccountsDto)obj).getInformacionProducto())
				&& this.getIntervinientes().equals(((TermsAccountsDto)obj).getIntervinientes())
				&& this.getDetalleCondiciones().equals(((TermsAccountsDto)obj).getDetalleCondiciones())
				&& this.getDireccionPostal().equals(((TermsAccountsDto)obj).getDireccionPostal());

	}

}
