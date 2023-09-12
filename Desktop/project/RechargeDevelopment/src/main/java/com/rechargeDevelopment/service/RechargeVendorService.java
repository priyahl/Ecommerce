package com.rechargeDevelopment.service;

import com.rechargeDevelopment.Dto.GetRechargeVendorBalanceDto;
import com.rechargeDevelopment.Dto.RechargeVendorDto;

public interface RechargeVendorService {
	
public RechargeVendorDto addVendor(RechargeVendorDto rechargeVendorDto);
public RechargeVendorDto getVendorById(long id);
public RechargeVendorDto updateVendor(RechargeVendorDto rechargeVendorDto);
public GetRechargeVendorBalanceDto getVendorBalanceById(long id);
}
