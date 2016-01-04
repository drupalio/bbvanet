package com.bbva.net.back.model.turnsClient;

import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

import com.bbva.net.back.core.pattern.dto.Dto;

/**
 * @author Entelgy
 */
public class FormCurrencyDto implements Dto {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    private String numeralCambiario;

    private String identNumeralCambiario;

    private String description;

    /**
     *
     */
    public FormCurrencyDto() {
    }

    /**
     * @param numeralCambiario
     * @param identNumeralCambiario
     * @param description
     */
    public FormCurrencyDto(String numeralCambiario, String identNumeralCambiario, String description) {
        this.numeralCambiario = numeralCambiario;
        this.identNumeralCambiario = identNumeralCambiario;
        this.description = description;
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(getNumeralCambiario()).append(getIdentNumeralCambiario()).append(getDescription()).toHashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return (obj != null)
                && (obj instanceof FormCurrencyDto)
                && (this.getNumeralCambiario() != null && ((FormCurrencyDto)obj).getNumeralCambiario() != null)
                && (this.getIdentNumeralCambiario() != null && ((FormCurrencyDto)obj).getIdentNumeralCambiario() != null)
                && (this.getDescription() != null && ((FormCurrencyDto)obj).getDescription() != null);
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("numeral", getNumeralCambiario()).append("codNumeral", getIdentNumeralCambiario())
                .append("descripcion", getDescription()).toString();
    }

    // Setters and getters

    /**
     * @return the numeralCambiario
     */
    public String getNumeralCambiario() {
        return numeralCambiario;
    }

    /**
     * @param numeralCambiario the numeralCambiario to set
     */
    public void setNumeralCambiario(String numeralCambiario) {
        this.numeralCambiario = numeralCambiario;
    }

    /**
     * @return the identNumeralCambiario
     */
    public String getIdentNumeralCambiario() {
        return identNumeralCambiario;
    }

    /**
     * @param identNumeralCambiario the identNumeralCambiario to set
     */
    public void setIdentNumeralCambiario(String identNumeralCambiario) {
        this.identNumeralCambiario = identNumeralCambiario;
    }

    /**
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description the description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }
}
