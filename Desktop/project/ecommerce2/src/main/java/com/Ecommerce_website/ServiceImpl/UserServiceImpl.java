package com.Ecommerce_website.ServiceImpl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Ecommerce_website.Dto.CartDto;
import com.Ecommerce_website.Dto.CartResDto;
import com.Ecommerce_website.Dto.CategoryDto;
import com.Ecommerce_website.Dto.GetByCategoryDto;
import com.Ecommerce_website.Dto.GetByItemDto;
import com.Ecommerce_website.Dto.ItemsDto;
import com.Ecommerce_website.Dto.OrderDto;
import com.Ecommerce_website.Dto.OrderHistoryDto;
import com.Ecommerce_website.Dto.UserDto;
import com.Ecommerce_website.Dto.UserFavAccountDto;
import com.Ecommerce_website.Model.Cart;
import com.Ecommerce_website.Model.Category;
import com.Ecommerce_website.Model.Items;
import com.Ecommerce_website.Model.Order;
import com.Ecommerce_website.Model.User;
import com.Ecommerce_website.Model.UserFavAccount;
import com.Ecommerce_website.Model.Vendor;
import com.Ecommerce_website.Repository.CartRepository;
import com.Ecommerce_website.Repository.CategoryRepository;
import com.Ecommerce_website.Repository.ItemsRepository;
import com.Ecommerce_website.Repository.UserFavAccountRepository;
import com.Ecommerce_website.Repository.UserRepository;
import com.Ecommerce_website.Repository.VendorRepository;
import com.Ecommerce_website.Repository.orderRepository;
import com.Ecommerce_website.Service.UserService;

