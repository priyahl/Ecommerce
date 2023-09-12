package com.rechargeDevelopment.Dto;

import java.math.BigDecimal;

public class GetRechargePlanDto {
	private long Id;
	private BigDecimal rechargeAmount;
	private String description;
	private String validity;
	private long catId;
	private long vendorId;
	public long getId() {
		return Id;
	}
	public void setId(long id) {
		Id = id;
	}
	public BigDecimal getRechargeAmount() {
		return rechargeAmount;
	}
	public void setRechargeAmount(BigDecimal rechargeAmount) {
		this.rechargeAmount = rechargeAmount;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getValidity() {
		return validity;
	}
	public void setValidity(String validity) {
		this.validity = validity;
	}
	public long getCatId() {
		return catId;
	}
	public void setCatId(long catId) {
		this.catId = catId;
	}
	public long getVendorId() {
		return vendorId;
	}
	public void setVendorId(long vendorId) {
		this.vendorId = vendorId;
	}
	
	
}
