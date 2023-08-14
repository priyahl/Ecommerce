package com.aruparking.model;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@Table(name = "PARKING_USER")
public class ParkingUser {

	@Id
	@Column(name = "ID")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@Column(name = "FIRST_NAME")
	private String firstName;

	@Column(name = "LAST_NAME")
	private String lastName;

	@Column(name = "EMAIL_ID")
	private String emailId;

	@Column(name = "DOB")
	@Temporal(TemporalType.DATE)
	private Date dob;

	@Column(name = "BALANCE")
	private BigDecimal balance;

	@Column(name = "CREATED_ON", updatable = false)
	@CreationTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	private Date creationOn;

	@Column(name = "LAST_UPDATED_ON")
	@UpdateTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	private Date LastUpdatedOn;
	
	@OneToMany(mappedBy = "parkingUser")
	private List<ParkingOrder> parkingOrder;

	public ParkingUser() {
		super();
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

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public BigDecimal getBalance() {
		return balance;
	}

	public void setBalance(BigDecimal balance) {
		this.balance = balance;
	}
	public Date getCreationOn() {
		return creationOn;
	}
	public void setCreationOn(Date creationOn) {
		this.creationOn = creationOn;
	}
	public Date getLastUpdatedOn() {
		return LastUpdatedOn;
	}
	public void setLastUpdatedOn(Date lastUpdatedOn) {
		LastUpdatedOn = lastUpdatedOn;
	}
	
}
