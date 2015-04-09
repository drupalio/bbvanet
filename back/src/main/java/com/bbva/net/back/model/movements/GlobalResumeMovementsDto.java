package com.bbva.net.back.model.movements;

import java.util.List;

import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

import com.bbva.net.back.core.pattern.dto.Dto;

public class GlobalResumeMovementsDto implements Dto {

	private static final long serialVersionUID = 3416944562783875982L;

	private List<MovementsResumeDto> movementsResumeDTO;

	public GlobalResumeMovementsDto() {
	}

	/**
	 * @param movementsResumeDTO
	 */
	public GlobalResumeMovementsDto(List<MovementsResumeDto> movementsResumeDTO) {
		this.movementsResumeDTO = movementsResumeDTO;
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder().append(getMovementsResumeDto()).toHashCode();
	}

	@Override
	public boolean equals(Object obj) {
		return (obj != null) && (obj instanceof GlobalResumeMovementsDto)
				&& this.getMovementsResumeDto() == (((GlobalResumeMovementsDto)obj).getMovementsResumeDto());
	}

	@Override
	public String toString() {
		return new ToStringBuilder(this).append("movementsResume", getMovementsResumeDto()).toString();
	}

	// Setters and getters

	/**
	 * @return
	 */
	public List<MovementsResumeDto> getMovementsResumeDto() {
		return movementsResumeDTO;
	}

	/**
	 * @param movementsResumeDTO
	 */
	public void setMovementsResumeDto(final List<MovementsResumeDto> movementsResumeDTO) {
		this.movementsResumeDTO = movementsResumeDTO;
	}

}