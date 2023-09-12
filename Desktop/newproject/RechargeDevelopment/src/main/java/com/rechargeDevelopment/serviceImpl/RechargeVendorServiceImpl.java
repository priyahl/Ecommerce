package com.rechargeDevelopment.serviceImpl;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rechargeDevelopment.Dto.GetRechargeVendorBalanceDto;
import com.rechargeDevelopment.Dto.RechargeVendorDto;
import com.rechargeDevelopment.Model.RechargeVendor;
import com.rechargeDevelopment.repository.RechargeVendorRepository;
import com.rechargeDevelopment.service.RechargeVendorService;
@Service
public class RechargeVendorServiceImpl implements RechargeVendorService{
	@Autowired
RechargeVendorRepository vrepo;
	
	@Override
	public RechargeVendorDto addVendor(RechargeVendorDto rechargeVendorDto) {
		RechargeVendor vendor=new RechargeVendor();
		vendor.setFirstName(rechargeVendorDto.getFirstName());
		vendor.setLastName(rechargeVendorDto.getLastName());
		vendor.setGender(rechargeVendorDto.getGender());
		vendor.setAddressLine1(rechargeVendorDto.getAddressLine1());
		vendor.setAddressLine2(rechargeVendorDto.getAddressLine2());
		vendor.setDob(rechargeVendorDto.getDob());
		vendor.setTelecomOperatorName(rechargeVendorDto.getTelecomOperatorName());
		vendor.setEmailId(rechargeVendorDto.getEmailId());
		vendor.setBalance(new BigDecimal(0.0));
		
		RechargeVendor vemailId=vrepo.findByEmailId(rechargeVendorDto.getEmailId());
if(vemailId==null) {
	
	RechargeVendor operName=vrepo.findBytelecomOperatorName(rechargeVendorDto.getTelecomOperatorName());
if(operName==null) {
	

		RechargeVendor addV=vrepo.save(vendor);
		
		rechargeVendorDto.setVendorId(addV.getVendorId());
		rechargeVendorDto.setFirstName(addV.getFirstName());
		rechargeVendorDto.setLastName(addV.getLastName());
		rechargeVendorDto.setGender(addV.getGender());
		rechargeVendorDto.setAddressLine1(addV.getAddressLine1());
		rechargeVendorDto.setAddressLine2(addV.getAddressLine2());
		rechargeVendorDto.setDob(addV.getDob());
		rechargeVendorDto.setTelecomOperatorName(addV.getTelecomOperatorName());
		rechargeVendorDto.setEmailId(addV.getEmailId());
		rechargeVendorDto.setBalance(addV.getBalance());
		rechargeVendorDto.setCreatedOn(addV.getCreatedOn());
		rechargeVendorDto.setLastUpdatedOn(addV.getLastUpdatedOn());
}
else {
	throw new RuntimeException("Telecom operator name already present present");

  }
}

else {
	throw new RuntimeException("vendor with same emailId is present");
}
		return rechargeVendorDto;
	}

	@Override
	public RechargeVendorDto getVendorById(long id) {
		RechargeVendor ven=vrepo.findById(id);
		if(ven!=null) {
		RechargeVendorDto ddto=new RechargeVendorDto();
		ddto.setVendorId(ven.getVendorId());
		ddto.setFirstName(ven.getFirstName());
		ddto.setLastName(ven.getLastName());
		ddto.setGender(ven.getGender());
		ddto.setAddressLine1(ven.getAddressLine1());
		ddto.setAddressLine2(ven.getAddressLine2());
		ddto.setDob(ven.getDob());
		ddto.setTelecomOperatorName(ven.getTelecomOperatorName());
		ddto.setEmailId(ven.getEmailId());
		ddto.setBalance(ven.getBalance());
		ddto.setCreatedOn(ven.getCreatedOn());
		ddto.setLastUpdatedOn(ven.getLastUpdatedOn());
		return ddto;
		}
		else {
			throw new RuntimeException("vendor id is not present");
		}
	}

	@Override
	public RechargeVendorDto updateVendor(RechargeVendorDto rechargeVendorDto) {
		RechargeVendor r1=vrepo.findById(rechargeVendorDto.getVendorId());
		if(r1!=null) {
			r1.setFirstName(rechargeVendorDto.getFirstName());
			r1.setLastName(rechargeVendorDto.getLastName());
			r1.setGender(rechargeVendorDto.getGender());
			r1.setAddressLine1(rechargeVendorDto.getAddressLine1());
			r1.setAddressLine2(rechargeVendorDto.getAddressLine2());
			r1.setDob(rechargeVendorDto.getDob());
			r1.setTelecomOperatorName(rechargeVendorDto.getTelecomOperatorName());
			r1.setEmailId(rechargeVendorDto.getEmailId());
			
			RechargeVendor r=vrepo.save(r1);
			return update(r);
		}else {
			throw new RuntimeException("vendor id is not present");
		
		}
	}
	public RechargeVendorDto update(RechargeVendor r) {
		RechargeVendorDto dto=new RechargeVendorDto();
		dto.setVendorId(r.getVendorId());
		dto.setFirstName(r.getFirstName());
		dto.setLastName(r.getLastName());
		dto.setGender(r.getGender());
		dto.setAddressLine1(r.getAddressLine1());
		dto.setAddressLine2(r.getAddressLine2());
		dto.setDob(r.getDob());
		dto.setTelecomOperatorName(r.getTelecomOperatorName());
		dto.setEmailId(r.getEmailId());
		dto.setBalance(r.getBalance());
		dto.setCreatedOn(r.getCreatedOn());
		dto.setLastUpdatedOn(r.getLastUpdatedOn());
		
		return dto;
	}

	@Override
	public GetRechargeVendorBalanceDto getVendorBalanceById(long id) {
		RechargeVendor ven=vrepo.findById(id);
		if(ven!=null) {
			GetRechargeVendorBalanceDto ddto=new GetRechargeVendorBalanceDto();
		ddto.setVendorId(ven.getVendorId());
		ddto.setFirstName(ven.getFirstName());
		ddto.setLastName(ven.getLastName());
//		ddto.setGender(ven.getGender());
		ddto.setEmailId(ven.getEmailId());
		ddto.setBalance(ven.getBalance());
		ddto.setCreatedOn(ven.getCreatedOn());
		ddto.setLastUpdatedOn(ven.getLastUpdatedOn());
		return ddto;
		}
		else {
			throw new RuntimeException("vendor id is not present");
		}
	}

}
