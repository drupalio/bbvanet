package com.bbva.net.back.model.office;

import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

import com.bbva.net.back.core.pattern.dto.Dto;

public class OfficeDto implements Dto {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2339037734252093711L;

	private String name;

	private String Addres;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddres() {
		return Addres;
	}

	public void setAddres(String Addres) {
		this.Addres = Addres;
	}

	@Override
	public boolean equals(Object obj) {

		return (obj instanceof OfficeDto) && this.getName().equals(((OfficeDto)obj).getName())
				&& this.getAddres().equals(((OfficeDto)obj).getAddres());
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder().append(getName()).append(getAddres()).toHashCode();
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return new ToStringBuilder(this).append("Name Office", getName()).append("Addres Office", getAddres())
				.toString();
	}

}
