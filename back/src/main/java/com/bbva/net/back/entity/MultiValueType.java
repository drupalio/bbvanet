/**
 * 
 */
package com.bbva.net.back.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/**
 * @author User
 */
@Entity(name = "MULTIVALUETYPE")
public class MultiValueType implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	@Column(name = "ID")
	private Long id;

	@Column(name = "TYPE_NAME")
	private String typeName;

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the typeName
	 */
	public String getTypeName() {
		return typeName;
	}

	/**
	 * @param typeName the typeName to set
	 */
	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}

	@Override
	public String toString() {
		return new ToStringBuilder(this).append("id", getId()).append("typeName", getTypeName()).toString();
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder().append(getId()).append(getTypeName()).toHashCode();
	}

	@Override
	public boolean equals(Object obj) {
		return (obj instanceof MultiValueType) && this.getId().equals(((MultiValueType)obj).getId())
				&& this.getTypeName().equals(((MultiValueType)obj).getTypeName());
	}

}