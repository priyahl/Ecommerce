package com.rechargeDevelopment.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rechargeDevelopment.Model.ConfigRechargeCategory;
import com.rechargeDevelopment.Model.RechargeVendor;

public interface ConfigRechargeCategoryRepository extends JpaRepository<ConfigRechargeCategory, Long>{
	ConfigRechargeCategory findById(long id);

	ConfigRechargeCategory findByCatId(long catId);

}
