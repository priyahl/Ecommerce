package com.rechargeDevelopment.service;

import java.util.List;

import com.rechargeDevelopment.Dto.RechargePlanDto;

public interface RechargePlanService {
	public Object addrecharge(RechargePlanDto rechargePlanDto);
	public RechargePlanDto updatePlan(RechargePlanDto rechargePlanDto);
	public RechargePlanDto getRechargePlanById(long id);

	public List<RechargePlanDto> getRechargePlanByRechargeVendorId(long vendorId);
	
}
