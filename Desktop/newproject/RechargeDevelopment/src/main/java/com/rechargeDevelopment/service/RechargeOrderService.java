package com.rechargeDevelopment.service;

import java.util.List;

import com.rechargeDevelopment.Dto.RechargeOrderDto;
import com.rechargeDevelopment.Dto.RechargeOrderHistoryDto;

public interface RechargeOrderService {
	public RechargeOrderDto addorder(RechargeOrderDto rechargeOrderDto);
public List<RechargeOrderHistoryDto> getUserOrderHistoryById( long id);
public List<RechargeOrderHistoryDto> getAllOrdersByVendorId(long id);
public List<RechargeOrderHistoryDto> getOrderHistoryByCatId(long id);
List<RechargeOrderHistoryDto> getOrderHistoryByPlanId(long id);
List<RechargeOrderHistoryDto> getOrderHistoryByOrderId(long id);



}
