/**
 *
 */
package com.bbva.net.back.model.checkbook;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import com.bbva.net.back.core.pattern.dto.Dto;

/**
 * @author User
 */
public class CheckbookDto implements Dto {

    private static final long serialVersionUID = 1L;

    private String actualState;

    // <!-- Entelgy / GP-12834 / 25112015 / INICIO -->

    private Date deliveryDate;

    private Date requestDate;

    // <!-- Entelgy / GP-12834 / 25112015 / FIN -->

    private String totalCheck;

    private String lastCheck;

    private String firstCheck;

    private String id;

    private List<CheckDto> checks;

    public CheckbookDto() {
        checks = new ArrayList<CheckDto>();
    }
    
    // <!-- Entelgy / GP-12834 / 25112015 / INICIO -->

    /**
     * @param actualState
     * @param deliveryDate
     * @param requestDate
     * @param totalCheck
     * @param lastCheck
     * @param firstCheck
     * @param id
     * @param checks
     */
    public CheckbookDto(String actualState, Date deliveryDate, Date requestDate, String totalCheck,
            String lastCheck, String firstCheck, String id, List<CheckDto> checks) {
        this.actualState = actualState;
        this.deliveryDate = deliveryDate;
        this.requestDate = requestDate;
        this.totalCheck = totalCheck;
        this.lastCheck = lastCheck;
        this.firstCheck = firstCheck;
        this.id = id;
        this.checks = checks;
    }

    // <!-- Entelgy / GP-12834 / 25112015 / FIN -->

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(getActualState()).append(getDeliveryDate()).append(getRequestDate())
                .append(getTotalCheck()).append(getLastCheck()).append(getFirstCheck()).append(getId()).toHashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return (obj != null) && (obj instanceof CheckbookDto)
                && (this.getId() != null && ((CheckbookDto)obj).getId() != null)
                && this.getId().equals(((CheckbookDto)obj).getId());
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("actualState", getActualState())
                .append("deliveryDate", getDeliveryDate()).append("requestDate", getRequestDate())
                .append("totalCheck", getTotalCheck()).append("lastCheck", getLastCheck())
                .append("firstCheck", getFirstCheck()).append("id", getId()).toString();
    }

    // Setters and getters

    /**
     * @return the actualState
     */
    public String getActualState() {
        return actualState;
    }

    /**
     * @param actualState the actualState to set
     */
    public void setActualState(String actualState) {
        this.actualState = actualState;
    }

    // <!-- Entelgy / GP-12834 / 25112015 / INICIO -->

    /**
     * @return the deliveryDate
     */
    public Date getDeliveryDate() {
        return deliveryDate;
    }

    /**
     * @param deliveryDate the deliveryDate to set
     */
    public void setDeliveryDate(Date deliveryDate) {
        this.deliveryDate = deliveryDate;
    }

    /**
     * @return the requestDate
     */
    public Date getRequestDate() {
        return requestDate;
    }

    /**
     * @param requestDate the requestDate to set
     */
    public void setRequestDate(Date requestDate) {
        this.requestDate = requestDate;
    }
    
    // <!-- Entelgy / GP-12834 / 25112015 / FIN -->

    /**
     * @return the totalCheck
     */
    public String getTotalCheck() {
        return totalCheck;
    }

    /**
     * @param totalCheck the totalCheck to set
     */
    public void setTotalCheck(String totalCheck) {
        this.totalCheck = totalCheck;
    }

    /**
     * @return the lastCheck
     */
    public String getLastCheck() {
        return lastCheck;
    }

    /**
     * @param lastCheck the lastCheckl to set
     */
    public void setLastCheck(String lastCheck) {
        this.lastCheck = lastCheck;
    }

    /**
     * @return the firstCheck
     */
    public String getFirstCheck() {
        return firstCheck;
    }

    /**
     * @param firstCheck the firstCheck to set
     */
    public void setFirstCheck(String firstCheck) {
        this.firstCheck = firstCheck;
    }

    /**
     * @return the id
     */
    public String getId() {
        return id;
    }

    /**
     * @return the checks
     */
    public List<CheckDto> getChecks() {
        return checks;
    }

    /**
     * @param checks the checks to set
     */
    public void setChecks(List<CheckDto> checks) {
        this.checks = checks;
    }

    /**
     * @param id the id to set
     */
    public void setId(String id) {
        this.id = id;
    }
}