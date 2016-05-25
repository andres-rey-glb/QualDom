package com.swacorp.crew.microservices.css.domain;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.springframework.data.annotation.Id;
import org.springframework.data.gemfire.mapping.Region;
import java.util.Date;
import java.io.Serializable;

@SuppressWarnings("serial")
@Region("QualDates")
public class QualDates implements Serializable{

	@Id
	private Integer qualDateId;
	private Integer crewMemberId;
	private Integer qualificationId;
	private Date date;
	private String certNumber;
	private String certBy;
	private String inputBy;
	private Date inputDate;
	private String score;
	private Integer basis;
	private Date expires;
	private String passFail;
	private String comment;
	private Long dateTime;
	private Long expiresTime;

	public Integer getQualDateId() {
		return qualDateId;
	}
	
	public void setQualDateId(Integer qualDateId) {
		this.qualDateId = qualDateId;
	}
	
	public Integer getCrewMemberId() {
		return crewMemberId;
	}
	
	public void setCrewMemberId(Integer crewMemberId) {
		this.crewMemberId = crewMemberId;
	}
	
	public Integer getQualificationId() {
		return qualificationId;
	}
	
	public void setQualificationId(Integer qualificationId) {
		this.qualificationId = qualificationId;
	}
	
	public Date getDate() {
		return date;
	}
	
	public void setDate(Date date) {
		this.date = date;
	}
	
	public String getCertNumber() {
		return certNumber;
	}
	
	public void setCertNumber(String certNumber) {
		this.certNumber = certNumber;
	}
	
	public String getCertBy() {
		return certBy;
	}
	
	public void setCertBy(String certBy) {
		this.certBy = certBy;
	}
	
	public String getInputBy() {
		return inputBy;
	}
	
	public void setInputBy(String inputBy) {
		this.inputBy = inputBy;
	}
	
	public Date getInputDate() {
		return inputDate;
	}
	
	public void setInputDate(Date inputDate) {
		this.inputDate = inputDate;
	}
	
	public String getScore() {
		return score;
	}
	
	public void setScore(String score) {
		this.score = score;
	}
	
	public Integer getBasis() {
		return basis;
	}
	
	public void setBasis(Integer basis) {
		this.basis = basis;
	}
	
	public Date getExpires() {
		return expires;
	}
	
	public void setExpires(Date expires) {
		this.expires = expires;
	}
	
	public String getPassFail() {
		return passFail;
	}
	
	public void setPassFail(String passFail) {
		this.passFail = passFail;
	}
	
	public String getComment() {
		return comment;
	}
	
	public void setComment(String comment) {
		this.comment = comment;
	}
	
	public Long getDateTime() {
		return dateTime;
	}
	
	public void setDateTime(Long dateTime) {
		this.dateTime = dateTime;
	}
	
	public Long getExpiresTime() {
		return expiresTime;
	}
	
	public void setExpiresTime(Long expiresTime) {
		this.expiresTime = expiresTime;
	}

	
    @Override
    public int hashCode() {
        return new HashCodeBuilder(3, 15).
                append(qualDateId).
                toHashCode();
    }

    @Override
    public boolean equals(Object testObj) {
        if (testObj == null) { return false; }
        if (testObj == this) { return true; }
        if (testObj.getClass() != getClass()) {
            return false;
        }
        QualDates test = (QualDates) testObj;
        return new EqualsBuilder()
                .appendSuper(super.equals(testObj))
                .append(qualDateId, test.qualDateId)
                .isEquals();
    }

}
