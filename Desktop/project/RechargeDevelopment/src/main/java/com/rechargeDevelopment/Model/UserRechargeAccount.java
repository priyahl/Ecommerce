package com.rechargeDevelopment.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;


@Entity
@Table(name = "USER_RECHARGE_ACCOUNT")
//@NamedQuery(name = "UserRechargeAccount.findAll", query = "SELECT t FROM UserRechargeAccount t")
public class UserRechargeAccount {


	@Id
	@Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private long Id;
	
	@Column(name="TELECOM_OPERATOR_NAME")
	private String telecomOperatorName;
	
	@Column(name="MOBILE_NUMBER")
	private String mobileNo;
	
	@Column(name="NICK_NAME")
	private String nickName;
	
	@Column(name="STATUS")
	private int status;
	
	@Column(name="FAV_NUMBER")
	private boolean favNumber;
	
	@Column(name="DEFAULT_NUMBER")
	private boolean defaultNumber;
	
	@ManyToOne
	@JoinColumn(name="USER_ID")
	private RechargeUser rechargeUser;


	public UserRechargeAccount() {
		super();
	}


	public long getId() {
		return Id;
	}


	public void setId(long id) {
		Id = id;
	}


	public String getTelecomOperatorName() {
		return telecomOperatorName;
	}


	public void setTelecomOperatorName(String telecomOperatorName) {
		this.telecomOperatorName = telecomOperatorName;
	}


	public String getMobileNo() {
		return mobileNo;
	}


	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}


	public String getNickName() {
		return nickName;
	}


	public void setNickName(String nickName) {
		this.nickName = nickName;
	}


	public int getStatus() {
		return status;
	}


	public void setStatus(int status) {
		this.status = status;
	}


	public boolean isFavNumber() {
		return favNumber;
	}


	public void setFavNumber(boolean favNumber) {
		this.favNumber = favNumber;
	}


	public boolean isDefaultNumber() {
		return defaultNumber;
	}


	public void setDefaultNumber(boolean defaultNumber) {
		this.defaultNumber = defaultNumber;
	}


	public RechargeUser getRechargeUser() {
		return rechargeUser;
	}


	public void setRechargeUser(RechargeUser rechargeUser) {
		this.rechargeUser = rechargeUser;
	}
	
	

}

