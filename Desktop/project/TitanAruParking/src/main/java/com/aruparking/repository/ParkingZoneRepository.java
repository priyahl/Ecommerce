package com.aruparking.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aruparking.model.ParkingSlots;
import com.aruparking.model.ParkingZones;

public interface ParkingZoneRepository extends JpaRepository<ParkingZones, Long> {

	public ParkingZones findById(long id);

//	public ParkingSlots findBySlotNameAndParkingZonesId(String slotName, long zoneId);
//
//	public ParkingSlots save(ParkingSlots ps);

}
