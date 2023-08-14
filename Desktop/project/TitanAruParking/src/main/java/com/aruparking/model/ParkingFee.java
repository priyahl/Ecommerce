package com.aruparking.model;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="PARKING_FEE")
public class ParkingFee {
	
	@Id
	@Column(name="PARKING_ID")
	@GeneratedValue(strategy = GenerationType.AUTO)
   private long id;
	
	@Column(name="AMOUNT")
   private BigDecimal ammount;
	
	@Column(name="TIMING")
   private String timing;
	
	@Column(name="CREATED_ON")
   private Date createdOn;
	
	@Column(name = "LAST_UPDATED_ON")
   private Date lastUpdatedOn;
	
	@OneToMany(mappedBy = "parkingFee")
	private List<ParkingOrder> parkingOrder;

	public ParkingFee() {
		super();
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public BigDecimal getAmmount() {
		return ammount;
	}

	public void setAmmount(BigDecimal ammount) {
		this.ammount = ammount;
	}

	public String getTiming() {
		return timing;
	}

	public void setTiming(String timing) {
		this.timing = timing;
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
