package com.rechargeDevelopment.Dto;

import java.math.BigDecimal;
import java.util.Date;

import com.rechargeDevelopment.Model.RechargePlan;
import com.rechargeDevelopment.Model.RechargeUser;

public class RechargeOrderDto {
	private long orderId;
	private String description;
	private BigDecimal amount;
	private String contactNo;
	private String trasactionId;
	private long userId;
	private long id;
	private Date createdOn;
	private Date lastUpdatedOn;
	
	
	public long getOrderId() {
		return orderId;
	}
	public void setOrderId(long orderId) {
		this.orderId = orderId;
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
	public String getContactNo() {
		return contactNo;
	}
	public void setContactNo(String contactNo) {
		this.contactNo = contactNo;
	}
	public String getTrasactionId() {
		return trasactionId;
	}
	public void setTrasactionId(String trasactionId) {
		this.trasactionId = trasactionId;
	}
	
	public long getUserId() {
		return userId;
	}
	public void setUserId(long userId) {
		this.userId = userId;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
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
