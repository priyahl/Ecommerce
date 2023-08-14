package com.aruparking.service;

import java.util.List;

import com.aruparking.dto.ParkingZonesDto;
import com.aruparking.model.ParkingZones;

public interface ParkingZoneService {
public ParkingZonesDto createParkingZones(ParkingZonesDto parkingZonesDto);

public ParkingZonesDto fetchbyid(long id);

public List<ParkingZones> getall();

public ParkingZonesDto updateparking(ParkingZonesDto parkingZonesDto);
}
