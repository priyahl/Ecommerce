package com.Ecommerce_website.Model;

import java.math.BigDecimal;
import java.util.Date;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

@Entity
@Table(name = "ECOMMERCE_VENDOR")
public class Vendor {
	
	@Id
	@Column(name="VENDOR_ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long vendorId;
	
	@Column(name="VENDOR_NAME")
	private String name;

	@Column(name="EMAIL")
	@Email(message = "Invalid email format.")
	private String emailId;
	
	@Column(name="MOB_NO")
	@Pattern(regexp = "^[0-9]{10}$", message = "Mobile number should be 10 digits long.")
	private String mobileNumber;
	
	@Column(name="ADDRESS")
	@NotNull(message = "Address cannot be null.")
	private String address;
	
	@Column(name="STATUS")
	private boolean status;
	
	@Column(name="AVAILABILITY")
	private String availability;
	
	@Column(name="BALANCE")
	private BigDecimal balance;
	
	@Column(name = "CREATED_ON", updatable=false)
	@CreationTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	private Date createdOn;
	
	@Column(name="LAST_MODIFIED_ON")
	@UpdateTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	private Date lastUpdatedOn;

	public long getVendorId() {
		return vendorId;
	}

	public void setVendorId(long vendorId) {
		this.vendorId = vendorId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	
	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	
	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public String getAvailability() {
		return availability;
	}

	public void setAvailability(String availability) {
		this.availability = availability;
	}

	public BigDecimal getBalance() {
		return balance;
	}

	public void setBalance(BigDecimal balance) {
		this.balance = balance;
	}

	public Date getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}

	public Date getLastUpdatedOn() {
		return lastUpdatedOn;
	}

	public void setLastUpdatedOn(Date lastUpdatedOn) {
		this.lastUpdatedOn = lastUpdatedOn;
	}

	
}
