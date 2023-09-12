package com.rechargeDevelopment.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.rechargeDevelopment.Dto.ConfigRechargeCategoryDto;
import com.rechargeDevelopment.Dto.GetRechargeVendorBalanceDto;
import com.rechargeDevelopment.Dto.RechargeOrderHistoryDto;
import com.rechargeDevelopment.Dto.RechargePlanDto;
import com.rechargeDevelopment.Dto.RechargeVendorDto;
import com.rechargeDevelopment.Dto.UserRechargeAccountDto;
import com.rechargeDevelopment.service.ConfigRechargeCategoryService;
import com.rechargeDevelopment.service.RechargeOrderService;
import com.rechargeDevelopment.service.RechargePlanService;
import com.rechargeDevelopment.service.RechargeVendorService;
import com.rechargeDevelopment.service.UserRechargeAccountService;

@RestController
public class VendorController {
	
	@Autowired
	RechargeVendorService rechargeVendorService;
	
	@Autowired
	ConfigRechargeCategoryService configRechargeCategoryService;
	
	@Autowired
	RechargePlanService rechargePlanService;
	
    @Autowired
    RechargeOrderService rechargeOrderService;
    
    @Autowired
    UserRechargeAccountService  userRechargeAccountService;
	
	@PostMapping("/addvendor")
	public RechargeVendorDto addVendor(@RequestBody RechargeVendorDto rechargeVendorDto) {
		return rechargeVendorService.addVendor(rechargeVendorDto);
	}
	

	@GetMapping("/getvendorid/{id}")
	public RechargeVendorDto getVendorById(@PathVariable long id) {
	    return rechargeVendorService.getVendorById(id);
	}
	
	@PutMapping("/updatevendor")
	public RechargeVendorDto updateVendor(@RequestBody RechargeVendorDto rechargeVendorDto) {
		return rechargeVendorService.updateVendor(rechargeVendorDto);
	}
	
	@PostMapping("/addCategory")
	private ConfigRechargeCategoryDto addConfigCategory(@RequestBody ConfigRechargeCategoryDto configRechargeCategoryDTO) {
		return configRechargeCategoryService.addConfigCategory(configRechargeCategoryDTO);
	}
	
	@GetMapping("/getAllConfig")
	public List<ConfigRechargeCategoryDto> getAllConfig(){
		return configRechargeCategoryService.getAllConfig();
	}
	

	@PostMapping("/addPlan")
	public Object addrecharge(@RequestBody RechargePlanDto rechargePlanDto) {
		return rechargePlanService.addrecharge(rechargePlanDto);
	}
	

	@PutMapping("/updatePlan")
	public RechargePlanDto updatePlan(@RequestBody RechargePlanDto rechargePlanDto) {
		return rechargePlanService.updatePlan(rechargePlanDto);
	}
	
		@GetMapping("/getPlanById/{id}")
		private RechargePlanDto getRplanById(@PathVariable long id) {
			return rechargePlanService.getRechargePlanById(id);
		}
		
		@GetMapping("/getPlanByVid/{id}")
			private List<RechargePlanDto> getPlanByVendorId(@PathVariable long id) {
				return rechargePlanService.getRechargePlanByRechargeVendorId(id);
			}
	

		@GetMapping("/getVendorBalanceById/{id}")
		private GetRechargeVendorBalanceDto getVendorBalanceById(@PathVariable long id) {
			return rechargeVendorService.getVendorBalanceById(id);
		}
	

		@GetMapping("/getAllOrdersByVendorId/{id}")
		public List<RechargeOrderHistoryDto> getAllOrdersByVendorId(@PathVariable long id){
			return rechargeOrderService.getAllOrdersByVendorId(id);
		}
		

		@GetMapping("/getOrderHistoryByCatId/{id}")
		public List<RechargeOrderHistoryDto> getOrderHistoryByCatId(@PathVariable long id){
			return rechargeOrderService.getOrderHistoryByCatId(id);
		}
		

		@GetMapping("/getOrderHistoryByPlanId/{id}")
		public List<RechargeOrderHistoryDto> getOrderHistoryByPlanId(@PathVariable long id){
			return rechargeOrderService.getOrderHistoryByPlanId(id);
		}
		

		@GetMapping("/getOrderHistoryByOrderId/{id}")
		public List<RechargeOrderHistoryDto> getOrderHistoryByOrderId(@PathVariable long id){
			return rechargeOrderService.getOrderHistoryByOrderId(id);
		}
	

		@GetMapping("/getAccountByUserId/{id}")
		public List<UserRechargeAccountDto> getAccountByUserId(@PathVariable long id){
			return userRechargeAccountService.getAccountByUserId(id);
		}
}
