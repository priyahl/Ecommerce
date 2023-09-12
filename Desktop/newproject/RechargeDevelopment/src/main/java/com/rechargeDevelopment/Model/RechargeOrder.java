package com.rechargeDevelopment.Model;

import java.math.BigDecimal;
import java.util.Date;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@Table(name = "RECHARGE_ORDER")
//@NamedQuery(name = "RechargeOrder.findAll", query = "SELECT t FROM RechargeOrder t")

public class RechargeOrder {

	@Id
	@Column(name = "ORDER_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private long orderId;
	
	@Column(name="DESCRIPTION")
	private String description;
	
	@Column(name="AMOUNT")
	private BigDecimal amount;
	
	@Column(name="CONTACT_NO")
	private String contactNo;

	
	@Column(name="TRANSACTION_ID")
	private String trasactionId;
	
	@ManyToOne
	@JoinColumn(name = "USER_ID")
	@JsonManagedReference
	private RechargeUser rechargeUser;

	@ManyToOne
	@JoinColumn(name = "RECHARGE_PLAN_ID")
	@JsonManagedReference
	private RechargePlan rechargePlan;


	@Column(name = "CREATED_ON", updatable=false)
	@CreationTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	private Date createdOn;
	
	
	@Column(name="LAST_MODIFIED_ON")
	@UpdateTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	private Date lastUpdatedOn;
	

	public RechargeOrder() {
		super();
	
	}

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


	public RechargePlan getRechargePlan() {
		return rechargePlan;
	}

	public void setRechargePlan(RechargePlan rechargePlan) {
		this.rechargePlan = rechargePlan;
	}

	public RechargeUser getRechargeUser() {
		return rechargeUser;
	}

	public void setRechargeUser(RechargeUser rechargeUser) {
		this.rechargeUser = rechargeUser;
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


