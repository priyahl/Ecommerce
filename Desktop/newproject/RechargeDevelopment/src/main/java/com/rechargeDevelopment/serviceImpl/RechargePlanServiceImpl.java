package com.rechargeDevelopment.serviceImpl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rechargeDevelopment.Dto.RechargePlanDto;
import com.rechargeDevelopment.Model.ConfigRechargeCategory;
import com.rechargeDevelopment.Model.RechargePlan;
import com.rechargeDevelopment.Model.RechargeVendor;
import com.rechargeDevelopment.repository.ConfigRechargeCategoryRepository;
import com.rechargeDevelopment.repository.RechargePlanRepository;
import com.rechargeDevelopment.repository.RechargeVendorRepository;
import com.rechargeDevelopment.service.RechargePlanService;

@Service
public class RechargePlanServiceImpl implements RechargePlanService {

	@Autowired
	RechargePlanRepository prepo;

	@Autowired
	RechargeVendorRepository vrepo;

	@Autowired
	ConfigRechargeCategoryRepository crepo;

	@Override
	public Object addrecharge(RechargePlanDto rechargePlanDto) {
		RechargePlan rplan = new RechargePlan();

		RechargeVendor vid = vrepo.findByVendorId(rechargePlanDto.getVendorId());
		if (vid != null) {
			ConfigRechargeCategory cid = crepo.findByCatId(rechargePlanDto.getCatId());
			if (cid != null) {
				RechargePlan rp = prepo.findByRechargeVendorVendorIdAndRechargeAmount(rechargePlanDto.getVendorId(),
						rechargePlanDto.getRechargeAmount());
				if (rp == null) {
					rplan.setRechargeAmount(rechargePlanDto.getRechargeAmount());
					rplan.setDescription(rechargePlanDto.getDescription());
					rplan.setValidity(rechargePlanDto.getValidity());
					rplan.setRechargeVendor(vid);
					rplan.setConfigRechargeCategory(cid);

					RechargePlan addp = prepo.save(rplan);

					rechargePlanDto.setId(addp.getId());
					rechargePlanDto.setRechargeAmount(addp.getRechargeAmount());
					rechargePlanDto.setDescription(addp.getDescription());
					rechargePlanDto.setValidity(addp.getValidity());
					rechargePlanDto.setVendorId(addp.getRechargeVendor().getVendorId());
					rechargePlanDto.setCatId(addp.getConfigRechargeCategory().getCatId());
					rechargePlanDto.setCreatedOn(addp.getCreatedOn());
					rechargePlanDto.setLastUpdatedOn(addp.getLastUpdatedOn());

				} else {
					Map<String, String> map = new HashMap<String, String>();
					map.put("ErrorMessage", "vendor with same amount present");
					return map;
				}
			} else {
				Map<String, String> map = new HashMap<String, String>();
				map.put("ErrorMessage", "catId id is not present");
				return map;
			}
		} else {
			Map<String, String> map = new HashMap<String, String>();
			map.put("ErrorMessage", "vendor id is not present");
			return map;
		}
		return rechargePlanDto;

	}

	@Override
	public RechargePlanDto updatePlan(RechargePlanDto rechargePlanDto) {
		RechargePlan rplan = prepo.findById(rechargePlanDto.getId());
		if (rplan != null) {
			rplan.setId(rechargePlanDto.getId());
			rplan.setDescription(rechargePlanDto.getDescription());
			rplan.setRechargeAmount(rechargePlanDto.getRechargeAmount());
			rplan.setValidity(rechargePlanDto.getValidity());

			RechargePlan addplan = prepo.save(rplan);

			rechargePlanDto.setId(addplan.getId());
			rechargePlanDto.setRechargeAmount(addplan.getRechargeAmount());
			rechargePlanDto.setDescription(addplan.getDescription());
			rechargePlanDto.setValidity(addplan.getValidity());
			rechargePlanDto.setVendorId(addplan.getRechargeVendor().getVendorId());
			rechargePlanDto.setCatId(addplan.getConfigRechargeCategory().getCatId());
			rechargePlanDto.setCreatedOn(addplan.getCreatedOn());
			rechargePlanDto.setLastUpdatedOn(addplan.getLastUpdatedOn());

		} else {
			throw new RuntimeException("Recharge plan id is not present");
		}
		return rechargePlanDto;
	}

	@Override
	public RechargePlanDto getRechargePlanById(long id) {

		RechargePlan plan = prepo.findById(id);

		if (plan != null) {

			RechargePlanDto planDto = new RechargePlanDto();

			planDto.setId(plan.getId());
			planDto.setRechargeAmount(plan.getRechargeAmount());
			planDto.setDescription(plan.getDescription());
			planDto.setValidity(plan.getValidity());
			planDto.setVendorId(plan.getRechargeVendor().getVendorId());
			planDto.setCatId(plan.getConfigRechargeCategory().getCatId());
			planDto.setCreatedOn(plan.getCreatedOn());
			planDto.setLastUpdatedOn(plan.getLastUpdatedOn());

			return planDto;
		} else {
			throw new RuntimeException("No such RechargePlan with id present.");
		}

	}

	@Override
	public List<RechargePlanDto> getRechargePlanByRechargeVendorId(long vendorId) {

		RechargeVendor rechargeVendor = vrepo.findByVendorId(vendorId);
		if (rechargeVendor != null) {

			List<RechargePlan> rplan = prepo.findByRechargeVendorVendorId(vendorId);
			List<RechargePlanDto> planDto = new ArrayList();

			for (RechargePlan rechargePlan1 : rplan) {

				RechargePlanDto pdto = new RechargePlanDto();
				pdto.setId(rechargePlan1.getId());
				pdto.setRechargeAmount(rechargePlan1.getRechargeAmount());
				pdto.setDescription(rechargePlan1.getDescription());
				pdto.setValidity(rechargePlan1.getValidity());
				pdto.setVendorId(rechargePlan1.getRechargeVendor().getVendorId());
				pdto.setCatId(rechargePlan1.getConfigRechargeCategory().getCatId());
				pdto.setCreatedOn(rechargePlan1.getCreatedOn());
				pdto.setLastUpdatedOn(rechargePlan1.getLastUpdatedOn());

				planDto.add(pdto);
			}
			return planDto;
		} else {
			throw new RuntimeException("vendorId is not present.");
		}
	}

}