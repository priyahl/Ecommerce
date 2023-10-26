package com.Ecommerce_website.Service;

import java.util.List;

import com.Ecommerce_website.Dto.CategoryDto;
import com.Ecommerce_website.Dto.ItemsDto;
import com.Ecommerce_website.Dto.OrderDto;
import com.Ecommerce_website.Dto.OrderHistoryDto;
import com.Ecommerce_website.Dto.VendorDto;
import com.Ecommerce_website.Model.Items;

public interface VendorService {
	public VendorDto addvendor(VendorDto vendorDto );
	public VendorDto updatevendor(VendorDto vendorDto);
	public VendorDto getByVendorId(long id);
	public Object deleteVendor(long id);
//	 VendorDto deleteVendor(long id);
	public CategoryDto addCategory(CategoryDto categoryDto);
   public CategoryDto updateCategory(CategoryDto categoryDto);
   public CategoryDto getByCategoryId(long id);
   public List<CategoryDto> getAllCategoryByVendorId(long id);
	public ItemsDto addItems(ItemsDto itemsDto);
	public ItemsDto updateItem(ItemsDto itemsDto);
	public List<ItemsDto> getAlItemsByCategoryId(long id);
	   public ItemsDto getByItemId(long id);
	      public List<OrderHistoryDto> getAllOrderHistoryByVendorId(long id);
			public OrderHistoryDto getAllOrderHistoryByVendorIdAndOrderId(long vendorId,long orderId);
}
