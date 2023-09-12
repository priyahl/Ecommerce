package com.rechargeDevelopment.serviceImpl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rechargeDevelopment.Dto.UserRechargeAccountDto;
import com.rechargeDevelopment.Model.RechargeUser;
import com.rechargeDevelopment.Model.UserRechargeAccount;
import com.rechargeDevelopment.repository.RechargeUserRepository;
import com.rechargeDevelopment.repository.UserRechargeAccountRepository;
import com.rechargeDevelopment.service.UserRechargeAccountService;

@Service
public class UserRechargeAccountServiceImpl implements UserRechargeAccountService {

	@Autowired
	RechargeUserRepository rechargeUserRepository;

	@Autowired
	UserRechargeAccountRepository userRechargeAccountRepository;

	@Override
	public UserRechargeAccountDto addaccount(UserRechargeAccountDto userRechargeAccountDto) {
		RechargeUser user = rechargeUserRepository.findById(userRechargeAccountDto.getUserId());
		if (user != null) {

			UserRechargeAccount racc = userRechargeAccountRepository.findByRechargeUserUserIdAndMobileNo(
					userRechargeAccountDto.getUserId(), userRechargeAccountDto.getMobileNo());
			if (racc == null) {

				UserRechargeAccount account = new UserRechargeAccount();

				account.setTelecomOperatorName(userRechargeAccountDto.getTelecomOperatorName());
				account.setMobileNo(userRechargeAccountDto.getMobileNo());
				account.setNickName(userRechargeAccountDto.getNickName());
				account.setStatus(1);
				account.setFavNumber(userRechargeAccountDto.isFavNumber());
				account.setDefaultNumber(userRechargeAccountDto.isDefaultNumber());
				account.setRechargeUser(user);

				if (userRechargeAccountDto.isDefaultNumber() == true) {

					UserRechargeAccount useracc = userRechargeAccountRepository
							.findByRechargeUserUserIdAndDefaultNumber(userRechargeAccountDto.getUserId(),
									userRechargeAccountDto.isDefaultNumber());

					if (useracc == null) {

						UserRechargeAccount acc1 = userRechargeAccountRepository.save(account);

						UserRechargeAccountDto dto = new UserRechargeAccountDto();

						dto.setId(acc1.getId());
						dto.setTelecomOperatorName(acc1.getTelecomOperatorName());
						dto.setMobileNo(acc1.getMobileNo());
						dto.setNickName(acc1.getNickName());
						dto.setStatus(acc1.getStatus());
						dto.setFavNumber(acc1.isFavNumber());
						dto.setDefaultNumber(acc1.isDefaultNumber());
						dto.setUserId(acc1.getRechargeUser().getUserId());

						return dto;

					} else {

						useracc.setDefaultNumber(false);
						userRechargeAccountRepository.save(useracc);

						UserRechargeAccount acc1 = userRechargeAccountRepository.save(account);

						UserRechargeAccountDto dto = new UserRechargeAccountDto();

						dto.setId(acc1.getId());
						dto.setTelecomOperatorName(acc1.getTelecomOperatorName());
						dto.setMobileNo(acc1.getMobileNo());
						dto.setNickName(acc1.getNickName());
						dto.setStatus(acc1.getStatus());
						dto.setFavNumber(acc1.isFavNumber());
						dto.setDefaultNumber(acc1.isDefaultNumber());
						dto.setUserId(acc1.getRechargeUser().getUserId());
						return dto;
					}
					
				} else {
					UserRechargeAccount acc1 = userRechargeAccountRepository.save(account);
					UserRechargeAccountDto dto = new UserRechargeAccountDto();
					dto.setId(acc1.getId());
					dto.setTelecomOperatorName(acc1.getTelecomOperatorName());
					dto.setMobileNo(acc1.getMobileNo());
					dto.setNickName(acc1.getNickName());
					dto.setStatus(acc1.getStatus());
					dto.setFavNumber(acc1.isFavNumber());
					dto.setDefaultNumber(acc1.isDefaultNumber());
					dto.setUserId(acc1.getRechargeUser().getUserId());
					return dto;
				}
			} else {
				throw new RuntimeException("duplicate number for userId");
			}
		} else {
			throw new RuntimeException(" userId is not present");

		}
	}

