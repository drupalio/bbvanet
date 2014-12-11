/**
 * 
 */
package com.bbva.net.back.model.globalposition;

import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import com.bbva.net.back.core.pattern.dto.Dto;

/**
 * @author User
 */
public class LikeDTO implements Dto {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String likeId;

	private String value;

	private Integer typeId;

	/**
	 * @return the likeId
	 */
	public String getLikeId() {
		return likeId;
	}

	/**
	 * @param likeId the likeId to set
	 */
	public void setLikeId(String likeId) {
		this.likeId = likeId;
	}

	/**
	 * @return the value
	 */
	public String getValue() {
		return value;
	}

	/**
	 * @param value the value to set
	 */
	public void setValue(String value) {
		this.value = value;
	}

	/**
	 * @return the typeId
	 */
	public Integer getTypeId() {
		return typeId;
	}

	/**
	 * @param typeId the typeId to set
	 */
	public void setTypeId(Integer typeId) {
		this.typeId = typeId;
	}

	@Override
	public String toString() {
		return new ToStringBuilder(this).append("productID", getLikeId()).toString();
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder().append(getLikeId()).toHashCode();
	}

	@Override
	public boolean equals(Object obj) {
		return (obj instanceof ProductDTO) && this.getLikeId().equals(((LikeDTO)obj).getLikeId());
	}

}
