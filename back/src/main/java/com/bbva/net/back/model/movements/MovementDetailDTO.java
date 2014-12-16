package com.bbva.net.back.model.movements;

import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import com.bbva.net.back.core.pattern.dto.Dto;

/**
 * Clase de negocio que contiene la información del detalle en un movimiento
 * 
 * @author Entelgy
 */
public class MovementDetailDTO implements Dto {

	private static final long serialVersionUID = 4629186550492617188L;

	private String plaza;

	private String observations;

	private String centralSourceMovement;

	private String state;

	public String getPlaza() {
		return plaza;
	}

	public void setPlaza(String plaza) {
		this.plaza = plaza;
	}

	public String getObservations() {
		return observations;
	}

	public void setObservations(String observations) {
		this.observations = observations;
	}

	public String getCentralSourceMovement() {
		return centralSourceMovement;
	}

	public void setCentralSourceMovement(String centralSourceMovement) {
		this.centralSourceMovement = centralSourceMovement;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	@Override
	public int hashCode() {

		HashCodeBuilder hashCodeBuielder = new HashCodeBuilder();
		hashCodeBuielder.append(getCentralSourceMovement()).toHashCode();
		hashCodeBuielder.append(getPlaza()).toHashCode();
		hashCodeBuielder.append(getState()).toHashCode();
		return hashCodeBuielder.hashCode();
	}

	@Override
	public boolean equals(Object obj) {

		return (obj instanceof MovementDetailDTO)
				&& this.getCentralSourceMovement().equals(((MovementDetailDTO)obj).getCentralSourceMovement())
				&& this.getPlaza().equals(((MovementDetailDTO)obj).getPlaza())
				&& this.getState().equals(((MovementDetailDTO)obj).getState());
	}

	@Override
	public String toString() {
		ToStringBuilder toStringBuilder = new ToStringBuilder(this);
		toStringBuilder.append("centralSourceMovement", getCentralSourceMovement()).toString();
		toStringBuilder.append("plaza", getPlaza()).toString();
		toStringBuilder.append("state", getState()).toString();
		return toStringBuilder.toString();
	}

}
