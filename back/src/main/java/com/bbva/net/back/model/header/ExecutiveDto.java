package com.bbva.net.back.model.header;

import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

import com.bbva.net.back.core.pattern.dto.Dto;
import com.bbva.net.back.model.office.OfficeDto;

/**
 * @author Entelgy
 */
public class ExecutiveDto implements Dto {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5171899248470478707L;

	/**
	 * 
	 */
	private String name;

	/**
	 * 
	 */
	private OfficeDto office;

	/**
	 * 
	 */
	private String phone;

	/**
	 * 
	 */
	private String mail;

	/**
	 * 
	 */
	private String coordenadas;

	/**
	 * 
	 */
	public ExecutiveDto() {
	}

	/**
	 * @param name
	 * @param office
	 * @param phone
	 * @param mail
	 * @param coordenadas
	 */
	public ExecutiveDto(final String name, final OfficeDto office, final String phone, final String mail,
			final String coordenadas) {
		super();
		this.name = name;
		this.office = office;
		this.phone = phone;
		this.mail = mail;
		this.coordenadas = coordenadas;
	}

	/**
	 * 
	 */
	@Override
	public int hashCode() {
		return new HashCodeBuilder().append(getName()).append(getOffice()).append(getPhone()).append(getMail())
				.append(getCoordenadas()).toHashCode();
	}

	/**
	 * 
	 */
	@Override
	public boolean equals(final Object obj) {
		return (obj != null) && (obj instanceof ExecutiveDto) && this.getName().equals(((ExecutiveDto)obj).getName())
				&& this.getOffice().equals(((ExecutiveDto)obj).getOffice())
				&& this.getPhone().equals(((ExecutiveDto)obj).getPhone())
				&& this.getMail().equals(((ExecutiveDto)obj).getMail())
				&& this.getCoordenadas().equals(((ExecutiveDto)obj).getCoordenadas());
	}

	/**
	 * 
	 */
	@Override
	public String toString() {
		return new ToStringBuilder(this).append("Name ", getName()).append("Office ", getOffice())
				.append("Phone ", getPhone()).append("Mail ", getMail()).append("Cordenadas ", getCoordenadas())
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
	public void setName(final String name) {
		this.name = name;
	}

	/**
	 * @return the office
	 */
	public OfficeDto getOffice() {
		return office;
	}

	/**
	 * @param office the office to set
	 */
	public void setOffice(final OfficeDto office) {
		this.office = office;
	}

	/**
	 * @return the phone
	 */
	public String getPhone() {
		return phone;
	}

	/**
	 * @param phone the phone to set
	 */
	public void setPhone(final String phone) {
		this.phone = phone;
	}

	/**
	 * @return the mail
	 */
	public String getMail() {
		return mail;
	}

	/**
	 * @param mail the mail to set
	 */
	public void setMail(final String mail) {
		this.mail = mail;
	}

	/**
	 * @return the coordenadas
	 */
	public String getCoordenadas() {
		return coordenadas;
	}

	/**
	 * @param coordenadas the coordenadas to set
	 */
	public void setCoordenadas(final String coordenadas) {
		this.coordenadas = coordenadas;
	}
}
