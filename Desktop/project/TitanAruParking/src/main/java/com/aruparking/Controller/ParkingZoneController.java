package com.aruparking.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.aruparking.dto.ParkingZonesDto;
import com.aruparking.model.ParkingZones;
import com.aruparking.service.ParkingZoneService;

@RestController
//@RequestMapping("/c")

public class ParkingZoneController {
	@Autowired
	private ParkingZoneService parkingZoneService;


	@PostMapping("/addparking")
	public ResponseEntity<ParkingZonesDto> createParkingZones(@RequestBody ParkingZonesDto parkingZonesDto)
	{

		ParkingZonesDto dto=parkingZoneService.createParkingZones(parkingZonesDto);
		return new ResponseEntity<>(dto,HttpStatus.CREATED);

}
	@GetMapping("/parking/{id}")
public ParkingZonesDto fetchbyid(@PathVariable("id")long id)
{
	return parkingZoneService.fetchbyid(id);
}
	
	@GetMapping("/parkingzones")
	public List<ParkingZones> getall()
	{
		return parkingZoneService.getall();
	}
	@PutMapping("/zones")
	public ParkingZonesDto updateparking(@RequestBody ParkingZonesDto parkingZonesDto)
	{
		return parkingZoneService.updateparking(parkingZonesDto);
	}
	
	
}
