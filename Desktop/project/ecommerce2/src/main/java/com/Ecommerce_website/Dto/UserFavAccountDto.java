package com.Ecommerce_website.Dto;

import java.math.BigDecimal;

import com.Ecommerce_website.Model.Items;
import com.Ecommerce_website.Model.User;

public class UserFavAccountDto {
    private long userAccountId;
    private String itemName;
    private BigDecimal amount;
    private boolean status;
    private long itemId;
    private long userId;
	public long getUserAccountId() {
		return userAccountId;
	}
	public void setUserAccountId(long userAccountId) {
		this.userAccountId = userAccountId;
	}
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
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
	public long getItemId() {
		return itemId;
	}
	public void setItemId(long itemId) {
		this.itemId = itemId;
	}
	public long getUserId() {
		return userId;
	}
	public void setUserId(long userId) {
		this.userId = userId;
	}

}
