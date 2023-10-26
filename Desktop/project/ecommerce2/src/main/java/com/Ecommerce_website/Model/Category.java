package com.Ecommerce_website.Model;

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
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@Table(name = "ECOMMERCE_CATEGORY")
public class Category {

	@Id
	@Column(name="CAT_ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long catId;
	
	@Column(name="NAME")
	private String name;
	
	@ManyToOne
	@JoinColumn(name="VENDOR_ID")
	private Vendor vendor;
	
	@Column(name = "CREATED_ON", updatable=false)
	@CreationTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	private Date createdOn;

	@Column(name="LAST_MODIFIED_ON")
	@UpdateTimestamp
	@Temporal(TemporalType.TIMESTAMP)
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

	public Vendor getVendor() {
		return vendor;
	}

	public void setVendor(Vendor vendor) {
		this.vendor = vendor;
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
