package com.aruparking.Controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.aruparking.dto.ParkingUserDto;
import com.aruparking.service.ParkingUserService;

public class UserController {
	@Autowired
	ParkingUserService parkingUserService;
	
	@PostMapping
	public Object addUser(@RequestBody ParkingUserDto userDto) {
		return parkingUserService.createParkingUser(userDto);
	}
}
