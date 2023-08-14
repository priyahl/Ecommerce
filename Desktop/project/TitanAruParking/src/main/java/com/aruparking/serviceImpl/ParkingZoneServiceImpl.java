package com.aruparking.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aruparking.dto.ParkingZonesDto;
import com.aruparking.model.ParkingZones;
import com.aruparking.repository.ParkingZoneRepository;
import com.aruparking.service.ParkingZoneService;
@Service
public class ParkingZoneServiceImpl implements ParkingZoneService{
	@Autowired
private ParkingZoneRepository parkingZoneRepository;
	
	@Override
	public ParkingZonesDto createParkingZones(ParkingZonesDto parkingZonesDto) {
		ParkingZones p=new ParkingZones();
	//	p.setId(parkingZonesDto.getId());
		p.setZoneName(parkingZonesDto.getZoneName());
		p.setStatus(parkingZonesDto.getStatus());
		p.setCreatedOn(parkingZonesDto.getCreatedOn());
		p.setUpdatedOn(parkingZonesDto.getUpdatedOn());
		
		ParkingZones newzones=parkingZoneRepository.save(p);
		
		
		ParkingZonesDto dto=new ParkingZonesDto();
		dto.setId(newzones.getId());
		dto.setZoneName(newzones.getZoneName());
		dto.setStatus(newzones.getStatus());
		dto.setCreatedOn(newzones.getCreatedOn());
		dto.setUpdatedOn(newzones.getUpdatedOn());
		
				return dto;
	}

	@Override
	public ParkingZonesDto fetchbyid(long id) {
	ParkingZones parkingZones=parkingZoneRepository.findById(id);
//	ParkingZones p=parkingZones.get();
	ParkingZonesDto parkingZonesDto=new ParkingZonesDto();
	parkingZonesDto.setId(parkingZones.getId());
	parkingZonesDto.setZoneName(parkingZones.getZoneName());
	parkingZonesDto.setStatus(parkingZones.getStatus());
	parkingZonesDto.setCreatedOn(parkingZones.getCreatedOn());
	parkingZonesDto.setUpdatedOn(parkingZones.getUpdatedOn());
	
		return parkingZonesDto;
	}

	@Override
	public List<ParkingZones> getall() {
		
		return parkingZoneRepository.findAll();
	}

	@Override
	public ParkingZonesDto updateparking(ParkingZonesDto parkingZonesDto) {
		ParkingZones parkingZones=parkingZoneRepository.findById(parkingZonesDto.getId());
//		ParkingZones parZones1=parkingZones.get();
		if(parkingZones!=null) {
			parkingZones.setZoneName(parkingZonesDto.getZoneName());
			parkingZones.setStatus(parkingZonesDto.getStatus());
			ParkingZones parkingZones2=parkingZoneRepository.save(parkingZones);
			return getupdate(parkingZones2);
		}
		else
		{
			throw new RuntimeException("it is not present");
		}
	}
		
		
	

	private ParkingZonesDto getupdate(ParkingZones parkingZones2) {
		ParkingZonesDto parkingZonesDto=new ParkingZonesDto();
		parkingZonesDto.setId(parkingZones2.getId());
		parkingZonesDto.setZoneName(parkingZones2.getZoneName());
		parkingZonesDto.setStatus(parkingZones2.getStatus());
		parkingZonesDto.setCreatedOn(parkingZones2.getCreatedOn());
		parkingZonesDto.setUpdatedOn(parkingZones2.getUpdatedOn());
		return parkingZonesDto;
	}

	
	

}
