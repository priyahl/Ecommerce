package com.aruparking.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import com.aruparking.model.ParkingSlots;
import com.aruparking.model.ParkingUser;

@Repository
public interface ParkingSlotRepository extends JpaRepository<ParkingSlots, Long> {

	ParkingSlots findBySlotNameAndParkingZonesId(String slotName, long zoneId);

//	Optional<ParkingSlots> findById(long id);
	
	public ParkingSlots findById(long id);
	
	
}
