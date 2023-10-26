package com.Ecommerce_website.Dto;

import java.util.Date;


public class CategoryDto {
	private long catId;
	private String name;
	private long vendorId;
	private Date createdOn;
	private Date lastUpdatedOn;
	public long getCatId() {
		return catId;
	}
	public void setCatId(long catId) {
		this.catId = catId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public long getVendorId() {
		return vendorId;
	}
	public void setVendorId(long vendorId) {
		this.vendorId = vendorId;
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
