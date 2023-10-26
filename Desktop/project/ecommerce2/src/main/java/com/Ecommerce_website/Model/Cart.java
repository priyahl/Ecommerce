package com.Ecommerce_website.Model;

import java.math.BigDecimal;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "ECOMMERCE_CART")
public class Cart {

	@Id
	@Column(name="CART_ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long cartId;
	
	@OneToMany(mappedBy="cart")
//	@JoinColumn(name="ITEM_ID")
	private List<Items> item;
	
	@Column(name="AMOUNT")
	private BigDecimal amount;

	public long getCartId() {
		return cartId;
	}

	public void setCartId(long cartId) {
		this.cartId = cartId;
	}


	public List<Items> getItem() {
		return item;
	}

	public void setItem(List<Items> item) {
		this.item = item;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}
	
	
}
