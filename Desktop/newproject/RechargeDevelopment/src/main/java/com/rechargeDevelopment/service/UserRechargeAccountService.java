package com.rechargeDevelopment.service;

import java.util.List;

import com.rechargeDevelopment.Dto.UserRechargeAccountDto;

public interface UserRechargeAccountService {
	public UserRechargeAccountDto addaccount(UserRechargeAccountDto userRechargeAccountDto);
	public UserRechargeAccountDto updateacc(UserRechargeAccountDto userRechargeAccountDto);
	public List<UserRechargeAccountDto> getAccountByUserId(long id);
	public Object removeAcc(long id);
	public List<UserRechargeAccountDto> getFavNumberByUserId(long id);
	public UserRechargeAccountDto getdefaultNumberByUserId(long id);


}
