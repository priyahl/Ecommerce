package com.Ecommerce_website.Service;

import java.util.List;

import com.Ecommerce_website.Dto.CartDto;
import com.Ecommerce_website.Dto.CartResDto;
import com.Ecommerce_website.Dto.GetByCategoryDto;
import com.Ecommerce_website.Dto.GetByItemDto;
import com.Ecommerce_website.Dto.ItemsDto;
import com.Ecommerce_website.Dto.OrderDto;
import com.Ecommerce_website.Dto.OrderHistoryDto;
import com.Ecommerce_website.Dto.UserDto;
import com.Ecommerce_website.Dto.UserFavAccountDto;

public interface UserService {
	public UserDto adduser(UserDto userDto);
	public UserDto updateuser(UserDto userDto);
	public List<UserDto> getAllUser();
	public Object deleteuser(long id);
	public CartResDto addCart(CartDto cartDto);
//	public CartResDto updatecart(CartDto cartDto);
	public CartResDto updateCart(CartDto cartDto);
	public Object deleteCart(long id);
	public OrderDto addorder(OrderDto orderDto);
//	   public List<OrderHistoryDto> getOrderHistoryByOrderId(long id);
//		public UserFavAccountDto addAccount(UserFavAccountDto userFavAccountDto);
	      public List<OrderHistoryDto> getAllOrderHistoryByUserId(long id);
	      public GetByCategoryDto getByCategoryId(long id);
	      public List<GetByCategoryDto> getAllCategoryByVendorId(long id);
	      public List<GetByItemDto> getAlItemsByCategoryId(long id);
		   public GetByItemDto getByItemId(long id);
public OrderHistoryDto getAllOrderHistoryByUserIdAndOrderId(long userId,long orderId);
			public UserFavAccountDto addAccount(UserFavAccountDto userFavAccountDto);
			   public UserFavAccountDto getByAccountId(long id);
				public Object deleteaccount(long id);
}
