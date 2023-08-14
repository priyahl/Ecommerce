package com.aruparking.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.aruparking.model.ParkingFee;
import com.aruparking.model.ParkingUser;

public interface ParkingUserRepository extends JpaRepository<ParkingUser, Long> {
	public ParkingUser findById(long id);
}
