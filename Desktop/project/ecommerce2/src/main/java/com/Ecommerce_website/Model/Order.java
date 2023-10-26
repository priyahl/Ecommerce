package com.Ecommerce_website.Model;

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
@Table(name = "ECOMMERCE_ORDER")
public class Order {

	@Id
	@Column(name="ORDER_ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long orderId;
	
	@OneToOne
	@JoinColumn(name="CART_ID")
	private Cart cart;
	
	@ManyToOne
	@JoinColumn(name="USER_ID")
	private User user;
	
	@ManyToOne
	@JoinColumn(name="VENDOR_ID")
	private Vendor vendor;
	
	@Column(name="AMOUNT")
	private BigDecimal amount;

	@Column(name="TRANSACTION_ID")
	private String transactionId;
	
	@Column(name="DESCRIPTION")
	private String description;
	
	@Column(name = "CREATED_ON", updatable=false)
	@CreationTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	private Date createdOn;
	
	@Column(name="LAST_MODIFIED_ON")
	@UpdateTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	private Date lastUpdatedOn;

	public long getOrderId() {
		return orderId;
	}

	public void setOrderId(long orderId) {
		this.orderId = orderId;
	}

	public Cart getCart() {
		return cart;
	}

	public void setCart(Cart cart) {
		this.cart = cart;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Vendor getVendor() {
		return vendor;
	}

	public void setVendor(Vendor vendor) {
		this.vendor = vendor;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	
	public String getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(String transactionId) {
		this.transactionId = transactionId;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
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
