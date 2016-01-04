package com.bbva.net.back.model.turnsClient;

import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

import com.bbva.net.back.core.pattern.dto.Dto;

/**
 * @author Entelgy
 */
public class CityDto implements Dto {
    
    /**
     *
     */
    private static final long serialVersionUID = 1L;
    
    private String nameConutry;
    
    private String idenCountry;
    
    private String nameCity;
    
    private String identCity;
    
    /**
     *
     */
    public CityDto() {
    }
    
    /**
     * @param nameConutry
     * @param idenCountry
     * @param nameCity
     * @param identCity
     */
    public CityDto(String nameConutry, String idenCountry, String nameCity, String identCity) {
        this.nameConutry = nameConutry;
        this.idenCountry = idenCountry;
        this.nameCity = nameCity;
        this.identCity = identCity;
    }
    
    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(getNameConutry()).append(getIdenCountry()).append(getNameCity())
                .append(getIdentCity()).toHashCode();
    }
    
    @Override
    public boolean equals(Object obj) {
        return (obj != null)
                && (obj instanceof CityDto)
                && (this.getNameConutry() != null && ((CityDto)obj).getNameConutry() != null)
                && (this.getIdenCountry() != null && ((CityDto)obj).getIdenCountry() != null)
                && (this.getNameCity() != null && ((CityDto)obj).getNameCity() != null)
                && (this.getIdentCity() != null && ((CityDto)obj).getIdentCity() != null);
    }
    
    @Override
    public String toString() {
        return new ToStringBuilder(this).append("nombre pais", getNameConutry()).append("cod pais", getIdenCountry())
                .append("nombre ciudad", getNameCity()).append("cod ciudad", getIdentCity()).toString();
    }
    
    // Setters and getters
    
    /**
     * @return the nameConutry
     */
    public String getNameConutry() {
        return nameConutry;
    }
    
    /**
     * @param nameConutry the nameConutry to set
     */
    public void setNameConutry(String nameConutry) {
        this.nameConutry = nameConutry;
    }
    
    /**
     * @return the idenCountry
     */
    public String getIdenCountry() {
        return idenCountry;
    }
    
    /**
     * @param idenCountry the idenCountry to set
     */
    public void setIdenCountry(String idenCountry) {
        this.idenCountry = idenCountry;
    }
    
    /**
     * @return the nameCity
     */
    public String getNameCity() {
        return nameCity;
    }
    
    /**
     * @param nameCity the nameCity to set
     */
    public void setNameCity(String nameCity) {
        this.nameCity = nameCity;
    }
    
    /**
     * @return the identCity
     */
    public String getIdentCity() {
        return identCity;
    }
    
    /**
     * @param identCity the identCity to set
     */
    public void setIdentCity(String identCity) {
        this.identCity = identCity;
    }
    
}
