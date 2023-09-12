package com.rechargeDevelopment.Dto;

import java.math.BigDecimal;

public class RechargeOrderHistoryDto {
	private long orderId;
	private BigDecimal amount;
	private String contactNo;
	private String trasactionId;
	private long userId;
	private long id;
	public long getOrderId() {
		return orderId;
	}
	public void setOrderId(long orderId) {
		this.orderId = orderId;
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

	
}