import jakarta.mail.FetchProfile.Item;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	public UserRepository userRepo;
	@Autowired
	public CartRepository cartRepo;
	@Autowired
	public ItemsRepository itemRepo;
   @Autowired
   public VendorRepository vendorRepo;
   @Autowired
   public orderRepository orderRepo;
   @Autowired
   public UserFavAccountRepository userFavAccRepo;
   @Autowired
   public CategoryRepository categoryRepo;
 
   
	@Override
	public UserDto adduser(UserDto userDto) {

		User user = new User();

		user.setFirstName(userDto.getFirstName());
		user.setLastName(userDto.getLastName());
		user.setEmailId(userDto.getEmailId());
		user.setMobileNumber(userDto.getMobileNumber());
		user.setBalance(new BigDecimal(500.0));
		user.setStatus(true);
		user.setAddress(userDto.getAddress());

		User uemailId = userRepo.findByEmailId(userDto.getEmailId());
		if (uemailId == null) {

			User addu = userRepo.save(user);

			userDto.setUserId(addu.getUserId());
			userDto.setFirstName(addu.getFirstName());
			userDto.setLastName(addu.getLastName());
			userDto.setEmailId(addu.getEmailId());
			userDto.setMobileNumber(addu.getMobileNumber());
			userDto.setBalance(addu.getBalance());
			userDto.setStatus(addu.isStatus());
			userDto.setAddress(addu.getAddress());
			userDto.setCreatedOn(addu.getCreatedOn());
			userDto.setLastUpdatedOn(addu.getLastUpdatedOn());

		} else {
			throw new RuntimeException("user with same emailId is present");

		}
		return userDto;
	}

	@Override
	public UserDto updateuser(UserDto userDto) {

		User user1 = userRepo.findById(userDto.getUserId());
		if (user1 != null) {

			user1.setFirstName(userDto.getFirstName());
			user1.setLastName(userDto.getLastName());
			user1.setEmailId(userDto.getEmailId());
			user1.setMobileNumber(userDto.getMobileNumber());
			user1.setBalance(new BigDecimal(500.0));
			user1.setAddress(userDto.getAddress());

			User adduser = userRepo.save(user1);

			userDto.setUserId(adduser.getUserId());
			userDto.setFirstName(adduser.getFirstName());
			userDto.setLastName(adduser.getLastName());
			userDto.setEmailId(adduser.getEmailId());
			userDto.setMobileNumber(adduser.getMobileNumber());
			userDto.setBalance(adduser.getBalance());
			userDto.setAddress(adduser.getAddress());
			userDto.setCreatedOn(adduser.getCreatedOn());
			userDto.setLastUpdatedOn(adduser.getLastUpdatedOn());

		}

		else {
			throw new RuntimeException("user id is not present");
		}

		return userDto;
	}

	@Override
	public List<UserDto> getAllUser() {
		List<User> user = userRepo.findAll();
		List<UserDto> dto = new ArrayList<>();

		for (User user1 : user) {
			UserDto udto = new UserDto();
			udto.setUserId(user1.getUserId());
			udto.setFirstName(user1.getFirstName());
			udto.setLastName(user1.getLastName());
			udto.setEmailId(user1.getEmailId());
			udto.setMobileNumber(user1.getMobileNumber());
			udto.setBalance(user1.getBalance());
			udto.setStatus(user1.isStatus());
			udto.setAddress(user1.getAddress());
			udto.setCreatedOn(user1.getCreatedOn());
			udto.setLastUpdatedOn(user1.getLastUpdatedOn());
			dto.add(udto);
		}
		return dto;
	}

	@Override
	public Object deleteuser(long id) {
		User user = userRepo.findById(id);
		if (user != null) {
			user.setStatus(false);
			userRepo.save(user);
			Map<String, String> map = new HashMap<String, String>();
			map.put("status", "deleted successfully");
			return map;
		} else {
			Map<String, String> map = new HashMap<String, String>();
			map.put("status", "user does not exists");
			return map;
		}
	}

	@Override
	public CartResDto addCart(CartDto cartDto) {
		Cart cart = new Cart();
		BigDecimal totalAmount = new BigDecimal(0);
		List<Items> item = cartDto.getItemId();
		for (Items i : item) {
			Items it = itemRepo.findById(i.getItemId());
			if (it != null) {
				long itemQuantity = i.getQuantity();
				BigDecimal itemAmount = it.getAmount();
				if (itemQuantity > 1) {
					itemAmount = itemAmount.multiply(BigDecimal.valueOf(itemQuantity));
					totalAmount = totalAmount.add(itemAmount);
				} else
					totalAmount = totalAmount.add(itemAmount);
			} else {
				throw new RuntimeException("item with the given id is not present");
			}
		}
		cart.setAmount(totalAmount);

		Cart cart1 = cartRepo.save(cart);

		CartResDto cresponse = new CartResDto();

		cresponse.setCartId(cart1.getCartId());
		cresponse.setAmount(cart1.getAmount());
		return cresponse;
	}

	@Override
	public CartResDto updateCart(CartDto cartDto) {
	    Cart existingCart = cartRepo.findById(cartDto.getCartId());

	    if (existingCart != null) {
	        BigDecimal totalAmount = new BigDecimal(0);
	        List<Items> updatedItems = cartDto.getItemId();

	        for (Items updatedItem : updatedItems) {
	            Items item = itemRepo.findById(updatedItem.getItemId());

	            if (item != null) {
	                long itemQuantity = updatedItem.getQuantity();
	                BigDecimal itemAmount = item.getAmount();

	                if (itemQuantity > 1) {
	                    itemAmount = itemAmount.multiply(BigDecimal.valueOf(itemQuantity));
	                }

	                totalAmount = totalAmount.add(itemAmount);
	            } else {
	                throw new RuntimeException("Item with the given ID is not present");
	            }
	        }

	        existingCart.setAmount(totalAmount);

	        Cart updatedCart = cartRepo.save(existingCart);

	        CartResDto cresponse = new CartResDto();

	        cresponse.setCartId(updatedCart.getCartId());
	        cresponse.setAmount(updatedCart.getAmount());

	        return cresponse;
	    } else {
	        throw new RuntimeException("Cart with the given ID is not present");
	    }
	}

	@Override
	public OrderDto addorder(OrderDto orderDto) {
		User userid=userRepo.findById(orderDto.getUserId());
		if(userid!=null) {
			
			Vendor venid=vendorRepo.findById(orderDto.getVendorId());
			if(venid!=null) {
				
				Cart cid=cartRepo.findById(orderDto.getCartId());
				if(cid!=null) {
				
				Order order=new Order();
		
				BigDecimal amt=cid.getAmount();
				BigDecimal balance=userid.getBalance();
				
				int deduction=balance.compareTo(amt);
				if(deduction>=0) {
					
					BigDecimal curentbalance=balance.subtract(amt);
					userid.setBalance(curentbalance);
					
					userRepo.save(userid);
				
					BigDecimal add=venid.getBalance().add(amt);
					venid.setBalance(add);
					
						order.setDescription("payment successfull");
						order.setAmount(amt);
						order.setTransactionId(UUID.randomUUID().toString());
						order.setUser(userid);
						order.setVendor(venid);
						order.setCart(cid);
							
				     Order order1=orderRepo.save(order);
					
				     orderDto.setOrderId(order1.getOrderId());	
					orderDto.setCartId(order1.getCart().getCartId());
					orderDto.setAmount(order1.getAmount());
					orderDto.setUserId(order1.getUser().getUserId());
					orderDto.setTransactionId(order1.getTransactionId());
					orderDto.setVendorId(order1.getVendor().getVendorId());
					orderDto.setDescription(order1.getDescription());
					orderDto.setCreatedOn(order1.getCreatedOn());
					orderDto.setLastUpdatedOn(order1.getLastUpdatedOn());
					
					return orderDto;
			    }
				else throw new RuntimeException("balance is low");
				
				}else throw new RuntimeException("cart id is not present");
				
			}else throw new RuntimeException("vendor id is not present");
	
		}
		else throw new RuntimeException("user id is not present");
		
	}

	@Override
	public Object deleteCart(long id) {
		 Cart cart = cartRepo.findById(id);
		    if (cart != null) {
		    	cartRepo.delete(cart);
		        CartDto deletedDto = new CartDto();
		        deletedDto.setCartId(cart.getCartId());
		     
		        // Set other fields as needed
		        return "deleted successfully";
		    } else {
		        throw new RuntimeException("cart with ID " + id + " not found.");
		    }
	}

