package com.bbva.net.back.model.header;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

import com.bbva.net.back.core.pattern.dto.Dto;

/**
 * @author Entelgy
 */
public class CustomerDto implements Dto {

	/**
	 * 
	 */
	private static final long serialVersionUID = -907569225803522803L;

	/**
	 * 
	 */
	private String nombre;

	/**
	 * 
	 */
	private String date;

	/**
	 * 
	 */
	private String segment;

	/**
	 * 
	 */
	private List<EmailDto> emails;

	/**
	 * 
	 */
	private List<PhoneNumbers> phoneNumbers;

	/**
	 * 
	 */
	public CustomerDto() {
	}

	/**
	 * @param nombre
	 * @param date
	 */
	public CustomerDto(final String nombre, final String date) {
		this.nombre = nombre;
		this.date = date;
	}

	/**
	 * 
	 */
	@Override
	public boolean equals(final Object obj) {
		return (obj != null) && (obj instanceof CustomerDto) && this.getDate().equals(((CustomerDto)obj).getDate())
				&& this.getNombre().equals(((CustomerDto)obj).getNombre());
	}

	/**
	 * 
	 */
	@Override
	public int hashCode() {
		return new HashCodeBuilder().append(getDate()).append(getDate()).append(getNombre()).toHashCode();
	}

	/**
	 * 
	 */
	@Override
	public String toString() {
		return new ToStringBuilder(this).append("Ultima Fecha", getDate()).append("Nombre", getNombre()).toString();
	}

	// Setters and getters

	/**
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}

	public String getFecha() {
		SimpleDateFormat fecha = new SimpleDateFormat("E MMM dd HH:mm:ss z yyyy", Locale.ENGLISH);
		try {
			Date datehora = fecha.parse(this.date);
			fecha = new SimpleDateFormat("dd/MM/yyyy");
			return fecha.format(datehora);

		} catch (Exception e) {
			System.out.println("EEE:" + e.getMessage());
			return "";
		}
	}

	public String getHora() {
		SimpleDateFormat fecha = new SimpleDateFormat("E MMM dd HH:mm:ss z yyyy", Locale.ENGLISH);
		try {
			Date datehora = fecha.parse(this.date);
			fecha = new SimpleDateFormat("HH:mm");
			return fecha.format(datehora);

		} catch (Exception e) {
			System.out.println("EEE:" + e.getMessage());
			return "";
		}
	}

	/**
	 * @param nombre the nombre to set
	 */
	public void setNombre(final String nombre) {
		this.nombre = nombre;
	}

	/**
	 * @return the date
	 */
	public String getDate() {
		return date;
	}

	/**
	 * @param date the date to set
	 */
	public void setDate(final String date) {
		this.date = date;
	}

	/**
	 * @return
	 */
	public List<EmailDto> getEmails() {
		return emails;
	}

	/**
	 * @param emails
	 */
	public void setEmails(List<EmailDto> emails) {
		this.emails = emails;
	}

	/**
	 * @return
	 */
	public List<PhoneNumbers> getPhoneNumbers() {
		return phoneNumbers;
	}

	/**
	 * @param phoneNumbers
	 */
	public void setPhoneNumbers(List<PhoneNumbers> phoneNumbers) {
		this.phoneNumbers = phoneNumbers;
	}

	/**
	 * @return
	 */
	public String getSegment() {
		return segment;
	}

	/**
	 * @param segment
	 */
	public void setSegment(String segment) {
		this.segment = segment;
	}

}
