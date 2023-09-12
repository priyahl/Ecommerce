package com.rechargeDevelopment.serviceImpl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rechargeDevelopment.Dto.RechargeOrderDto;
import com.rechargeDevelopment.Dto.RechargeOrderHistoryDto;
import com.rechargeDevelopment.Model.ConfigRechargeCategory;
import com.rechargeDevelopment.Model.RechargeOrder;
import com.rechargeDevelopment.Model.RechargePlan;
import com.rechargeDevelopment.Model.RechargeUser;
import com.rechargeDevelopment.Model.RechargeVendor;
import com.rechargeDevelopment.repository.ConfigRechargeCategoryRepository;
import com.rechargeDevelopment.repository.RechargeOrderRepository;
import com.rechargeDevelopment.repository.RechargePlanRepository;
import com.rechargeDevelopment.repository.RechargeUserRepository;
import com.rechargeDevelopment.repository.RechargeVendorRepository;
import com.rechargeDevelopment.service.RechargeOrderService;
@Service
public class RechargeOrderServiceImpl implements RechargeOrderService{
   
	@Autowired
	RechargeUserRepository rechargeUserRepository;
	
	@Autowired
	RechargePlanRepository rechargePlanRepository;
  
	@Autowired
	RechargeOrderRepository rechargeOrderRepository;
    
	@Autowired	
    RechargeVendorRepository rechargeVendorRepository;
    
	@Autowired
    ConfigRechargeCategoryRepository configRechargeCategoryRepository;
	
	@Override
	public RechargeOrderDto addorder(RechargeOrderDto rechargeOrderDto) {
		RechargeUser userid=rechargeUserRepository.findById(rechargeOrderDto.getUserId());
		if(userid!=null) {
			//System.out.println("print");
			
			RechargePlan planid=rechargePlanRepository.findById(rechargeOrderDto.getId());
			if(planid!=null) {
				RechargeOrder order=new RechargeOrder();
		
				BigDecimal amt=planid.getRechargeAmount();
				BigDecimal balance=userid.getBalance();
				
				int deduction=balance.compareTo(amt);
				if(deduction>=0) {
					
					BigDecimal curentbalance=balance.subtract(amt);
					userid.setBalance(curentbalance);
					
					rechargeUserRepository.save(userid);
				
					BigDecimal add=planid.getRechargeVendor().getBalance().add(amt);
					planid.getRechargeVendor().setBalance(add);
					
						order.setDescription("payment successfull");
						order.setAmount(amt);
						order.setContactNo(rechargeOrderDto.getContactNo());
						order.setTrasactionId(UUID.randomUUID().toString());
						order.setRechargeUser(userid);
						order.setRechargePlan(planid);
							
					RechargeOrder order1=rechargeOrderRepository.save(order);
					
					rechargeOrderDto.setOrderId(order1.getOrderId());	
					rechargeOrderDto.setDescription(order1.getDescription());
					rechargeOrderDto.setAmount(order1.getAmount());
					rechargeOrderDto.setContactNo(order1.getContactNo());
					rechargeOrderDto.setTrasactionId(order1.getTrasactionId());
					rechargeOrderDto.setUserId(order1.getRechargeUser().getUserId());
					rechargeOrderDto.setId(order1.getRechargePlan().getId());
					rechargeOrderDto.setCreatedOn(order1.getCreatedOn());
					rechargeOrderDto.setLastUpdatedOn(order1.getLastUpdatedOn());
					
					return rechargeOrderDto;
			    }
				else throw new RuntimeException("balance is low");
				
			}else throw new RuntimeException("plan id is not present");
	
		}
		else throw new RuntimeException("user id is not present");
		
		
	
	}



	@Override
	public List<RechargeOrderHistoryDto> getUserOrderHistoryById(long id) {
RechargeUser user=rechargeUserRepository.findById(id);
if(user!=null) {
	List<RechargeOrder> order1=rechargeOrderRepository.findByRechargeUserUserId(id);
List<RechargeOrderHistoryDto> hdto=new ArrayList();
for(RechargeOrder order:order1) {
	RechargeOrderHistoryDto rdto=new RechargeOrderHistoryDto();
	rdto.setOrderId(order.getOrderId());
	rdto.setAmount(order.getAmount());
	rdto.setContactNo(order.getContactNo());
	rdto.setTrasactionId(order.getTrasactionId());
	rdto.setUserId(order.getRechargeUser().getUserId());
	rdto.setId(order.getRechargePlan().getId());
	hdto.add(rdto);

}
		return hdto;
	}else {
		throw new RuntimeException("user id is not present");
	}
	}



