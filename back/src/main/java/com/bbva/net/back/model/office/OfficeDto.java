package com.bbva.net.back.model.office;

import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

import com.bbva.net.back.core.pattern.dto.Dto;

public class OfficeDto implements Dto {

	private static final long serialVersionUID = -2339037734252093711L;

	private String name;

	private String Addres;

	public OfficeDto() {
	}

	/**
	 * @param name
	 * @param addres
	 */
	public OfficeDto(String name, String addres) {
		super();
		this.name = name;
		Addres = addres;
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder().append(getName()).append(getAddres()).toHashCode();
	}

	@Override
	public boolean equals(Object obj) {
		return (obj != null) && (obj instanceof OfficeDto) && this.getName().equals(((OfficeDto)obj).getName())
				&& this.getAddres().equals(((OfficeDto)obj).getAddres());
	}

	@Override
	public String toString() {
		return new ToStringBuilder(this).append("Name Office", getName()).append("Addres Office", getAddres())
				.toString();
	}

	// Setters and getters

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the addres
	 */
	public String getAddres() {
		return Addres;
	}

	/**
	 * @param addres the addres to set
	 */
	public void setAddres(String addres) {
		Addres = addres;
	}
}
