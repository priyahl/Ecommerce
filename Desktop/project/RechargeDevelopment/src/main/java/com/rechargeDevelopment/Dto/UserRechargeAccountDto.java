package com.rechargeDevelopment.Dto;


public class UserRechargeAccountDto {
	private long Id;
	private String telecomOperatorName;
	private String mobileNo;
	private String nickName;
	private int status;
	private boolean favNumber;
	private boolean defaultNumber;
	private long userId;
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
	public long getUserId() {
		return userId;
	}
	public void setUserId(long userId) {
		this.userId = userId;
	}
	
}
