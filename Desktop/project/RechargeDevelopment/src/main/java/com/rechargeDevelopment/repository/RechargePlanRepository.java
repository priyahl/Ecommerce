package com.rechargeDevelopment.repository;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.rechargeDevelopment.Model.RechargePlan;
import com.rechargeDevelopment.Model.RechargeUser;
import com.rechargeDevelopment.Model.RechargeVendor;

public interface RechargePlanRepository extends JpaRepository<RechargePlan, Long>{
	
	RechargePlan findById(long id);
	RechargePlan findByRechargeVendorVendorIdAndRechargeAmount(long Id,BigDecimal rechargeAmount);

	List<RechargePlan> findByRechargeVendorVendorId(long vendorId);
	List<RechargePlan> findByRechargeVendorVendorIdAndConfigRechargeCategoryCatId(long vendorId,long catId);


}
