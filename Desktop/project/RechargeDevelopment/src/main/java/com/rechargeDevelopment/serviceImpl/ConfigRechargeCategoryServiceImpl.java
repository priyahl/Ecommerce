package com.rechargeDevelopment.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rechargeDevelopment.Dto.ConfigRechargeCategoryDto;
import com.rechargeDevelopment.Dto.RechargeOrderHistoryDto;
import com.rechargeDevelopment.Model.ConfigRechargeCategory;
import com.rechargeDevelopment.repository.ConfigRechargeCategoryRepository;
import com.rechargeDevelopment.service.ConfigRechargeCategoryService;
@Service
public class ConfigRechargeCategoryServiceImpl implements ConfigRechargeCategoryService{
	@Autowired
	ConfigRechargeCategoryRepository conrepo;
	
	@Override
	public List<ConfigRechargeCategoryDto> getAllConfig() {
		List<ConfigRechargeCategory> con=conrepo.findAll();
	   List<ConfigRechargeCategoryDto> dto=new ArrayList<>();
		
	   for(ConfigRechargeCategory config:con) {
			ConfigRechargeCategoryDto cat=new ConfigRechargeCategoryDto();
			cat.setCatId(config.getCatId());
			cat.setCategoryName(config.getCategoryName());
			cat.setCreatedOn(config.getCreatedOn());
			cat.setLastUpdatedOn(config.getLastUpdatedOn());
		
			dto.add(cat);
	   }
		return dto;
	}

	@Override
	public ConfigRechargeCategoryDto addConfigCategory(ConfigRechargeCategoryDto configRechargeCategoryDTO) {

		ConfigRechargeCategory configCat = new ConfigRechargeCategory();

		configCat.setCategoryName(configRechargeCategoryDTO.getCategoryName());

		ConfigRechargeCategory addCategory = conrepo.save(configCat);

//		ConfigRechargeCategoryDTO cdto = new ConfigRechargeCategoryDTO();

		configRechargeCategoryDTO.setCatId(addCategory.getCatId());
		configRechargeCategoryDTO.setCategoryName(addCategory.getCategoryName());
		configRechargeCategoryDTO.setCreatedOn(addCategory.getCreatedOn());
		configRechargeCategoryDTO.setLastUpdatedOn(addCategory.getLastUpdatedOn());

		return configRechargeCategoryDTO;
		
	}


}