//	@Override
//	public List<OrderHistoryDto> getOrderHistoryByOrderId(long id) {
//      Order order=orderRepo.findById(id);
//      if(order!=null) {
//    	  List<Order> order1=orderRepo.findByOrderId(id);
//    	  List<OrderHistoryDto> odto=new ArrayList();
//    	  for(Order dto:order1) {
//    		  OrderHistoryDto od=new OrderHistoryDto();
//    		  od.setOrderId(dto.getOrderId());
//    	     od.setCartId(dto.getCart().getCartId());
//    	     od.setUserId(dto.getUser().getUserId());
//    	     od.setVendorId(dto.getVendor().getVendorId());
//    	     od.setAmount(dto.getAmount());
//    	     od.setTransactionId(dto.getTransactionId());
//    	     od.setDescription(dto.getDescription());
//    	     odto.add(od);
//    	  }
//  		return odto;
//      }
//      else {
//    	  throw new RuntimeException("order id is not present");
//      }
//	}

	@Override
	public List<OrderHistoryDto> getAllOrderHistoryByUserId(long id) {
      User user=userRepo.findById(id);
      if(user!=null) {
    	  
    	  List<Order> order1=orderRepo.findByUserUserId(id);
    	  List<OrderHistoryDto> odto=new ArrayList();
    	  for(Order dto:order1) {
    		  OrderHistoryDto od=new OrderHistoryDto();
    		  od.setOrderId(dto.getOrderId());
    	     od.setCartId(dto.getCart().getCartId());
    	     od.setUserId(dto.getUser().getUserId());
    	     od.setVendorId(dto.getVendor().getVendorId());
    	     od.setAmount(dto.getAmount());
    	     od.setTransactionId(dto.getTransactionId());
    	     od.setDescription(dto.getDescription());
    	     odto.add(od);
    	  }
  		return odto;
      }
      else {
    	  throw new RuntimeException("user id is not present");
      }
	}

	@Override
	public GetByCategoryDto getByCategoryId(long id) {
		Category cat = categoryRepo.findById(id);
		if (cat != null) {
			GetByCategoryDto cdto = new GetByCategoryDto();
			cdto.setCatId(cat.getCatId());
			cdto.setName(cat.getName());
			cdto.setVendorId(cat.getVendor().getVendorId());
			return cdto;
		} else {
			throw new RuntimeException("Category id is not present");
		}
	}

	@Override
	public List<GetByCategoryDto> getAllCategoryByVendorId(long id) {
		Vendor ven = vendorRepo.findById(id);
		if (ven != null) {
			List<Category> cat = categoryRepo.findByVendorVendorId(id);
			List<GetByCategoryDto> cdto = new ArrayList();

			for (Category cat1 : cat) {
				GetByCategoryDto catdto = new GetByCategoryDto();
				catdto.setCatId(cat1.getCatId());
				catdto.setName(cat1.getName());
				catdto.setVendorId(cat1.getVendor().getVendorId());

				cdto.add(catdto);
			}
			return cdto;
		} else {
			throw new RuntimeException("vendor id is not present");
		}
	}

	@Override
	public List<GetByItemDto> getAlItemsByCategoryId(long id) {
		Category cat = categoryRepo.findById(id);
		if (cat != null) {
			List<Items> item = itemRepo.findByCategoryCatId(id);
			List<GetByItemDto> idto = new ArrayList();

			for (Items item1 : item) {
				GetByItemDto idto1 = new GetByItemDto();
				idto1.setItemId(item1.getItemId());
				idto1.setName(item1.getName());
				idto1.setCatId(item1.getCategory().getCatId());
				idto1.setVendorId(item1.getVendor().getVendorId());
				idto1.setAmount(item1.getAmount());
				idto1.setStatus(item1.isStatus());

				idto.add(idto1);
			}
			return idto;
		} else {
			throw new RuntimeException("category id is not present");
		}
	}

	@Override
	public GetByItemDto getByItemId(long id) {
		Items it = itemRepo.findById(id);
		if (it != null) {
			GetByItemDto idto = new GetByItemDto();
			idto.setItemId(it.getItemId());
			idto.setName(it.getName());
			idto.setCatId(it.getCategory().getCatId());
			idto.setVendorId(it.getVendor().getVendorId());
			idto.setAmount(it.getAmount());
			idto.setStatus(it.isStatus());
			return idto;
		} else {
			throw new RuntimeException("item id is not present");
		}
	}


	
	@Override
	public OrderHistoryDto getAllOrderHistoryByUserIdAndOrderId(long userId, long orderId) {
		User user = userRepo.findByUserId(userId);
		if (user != null) {
			Order order = orderRepo.findByOrderId(orderId);
			if (order != null) {
				Order orders = orderRepo.findByUserUserIdAndOrderId(userId,orderId);
				if (orders != null) {
					OrderHistoryDto odto = new OrderHistoryDto();
					odto.setOrderId(orders.getOrderId());
					odto.setCartId(orders.getCart().getCartId());
					odto.setUserId(orders.getUser().getUserId());
					odto.setVendorId(orders.getVendor().getVendorId());
					odto.setAmount(orders.getAmount());
					odto.setTransactionId(orders.getTransactionId());
					odto.setDescription(orders.getDescription());
					return odto;
				}
				else throw new RuntimeException("no data exists");
			}
			else throw new RuntimeException("order id is not present");
		}
		else throw new RuntimeException("user id is not present");

	}

	
	@Override
	public UserFavAccountDto addAccount(UserFavAccountDto userFavAccountDto) {
		User userid = userRepo.findById(userFavAccountDto.getUserId());
		if (userid != null) {
			Items itemid = itemRepo.findById(userFavAccountDto.getItemId());
			if (itemid != null) {
			
				UserFavAccount user = new UserFavAccount();
				user.setItemName(itemid.getName());
				user.setAmount(itemid.getAmount());
				user.setStatus(itemid.isStatus());
				user.setItems(itemid);
				user.setUser(userid);

				UserFavAccount addu = userFavAccRepo.save(user);
				userFavAccountDto.setUserAccountId(addu.getUserAccountId());
				userFavAccountDto.setItemName(addu.getItemName());
				userFavAccountDto.setAmount(addu.getAmount());
				userFavAccountDto.setStatus(true);
				userFavAccountDto.setItemId(addu.getItems().getItemId());
				userFavAccountDto.setUserId(addu.getUser().getUserId());


		} else {
			throw new RuntimeException("item id is not present");
         }
		}else {
			throw new RuntimeException("user id is not present");

		}
		return userFavAccountDto;
	}
	
	@Override
	public UserFavAccountDto getByAccountId(long id) {
		UserFavAccount u = userFavAccRepo.findById(id);
		if (u != null) {
			UserFavAccountDto udto = new UserFavAccountDto();
			udto.setUserAccountId(u.getUserAccountId());
			udto.setItemName(u.getItemName());
			udto.setAmount(u.getAmount());
			udto.setStatus(u.isStatus());
			udto.setItemId(u.getItems().getItemId());
			udto.setUserId(u.getUser().getUserId());
			return udto;
		} else {
			throw new RuntimeException("account id is not present");
		}
	}

	@Override
	public Object deleteaccount(long id) {
		UserFavAccount user = userFavAccRepo.findById(id);
		if (user != null) {
			user.setStatus(false);
			userFavAccRepo.save(user);
			Map<String, String> map = new HashMap<String, String>();
			map.put("status", "deleted successfully");
			return map;
		} else {
			Map<String, String> map = new HashMap<String, String>();
			map.put("status", "account does not exists");
			return map;
		}
	}
	
	


}
