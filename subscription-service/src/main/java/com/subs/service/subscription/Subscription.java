package com.subs.service.subscription;



import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;


@Entity
@Table(name = "subscriptions")
public class Subscription implements Serializable{

	
    private long id;
    private String firstName;
    private String gender;
    private Date  dateOfBirth;
    private Boolean consent;
    private String emailId;

    public Subscription() {

    }

   
    //TODO

    public Subscription(long id, String firstName, String gender, Date dateOfBirth, Boolean consent, String emailId) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.gender = gender;
		this.dateOfBirth = dateOfBirth;
		this.consent = consent;
		this.emailId = emailId;
	}



	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }

    @Column(name = "first_name", nullable = true)
    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Column(name = "gender", nullable = true)
    public String getGender() {
        return gender;
    }
    public void setGender(String gender) {
        this.gender = gender;
    }
    
    @NotNull(message = "Please a date of birth")
    @Column(name = "date_of_birth", nullable = false)
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

    @NotNull(message = "Please put a email address")
    @Email
	@Column(name = "email_address", nullable = false)
    public String getEmailId() {
        return emailId;
    }
    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }


	@Override
	public String toString() {
		return "Subscription [id=" + id + ", firstName=" + firstName + ", gender=" + gender + ", dateOfBirth="
				+ dateOfBirth + ", consent=" + consent + ", emailId=" + emailId + "]";
	}
	
    
}