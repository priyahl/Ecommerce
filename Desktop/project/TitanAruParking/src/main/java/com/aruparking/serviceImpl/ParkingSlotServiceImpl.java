package com.aruparking.serviceImpl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.aruparking.dto.ParkingSlotDto;
import com.aruparking.model.ParkingSlots;
import com.aruparking.model.ParkingZones;
import com.aruparking.repository.ParkingSlotRepository;
import com.aruparking.repository.ParkingZoneRepository;
import com.aruparking.service.ParkingSlotService;

@Service
public class ParkingSlotServiceImpl implements ParkingSlotService {
	@Autowired
	ParkingSlotRepository parkingSlotRepository;

	@Autowired
	ParkingZoneRepository parkingZoneRepository;
	
	@Override
	public Object addParkingSlots(ParkingSlotDto parkingSlotsDto) {
		ParkingSlots ps = new ParkingSlots();
		ParkingZones parkingZones = parkingZoneRepository.findById(parkingSlotsDto.getZoneId());

	    if (parkingZones != null) {
	        ParkingSlots parkingSlot = parkingSlotRepository.findBySlotNameAndParkingZonesId(parkingSlotsDto.getSlotName(),parkingSlotsDto.getZoneId());
	        if (parkingSlot == null) {
	            ps.setSlotName(parkingSlotsDto.getSlotName());
	            ps.setStatus(1);
	            ps.setParkingZones(parkingZones);
	            ParkingSlots savedSlot = parkingSlotRepository.save(ps);

	            ParkingSlotDto	dto = new ParkingSlotDto();
	            dto.setId(savedSlot.getId());
	            dto.setSlotName(savedSlot.getSlotName());
	            dto.setStatus(savedSlot.getStatus());
	            dto.setCreatedOn(savedSlot.getCreatedOn());
	            dto.setUpdatedOn(savedSlot.getUpdatedOn());
	            dto.setZoneId(savedSlot.getParkingZones().getId());
	            return dto;
	        } else {
	        	//System.out.println("Parking slot with the same name already exists");
	            //throw new RuntimeException("Parking slot with the same name already exists.");
	            Map<String, String> map = new HashMap<String, String>();
	            map.put("ErrorMessage", "Parking slot with the same name already exists.");
	            return map;
	        }
            }else {
            	//throw new RuntimeException("Parking zone is not there.");
            	Map<String, String> map = new HashMap<String, String>();
	            map.put("ErrorMessage", "Parking zone is not there.");
	            return map;
            }
	}

	@Override
	public List<ParkingSlots> getallSlots() {
		return parkingSlotRepository.findAll();
		
//		List<ParkingSlots> parkingSlots = parkingSlotRepository.findAll();
//		List<ParkingSlotDto> dto = new ArrayList();
//		
//		for (ParkingSlots allSlots : parkingSlots) {
//			ParkingSlotDto pdto = new ParkingSlotDto();
//			pdto.setId(allSlots.getId());
//			pdto.setSlotName(allSlots.getSlotName());
//			pdto.setStatus(allSlots.getStatus());
//			pdto.setCreatedOn(allSlots.getCreatedOn());
//			pdto.setUpdatedOn(allSlots.getUpdatedOn());
//			pdto.setZoneId(allSlots.getParkingZones().getId());
//			
//			dto.add(pdto);
//		}
//		return dto;
	}

	@Override
	public ParkingSlotDto fetchbyid(long id) {
		Optional<ParkingSlots> p = parkingSlotRepository.findById(id);
		
		ParkingSlotDto parkingSlotDto = new ParkingSlotDto();
		ParkingSlots parkingSlots= p.get();
		
		parkingSlotDto.setId(parkingSlots.getId());
		parkingSlotDto.setSlotName(parkingSlots.getSlotName());
		parkingSlotDto.setStatus(parkingSlots.getStatus());
		parkingSlotDto.setCreatedOn(parkingSlots.getCreatedOn());
		parkingSlotDto.setUpdatedOn(parkingSlots.getUpdatedOn());
		parkingSlotDto.setZoneId(parkingSlots.getParkingZones().getId());
		return parkingSlotDto;
	}

	@Override
	public ParkingSlotDto updateparking(ParkingSlotDto parkingSlotDto) {
		Optional<ParkingSlots> parkingSlots = parkingSlotRepository.findById(parkingSlotDto.getId());
		ParkingSlots parSlot1 = parkingSlots.get();
		if (parkingSlots != null) {
			parSlot1.setSlotName(parkingSlotDto.getSlotName());
			parSlot1.setStatus(parkingSlotDto.getStatus());
			ParkingSlots parkingSlots1 = parkingSlotRepository.save(parSlot1);
			return getupdate(parkingSlots1);
		} else {
			throw new RuntimeException("it is not present");
		}
	}

	private ParkingSlotDto getupdate(ParkingSlots parkingSlots1) {
		ParkingSlotDto parkingSlotDto = new ParkingSlotDto();
		parkingSlotDto.setId(parkingSlots1.getId());
		parkingSlotDto.setSlotName(parkingSlots1.getSlotName());
		parkingSlotDto.setStatus(parkingSlots1.getStatus());
		parkingSlotDto.setCreatedOn(parkingSlots1.getCreatedOn());
		parkingSlotDto.setUpdatedOn(parkingSlots1.getUpdatedOn());
		parkingSlotDto.setZoneId(parkingSlots1.getParkingZones().getId());
		return parkingSlotDto;
	}

}
