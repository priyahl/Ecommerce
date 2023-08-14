package com.aruparking.dto;

import java.math.BigDecimal;
import java.util.Date;

import com.aruparking.model.ParkingSlots;
import com.aruparking.model.ParkingUser;

public class ParkingOrderDto {
	private long id;
	private String description;
	private BigDecimal amount;
	private String vehicleNo;
	private String contactNo;
	private String transactionId;
	private long userid;
	private long slotid;
	private Date parkingStartTime;
	private Date parkingEndDate;
	private Date createdOn;
	private Date lastUpdatedOn;
	private long feeid;
	
	

	public long getFeeid() {
		return feeid;
	}

	public void setFeeid(long feeid) {
		this.feeid = feeid;
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

	public long getUserid() {
		return userid;
	}

	public void setUserid(long userid) {
		this.userid = userid;
	}

	public long getSlotid() {
		return slotid;
	}

	public void setSlotid(long slotid) {
		this.slotid = slotid;
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

}
