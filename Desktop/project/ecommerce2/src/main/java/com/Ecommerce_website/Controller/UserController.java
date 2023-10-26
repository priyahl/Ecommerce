package com.Ecommerce_website.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

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
import com.Ecommerce_website.Service.UserService;



@RestController
public class UserController {
	 
		@Autowired
		UserService userService;
		    
	    @PostMapping("/adduser")
		public UserDto adduser(@RequestBody UserDto userDto) {
			return userService.adduser(userDto);
		}
	
	    @PutMapping("/updateuser")
	 		public UserDto updateuser(@RequestBody UserDto userDto) {
	 			return userService.updateuser(userDto);
	 		}
	    @GetMapping("/getAllUser")
		public List<UserDto> getAllUser(){
			return userService.getAllUser();
		}
	    @DeleteMapping("/deleteuser/{id}")
		public Object deleteuser(@PathVariable long id) {
			return userService.deleteuser(id);
		}
	    @PostMapping("/addcart")
	  		public CartResDto addcart(@RequestBody CartDto cartDto) {
	  			return userService.addCart(cartDto);
	  		}
	    @PutMapping("/updatecart")
 		public CartResDto updatecart(@RequestBody CartDto cartDto) {
 			return userService.updateCart(cartDto);
 		}
	    @PostMapping("/addorder")
	  		public OrderDto addorder(@RequestBody OrderDto orderDto) {
	  			return userService.addorder(orderDto);
	  		}
	    @DeleteMapping("/deleteCart/{id}")
		public Object deletecart(@PathVariable long id) {
			return userService.deleteCart(id);
		}
//	    @GetMapping("/getAllOrderHistoryByOrderId/{id}")
//	    public List<OrderHistoryDto> getAllOrderHistoryByOrderId(@PathVariable long id) {
//	    	return userService.getOrderHistoryByOrderId(id);
//	    }
	    @GetMapping("/getAllOrderHistoryByUserId/{id}")
	    public List<OrderHistoryDto> getAllOrderHistoryByUserId(@PathVariable long id) {
	    	return userService.getAllOrderHistoryByUserId(id);
	    }
	    @GetMapping("/getCategoryById1/{id}")
	    public GetByCategoryDto getByCategoryId(@PathVariable long id) {
	    	return userService.getByCategoryId(id);
	    }
	    
	    @GetMapping("/getAllCategoryByVendorId1/{id}")
	    public List<GetByCategoryDto> getAllCategoryByVendorId(@PathVariable long id) {
	    	return userService.getAllCategoryByVendorId(id);
	    }
	    @GetMapping("/getAllItemsByCatId1/{id}")
	    public List<GetByItemDto> getAllItemsByCatId(@PathVariable long id) {
	    	return userService.getAlItemsByCategoryId(id);
	    }
	    
	    @GetMapping("/getAllItemsByItemId1/{id}")
	    public GetByItemDto getAllItemsByItemId(@PathVariable long id) {
	    	return userService.getByItemId(id);
	    }
	  
	    @GetMapping("/getAllOrderHistoryByUserIdAndOrderId/{userId}/{orderId}")
	  		private OrderHistoryDto getAllOrderHistoryByUserIdAndOrderId(@PathVariable long userId,@PathVariable long orderId) {
	  			return userService.getAllOrderHistoryByUserIdAndOrderId( userId, orderId);
	  		}
	    
	  	    @PostMapping("/addaccount")
	    		public UserFavAccountDto addaccount(@RequestBody UserFavAccountDto userFavAccountDto) {
	    			return userService.addAccount(userFavAccountDto);
	  	    }
	  	  @GetMapping("/getByAccountId/{id}")
		    public UserFavAccountDto getByAccountId(@PathVariable long id) {
		    	return userService.getByAccountId(id);
		    }
		    @DeleteMapping("/deleteAcc/{id}")
			public Object deleteAcc(@PathVariable long id) {
				return userService.deleteaccount(id);
			}
}
