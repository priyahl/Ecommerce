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
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@Table(name = "ECOMMERCE_ITEMS")
public class Items {

	@Id
	@Column(name="ITEM_ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long itemId;
	
	@Column(name="ITEM_NAME")
	private String name;

	@Column(name="QUANTITY")
	private long quantity;

	@ManyToOne
	@JoinColumn(name="CAT_ID")
	private Category category;
	
	@ManyToOne
	@JoinColumn(name="VENDOR_ID")
	private Vendor vendor;
	
	@ManyToOne
	@JoinColumn(name="CART_ID")
	private Cart cart;
	
	@Column(name="AMOUNT")
	private BigDecimal amount;

	@Column(name="STATUS")
	private boolean status;

	@Column(name = "CREATED_ON", updatable=false)
	@CreationTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	private Date createdOn;
	
	@Column(name="LAST_MODIFIED_ON")
	@UpdateTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	private Date lastUpdatedOn;

	public long getItemId() {
		return itemId;
	}

	public void setItemId(long itemId) {
		this.itemId = itemId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	
	public long getQuantity() {
		return quantity;
	}

	public void setQuantity(long quantity) {
		this.quantity = quantity;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public Vendor getVendor() {
		return vendor;
	}

	public void setVendor(Vendor vendor) {
		this.vendor = vendor;
	}

	
	public Cart getCart() {
		return cart;
	}

	public void setCart(Cart cart) {
		this.cart = cart;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
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
