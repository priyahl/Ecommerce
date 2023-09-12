package com.rechargeDevelopment.serviceImpl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rechargeDevelopment.Dto.ConfigRechargeCategoryDto;
import com.rechargeDevelopment.Dto.GetAllCategoryDto;
import com.rechargeDevelopment.Dto.GetRechargePlanDto;
import com.rechargeDevelopment.Dto.GetTelecomOperatorDto;
import com.rechargeDevelopment.Dto.RechargePlanDto;
import com.rechargeDevelopment.Dto.RechargeUserDto;
import com.rechargeDevelopment.Dto.RechargeVendorDto;
import com.rechargeDevelopment.Model.ConfigRechargeCategory;
import com.rechargeDevelopment.Model.RechargePlan;
import com.rechargeDevelopment.Model.RechargeUser;
import com.rechargeDevelopment.Model.RechargeVendor;
import com.rechargeDevelopment.repository.ConfigRechargeCategoryRepository;
import com.rechargeDevelopment.repository.RechargePlanRepository;
import com.rechargeDevelopment.repository.RechargeUserRepository;
import com.rechargeDevelopment.repository.RechargeVendorRepository;
import com.rechargeDevelopment.service.RechargeUserService;

@Service
public class RechargeUserServiceImpl implements RechargeUserService {

	@Autowired
	public RechargeUserRepository userRepo;
	@Autowired
	RechargeVendorRepository venrepo;
	@Autowired
	ConfigRechargeCategoryRepository config;
	@Autowired
	RechargePlanRepository rrepo;

	@Override
	public RechargeUserDto adduser(RechargeUserDto rechargeUserDto) {

		RechargeUser user = new RechargeUser();

		user.setFirstName(rechargeUserDto.getFirstName());
		user.setLastName(rechargeUserDto.getLastName());
		user.setEmailId(rechargeUserDto.getEmailId());
		user.setGender(rechargeUserDto.getGender());
		user.setDob(rechargeUserDto.getDob());
		user.setMobileNumber(rechargeUserDto.getMobileNumber());
		user.setAdhaarNumber(rechargeUserDto.getAdhaarNumber());
		user.setBalance(new BigDecimal(500.0));

		String email = rechargeUserDto.getEmailId();
		if (!email.matches("^[A-Za-z0-9+_.-]+@(.+)$")) {
			throw new RuntimeException("Invalid Email format.");
		} else {

			RechargeUser uemailId = userRepo.findByEmailId(rechargeUserDto.getEmailId());
			if (uemailId == null) {

				String adhaarNumber = rechargeUserDto.getAdhaarNumber();
				if (!adhaarNumber.matches("\\d{12}")) {
					throw new RuntimeException("Invalid Aadhaar Number format.");
				} else {

					RechargeUser useradhar = userRepo.findByAdhaarNumber(rechargeUserDto.getAdhaarNumber());
					if (useradhar == null) {

						RechargeUser addu = userRepo.save(user);

						rechargeUserDto.setUserId(addu.getUserId());
						rechargeUserDto.setFirstName(addu.getFirstName());
						rechargeUserDto.setLastName(addu.getLastName());
						rechargeUserDto.setEmailId(addu.getEmailId());
						rechargeUserDto.setGender(addu.getGender());
						rechargeUserDto.setDob(addu.getDob());
						rechargeUserDto.setMobileNumber(addu.getMobileNumber());
						rechargeUserDto.setAdhaarNumber(addu.getAdhaarNumber());
						rechargeUserDto.setBalance(addu.getBalance());
						rechargeUserDto.setCreatedOn(addu.getCreatedOn());
						rechargeUserDto.setLastUpdatedOn(addu.getLastUpdatedOn());
					} else {
						throw new RuntimeException("Adhar number already exists");
					}
				}
			} else {
				throw new RuntimeException("user with same emailId is present");
			}
		}
		return rechargeUserDto;
	}

	@Override
	public RechargeUserDto updateuser(RechargeUserDto rechargeUserDto) {

		RechargeUser ruser = userRepo.findById(rechargeUserDto.getUserId());
		if (ruser != null) {

			ruser.setFirstName(rechargeUserDto.getFirstName());
			ruser.setLastName(rechargeUserDto.getLastName());
			ruser.setEmailId(rechargeUserDto.getEmailId());
			ruser.setGender(rechargeUserDto.getGender());
			ruser.setDob(rechargeUserDto.getDob());
			ruser.setMobileNumber(rechargeUserDto.getMobileNumber());
			ruser.setAdhaarNumber(rechargeUserDto.getAdhaarNumber());
			ruser.setBalance(new BigDecimal(50.0));

			String email = rechargeUserDto.getEmailId();
			if (!email.matches("^[A-Za-z0-9+_.-]+@(.+)$")) {
				throw new RuntimeException("Invalid Email format.");
			} else {

				String adhaarNumber = rechargeUserDto.getAdhaarNumber();
				if (!adhaarNumber.matches("\\d{12}")) {
					throw new RuntimeException("Invalid Aadhaar Number format.");
				} else {

					RechargeUser adduser = userRepo.save(ruser);

					rechargeUserDto.setUserId(adduser.getUserId());
					rechargeUserDto.setFirstName(adduser.getFirstName());
					rechargeUserDto.setLastName(adduser.getLastName());
					rechargeUserDto.setEmailId(adduser.getEmailId());
					rechargeUserDto.setGender(adduser.getGender());
					rechargeUserDto.setDob(adduser.getDob());
					rechargeUserDto.setMobileNumber(adduser.getMobileNumber());
					rechargeUserDto.setAdhaarNumber(adduser.getAdhaarNumber());
					rechargeUserDto.setCreatedOn(adduser.getCreatedOn());
					rechargeUserDto.setLastUpdatedOn(adduser.getLastUpdatedOn());

				}
			}
		} else {
			throw new RuntimeException("user id is not present");
		}

		return rechargeUserDto;
	}

