package com.rechargeDevelopment.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rechargeDevelopment.Model.RechargeOrder;
import com.rechargeDevelopment.Model.RechargePlan;

public interface RechargeOrderRepository extends JpaRepository<RechargeOrder, Long>{
	
	RechargeOrder findById(long id);

List<RechargeOrder> findByRechargeUserUserId(long userId);

List<RechargeOrder> findByRechargePlanRechargeVendorVendorId(long id);


List<RechargeOrder> findByRechargePlanConfigRechargeCategoryCatId(long id);

List<RechargeOrder> findByRechargePlanId(long id);

List<RechargeOrder> findByOrderId(long id);

}
