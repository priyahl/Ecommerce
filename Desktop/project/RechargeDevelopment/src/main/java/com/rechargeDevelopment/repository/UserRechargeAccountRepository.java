package com.rechargeDevelopment.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rechargeDevelopment.Model.RechargeVendor;
import com.rechargeDevelopment.Model.UserRechargeAccount;

public interface UserRechargeAccountRepository extends JpaRepository<UserRechargeAccount, Long>{

	//UserRechargeAccount findByRechargeUserUserIdAndMobileNumber(long userId, String mobileNo);

	UserRechargeAccount findById(long id);

	UserRechargeAccount findByRechargeUserUserIdAndDefaultNumber(long userId, boolean defaultNumber);

	UserRechargeAccount findByRechargeUserUserIdAndMobileNo(long userId, String mobileNo);

	List<UserRechargeAccount> findByRechargeUserUserId(long id);

	List<UserRechargeAccount> findByRechargeUserUserIdAndFavNumber(long id, boolean b);

}
