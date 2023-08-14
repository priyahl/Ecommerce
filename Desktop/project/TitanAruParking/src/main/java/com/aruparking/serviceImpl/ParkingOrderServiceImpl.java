package com.aruparking.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aruparking.dto.ParkingOrderDto;
import com.aruparking.model.ParkingFee;
import com.aruparking.model.ParkingOrder;
import com.aruparking.model.ParkingSlots;
import com.aruparking.model.ParkingUser;
import com.aruparking.repository.ParkingFeeRepository;
import com.aruparking.repository.ParkingOrderRepository;
import com.aruparking.repository.ParkingSlotRepository;
import com.aruparking.repository.ParkingUserRepository;
import com.aruparking.service.ParkingOrderService;

@Service
public class ParkingOrderServiceImpl implements ParkingOrderService {
	@Autowired
	private ParkingOrderRepository parkingOrderRepository;

	@Autowired
	private ParkingUserRepository parkingUserRepository;

	@Autowired
	private ParkingSlotRepository parkingSlotRepository;

	@Autowired
	private ParkingFeeRepository parkingFeeRepository;

	@Override
	public ParkingOrderDto orderplace(ParkingOrderDto parkingOrderDto) {
		// ParkingOrder parkingOrder=new ParkingOrder();
		ParkingUser user = parkingUserRepository.findById(parkingOrderDto.getUserid());
		if (user != null) {
			ParkingSlots parkingSlots = parkingSlotRepository.findById(parkingOrderDto.getId());
			if (parkingSlots != null) {
				ParkingFee parkingFee = parkingFeeRepository.findById(parkingOrderDto.getFeeid());

				ParkingOrder parkingOrder = new ParkingOrder();
				parkingOrder.setParkingUser(user);
				parkingOrder.setParkingSlots(parkingSlots);
				parkingOrder.setParkingFee(parkingFee);
				parkingOrder.setVehicleNo(parkingOrder.getVehicleNo());
				parkingOrder.setContactNo(parkingOrder.getContactNo());

				ParkingOrder neworder = parkingOrderRepository.save(parkingOrder);

				ParkingOrderDto dto = new ParkingOrderDto();
				dto.setDescription("payment successfull");
				dto.setAmount(neworder.getAmount());
				dto.setId(neworder.getId());
				dto.setTransactionId(neworder.getTransactionId());

				return dto;
			} else {
				throw new RuntimeException("fee id is not present");
			}
		}
		return parkingOrderDto;

	}
}
