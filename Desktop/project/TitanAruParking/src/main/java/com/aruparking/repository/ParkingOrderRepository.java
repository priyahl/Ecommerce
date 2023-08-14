package com.aruparking.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aruparking.model.ParkingOrder;

public interface ParkingOrderRepository extends JpaRepository<ParkingOrder, Long>{
	//public ParkingOrder findById(long id);
}
