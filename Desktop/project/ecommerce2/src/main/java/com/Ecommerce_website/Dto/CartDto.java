package com.Ecommerce_website.Dto;

import java.math.BigDecimal;
import java.util.List;

import com.Ecommerce_website.Model.Items;

public class CartDto {
	private long cartId;
	private List<Items> itemId;
	private BigDecimal amount;
	public long getCartId() {
		return cartId;
	}
	public void setCartId(long cartId) {
		this.cartId = cartId;
	}
	public List<Items> getItemId() {
		return itemId;
	}
	public void setItemId(List<Items> itemId) {
		this.itemId = itemId;
	}
	public BigDecimal getAmount() {
		return amount;
	}
	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

}
