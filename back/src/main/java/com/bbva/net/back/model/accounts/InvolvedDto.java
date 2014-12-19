package com.bbva.net.back.model.accounts;

import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

import com.bbva.net.back.core.pattern.dto.Dto;

public class InvolvedDto implements Dto {

	public InvolvedDto() {
		// TODO Auto-generated constructor stub
	}

	public InvolvedDto(String titular1, String titular2, String condicionesMovilizacion) {
		super();
		this.titular1 = titular1;
		this.titular2 = titular2;
		this.condicionesMovilizacion = condicionesMovilizacion;
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 3880054876347057143L;

	private String titular1;

	private String titular2;

	private String condicionesMovilizacion;

	public String getTitular1() {
		return titular1;
	}

	public void setTitular1(String titular1) {
		this.titular1 = titular1;
	}

	public String getTitular2() {
		return titular2;
	}

	public void setTitular2(String titular2) {
		this.titular2 = titular2;
	}

	public String getCondicionesMovilizacion() {
		return condicionesMovilizacion;
	}

	public void setCondicionesMovilizacion(String condicionesMovilizacion) {
		this.condicionesMovilizacion = condicionesMovilizacion;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return new ToStringBuilder(this).append("titular1", getTitular1()).append("titular2", getTitular2())
				.append("condicionesMovilizacion", getCondicionesMovilizacion()).toString();
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder().append(getTitular1()).append(getTitular2()).append(getCondicionesMovilizacion())
				.toHashCode();
	}

	@Override
	public boolean equals(Object obj) {

		return (obj instanceof InvolvedDto) && this.getTitular1().equals(((InvolvedDto)obj).getTitular1())
				&& this.getTitular2().equals(((InvolvedDto)obj).getTitular2())
				&& this.getCondicionesMovilizacion().equals(((InvolvedDto)obj).getCondicionesMovilizacion());

	}

}
