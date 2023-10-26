package com.Ecommerce_website.Dto;

import java.math.BigDecimal;
import java.util.List;

import com.Ecommerce_website.Model.Items;

public class CartResDto {
	private long cartId;
	private BigDecimal amount;
	public long getCartId() {
		return cartId;
	}
	public void setCartId(long cartId) {
		this.cartId = cartId;
	}
	public BigDecimal getAmount() {
		return amount;
	}
	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}
	
}
