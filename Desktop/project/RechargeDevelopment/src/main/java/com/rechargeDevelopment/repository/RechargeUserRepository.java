package com.rechargeDevelopment.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rechargeDevelopment.Model.RechargeUser;

public interface RechargeUserRepository extends JpaRepository<RechargeUser, Long>{
	RechargeUser findById(long id);

	RechargeUser findByEmailId(String emailId);
	RechargeUser findByAdhaarNumber(String adhaarNumber);
}
