package com.aruparking.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aruparking.dto.ParkingFeeDTO;
import com.aruparking.service.ParkingFeeService;

@RestController
//@RequestMapping("/fee")
	//fee controller
public class ParkingFeeController {

	@Autowired
	ParkingFeeService parkingFeeService;
	
	@PostMapping("/fees")
	public Object addFee(@RequestBody ParkingFeeDTO parkingFee) {
		return parkingFeeService.addParkingFee(parkingFee);
	}
	
}
