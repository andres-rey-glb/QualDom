package com.swacorp.crew.microservices.css.domain;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.springframework.data.annotation.Id;
import org.springframework.data.gemfire.mapping.Region;
import java.io.Serializable;

@Region("ChangeLog")
public class ChangeLog implements Serializable{

   @Id
   private Long changeLogID;  
   private Long changeLogDate;
   private String changeLogUserID;
   private String changeLogAppID;
   private String changeLogDescription;
   private String changeLogAction;

   
    public Long getChangeLogID() {
        return changeLogID;
    }

    public void setChangeLogID(Long changeLogID) {
        this.changeLogID = changeLogID;
    }

    public Long getChangeLogDate() {
        return changeLogDate;
    }

    public void setChangeLogDate(Long changeLogDate) {
        this.changeLogDate = changeLogDate;
    }

    public String getChangeLogUserID() {
        return changeLogUserID;
    }

    public void setChangeLogUserID(String changeLogUserID) {
        this.changeLogUserID = changeLogUserID;
    }

    public String getChangeLogAppID() {
        return changeLogAppID;
    }

    public void setChangeLogAppID(String changeLogAppID) {
        this.changeLogAppID = changeLogAppID;
    }

    public String getChangeLogDescription() {
        return changeLogDescription;
    }

    public void setChangeLogDescription(String changeLogDescription) {
        this.changeLogDescription = changeLogDescription;
    }

    public String getChangeLogAction() {
        return changeLogAction;
    }

    public void setChangeLogAction(String changeLogAction) {
        this.changeLogAction = changeLogAction;
    }


    @Override
    public int hashCode() {
        return new HashCodeBuilder(3, 15).
                append(changeLogID).
                toHashCode();
    }

    @Override
    public boolean equals(Object testObj) {
        if (testObj == null) { return false; }
        if (testObj == this) { return true; }
        if (testObj.getClass() != getClass()) {
            return false;
        }
        ChangeLog test = (ChangeLog) testObj;
        return new EqualsBuilder()
                .appendSuper(super.equals(testObj))
                .append(changeLogID, test.changeLogID)
                .isEquals();
    }

}
