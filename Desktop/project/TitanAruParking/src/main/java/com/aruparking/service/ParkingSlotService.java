package com.aruparking.service;

import java.util.List;

import com.aruparking.dto.ParkingSlotDto;
import com.aruparking.model.ParkingSlots;

public interface ParkingSlotService {
	
	public Object addParkingSlots(ParkingSlotDto parkingSlotDto);

	public List<ParkingSlots> getallSlots();

	public ParkingSlotDto fetchbyid(long id);

	public ParkingSlotDto updateparking(ParkingSlotDto parkingSlotDto);

}
