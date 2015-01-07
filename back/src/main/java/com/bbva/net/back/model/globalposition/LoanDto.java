package com.bbva.net.back.model.globalposition;

import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

import com.bbva.net.back.model.commons.Money;

public class LoanDto extends ProductDto {

	private final static long serialVersionUID = 1L;

	private Money totalDebt;

	private Money totalDue;

	public Money getTotalDebt() {
		return totalDebt;
	}

	public void setTotalDebt(Money value) {
		this.totalDebt = value;
	}

	public boolean isSetTotalDebt() {
		return (this.totalDebt != null);
	}

	public Money getTotalDue() {
		return totalDue;
	}

	public void setTotalDue(Money value) {
		this.totalDue = value;
	}

	public boolean isSetTotalDue() {
		return (this.totalDue != null);
	}

	@Override
	public String toString() {
		return new ToStringBuilder(this).append("totalDebt", getTotalDebt()).append("totalDue", getTotalDue())
				.toString();
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder().append(getTotalDebt()).append(getTotalDue()).toHashCode();
	}

	@Override
	public boolean equals(Object obj) {
		return (obj instanceof LoanDto) && this.getTotalDebt().equals(((LoanDto)obj).getTotalDebt())
				&& this.getTotalDue().equals(((LoanDto)obj).getTotalDue());
	}

}
