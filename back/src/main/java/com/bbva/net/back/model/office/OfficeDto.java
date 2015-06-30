package com.bbva.net.back.model.office;

import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

import com.bbva.net.back.core.pattern.dto.Dto;

public class OfficeDto implements Dto {

	private static final long serialVersionUID = -2339037734252093711L;

	private String code;

	private String name;

	private String Addres;

	private String city;

	private String latitude;

	private String length;

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

	/**
	 * @param code
	 * @param name
	 * @param addres
	 * @param city
	 */
	public OfficeDto(String code, String name, String addres, String city) {
		super();
		this.code = code;
		this.name = name;
		this.Addres = addres;
		this.city = city;
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder().append(getCode()).append(getName()).append(getAddres()).append(getCity())
				.toHashCode();
	}

	@Override
	public boolean equals(Object obj) {
		return (obj != null) && (obj instanceof OfficeDto) && this.getCode().equals(((OfficeDto)obj).getCode())
				&& this.getName().equals(((OfficeDto)obj).getName())
				&& this.getAddres().equals(((OfficeDto)obj).getAddres())
				&& this.getCity().equals(((OfficeDto)obj).getCity());
	}

	@Override
	public String toString() {
		return new ToStringBuilder(this).append("Code Office", getCode()).append("Name Office", getName())
				.append("Addres Office", getAddres()).append("City Office", getCity()).toString();
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

	/**
	 * @return
	 */
	public String getCode() {
		return code;
	}

	/**
	 * @param code
	 */
	public void setCode(String code) {
		this.code = code;
	}

	/**
	 * @return
	 */
	public String getCity() {
		return city;
	}

	/**
	 * @param city
	 */
	public void setCity(String city) {
		this.city = city;
	}

	public String getLatitude() {
		return latitude;
	}

	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}

	public String getLength() {
		return length;
	}

	public void setLength(String length) {
		this.length = length;
	}

}
