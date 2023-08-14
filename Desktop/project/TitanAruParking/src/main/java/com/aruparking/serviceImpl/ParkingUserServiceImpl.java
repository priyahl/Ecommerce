package com.aruparking.serviceImpl;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.aruparking.dto.ParkingUserDto;
import com.aruparking.model.ParkingUser;
import com.aruparking.repository.ParkingUserRepository;
import com.aruparking.service.ParkingUserService;

@Service
public class ParkingUserServiceImpl implements ParkingUserService {

	@Autowired
	ParkingUserRepository userRepo;

	@Override
	public Object createParkingUser(ParkingUserDto userDto) {
		ParkingUser puser = new ParkingUser();

		puser.setFirstName(userDto.getFirstName());
		puser.setLastName(userDto.getLastName());
		puser.setEmailId(userDto.getEmailId());
		puser.setDob(userDto.getdOB());
		puser.setBalance(new BigDecimal("100.00"));

		ParkingUser addUser = userRepo.save(puser);

		ParkingUserDto udto = new ParkingUserDto();
		udto.setId(addUser.getId());
		udto.setFirstName(addUser.getFirstName());
		udto.setLastName(addUser.getLastName());
		udto.setEmailId(addUser.getEmailId());
		udto.setdOB(addUser.getDob());
		udto.setBalance(addUser.getBalance());
		udto.setCreatedOn(addUser.getCreationOn());
		udto.setLastUpdatedOn(addUser.getLastUpdatedOn());
		
		
	

		return udto;
	}

}
