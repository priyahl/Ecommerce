package com.rechargeDevelopment.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.rechargeDevelopment.Dto.ConfigRechargeCategoryDto;
import com.rechargeDevelopment.Dto.GetAllCategoryDto;
import com.rechargeDevelopment.Dto.GetRechargePlanDto;
import com.rechargeDevelopment.Dto.GetTelecomOperatorDto;
import com.rechargeDevelopment.Dto.RechargeOrderDto;
import com.rechargeDevelopment.Dto.RechargeOrderHistoryDto;
import com.rechargeDevelopment.Dto.RechargePlanDto;
import com.rechargeDevelopment.Dto.RechargeUserDto;
import com.rechargeDevelopment.Dto.UserRechargeAccountDto;
import com.rechargeDevelopment.service.ConfigRechargeCategoryService;
import com.rechargeDevelopment.service.RechargeOrderService;
import com.rechargeDevelopment.service.RechargeUserService;
import com.rechargeDevelopment.service.UserRechargeAccountService;


@RestController
public class UserController {
	
    @Autowired
	RechargeUserService rechargeUserService;
    
    @Autowired
    RechargeOrderService rechargeOrderService;
	
    @Autowired
    UserRechargeAccountService UserRechargeAccountService;
  
    @PostMapping("/adduser")
	public RechargeUserDto adduser(@RequestBody RechargeUserDto rechargeUserDto) {
		return rechargeUserService.adduser(rechargeUserDto);
	}
	

	@PutMapping("/updateuser")
	public RechargeUserDto updateuser(@RequestBody RechargeUserDto rechargeUserDto) {
		return rechargeUserService.updateuser(rechargeUserDto);
	}
	

	@GetMapping("/getuserid/{id}")
	public RechargeUserDto getUserById(@PathVariable long id) {
	    return rechargeUserService.getUserById(id);
	}
	

	@GetMapping("/getAllOperator")
	public List<GetTelecomOperatorDto> getAllTelecomOperator() {
		return rechargeUserService.getAllTelecomOperator();
	}
	

	@GetMapping("/getAllCategories")
	public List<GetAllCategoryDto> getAllCategory(){
		return rechargeUserService.getAllCategory();
	}
	

	@GetMapping("/getPlanByPlanId/{id}")
	private GetRechargePlanDto getRechargePlanByPlanId(@PathVariable long id) {
		return rechargeUserService.getRechargePlanByPlanId(id);
	}
	

	@GetMapping("/getPlanByvendorId/{id}")
	private List<GetRechargePlanDto> getRechargePlanByVendorId(@PathVariable long id) {
		return rechargeUserService.getRechargePlanByVendorId(id);
	}
	
	@GetMapping("/getPlanByvendorIdAndCatId/{vendorId}/{catId}")
	private List<GetRechargePlanDto> getRechargePlanByVendorIdCatId(@PathVariable long vendorId,@PathVariable long catId) {
		return rechargeUserService.getRechargePlanByVendorIdCatId( vendorId, catId);
	}
	
		@PostMapping("/addorder")
		public RechargeOrderDto addorder(@RequestBody RechargeOrderDto rechargeOrderDto) {
			return rechargeOrderService.addorder(rechargeOrderDto);
		}
	

		@GetMapping("/getuserhistorybyid/{id}")
		public List<RechargeOrderHistoryDto> getUserOrderHistoryById(@PathVariable long id) {
		    return rechargeOrderService.getUserOrderHistoryById(id);
		}
		

		@GetMapping("/getOrderHistoryByOrder1Id/{id}")
		public List<RechargeOrderHistoryDto> getOrderHistoryByOrderId(@PathVariable long id){
			return rechargeOrderService.getOrderHistoryByOrderId(id);
		}
	

	    @PostMapping("/addaccount")
		public UserRechargeAccountDto addaccount(@RequestBody UserRechargeAccountDto userRechargeAccountDto) {
			return UserRechargeAccountService.addaccount(userRechargeAccountDto);
		}
	    
	    @PutMapping("/updateacc")
		public UserRechargeAccountDto updateacc(@RequestBody UserRechargeAccountDto userRechargeAccountDto) {
			return UserRechargeAccountService.updateacc(userRechargeAccountDto);
		}
	    

		@DeleteMapping("/delete/{id}")
		public Object removeAcc(@PathVariable long id) {
			return UserRechargeAccountService.removeAcc(id);
		}
		
		@GetMapping("/getFavNumberByUserId/{id}")
		public List<UserRechargeAccountDto> getFavNumberByUserId(@PathVariable long id){
			return UserRechargeAccountService.getFavNumberByUserId(id);
		}
		

		@GetMapping("/getdefaultNumberByUserId/{id}")
		public UserRechargeAccountDto getdefaultNumberByUserId(@PathVariable long id){
			return UserRechargeAccountService.getdefaultNumberByUserId(id);
		}
}
