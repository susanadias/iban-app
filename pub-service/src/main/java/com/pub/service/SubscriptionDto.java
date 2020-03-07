package com.pub.service;



import java.io.Serializable;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonIgnore;


/*
 * Template to define the Subscription 
 * 
 */

public class SubscriptionDto implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -3691929979667909852L;
	@JsonIgnore
    private long id;
    private String firstName;
    private String gender;
    private Date  dateOfBirth;
    private Boolean consent;
    private String emailId;

    public SubscriptionDto() {

    }

   
    //Builder Pattern

    public SubscriptionDto(long id, String firstName, String gender, Date dateOfBirth, Boolean consent, String emailId) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.gender = gender;
		this.dateOfBirth = dateOfBirth;
		this.consent = consent;
		this.emailId = emailId;
	}

    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }

   
    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    
    public String getGender() {
        return gender;
    }
    public void setGender(String gender) {
        this.gender = gender;
    }
    
    
    public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	
	
	public Boolean getConsent() {
		return consent;
	}

	public void setConsent(Boolean consent) {
		this.consent = consent;
	}

	
    public String getEmailId() {
        return emailId;
    }
    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }


	@Override
	public String toString() {
		return "SubscriptionDto [id=" + id + ", firstName=" + firstName + ", gender=" + gender + ", dateOfBirth="
				+ dateOfBirth + ", consent=" + consent + ", emailId=" + emailId + "]";
	}
    
    
    
}