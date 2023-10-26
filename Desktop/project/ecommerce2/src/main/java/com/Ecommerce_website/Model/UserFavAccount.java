package com.Ecommerce_website.Model;

import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "ECOMMERCE_USER_FAV_ACCOUNT")
public class UserFavAccount {
	    @Id
	    @Column(name = "USER_ACCOUNT_ID")
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private long userAccountId;

	    @Column(name = "ITEM_NAME")
	    private String itemName;

	    @Column(name = "AMOUNT")
	    private BigDecimal amount;

	    @Column(name = "STATUS")
	    private boolean status;
	    
	    @ManyToOne
	    @JoinColumn(name = "ITEM_ID")
	    private Items items;

	    @ManyToOne
	    @JoinColumn(name = "USER_ID")
	    private User user;

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

		public Items getItems() {
			return items;
		}

		public void setItems(Items items) {
			this.items = items;
		}

		public User getUser() {
			return user;
		}

		public void setUser(User user) {
			this.user = user;
		}

	 

}
