package com.bbva.net.back.model.accounts;

import java.util.List;

import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import com.bbva.net.back.core.pattern.dto.Dto;

public class TermsAccountsDto implements Dto {

	private static final long serialVersionUID = -991855557764879895L;

	private DetailConditionsDto detalleCondiciones;

	private PostalAddresDto direccionPostal;

	private List<InvolvedDto> holders;

	private String condicionesMovilizacion;

	public TermsAccountsDto() {
	}

	/**
	 * @param detalleCondiciones
	 * @param direccionPostal
	 * @param holders
	 * @param condicionesMovilizacion
	 */
	public TermsAccountsDto(DetailConditionsDto detalleCondiciones, PostalAddresDto direccionPostal,
			List<InvolvedDto> holders, String condicionesMovilizacion) {
		this.detalleCondiciones = detalleCondiciones;
		this.direccionPostal = direccionPostal;
		this.holders = holders;
		this.condicionesMovilizacion = condicionesMovilizacion;
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder().append(getDetalleCondiciones()).append(getDireccionPostal()).append(getHolders())
				.append(getCondicionesMovilizacion()).toHashCode();
	}

	@Override
	public boolean equals(Object obj) {
		return (obj != null) && (obj instanceof TermsAccountsDto)
				&& this.getDetalleCondiciones() == (((TermsAccountsDto)obj).getDetalleCondiciones())
				&& this.getDireccionPostal() == (((TermsAccountsDto)obj).getDireccionPostal())
				&& this.getHolders() == (((TermsAccountsDto)obj).getHolders())
				&& this.getCondicionesMovilizacion().equals(((TermsAccountsDto)obj).getCondicionesMovilizacion());
	}

	@Override
	public String toString() {
		return new ToStringBuilder(this).append("detalleCondiciones", getDetalleCondiciones())
				.append("direccionPostal", getDireccionPostal()).append("holders", getHolders())
				.append("condiMov", getCondicionesMovilizacion()).toString();
	}

	// Setters and getters

	/**
	 * @return the detalleCondiciones
	 */
	public DetailConditionsDto getDetalleCondiciones() {
		return detalleCondiciones;
	}

	/**
	 * @param detalleCondiciones the detalleCondiciones to set
	 */
	public void setDetalleCondiciones(DetailConditionsDto detalleCondiciones) {
		this.detalleCondiciones = detalleCondiciones;
	}

	/**
	 * @return the direccionPostal
	 */
	public PostalAddresDto getDireccionPostal() {
		return direccionPostal;
	}

	/**
	 * @param direccionPostal the direccionPostal to set
	 */
	public void setDireccionPostal(PostalAddresDto direccionPostal) {
		this.direccionPostal = direccionPostal;
	}

	/**
	 * @return the holders
	 */
	public List<InvolvedDto> getHolders() {
		return holders;
	}

	/**
	 * @param holders the holders to set
	 */
	public void setHolders(List<InvolvedDto> holders) {
		this.holders = holders;
	}

	/**
	 * @return the condicionesMovilizacion
	 */
	public String getCondicionesMovilizacion() {
		return condicionesMovilizacion;
	}

	/**
	 * @param condicionesMovilizacion the condicionesMovilizacion to set
	 */
	public void setCondicionesMovilizacion(String condicionesMovilizacion) {
		this.condicionesMovilizacion = condicionesMovilizacion;
	}

}
