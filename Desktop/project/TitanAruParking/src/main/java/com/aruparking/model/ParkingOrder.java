package com.aruparking.model;

import java.math.BigDecimal;
import java.util.Date;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@Table(name = "PARKING_ORDER")
public class ParkingOrder {

	@Id
	@Column(name = "ORDER_ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Column(name = "DESCRIPTION")
	private String description;

	@Column(name = "AMOUNT")
	private BigDecimal amount;

	@Column(name = "VEHICLE_NO")
	private String vehicleNo;

	@Column(name = "CONTACT_NO")
	private String contactNo;

	@Column(name = "TRANSACTION_ID")
	private String transactionId;
	
	@ManyToOne
	@JoinColumn(name = "USER_ID")
	private ParkingUser parkingUser;
	
	@ManyToOne
	@JoinColumn(name = "SLOTS_ID")
	private ParkingSlots parkingSlots;
	
	@ManyToOne
	@JoinColumn(name = "FEE_ID")
	private ParkingFee parkingFee;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "PARKING_START_TIME",updatable = false)
	private Date parkingStartTime;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "PARKING_END_DATE")
	private Date parkingEndDate;

	@CreationTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "CREATED_ON",updatable = false)
	private Date createdOn;

	@UpdateTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	private Date lastUpdatedOn;

	
	public ParkingOrder() {
		super();
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public String getVehicleNo() {
		return vehicleNo;
	}

	public void setVehicleNo(String vehicleNo) {
		this.vehicleNo = vehicleNo;
	}

	public String getContactNo() {
		return contactNo;
	}

	public void setContactNo(String contactNo) {
		this.contactNo = contactNo;
	}

	public String getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(String transactionId) {
		this.transactionId = transactionId;
	}

	public ParkingUser getParkingUser() {
		return parkingUser;
	}

	public void setParkingUser(ParkingUser parkingUser) {
		this.parkingUser = parkingUser;
	}

	public ParkingSlots getParkingSlots() {
		return parkingSlots;
	}

	public void setParkingSlots(ParkingSlots parkingSlots) {
		this.parkingSlots = parkingSlots;
	}

	public Date getParkingStartTime() {
		return parkingStartTime;
	}

	public void setParkingStartTime(Date parkingStartTime) {
		this.parkingStartTime = parkingStartTime;
	}

	public Date getParkingEndDate() {
		return parkingEndDate;
	}

	public void setParkingEndDate(Date parkingEndDate) {
		this.parkingEndDate = parkingEndDate;
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

	public ParkingFee getParkingFee() {
		return parkingFee;
	}

	public void setParkingFee(ParkingFee parkingFee) {
		this.parkingFee = parkingFee;
	}

}
