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
import org.springframework.web.bind.annotation.RestController;

import com.aruparking.dto.ParkingSlotDto;
import com.aruparking.dto.ParkingZonesDto;
import com.aruparking.model.ParkingSlots;
import com.aruparking.model.ParkingZones;
import com.aruparking.service.ParkingSlotService;

@RestController
//@RequestMapping("/add1")
public class ParkingSlotController {

	@Autowired
	private ParkingSlotService parkingSlotService;

	@PostMapping("/addslots")
	public Object addParkingSlots(@RequestBody ParkingSlotDto parkingSlotDto) {
		return parkingSlotService.addParkingSlots(parkingSlotDto);
	}

	@GetMapping("/parkingslot")
	public List<ParkingSlots> getallslSlots() {
		return parkingSlotService.getallSlots();
	}

	@GetMapping("/parkingslot/{id}")
	public ParkingSlotDto fetchbyid(@PathVariable long id) {
		return parkingSlotService.fetchbyid(id);
	}

	@PutMapping("/slots")
	public Object updateparking(@RequestBody ParkingSlotDto parkingSlotDto) {
		return parkingSlotService.updateparking(parkingSlotDto);
	}

}
