package com.aruparking.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.aruparking.dto.ParkingOrderDto;
import com.aruparking.dto.ParkingUserDto;
import com.aruparking.service.ParkingOrderService;
@RestController
public class ParkingOrderController {
	
	@Autowired
private ParkingOrderService parkingOrderService;
	
@PostMapping("/order")
public ParkingOrderDto orderPlacement(@RequestBody ParkingOrderDto parkingOrderDto) {
	return parkingOrderService.orderplace(parkingOrderDto);
}

}
