package com.rechargeDevelopment.service;

import java.util.List;

import com.rechargeDevelopment.Dto.ConfigRechargeCategoryDto;
import com.rechargeDevelopment.Dto.RechargeOrderHistoryDto;


public interface ConfigRechargeCategoryService {
	public ConfigRechargeCategoryDto addConfigCategory(ConfigRechargeCategoryDto configRechargeCategoryDTO);

	public List<ConfigRechargeCategoryDto> getAllConfig();
   

}