	@Override
	public UserRechargeAccountDto updateacc(UserRechargeAccountDto userRechargeAccountDto) {
		UserRechargeAccount account = userRechargeAccountRepository.findById(userRechargeAccountDto.getId());
		if (account != null) {

			UserRechargeAccount racc = userRechargeAccountRepository.findByRechargeUserUserIdAndMobileNo(
					userRechargeAccountDto.getUserId(), userRechargeAccountDto.getMobileNo());
			if (racc == null) {

//				account.setId(userRechargeAccountDto.getId());
				account.setTelecomOperatorName(userRechargeAccountDto.getTelecomOperatorName());
				account.setMobileNo(userRechargeAccountDto.getMobileNo());
				account.setNickName(userRechargeAccountDto.getNickName());
				account.setFavNumber(userRechargeAccountDto.isFavNumber());
				account.setDefaultNumber(userRechargeAccountDto.isDefaultNumber());
//				account.setRechargeUser(userRechargeAccountDto.getUserId());

				if (userRechargeAccountDto.isDefaultNumber() == true) {

					UserRechargeAccount useracc = userRechargeAccountRepository
							.findByRechargeUserUserIdAndDefaultNumber(userRechargeAccountDto.getUserId(),
									userRechargeAccountDto.isDefaultNumber());

					if (useracc == null) {

						UserRechargeAccount acc1 = userRechargeAccountRepository.save(account);

						UserRechargeAccountDto dto = new UserRechargeAccountDto();

						dto.setId(account.getId());
						dto.setTelecomOperatorName(account.getTelecomOperatorName());
						dto.setMobileNo(account.getMobileNo());
						dto.setNickName(account.getNickName());
						dto.setStatus(account.getStatus());
						dto.setFavNumber(account.isFavNumber());
						dto.setDefaultNumber(account.isDefaultNumber());
						dto.setUserId(account.getRechargeUser().getUserId());
						return dto;

					} else {

						useracc.setDefaultNumber(false);
						userRechargeAccountRepository.save(useracc);

						UserRechargeAccount acc1 = userRechargeAccountRepository.save(account);

						UserRechargeAccountDto dto = new UserRechargeAccountDto();

						dto.setId(account.getId());
						dto.setTelecomOperatorName(account.getTelecomOperatorName());
						dto.setMobileNo(account.getMobileNo());
						dto.setNickName(account.getNickName());
						dto.setStatus(account.getStatus());
						dto.setFavNumber(account.isFavNumber());
						dto.setDefaultNumber(account.isDefaultNumber());
						dto.setUserId(account.getRechargeUser().getUserId());
						return dto;
					}
				} else {
					UserRechargeAccount acc1 = userRechargeAccountRepository.save(account);

					UserRechargeAccountDto dto = new UserRechargeAccountDto();
					dto.setId(account.getId());
					dto.setTelecomOperatorName(account.getTelecomOperatorName());
					dto.setMobileNo(account.getMobileNo());
					dto.setNickName(account.getNickName());
					dto.setStatus(account.getStatus());
					dto.setFavNumber(account.isFavNumber());
					dto.setDefaultNumber(account.isDefaultNumber());
					dto.setUserId(account.getRechargeUser().getUserId());
					return dto;
				}
			} else {
				throw new RuntimeException("duplicate number for userId");
			}
		} else {
			throw new RuntimeException(" account is not present");

		}

	}

	@Override
	public List<UserRechargeAccountDto> getAccountByUserId(long id) {
RechargeUser user=rechargeUserRepository.findById(id);
if(user!=null) {
	List<UserRechargeAccount> acc=userRechargeAccountRepository.findByRechargeUserUserId(id);
	List<UserRechargeAccountDto> dto1=new ArrayList<UserRechargeAccountDto>();
	
	for(UserRechargeAccount account:acc) {
		UserRechargeAccountDto dto=new UserRechargeAccountDto();
		dto.setId(account.getId());
		dto.setTelecomOperatorName(account.getTelecomOperatorName());
		dto.setMobileNo(account.getMobileNo());
		dto.setNickName(account.getNickName());
		dto.setStatus(account.getStatus());
		dto.setFavNumber(account.isFavNumber());
		dto.setDefaultNumber(account.isDefaultNumber());
		dto.setUserId(account.getRechargeUser().getUserId());
		dto1.add(dto);
	}
	return dto1;
}
else {
	throw new RuntimeException("user id is not present");
     }
}

	@Override
	public Object removeAcc(long id) {

		UserRechargeAccount account = userRechargeAccountRepository.findById(id);
		if (account != null) {
			account.setStatus(0);
			userRechargeAccountRepository.save(account);
			Map<String, String> map = new HashMap<String, String>();
			map.put("status", "deleted successfully");
			return map;
		} else {
			Map<String, String> map = new HashMap<String, String>();
			map.put("status", "account does not exists");
			return map;
		}
	
	}

	@Override
	public List<UserRechargeAccountDto> getFavNumberByUserId(long id) {

		RechargeUser user = rechargeUserRepository.findById(id);
		if (user != null) {
			List<UserRechargeAccount> favNumber = userRechargeAccountRepository.findByRechargeUserUserIdAndFavNumber(id,
					true);
			List<UserRechargeAccountDto> dto1 = new ArrayList();

			for (UserRechargeAccount num : favNumber) {
				UserRechargeAccountDto dto = new UserRechargeAccountDto();
				dto.setId(num.getId());
				dto.setTelecomOperatorName(num.getTelecomOperatorName());
				dto.setMobileNo(num.getMobileNo());
				dto.setNickName(num.getNickName());
				dto.setStatus(num.getStatus());
				dto.setFavNumber(num.isFavNumber());
				dto.setDefaultNumber(num.isDefaultNumber());
				dto.setUserId(num.getRechargeUser().getUserId());
				
				dto1.add(dto);

			}
			return dto1;
		} else {
			throw new RuntimeException("User is not present");

		}

	}

	@Override
	public UserRechargeAccountDto getdefaultNumberByUserId(long id) {

		RechargeUser user = rechargeUserRepository.findById(id);
		if (user != null) {
			UserRechargeAccount defnumber = userRechargeAccountRepository.findByRechargeUserUserIdAndDefaultNumber(id,
					true);

				UserRechargeAccountDto dto = new UserRechargeAccountDto();
				dto.setId(defnumber.getId());
				dto.setTelecomOperatorName(defnumber.getTelecomOperatorName());
				dto.setMobileNo(defnumber.getMobileNo());
				dto.setNickName(defnumber.getNickName());
				dto.setStatus(defnumber.getStatus());
				dto.setFavNumber(defnumber.isFavNumber());
				dto.setDefaultNumber(defnumber.isDefaultNumber());
				dto.setUserId(defnumber.getRechargeUser().getUserId());
				return dto;
			}
			
		 else {
			throw new RuntimeException("User is not present");

		}

		
	}
		
		
	



}
