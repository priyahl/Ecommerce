package com.Ecommerce_website.Dto;

public class GetByCategoryDto {
	private long catId;
	private String name;
	private long vendorId;
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

}
