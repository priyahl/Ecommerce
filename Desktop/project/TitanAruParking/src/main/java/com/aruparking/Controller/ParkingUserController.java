package com.aruparking.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.aruparking.dto.ParkingSlotDto;
import com.aruparking.dto.ParkingUserDto;
import com.aruparking.service.ParkingUserService;

@RestController
public class ParkingUserController {

	@Autowired
	private ParkingUserService parkingUserService;

@PostMapping("/addUser")
public Object addParkingUser(@RequestBody ParkingUserDto parkingUserDto) {
	return parkingUserService.createParkingUser(parkingUserDto);
}

}
