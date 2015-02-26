package com.bbva.net.back.model.accounts;

import java.util.List;

import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

import com.bbva.net.back.core.pattern.dto.Dto;

public class TermsAccountsDto implements Dto {

	/**
	 * 
	 */
	private static final long serialVersionUID = -991855557764879895L;

	private DetailConditionsDto detalleCondiciones;

	private PostalAddresDto direccionPostal;

	private List<InvolvedDto> holders;

	private String condicionesMovilizacion;

	@Override
	public String toString() {
		return new ToStringBuilder(this).append("detalleCondiciones", getDetalleCondiciones())
				.append("direccionPostal", getDireccionPostal()).append("holders", getHolders())
				.append("condicionesMovilizacion", getCondicionesMovilizacion()).toString();
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder().append(getDetalleCondiciones()).append(getDireccionPostal()).append(getHolders())
				.append(getCondicionesMovilizacion()).toHashCode();
	}

	@Override
	public boolean equals(Object obj) {

		return (obj instanceof TermsAccountsDto)
				&& this.getDetalleCondiciones().equals(((TermsAccountsDto)obj).getDetalleCondiciones())
				&& this.getDireccionPostal().equals(((TermsAccountsDto)obj).getDireccionPostal())
				&& this.getCondicionesMovilizacion().equals(((TermsAccountsDto)obj).getCondicionesMovilizacion())
				&& this.getHolders() == (((TermsAccountsDto)obj).getHolders());

	}

	// Setters and Getters

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

	public List<InvolvedDto> getHolders() {
		return holders;
	}

	public void setHolders(List<InvolvedDto> holders) {
		this.holders = holders;
	}

	public String getCondicionesMovilizacion() {
		return condicionesMovilizacion;
	}

	public void setCondicionesMovilizacion(String condicionesMovilizacion) {
		this.condicionesMovilizacion = condicionesMovilizacion;
	}
}
