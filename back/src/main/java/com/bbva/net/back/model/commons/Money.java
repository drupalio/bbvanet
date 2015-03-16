package com.bbva.net.back.model.commons;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.Locale;

import org.apache.commons.lang.builder.HashCodeBuilder;

import com.bbva.net.back.core.pattern.dto.Dto;

/**
 * @author Entelgy
 */
public class Money implements Dto, Comparable<Money> {

	private static final long serialVersionUID = -4589862928168820463L;

	private String symbol = "$";

	private String currency;

	private BigDecimal amount;

	public Money() {
		super();
	}

	public Money(String arg0) {
		String[] temp;

		/* delimiter */
		String delimiter = " ";

		if (arg0 != null) {

			/* given string will be split by the argument delimiter provided. */
			temp = arg0.split(delimiter);

			if (temp != null && temp.length == 2) {
				setAmount(new BigDecimal(temp[0]));
				setCurrency(temp[1]);
			}
		}
	}

	@Override
	public String toString() {
		final NumberFormat formatter = NumberFormat.getInstance(new Locale("es_CO"));
		formatter.setGroupingUsed(true);
		formatter.setMinimumFractionDigits(2);
		return symbol + formatter.format(amount);
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder().append(getCurrency()).append(getAmount()).toHashCode();
	}

	@Override
	public boolean equals(Object obj) {
		return (obj != null) && (obj instanceof Money) && this.getCurrency() == (((Money)obj).getCurrency())
				&& this.getAmount() == (((Money)obj).getAmount());
	}

	@Override
	public int compareTo(final Money otherMoney) {
		int compare = 0;
		if (this.amount.compareTo(otherMoney.amount) >= 1) compare = 1;

		if (this.amount.compareTo(otherMoney.amount) == 0) compare = 0;

		if (this.amount.compareTo(otherMoney.amount) <= -1) compare = -1;

		return compare;
	}

	// Setters and getters

	public Money(BigDecimal amount) {
		this.amount = amount;
	}

	public Money(BigDecimal money, String currency) {
		this.currency = currency;
		this.amount = money;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}
}