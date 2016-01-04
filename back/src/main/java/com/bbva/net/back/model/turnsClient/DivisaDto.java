package com.bbva.net.back.model.turnsClient;

import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

import com.bbva.net.back.core.pattern.dto.Dto;

/**
 * @author Entelgy
 */
public class DivisaDto implements Dto {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    private String nameMoney;

    private String identMoney;

    /**
     *
     */
    public DivisaDto() {
    }

    /**
     * @param nameMoney
     * @param identMoney
     */
    public DivisaDto(String nameMoney, String identMoney) {
        this.nameMoney = nameMoney;
        this.identMoney = identMoney;
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(getNameMoney()).append(getIdentMoney()).toHashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return (obj != null)
                && (obj instanceof DivisaDto)
                && (this.getNameMoney() != null && ((DivisaDto)obj).getNameMoney() != null)
                && (this.getIdentMoney() != null && ((DivisaDto)obj).getIdentMoney() != null);
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("nombre", getNameMoney()).append("cod", getIdentMoney()).toString();
    }

    // Setters and getters

    /**
     * @return the nameMoney
     */
    public String getNameMoney() {
        return nameMoney;
    }

    /**
     * @param nameMoney the nameMoney to set
     */
    public void setNameMoney(String nameMoney) {
        this.nameMoney = nameMoney;
    }

    /**
     * @return the identMoney
     */
    public String getIdentMoney() {
        return identMoney;
    }

    /**
     * @param identMoney the identMoney to set
     */
    public void setIdentMoney(String identMoney) {
        this.identMoney = identMoney;
    }

}