	@Override
	public RechargeUserDto getUserById(long id) {
		RechargeUser user = userRepo.findById(id);
		if (user != null) {
			RechargeUserDto udto = new RechargeUserDto();

			udto.setUserId(user.getUserId());
			udto.setFirstName(user.getFirstName());
			udto.setLastName(user.getLastName());
			udto.setEmailId(user.getEmailId());
			udto.setGender(user.getGender());
			udto.setDob(user.getDob());
			udto.setMobileNumber(user.getMobileNumber());
			udto.setAdhaarNumber(user.getAdhaarNumber());
			udto.setBalance(user.getBalance());
			udto.setCreatedOn(user.getCreatedOn());
			udto.setLastUpdatedOn(user.getLastUpdatedOn());
			return udto;
		} else {
			throw new RuntimeException("user id is not present");
		}
	}

	@Override
	public List<GetTelecomOperatorDto> getAllTelecomOperator() {
		List<RechargeVendor> tel = venrepo.findAll();
		List<GetTelecomOperatorDto> dto = new ArrayList();
		for (RechargeVendor users : tel) {
			GetTelecomOperatorDto tdto = new GetTelecomOperatorDto();
			tdto.setTelecomOperatorName(users.getTelecomOperatorName());
			dto.add(tdto);
		}

		return dto;
	}

	@Override
	public List<GetAllCategoryDto> getAllCategory() {
		List<ConfigRechargeCategory> conf = config.findAll();
		List<GetAllCategoryDto> dto = new ArrayList<>();

		for (ConfigRechargeCategory config : conf) {
			GetAllCategoryDto cat = new GetAllCategoryDto();
			cat.setCatId(config.getCatId());
			cat.setCategoryName(config.getCategoryName());

			dto.add(cat);
		}
		return dto;
	}

	@Override
	public GetRechargePlanDto getRechargePlanByPlanId(long id) {

		RechargePlan plan = rrepo.findById(id);

		if (plan != null) {

			GetRechargePlanDto planDto = new GetRechargePlanDto();

			planDto.setId(plan.getId());
			planDto.setRechargeAmount(plan.getRechargeAmount());
			planDto.setDescription(plan.getDescription());
			planDto.setValidity(plan.getValidity());
			planDto.setVendorId(plan.getRechargeVendor().getVendorId());
			planDto.setCatId(plan.getConfigRechargeCategory().getCatId());

			return planDto;
		} else {
			throw new RuntimeException("No such RechargePlan with id present.");
		}
	}

	@Override
	public List<GetRechargePlanDto> getRechargePlanByVendorId(long vendorId) {

		RechargeVendor rechargeVendor = venrepo.findByVendorId(vendorId);
		if (rechargeVendor != null) {

			List<RechargePlan> rplan = rrepo.findByRechargeVendorVendorId(vendorId);
			List<GetRechargePlanDto> planDto = new ArrayList();

			for (RechargePlan rechargePlan1 : rplan) {

				GetRechargePlanDto pdto = new GetRechargePlanDto();
				pdto.setId(rechargePlan1.getId());
				pdto.setRechargeAmount(rechargePlan1.getRechargeAmount());
				pdto.setDescription(rechargePlan1.getDescription());
				pdto.setValidity(rechargePlan1.getValidity());
				pdto.setVendorId(rechargePlan1.getRechargeVendor().getVendorId());
				pdto.setCatId(rechargePlan1.getConfigRechargeCategory().getCatId());

				planDto.add(pdto);
			}
			return planDto;
		} else {
			throw new RuntimeException("vendorId is not present.");
		}
	}

	@Override
	public List<GetRechargePlanDto> getRechargePlanByVendorIdCatId(long vendorId, long catId) {

		RechargeVendor rechargeVendor = venrepo.findByVendorId(vendorId);
		if (rechargeVendor != null) {
			ConfigRechargeCategory conid = config.findByCatId(catId);
			if (conid != null) {
				List<RechargePlan> vcid = rrepo.findByRechargeVendorVendorIdAndConfigRechargeCategoryCatId(vendorId,
						catId);

				List<RechargePlan> rplan = rrepo.findByRechargeVendorVendorId(vendorId);
				List<GetRechargePlanDto> planDto = new ArrayList();

				for (RechargePlan rechargePlan1 : rplan) {

					GetRechargePlanDto pdto = new GetRechargePlanDto();
					pdto.setId(rechargePlan1.getId());
					pdto.setRechargeAmount(rechargePlan1.getRechargeAmount());
					pdto.setDescription(rechargePlan1.getDescription());
					pdto.setValidity(rechargePlan1.getValidity());
					pdto.setVendorId(rechargePlan1.getRechargeVendor().getVendorId());
					pdto.setCatId(rechargePlan1.getConfigRechargeCategory().getCatId());

					planDto.add(pdto);
				}
				return planDto;
			} else {
				throw new RuntimeException("catId is not present.");
			}
		} else {
			throw new RuntimeException("vendorId is not present.");
		}
	}

}
