package com.aruparking.serviceImpl;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aruparking.dto.ParkingFeeDTO;
import com.aruparking.model.ParkingFee;
import com.aruparking.repository.ParkingFeeRepository;
import com.aruparking.service.ParkingFeeService;

@Service
public class ParkingFeeServiceImpl implements ParkingFeeService{

	@Autowired
	ParkingFeeRepository feeRepo;
	
	@Override
	public Object addParkingFee(ParkingFeeDTO parkingFeeDTO) {
		ParkingFee pf1 = new ParkingFee();
		BigDecimal bg=new BigDecimal(parkingFeeDTO.getTiming());
	//	System.out.println(parkingFeeDTO.getTiming());
		BigDecimal bigDecimal=new BigDecimal("15.00");
		BigDecimal totalFee=bg.multiply(bigDecimal);
		pf1.setAmmount(totalFee);
		pf1.setTiming(parkingFeeDTO.getTiming());
		
		ParkingFee addFeeDetail = feeRepo.save(pf1);
		
		ParkingFeeDTO pf1dto = new ParkingFeeDTO();
		
		pf1dto.setId(addFeeDetail.getId());
		pf1dto.setAmmount(addFeeDetail.getAmmount());
		pf1dto.setTiming(addFeeDetail.getTiming());
		pf1dto.setCreatedOn(addFeeDetail.getCreatedOn());
		pf1dto.setLastUpdatedOn(addFeeDetail.getLastUpdatedOn());
		return pf1dto;
	}

}
