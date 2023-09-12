package com.rechargeDevelopment.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rechargeDevelopment.Model.RechargeVendor;

public interface RechargeVendorRepository extends JpaRepository<RechargeVendor, Long>{
	RechargeVendor findById(long id);

	RechargeVendor findByVendorId(long vendorId);
	RechargeVendor findByEmailId(String emailId);

	RechargeVendor findBytelecomOperatorName(String telecomOperatorName);
}
