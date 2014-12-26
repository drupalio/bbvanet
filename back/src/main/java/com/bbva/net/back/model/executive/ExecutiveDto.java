package com.bbva.net.back.model.executive;

import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

import com.bbva.net.back.core.pattern.dto.Dto;
import com.bbva.net.back.model.office.OfficeDto;

public class ExecutiveDto implements Dto {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5171899248470478707L;

	private String name;

	private OfficeDto office;

	private String phone;

	private String mail;

	private String coordenadas;

	public String getCoordenadas() {
		return coordenadas;
	}

	public void setCoordenadas(String coordenadas) {
		this.coordenadas = coordenadas;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public OfficeDto getOffice() {
		return office;
	}

	public void setOffice(OfficeDto office) {
		this.office = office;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public boolean equals(Object obj) {
		return (obj instanceof ExecutiveDto) && this.getName().equals(((ExecutiveDto)obj).getName())
				&& this.getOffice().equals(((ExecutiveDto)obj).getOffice())
				&& this.getPhone().equals(((ExecutiveDto)obj).getPhone())
				&& this.getMail().equals(((ExecutiveDto)obj).getMail())
				&& this.getCoordenadas().equals(((ExecutiveDto)obj).getCoordenadas());
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder().append(getName()).append(getOffice()).append(getPhone()).append(getMail())
				.append(getCoordenadas()).toHashCode();
	}

	@Override
	public String toString() {
		return new ToStringBuilder(this).append("Name ", getName()).append("Office ", getOffice())
				.append("Phone ", getPhone()).append("Mail ", getMail()).append("Cordenadas ", getCoordenadas())
				.toString();
	}

}