	@Override
	public List<RechargeOrderHistoryDto> getAllOrdersByVendorId(long id) {
		RechargeVendor vendor=rechargeVendorRepository.findById(id);
		if(vendor!=null) {
List<RechargeOrder> rorder=rechargeOrderRepository.findByRechargePlanRechargeVendorVendorId(id);
List<RechargeOrderHistoryDto> dto=new ArrayList();

for(RechargeOrder order:rorder)
{
	RechargeOrderHistoryDto odto=new RechargeOrderHistoryDto();
	odto.setOrderId(order.getOrderId());
	odto.setAmount(order.getAmount());
	odto.setContactNo(order.getContactNo());
	odto.setTrasactionId(order.getTrasactionId());
	odto.setUserId(order.getRechargeUser().getUserId());
	odto.setId(order.getRechargePlan().getId());
	dto.add(odto);
	}
		return dto;
	}
	else {
		throw new RuntimeException("vendor id is not present");
	}
}



	@Override
	public List<RechargeOrderHistoryDto> getOrderHistoryByCatId(long id) {
ConfigRechargeCategory config=configRechargeCategoryRepository.findById(id);
if(config!=null) {
	List<RechargeOrder> rorder=rechargeOrderRepository.findByRechargePlanConfigRechargeCategoryCatId(id);
	List<RechargeOrderHistoryDto> dto=new ArrayList();
	for(RechargeOrder order:rorder) {
		RechargeOrderHistoryDto hdto=new RechargeOrderHistoryDto();
		hdto.setOrderId(order.getOrderId());
		hdto.setAmount(order.getAmount());
		hdto.setContactNo(order.getContactNo());
		hdto.setTrasactionId(order.getTrasactionId());
		hdto.setUserId(order.getRechargeUser().getUserId());
		hdto.setId(order.getRechargePlan().getId());
		dto.add(hdto);
	}
	return dto;
}
else {
	throw new RuntimeException("cat id is not presenty");
}
	}



	@Override
	public List<RechargeOrderHistoryDto> getOrderHistoryByPlanId(long id) {

		RechargePlan plan=rechargePlanRepository.findById(id);
		if(plan!=null) {
			List<RechargeOrder> rorder=rechargeOrderRepository.findByRechargePlanId(id);
			List<RechargeOrderHistoryDto> dto=new ArrayList();
			for(RechargeOrder order:rorder) {
				RechargeOrderHistoryDto hdto=new RechargeOrderHistoryDto();
				hdto.setOrderId(order.getOrderId());
				hdto.setAmount(order.getAmount());
				hdto.setContactNo(order.getContactNo());
				hdto.setTrasactionId(order.getTrasactionId());
				hdto.setUserId(order.getRechargeUser().getUserId());
				hdto.setId(order.getRechargePlan().getId());
				dto.add(hdto);
			}
			return dto;
		}
		else {
			throw new RuntimeException("plan  id is not presenty");
		}
		
		
	}



	@Override
	public List<RechargeOrderHistoryDto> getOrderHistoryByOrderId(long id) {

		RechargeOrder horder=rechargeOrderRepository.findById(id);
		if(horder!=null) {
			List<RechargeOrder> rorder=rechargeOrderRepository.findByOrderId(id);
			List<RechargeOrderHistoryDto> dto=new ArrayList();
			for(RechargeOrder order:rorder) {
				RechargeOrderHistoryDto hdto=new RechargeOrderHistoryDto();
				hdto.setOrderId(order.getOrderId());
				hdto.setAmount(order.getAmount());
				hdto.setContactNo(order.getContactNo());
				hdto.setTrasactionId(order.getTrasactionId());
				hdto.setUserId(order.getRechargeUser().getUserId());
				hdto.setId(order.getRechargePlan().getId());
				dto.add(hdto);
			}
			return dto;
		}
		else {
			throw new RuntimeException("order id is not presenty");
		}
		
		
	}
	

}
