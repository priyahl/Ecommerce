package com.rechargeDevelopment.service;

import java.util.List;

import com.rechargeDevelopment.Dto.GetAllCategoryDto;
import com.rechargeDevelopment.Dto.GetRechargePlanDto;
import com.rechargeDevelopment.Dto.GetTelecomOperatorDto;
import com.rechargeDevelopment.Dto.RechargePlanDto;
import com.rechargeDevelopment.Dto.RechargeUserDto;

public interface RechargeUserService {
	public RechargeUserDto adduser(RechargeUserDto rechargeUserDto);
	public RechargeUserDto updateuser(RechargeUserDto rechargeUserDto);
	public RechargeUserDto getUserById(long id);

	public List<GetTelecomOperatorDto> getAllTelecomOperator();
	public List<GetAllCategoryDto>  getAllCategory();
	public GetRechargePlanDto getRechargePlanByPlanId(long id);
	public List<GetRechargePlanDto> getRechargePlanByVendorId(long vendorId);
	public List<GetRechargePlanDto> getRechargePlanByVendorIdCatId(long vendorId,long catId);

}
